import java.lang.Math;

public class Matrix {
  private int [][] matrix;
  private int sizeOfSide;
  final private int MAXLENGTHBETWEENIDICES = 7;

  //Constructor
  public Matrix(){
    sizeOfSide = 0;
  }

  public void initializeMatrix(int size){
    if(size > 0){
      //safely can create a matrix

      //store 0 at each index in matrix
      matrix = new int[size][size];
      for(int i = 0; i < size; i++)
        for(int j = 0; j < size; j++)
          matrix[i][j] = 0;
      //set the private side value to the given size input
      sizeOfSide = size;
    }
    else{
      System.out.printf("ERROR :: Cannot initialize Matrix of size less than 1!");
    }
  }

  public void populateMatrix(){
    //loop through all indices and store the current 1D index there
    for(int i = 0; i < sizeOfSide; i++)
        for(int j = 0; j < sizeOfSide; j++)
          matrix[i][j] = (i*sizeOfSide)+j;
  }

  public void invertMatrixDiagonal(){
    int temp = 0;
    //already inverting via half the matrix, going beyond the half way point would
    //revert it back to the original matrix.
    for(int i = 0; i < sizeOfSide/2; i++){
      for(int j = 0; j < sizeOfSide; j++){
        if(j != (sizeOfSide - i)-1){
          //the current index is not apart of the diagonal, therefore it can be flipped!

          //store current value at the idex into the temporary variable
          temp = matrix[i][j];

          //store the opposite side's value at the current index
          matrix[i][j] = matrix[(sizeOfSide - i) - 1][(sizeOfSide - j) - 1];
          //store the original index's value to the opposite side
          matrix[sizeOfSide - i - 1][sizeOfSide - j - 1] = temp;
        }
      }
    }
  }

  public void printMatrix(){
    //blockAmount is the amount of chars in one integer being printed
    int blockAmount = 0;

    //print the dividing line
    System.out.printf("\n\t");
    printHorizontalLine(sizeOfSide * MAXLENGTHBETWEENIDICES);
    System.out.printf("\n\t");

    //loop through all indices
    for(int i = 0; i < sizeOfSide; i++){
      for(int j = 0; j < sizeOfSide; j++){
        //is the current index one of the diagonal indices?
        if(j != (sizeOfSide - i)-1){
          //if not, print the current value
          System.out.printf("%d", matrix[i][j]);
        }
        else{
          //if it is, print it with color escape codes
          System.out.printf("\u001B[33m%d\u001B[0m", matrix[i][j]);
        }
        //is the current matrix value 0?  if so, log would be undefined so set to 1
        if(matrix[i][j] == 0){
          blockAmount = 1;
        }
        else{
          //log 10 to get the length of the integer printed in terms of characters
          //use floor function to only accept all values that still don't let the number go over the given amount
          blockAmount = (int) Math.floor(Math.log10( Double.valueOf(matrix[i][j]) )) + 1;
        }
        printSpaceBlock( blockAmount );
      }
      System.out.printf("\n\t");
    }

    //print the dividing line
    printHorizontalLine(sizeOfSide * MAXLENGTHBETWEENIDICES);
    System.out.printf("\n");

  }




  private void printSpaceBlock(int lengthOfIndexChars){
    //print a block of spaces given the length of a string before it, to keep it
    //all evenly spaced apart, no matter the length of the string.
    for(int i = 0; i < (MAXLENGTHBETWEENIDICES - lengthOfIndexChars); i++)
      System.out.printf(" ");
  }

  private void printHorizontalLine(int length){
    for(int i = 0; i < length; i++){
      System.out.printf("-");
    }
  }

}
