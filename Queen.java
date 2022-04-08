import java.util.Scanner;

public class Queen {

  public static void main(String args[]){

   Scanner input = new Scanner(System.in);
   
   int [][] boardArray = new int [8][8];

    for(int i = 0; i < boardArray.length; i++){
      for (int j = 0; j < boardArray.length; j++){
        System.out.println("Enter a number 1 or 0: ");
        boardArray[i][j] = input.nextInt();
      }
    }

    System.out.print("Enter a board: \n");
    int counter = 0;
    for (int j = 0; j < boardArray.length; j++){
      for(int i = 0; i < boardArray.length; i++) {
        System.out.print(boardArray[j][i] + " ");
        if (counter < 7){
          counter++;
        } else {
          System.out.print("\n");
          counter = 0;
        }
      }
    }

    boolean rows = getRows(boardArray);
    boolean cols = getCols(boardArray);
    boolean diags = getDiags(boardArray);

    if ((rows == true) && (cols == true) && (diags == true)){
      System.out.print("The queen is safe.");
    } else {
      System.out.print("The queen is not safe.");
    }



  }

  public static boolean getRows(int boardArray[][]){
    boolean rows = true;

    for(int i = 0; i < boardArray.length; i++){
     int count = 0; //counter
     for (int j = 0; j < 8; j++){

      if(boardArray[i][j] == 1){
      count++;
      }
      if (count == 2){
        rows = false;
        return rows;
      }
     }
    }

    return rows;

  }

  public static boolean getCols(int boardArray[][]){
    boolean cols = true;

    for(int i = 0; i < boardArray.length; i++){
     int count = 0; //counter
     for (int j = 0; j < 8; j++){

      if(boardArray[j][i] == 1){
      count++;
      }
      if (count == 2){
        cols = false;
        return cols;
      }
     }
    }

    return cols;
  }

  public static boolean getDiags(int boardArray[][]){
    boolean diags = true;
    //i is rows
    //j is columns
    
    for(int i = 0; i < boardArray.length; i++){
      int counter = 0;
      for(int j = 0; j < boardArray[i].length; j++){
        
        
        if(boardArray[i][j] == 1){
          int count1 = i;
          int count2 = j;
          
          
          for (int q = 0; q < 10; q++){
            
            if ((count1 <= 7) && (count2 <= 7)){            
            
              if (boardArray[count1][count2] == 1){
                count1++;
                count2++;
                counter ++;
              } else if (boardArray[count1][count2] == 0){
                  count1++;
                  count2++;
                  diags = true;
                } 
            }
          }
          
          if(counter <= 1){
            counter = 0;
            count1 = i;
            count2 = j;
            for (int l = 0; l < 10; l++){

              if ((count1 >= 0) && (count2 <= 7)){

                if (boardArray[count1][count2] == 1){
                  count1 --;
                  count2 ++;
                  counter++;
                } else if (boardArray[count1][count2] == 0){
                    count1 --;
                    count2 ++;
                    diags = true;
                  }
              }     
            }
          }   

          

        }
          
        if (counter >= 2){
          diags = false;
        }  
        
      }
    
    
    }

    return diags;


  }



}

