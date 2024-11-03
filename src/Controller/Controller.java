package Controller;

import Model.Matrix;
import View.MatrixService;
import java.util.*;

public class Controller  {
    private final MatrixService matrixDisplayer = new MatrixService();
    private final Scanner scanner = new Scanner(System.in);

    public Controller(){
    }

    public void menu() throws NullPointerException, IllegalArgumentException {
        Matrix m1 = addNewMatrix();
        matrixDisplayer.displayMatrix(m1);
        Matrix m2 = addNewMatrix();
        matrixDisplayer.displayMatrix(m2);

        boolean isRunning = true;
        while(isRunning) {


            switch (getOption()) {
                case '1': //TODO transpose
                    matrixDisplayer.showMessage("Which matrix would you like to transpose? \n" + "1 = the first one \n2 = second");
                    try {
                        if (scanner.nextInt() == 1) {
                            transposeMatrix(m1);
                        } else if (scanner.nextInt() == 2) {
                            transposeMatrix(m2);
                        }
                    }catch (InputMismatchException ime){
                        matrixDisplayer.showError("Enter only numbers\n");
                    }
                    break;
                case '2': // TODO multiplication
                    try {
                        Matrix res = multiplyMatrices(m1, m2);
                        matrixDisplayer.displayMatrix(res);
                    }catch (IllegalArgumentException iae){
                        matrixDisplayer.showError(iae.getMessage());
                    }
                    break;
                case '3':
                    break; // TODO transponowanie macierzy wynikowej
                case 'Q':
                    isRunning = false;
                    matrixDisplayer.showMessage("Exit light (program)");
                    break;
                case 'R': //reboot
                    menu();
                default:
                    matrixDisplayer.showMessage("Invalid option, please try again ");
            }
        }
    }

    private int getIntInput(String prompt){
        while(true) {
            matrixDisplayer.showMessage(prompt);
            try {
                return scanner.nextInt();
            } catch (InputMismatchException ime) {
                matrixDisplayer.showError("Please, input a number");
                scanner.next();
            }
        }
    }

    private char getOption(){
        matrixDisplayer.showMessage("Wybierz opcje: ");
        matrixDisplayer.showMessage(" 1. Transponowanie \n 2.  Mnozenie \n " +
                "3. transponowanie macierzy wynikowej \n" +
                "Q  - quit\nR - reset");
        return  scanner.next().toUpperCase().charAt(0);
    }

//    private void transposeMatrix(Matrix m){
//        try{
//        Matrix trans = Matrix.transpose(m);
//        matrixDisplayer.showMessage("Transposed matrix:\n");
//        matrixDisplayer.displayMatrix(trans);
//        }catch (IndexOutOfBoundsException iae){
//            matrixDisplayer.showError(iae.getMessage());
//        }
//    }

    private void transposeMatrix(Matrix m){
        matrixDisplayer.showMessage("Transposed matrix: \n");
        matrixDisplayer.displayTransposedMatrix(m);
    }

    private Matrix multiplyMatrices(Matrix m1, Matrix m2) {
        try{
            return Matrix.multiplication(m1,m2);
        }catch (IllegalArgumentException | NullPointerException e){
            matrixDisplayer.showError(e.getMessage());
            matrixDisplayer.showError("EXCEPTION FROM CONTROLLER CLASS");
            return new Matrix(0, 0);
        }
    }

    private Matrix addNewMatrix(){
        int sizeX2 = getIntInput("X: ");
        int sizeY2 = getIntInput("Y: ");
        Matrix m = new Matrix(sizeX2, sizeY2);
        m.init();
        return m;
    }
}
