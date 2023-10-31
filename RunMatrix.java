import java.util.Scanner;

public class RunMatrix {
  public static void main(String[] args) {
    int user_input = 0;
    Scanner myscanner = new Scanner(System.in);
    Matrix myMatrix = new Matrix();
    System.out.printf("\n\tPlease enter the size of your matrix: ");
    user_input = myscanner.nextInt();
    System.out.printf("\n\tyour matrix is %d x %d\n", user_input, user_input);

    myMatrix.initializeMatrix(user_input);
    System.out.printf("\n\tprinting matrix with default values:");
    myMatrix.printMatrix();

    System.out.printf("\tpopulating matrix...");
    myMatrix.populateMatrix();
    System.out.printf("matrix populated\n\n\tprintng matrix:");
    myMatrix.printMatrix();

    System.out.printf("\tflipping matrix...");
    myMatrix.invertMatrixDiagonal();
    System.out.printf("matrix flipped\n\n\tprintng flipped matrix:");
    myMatrix.printMatrix();

    myscanner.close();
  }
}
