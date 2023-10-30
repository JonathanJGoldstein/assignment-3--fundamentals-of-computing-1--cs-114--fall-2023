import java.lang.Math;

public class Matrix {
  static int [][] matrix;
  static int sizeOfSide;
  final static int MAXLENGTHBETWEENIDICES = 7;

  //Constructor
  public void Matrix(){
    sizeOfSide = 0;
  }

  public void initializeMatrix(int size){
    if(size > 0){
      //safely can create a matrix
      matrix = new int[size][size];
      for(int i = 0; i < size; i++)
        for(int j = 0; j < size; j++)
          matrix[i][j] = 0;
      sizeOfSide = size;
    }
    else{
      System.out.printf("ERROR :: Cannot initialize Matrix of size less than 1!");
    }
  }

  public void populateMatrix(){
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
          temp = matrix[i][j];
          matrix[i][j] = matrix[(sizeOfSide - i) - 1][(sizeOfSide - j) - 1];
          matrix[sizeOfSide - i - 1][sizeOfSide - j - 1] = temp;
        }
      }
    }
  }

  public void printMatrix(){
    int block_amount = 0;
    System.out.printf("\n----------------\n");
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
      System.out.printf("\n");
    }
    System.out.printf("\n----------------\n");
  }
  static void printSpaceBlock(int lengthOfIndexChars){
    for(int i = 0; i < (MAXLENGTHBETWEENIDICES - lengthOfIndexChars); i++)
      System.out.printf(" ");
  }
}
