public class Matrix {
  //object's Fields
  private int [][] matrix;
  private int sizeOfSide;
  final private int LENGTH_OF_TAB_CHAR = 8;

  //Constructor method
  public Matrix(int size){
    if(size > 0){
      //can safely create a matrix

      //store 0 at each index in matrix
      matrix = new int[size][size];
      for(int i = 0; i < size; i++)
        for(int j = 0; j < size; j++)
          matrix[i][j] = 0;
      //set the private side value to the given size input
      sizeOfSide = size;
    }
    else{
      //throw an exception if the given size is less than 1
      throw new IllegalArgumentException("Cannot initialize Matrix of size less than 1!");
    }
  }

  public void populateMatrix(){
    int indexValue = 0;

    for(int i = 0; i < sizeOfSide; i++)
        for(int j = 0; j < sizeOfSide; j++)
          matrix[i][j] = ++indexValue;
  }

  public void flipMatrix(){
    //already flipping via half the matrix, going beyond the half way point would
    //revert it back to the original state.
    for(int i = 0; i < sizeOfSide/2; i++){
      for(int j = 0; j < sizeOfSide; j++){
        if(j != (sizeOfSide - i)-1){
          //the current index is not apart of the diagonal, therefore it can be flipped

          swap(j, i, (sizeOfSide - j) - 1, (sizeOfSide - i) - 1);
        }
      }
    }
  }

  private void swap(int x1, int y1, int x2, int y2){
    //store location one's value at the index into the temporary variable
    int temp = matrix[y1][x1];
    //store the second index's value at the first index
    matrix[y1][x1] = matrix[y2][x2];
    //store the original index's value to the second index
    matrix[y2][x2] = temp;
  }

  public void printMatrix(){

    //print the top dividing line
    System.out.printf("\n\t");
    printHorizontalLine(sizeOfSide * LENGTH_OF_TAB_CHAR);
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
        System.out.printf("\t");
      }
      System.out.printf("\n\t");
    }

    //print the bottom dividing line
    printHorizontalLine(sizeOfSide * LENGTH_OF_TAB_CHAR);
    System.out.printf("\n");

  }

  //prints a horizontal line of the given length in characters
  private void printHorizontalLine(int length){
    for(int i = 0; i < length; i++){
      System.out.printf("-");
    }
  }

}
