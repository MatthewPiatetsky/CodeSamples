/*
 * This file simulates an AI that plays connect four on an 8*8 board, where the pieces may be placed anywhere.
 * The AI works primarily by looking at each possible move and evaluating its importance. 
 * The class move takes a double int array representing the board and returns a Pair which represents the move that should be made.
 * 
 * The Player class begins with two for loops which help to iterate through each spot on the board. 
 * At each spot, our program evaluates the importance of a possible move.
 * This is done by scanning in all 8 directions and counting the number of spaces, friendly pieces and enemy pieces.
 * Our program also weights pieces that are in order more than pieces which are on their own and weights dangerous positions for our opponent.
 * Thus, this evaluation function will spur the program to block enemy pieces, attempt to secure its own four in a row and make moves 
 * near the center that will always have a significant impact on the action.
 * 
 * Note: The move method also accepts a player input in case our AI is called upon to move first. 
 * Otherwise, by default the AI is initialized to move second.
 * 
 * File: Player.java
 * Authors: Matthew Piatetsky, Alexandrea Mellen, Patrick Maruska
 */

public class Player {
    // Creates two variables to keep track of the two players
    public int AI;
    public int human;

    public Pair move(int [][] board) {
        // Initializes the AI as the second player if no player number is given in the call
        return move(board, 2);
    }

    public Pair move(int [][] board, int player)
    {
        if(player==1) { // Sets the AI to play first
            AI = 1;
            human = 2;
        }
        if(player==2){ // Sets the AI to play second
            human = 1;
            AI = 2;
        }

        int [][] us = new int [8][8]; // Establishes the AI's board which keeps track of the values of each move
        int point = 0; // Sets points to 0

        for(int x =0 ; x < 8 ; x++) // Iterates left to right
        { 
            for (int y=0 ; y < 8 ; y++) // Iterates top to bottom
            {

                if(board[x][y]==0){

                    //check columns up
                    point = 0;
                    int piece = 0;
                    int space=0;

                    // Checks the spots on the left and right for the opponent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    if((y+3<8)&&(board[x][y+1]==human)&&(board[x][y+2]==human)&&(board[x][y+3]==human)){
                        piece+=1500;
                    }
                    if((y-3>=0)&&(board[x][y-1]==human)&&(board[x][y-2]==human)&&(board[x][y-3]==human)){
                        piece+=1500;
                    }
                    if((x+3<8)&&(board[x+1][y]==human)&&(board[x+2][y]==human)&&(board[x+3][y]==human)){
                        piece+=1500;
                    }
                    if((x-3>=0)&&(board[x-1][y]==human)&&(board[x-2][y]==human)&&(board[x-3][y]==human)){
                        piece+=15000;
                    }
                    //point+=piece; // Adds points for each piece

                    // Checks the spots on the left and right for our AI ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    if((y+3<8)&&(board[x][y+1]==AI)&&(board[x][y+2]==AI)&&(board[x][y+3]==AI)){
                        piece+=20000;
                    }
                    if((y-3>=0)&&(board[x][y-1]==AI)&&(board[x][y-2]==AI)&&(board[x][y-3]==AI)){
                        piece+=20000;
                    }
                    if((x+3<8)&&(board[x+1][y]==AI)&&(board[x+2][y]==AI)&&(board[x+3][y]==AI)){
                        piece+=20000;
                    }
                    if((x-3>=0)&&(board[x-1][y]==AI)&&(board[x-2][y]==AI)&&(board[x-3][y]==AI)){
                        piece+=200000;
                    }
                    //point+=piece; // Adds points for each piece

                    // Checks the diagonals for our opponent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    if((y+3<8)&&(x+3<8)&&(board[x+1][y+1]==human)&&(board[x+2][y+2]==human)&&(board[x+3][y+3]==human)){
                        piece+=1500;
                    }
                    if((y-3>=0)&&(x-3>=0)&&(board[x-1][y-1]==human)&&(board[x-2][y-2]==human)&&(board[x-3][y-3]==human)){
                        piece+=1500;
                    }
                    if((x+3<8)&&(y-3>=0)&&(board[x+1][y-1]==human)&&(board[x+2][y-2]==human)&&(board[x+3][y-3]==human)){
                        piece+=1500;
                    }
                    if((x-3>=0)&&(y+3<8)&&(board[x-1][y+1]==human)&&(board[x-2][y+2]==human)&&(board[x-3][y+3]==human)){
                        piece+=150000;
                    }
                    //point+=piece; // Adds points for each piece

                    // Checks the diagonals for our AI ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~

                    if((y+3<8)&&(x+3<8)&&(board[x+1][y+1]==AI)&&(board[x+2][y+2]==AI)&&(board[x+3][y+3]==AI)){
                        piece+=20000;
                    }
                    if((y-3>=0)&&(x-3>=0)&&(board[x-1][y-1]==AI)&&(board[x-2][y-2]==AI)&&(board[x-3][y-3]==AI)){
                        piece+=20000;
                    }
                    if((x+3<8)&&(y-3>=0)&&(board[x+1][y-1]==AI)&&(board[x+2][y-2]==AI)&&(board[x+3][y-3]==AI)){
                        piece+=20000;
                    }
                    if((x-3>=0)&&(y+3<8)&&(board[x-1][y+1]==AI)&&(board[x-2][y+2]==AI)&&(board[x-3][y+3]==AI)){
                        piece+=200000;
                    }
                    //point+=piece; // Adds points for each piece

                    // Checks for a two block for our opponent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    if((y+3<8)&&(board[x][y+1]==human)&&(board[x][y+2]==human)&&(board[x][y+3]!=AI)){
                        piece+=1000;
                    }
                    if((y-3>=0)&&(board[x][y-1]==human)&&(board[x][y-2]==human)&&(board[x][y-3]!=AI)){
                        piece+=1000;
                    }
                    if((x+3<8)&&(board[x+1][y]==human)&&(board[x+2][y]==human)&&(board[x+3][y]!=AI)){
                        piece+=1000;
                    }
                    if((x-3>=0)&&(board[x-1][y]==human)&&(board[x-2][y]==human)&&(board[x-3][y]!=AI)){
                        piece+=1000;
                    }

                    // Checks for a block of two diagonally for our opponent ~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~~
                    if((y+3<8)&&(x+3<8)&&(board[x+1][y+1]==human)&&(board[x+2][y+2]==human)&&(board[x+3][y+3]!=AI)){
                        piece+=1000;
                    }
                    if((y-3>=0)&&(x-3>=0)&&(board[x-1][y-1]==human)&&(board[x-2][y-2]==human)&&(board[x-3][y-3]!=AI)){
                        piece+=1000;
                    }
                    if((x+3<8)&&(y-3>=0)&&(board[x+1][y-1]==human)&&(board[x+2][y-2]==human)&&(board[x+3][y-3]!=AI)){
                        piece+=1000;
                    }
                    if((x-3>=0)&&(y+3<8)&&(board[x-1][y+1]==human)&&(board[x-2][y+2]==human)&&(board[x-3][y+3]!=AI)){
                        piece+=1000;
                    }
                    //point+=piece; // Adds points for each piece

                    
                    // For two in a row for human
                    
                    if((y+3 < 8)&& (y-3 >= 0) &&(board[x][y+1] == human)&&(board[x][y-1] == human)&&((board[x][y+2]==0)||(board[x][y+2] == human))&&((board[x][y-2]==0)||(board[x][y-2] == human))){
                        piece+=1000;
                    }
                    if((x+3 < 8)&& (x-3 >= 0) &&(board[x+1][y] == human)&&(board[x-1][y] == human)&&((board[x+2][y]==0)||board[x+2][y] == human)&&((board[x-2][y]==0)||(board[x-2][y] == human))){
                        piece+=1000;
                    }
                    
                    if((x+3 < 8)&& (x-3 >= 0)&&(y+3 < 8)&& (y-3 >= 0) &&(board[x+1][y-1] == human)&&(board[x-1][y+1] == human)&&((board[x+2][y-2]==0)||(board[x+2][y-2] == human))&&((board[x-2][y+2]==0)||(board[x-2][y+2] == human))){
                        piece+=1000;
                    }
                    
                    if((x+3 < 8)&& (x-3 >= 0)&&(y+3 < 8)&& (y-3 >= 0)&&(board[x+1][y+1] == human)&&(board[x-1][y-1] == human)&&((board[x+2][y+2]==0)||(board[x+2][y+2] ==human))&&((board[x-2][y-2]==0)||(board[x-2][y-2]==human))){
                        piece+=1000;
                    }
                    
                    // For two in a row for AI
                    
                    if((y+3 < 8)&& (y-3 >= 0) &&(board[x][y+1] == AI)&&(board[x][y-1] == AI)&&((board[x][y+2]==0)||(board[x][y+2] == human))&&((board[x][y-2]==0)||(board[x][y-2] == AI))){
                        piece+=1000;
                    }
                    if((x+3 < 8)&& (x-3 >= 0) &&(board[x+1][y] == AI)&&(board[x-1][y] == AI)&&((board[x+2][y]==0)||board[x+2][y] == AI)&&((board[x-2][y]==0)||(board[x-2][y] == AI))){
                        piece+=1000;
                    }
                    
                    if((x+3 < 8)&& (x-3 >= 0)&&(y+3 < 8)&& (y-3 >= 0) &&(board[x+1][y-1] == AI)&&(board[x-1][y+1] == AI)&&((board[x+2][y-2]==0)||(board[x+2][y-2] == AI))&&((board[x-2][y+2]==0)||(board[x-2][y+2] == AI))){
                        piece+=1000;
                    }
                    
                    if((x+3 < 8)&& (x-3 >= 0)&&(y+3 < 8)&& (y-3 >= 0)&&(board[x+1][y+1] == AI)&&(board[x-1][y-1] == AI)&&((board[x+2][y+2]==0)||(board[x+2][y+2]==AI))&&((board[x-2][y-2]==0)||(board[x-2][y-2]==AI))){
                        piece+=1000;
                    }
                    
                    
                    point+=piece; // Adds points for each piece
                    piece = 0;

                    // Helps check columns going up when nearing the edge of the board 
                    if((y+1<8)&&board[x][y+1]>=0)
                    {
                        if(board[x][y+1]==0)
                        {
                            space++;
                        }
                        else
                        {
                            piece++;

                        }
                        if((y+2<8)&&(board[x][y+2]>=0))
                        {
                            if(board[x][y+2]==0)
                            {
                                space++;
                            }
                            else
                            {
                                piece++;

                            }
                            if((y+3<8)&&(board[x][y+3] >=0))
                            {
                                if(board[x][y+3]==0)
                                {
                                    space++;
                                }
                                else
                                {
                                    piece++;

                                }

                            }
                        }

                        point += piece*15+space; // Adds 15 points each for pieces and 1 point each for spaces

                    }

                    // Resets the count for pieces and spaces back to 0
                    piece=0;
                    space=0;
                    // Helps check columns going down when nearing the edge of the board 
                    if((y-1>=0)&&(board[x][y-1]>=0))
                    {
                        if(board[x][y-1]==0)
                        {
                            space++;
                        }
                        else
                        {
                            piece++;

                        }
                        if((y-2>=0)&&(board[x][y-2]>=0))
                        {
                            if(board[x][y-2]==0)
                            {
                                space++;
                            }
                            else
                            {
                                piece++;

                            }
                            if((y-3>=0)&&(board[x][y-3]>=0))
                            {
                                if(board[x][y-3]==0)
                                {
                                    space++;
                                }
                                else
                                {
                                    piece++;

                                }
                            }

                            point += piece*15+space; // Adds 15 points each for pieces and 1 point each for spaces

                        }
                    }

                    // Resets the count for pieces and spaces to 0
                    piece=0;
                    space=0;
                    // Helps check rows to the right when nearing the edge of the board 
                    if((x+1<8)&&(board[x+1][y]>=0))
                    {
                        if(board[x+1][y]==0)
                        {
                            space++;
                        }
                        else
                        {
                            piece++;

                        }
                        if((x+2<8)&&(board[x+2][y]>=0))
                        {
                            if(board[x+2][y]==0)
                            {
                                space++;
                            }
                            else
                            {
                                piece++;

                            }
                            if((x+3<8)&&(board[x+3][y]>=0))
                            {
                                if(board[x+3][y]==0)
                                {
                                    space++;
                                }
                                else
                                {
                                    piece++;

                                }

                            }
                        }
                        point += piece*15+space; // Adds 15 points each for pieces and 1 point each for spaces

                    }

                    // Resets the count for pieces and spaces back to 0
                    piece=0;
                    space=0;
                    // Helps check rows to the left when nearing the edge of the board 
                    if((x-1>=0)&&(board[x-1][y]>=0))
                    {
                        if(board[x-1][y]==0)
                        {
                            space++;
                        }
                        else
                        {
                            piece++;

                        }
                        if((x-2>=0)&&(board[x-2][y]>=0))
                        {
                            if(board[x-2][y]==0)
                            {
                                space++;
                            }
                            else
                            {
                                piece++;

                            }
                            if((x-3>=0)&&(board[x-3][y]>=0))
                            {
                                if(board[x-1][y]==0)
                                {
                                    space++;
                                }
                                else
                                {
                                    piece++;

                                }
                            }
                        }
                        point += piece*15+space;  // Adds 15 points each for pieces and 1 point each for spaces

                    }

                    us[x][y] += point; // Sums the point value for each possible move and places it on our own board
                }
            }
        } 

        // Creates variables to keep track of the maximum point value and the maximum's x and y coordinates
        int max = 0;
        int maxx = 0;
        int maxy= 0;
        
        //Prints out the point value board for testing purposes 
        /*
        for(int x = 0; x < 8 ; x++)
        {
            System.out.println(us[x][0] + "\t" + us[x][1] + "\t" + us[x][2] + "\t" + us[x][3] + "\t" + us[x][4] + "\t" + us[x][5] + "\t" + us[x][6] + "\t" + us[x][7]);
        }

        System.out.println();
        System.out.println();
        System.out.println();
        System.out.println();
        */
        
        // Iterates through the point value board and find the best move
        for(int x = 0; x <8 ; x++)
        {
            for( int y = 0 ; y < 8 ; y++)
            {
                if( us[x][y] > max)
                {
                    // Updates the maximum each time a higher point value is found on the board
                    max = us[x][y];
                    maxx = x;
                    maxy= y;
                }
            }
        }

        // Returns the x and y coordinates of the best move
        return new Pair(maxx,maxy);
    }

}