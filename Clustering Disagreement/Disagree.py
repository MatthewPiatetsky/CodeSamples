import csv
import math

def main():
    #Put filenames here for testing program <<<<<<<<<<<<<<<<<<
    #These filenames are just placeholders
    Datafile="C:/DataMining/comm.csv"
    C1 = "C:/DataMining/comm-clusterings/idclus-com9-A5s17.csv"
    C2 = "C:/DataMining/comm-clusterings/idclus-com9-D5s64.csv"
    
    dlines=list( csv.reader(open(Datafile)) )
    nrec=len(dlines)-1
    
    c1lines = list( csv.reader(open(C1)) )
    
    c2lines=list( csv.reader(open(C2)) )
    
    # cluster pairs
    clus1_cnt = {} # clus1_cnt[c] will have the count of cluster c
    clus2_cnt = {} # clus2_cnt[c] will have the count of cluster c
    clus_pair = {} # clus_pair[a,b] will contain the count of clusters
    
    # read header
    fnames=dlines[0]
    # remove first field - instance no ignore the last 2 fields which have cluster names
    nfields=len(fnames)
    
    # compute sums of each field by cluster
    sum1 = {}
    sum2 = {}
    vals = [dlines[i] for i in range(0,nrec+1)]
    
    for nr in range(1,nrec+1): 
        # get cluster labels from the last two values
        c1=c1lines[nr][1]
        c2=c2lines[nr][1]
        if(c1 in clus1_cnt.keys()):
            clus1_cnt[c1]=clus1_cnt[c1]+1
        else:
            clus1_cnt[c1]=1
        if(c2 in clus2_cnt.keys()):
            clus2_cnt[c2]=clus2_cnt[c2]+1
        else:
            clus2_cnt[c2]=1
        if((c1,c2) in clus_pair.keys()):
            clus_pair[(c1,c2)] = clus_pair[c1,c2]+1
        else:
            clus_pair[(c1,c2)] = 1
       
        # compute sum of values
        for nf in range(1,nfields):
            val1 = float(vals[nr][nf])
            
            if(not (c1,nf) in sum1.keys()):
                sum1[(c1,nf)]=0
            sum1[(c1,nf)]+=val1
            if(not (c2,nf) in sum2.keys()):
                sum2[(c2,nf)]=0
            sum2[(c2,nf)]+=val1
    
    
    avg1 = {}
    avg2 = {}
    
    clus1_labels=clus1_cnt.keys()
    clus1_labels.sort() 
    clus2_labels=clus2_cnt.keys()
    clus2_labels.sort()
    
    # compute averages
    for i in range(1,nfields):
        for c1 in clus1_labels: 
            if(not (c1,i) in avg1.keys()):
                avg1[(c1,i)] = 0
            avg1[(c1,i)]=sum1[(c1,i)]/clus1_cnt[c1]
        for c2 in clus2_labels: 
            if(not (c2,i) in avg2.keys()):
                avg2[(c2,i)] = 0
            avg2[(c2,i)]=sum2[(c2,i)]/clus2_cnt[c2]
    
    # for each clus1 find the best match in clus2
    cmap = {} 
    for c1 in clus1_labels:
        best_cnt=0
        for c2 in clus2_labels:
            if((c1,c2) in clus_pair.keys()):
                cpair_cnt= clus_pair[c1,c2]
            else: 
                cpair_cnt = 0
            if (cpair_cnt > best_cnt):
                cmap[c1]=c2 
                best_cnt=cpair_cnt
        print "best match for", c1,  cmap[c1], best_cnt
    
    # compute weighted distance
    clus_dist=0
    cnt_diff=0
    for c1 in clus1_labels: 
        for c2 in clus2_labels: 
            # find distance from c1 to c2
            dist=0
            if((c1,c2) in clus_pair.keys()):
                cpair_cnt= clus_pair[c1,c2]
            else: 
                cpair_cnt = 0
            if(cmap[c1]==c2):
                print "c1 matches c2, exclude from distance\n"
            elif (cpair_cnt>0):
                print "P: compute dist c1 to c2\n"
                cnt_diff+=cpair_cnt;
                for i in range(1,nfields): 
                    dist+=(avg1[(c1,i)] - avg2[(c2,i)])**2    
                dist=math.sqrt(dist)*cpair_cnt/nrec
            clus_dist+=dist
    print "mem_diff", cnt_diff
    print "clus_dist", clus_dist

if __name__ == "__main__":
    main()