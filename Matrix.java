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
    int block_amount = 0;
    System.out.printf("\n\t");
    printHorizontalLine(sizeOfSide * MAXLENGTHBETWEENIDICES);
    System.out.printf("\n\t");
    for(int i = 0; i < sizeOfSide; i++){
      for(int j = 0; j < sizeOfSide; j++){
        if(j != (sizeOfSide - i)-1){
          System.out.printf("%d", matrix[i][j]);
        }
        else{
          System.out.printf("\u001B[33m%d\u001B[0m", matrix[i][j]);
        }
        //Math.round(Math.sqrt((Double.valueOf(matrix[i][j]))))
        if(matrix[i][j] == 0){
          block_amount = 1;
        }
        else{
          //log 10 to get the amount of chars printed, some type conversions so no errors are thrown, and adding 1 since the value is rounded down to
          //cast it back to an int.  we floor the value because we want to know the minimum amount of times 10 is multiplied to fit neatly in the given value
          block_amount = (int) Math.floor(Math.log10( Double.valueOf(matrix[i][j]) )) + 1;
        }
        printSpaceBlock( block_amount );
      }
      System.out.printf("\n\t");
    }
    printHorizontalLine(sizeOfSide * MAXLENGTHBETWEENIDICES);
    System.out.printf("\n");
  }




  private void printSpaceBlock(int lengthOfIndexChars){
    for(int i = 0; i < (MAXLENGTHBETWEENIDICES - lengthOfIndexChars); i++)
      System.out.printf(" ");
  }

  private void printHorizontalLine(int length){
    for(int i = 0; i < length; i++){
      System.out.printf("-");
    }
  }

}
