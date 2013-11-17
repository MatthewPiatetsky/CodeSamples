#!/bin/bash

ant -f photoshare.xml all
rm -fr apache-tomcat-5.5.15/webapps/photoshare.war
rm -fr apache-tomcat-5.5.15/webapps/photoshare/
cp photoshare/photoshare.war apache-tomcat-5.5.15/webapps 
