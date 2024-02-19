
import java.util.Random;
public class Board {

	private final int NUM_OF_COLUMNS = 7;
	private final int NUM_OF_ROW = 6;
	private int counter = 0;
	private char[][] board;

	

	public Board() {
		board = new char[NUM_OF_ROW][NUM_OF_COLUMNS];
		reset();
	}

	public void printBoard() {
		for (int r = 0; NUM_OF_ROW > r; r += 1) {
			for (int c = 0; NUM_OF_COLUMNS > c; c += 1) {
				System.out.print("|" + board[r][c] + "");
			}
			System.out.println("|");
		}
	}

	public boolean containsWin() {
		int counter = 0;
		int TrueCount = 0;
		int r=0;
		int c=0;
		// horizon
		for ( r = 0; NUM_OF_ROW > r; r += 1) {
			counter = 0;
			for ( c = 0; NUM_OF_COLUMNS - 1 > c; c += 1) {

				if ((board[r][c] == board[r][c + 1]) && (board[r][c]!= ' ')) {
					counter += 1;
				} else {
					counter = 0;
				}

				if (counter >= 3) {
					TrueCount += 1;
					return true;
				}

				else {
					;
				}
			}
		}

		// vert

		for ( c = 0; NUM_OF_COLUMNS > c; c += 1) {
			counter = 0;
			for ( r = 0; NUM_OF_ROW - 1 > r; r += 1) {

				if ((board[r][c] == board[r + 1][c]) && (board[r][c]!= ' ')) {
					counter += 1;
				} else {
					counter = 0;
				}

				if (counter >= 3) {
					TrueCount += 1;
					return true;
				}

				else {;	}
			}
		}

		// normal  diag


		for ( r = 0; r < 3; r++)
		{  counter=0; 
			for ( c = 0; c < 4; c++)
			{
				   char checker = board[r][c];
				   if (checker!=' ' && checker== board[r+1][c+1] && checker==board[r+2][c+2] && checker==board[r+3][c+3]){ 
						counter += 1;}
					 
					else{counter=0;}
			 
					if(counter >= 1){
						TrueCount += 1;
						return true;  }
	
			}}

		// counter diag

		for (  r = 0; r < 3; r++)
		{   counter=0; 
			for ( c = 3; c < 7; c++)
			{
				   char checker = board[r][c];
				   if (checker!=' ' && checker== board[r+1][c-1] && checker==board[r+2][c-2] && checker==board[r+3][c-3]){ 
						counter += 1;}
					 
					else{counter=0;}
			 
					if(counter >= 1){
						TrueCount += 1;
						return true; }

					}
				}
			 
		 

		if (TrueCount == 0) {
			return false;
		} else {
			return true;
		}
	}


	public void AIMove(char sym) {
		//hor
		int TrueCount=0;

		for(int r = 0; NUM_OF_ROW > r; r += 1){
  
			   for(int c = 0; 4> c; c += 1){
			  
				 
				 
			       if (board[r][c]==' ' && board[r][c+1]==board[r][c+2] && board[r][c+2]==board[r][c+3] && board[r][c+1]!=' ') {
			            board[r][c]=sym;   
						TrueCount+=1;}
					   
			       else if (board[r][c]==board[r][c+1] && board[r][c+1]==board[r][c+2] && board[r][c+3]==' ' && board[r][c]!=' '){
			           	board[r][c+3]=sym ;
					  	TrueCount+=1; }

			        else if (board[r][c]==board[r][c+1] && board[r][c+2]==' ' && board[r][c+1]==board[r][c+3] && board[r][c]!=' ') {
			         	board[r][c+2]=sym;  
					 	TrueCount+=1; }
				 
			       else if (board[r][c]==board[r][c+2] && board[r][c+1]==' ' && board[r][c+2]==board[r][c+3] && board[r][c]!=' ') {
			         	board[r][c+1]=sym;
					 	TrueCount+=1;}

				    else{
						;} }}

	    // ver

		for (int c = 6; c>=0; c -= 1) {
			int counter = 0;
			for (int r = 5; r>0; r -= 1) {
	

				if (board[r][c] == board[r - 1][c] && (board[r][c]!= ' ') ) {
						counter += 1;	} 
					
				else {
						counter = 0;}
	
				if (counter == 2 && board[r-2][c]==' ') {
					board[r-2][c]=sym;
					TrueCount+=1;
					counter=0;}
			
			}}

		// diag


		for (int r = 0; r < 3; r++){
        for (int c = 0; c < 4; c++)
        {    
               char checker = board[r][c];
          
               if (checker!=' ' && checker== board[r+1][c+1] && checker==board[r+2][c+2] && board[r+3][c+3]==' '){ 
                 board[r+3][c+3]=sym;        
				 TrueCount+=1;}
                 
               else if (checker==' ' && board[r+2][c+2]== board[r+1][c+1] && board[r+3][c+3]==board[r+2][c+2] && board[r+3][c+3]!=' '){ 
                 checker=sym;       
				 TrueCount+=1;}

              else if (checker!=' ' && checker== board[r+1][c+1] && board[r+2][c+2]==' ' && board[r+3][c+3]==checker){
                board[r+2][c+2]=sym;
				TrueCount+=1;}

              else if (checker!=' ' && checker== board[r+2][c+2]  && board[r+1][c+1]==' ' && board[r+3][c+3]==checker){
                board[r+1][c+1]=sym;
				TrueCount+=1;}

              else {;}

        }}

		//counter diag

		for ( int r = 0; r < 3; r++){
			for (int c = 3; c < 7; c++)
			{                   
				
				char checker = board[r][c];
				if (checker!=' ' && checker== board[r+1][c-1] && checker==board[r+2][c-2] && board[r+3][c-3]==' '){ 
					board[r+3][c-3]=sym;
					TrueCount+=1;	}
					
					else if (checker==' ' && board[r+2][c-2]== board[r+1][c-1] && board[r+3][c-3]==board[r+2][c-2] && board[r+3][c-3]!=' '){ 
					checker=sym ;	
					TrueCount+=1;}
				
				else if (checker!=' ' && checker== board[r+1][c-1] && board[r+2][c-2]==' ' && board[r+3][c-3]==checker){
					board[r+2][c-2]=sym ;
					TrueCount+=1;	}
				
				else if (checker!=' ' && checker== board[r+2][c-2]  && board[r+1][c-1]==' ' && board[r+3][c-3]==checker){
					board[r+1][c-1]=sym	;
					TrueCount+=1;	}
				else{;}
			}}
 
			 

		if (TrueCount==0){
			Random rand = new Random();
			int upperbound=7;
			int randomNum = rand.nextInt(upperbound); 
			while (isColFull(randomNum+1)==true) {
				randomNum = rand.nextInt(upperbound); 	}
			
			if (isColFull(randomNum+1)==false){
				addPiece(sym,randomNum+1);}
			}
		else {;}

			   }



	
	public boolean isTie() {

		int TrueCount = 0;
		for (int r = 0; NUM_OF_ROW > r; r += 1) {
			for (int c = 0; NUM_OF_COLUMNS > c; c += 1) {
				if (board[r][c] == ' ') {
					;
				} else {
					TrueCount += 1;
				}
			}
		}

		if ((TrueCount == 42) && (containsWin() == false)) {

			return true;
		}

		else {
			return false;
		}

	}

	public boolean isColFull(int num){
		if (board[0][num - 1] != ' '){
			return true;
		}
		else {
			return false;}

	}

	public void addPiece(char sym, int num){
		for (int r = 6 - 1; r >= 0; r--) {
            if (board[r][num - 1] == ' ') {
                board[r][num - 1] = sym;
                break;}
             else {     ;            }
        }
	}

	public void reset() {
		for (int r = 0; NUM_OF_ROW > r; r += 1) {
			for (int c = 0; NUM_OF_COLUMNS > c; c += 1) {
				board[r][c] = ' ';
			}
		}
	}

}
