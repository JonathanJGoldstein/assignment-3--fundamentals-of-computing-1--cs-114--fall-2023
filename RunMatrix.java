import java.util.Scanner;

public class RunMatrix {
  public static void main(String[] args) {
    int user_input = 0;
    Scanner myscanner = new Scanner(System.in);
    Matrix myMatrix = new Matrix();
    user_input = myscanner.nextInt();
    myMatrix.initializeMatrix(user_input);
    myMatrix.printMatrix();
    myMatrix.populateMatrix();
    myMatrix.printMatrix();
    myMatrix.invertMatrixDiagonal();
    myMatrix.printMatrix();

    myscanner.close();
  }
}
