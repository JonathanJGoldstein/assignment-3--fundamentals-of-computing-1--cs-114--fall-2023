import java.util.Scanner;

public class RunMatrix {
  public static void main(String[] args) {
    int userInput = 0;
    Scanner myScanner = new Scanner(System.in);

    System.out.printf("\n\tPlease enter the size of your matrix: ");
    userInput = myScanner.nextInt();
    System.out.printf("\n\tyour matrix is %d x %d\n", userInput, userInput);

    Matrix myMatrix = new Matrix(userInput);
    System.out.printf("\n\tprinting matrix with default values:");
    myMatrix.printMatrix();

    System.out.printf("\tpopulating matrix...");
    myMatrix.populateMatrix();
    System.out.printf("matrix populated\n\n\tprintng matrix:");
    myMatrix.printMatrix();

    System.out.printf("\tflipping matrix...");
    myMatrix.flipMatrix();
    System.out.printf("matrix flipped\n\n\tprintng flipped matrix:");
    myMatrix.printMatrix();

    myScanner.close();
  }
}
