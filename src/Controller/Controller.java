package Controller;

import Model.Matrix;
import View.MatrixService;

import java.io.IOException;
import java.util.*;

public class Controller  {
    //private final Matrix m = new Matrix();
    private final MatrixService matrixDisplayer = new MatrixService();
    private final Scanner scanner = new Scanner(System.in);
//    private Matrix[] matrices = new Matrix[10];
    private List<Matrix> matrices = new ArrayList<Matrix>();

    public Controller(){
    }

    public void menu() throws NullPointerException, IllegalArgumentException {
        matrixDisplayer.showMessage("Wpisz rozmiar macierzy: ");
//        int xInput = getIntInput("X: ");
//        int yInput = getIntInput("Y: ");
//        Matrix m = new Matrix(xInput, yInput);
//        m.init();
        Matrix m = addNewMatrix();

        boolean run = true;
        while(run) {
            switch (getOption()) {
                case 1: //TODO adding a new matrix
                    matrixDisplayer.showMessage("Adding a new matrix ");
                    Matrix mNew = addNewMatrix();
                case 2: //TODO transponowanie macierze wejsciowej
                    transposeMatrix(m);
                    break;
                case 3: // TODO mnozenie
//                    Matrix m2 = addNewMatrix();
                    if(matrices.size() <=1){
                        matrixDisplayer.showMessage("Add another matrix (option 1 in menu) ");
                        break;
                    }
                    multiplyMatrices(m, m2);
                    break;
                case 4:
                    break; // TODO transponowanie macierzy wynikowej
                case 'Q':
                    run = false;
                    matrixDisplayer.showMessage("Exit light (program)");
                    break;

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
                matrixDisplayer.showError(ime.getMessage());
                scanner.next();
            }
        }
    }

    private char getOption(){
        matrixDisplayer.showMessage("Wybierz opcje: ");
        matrixDisplayer.showMessage("1. Transponowanie \n 2.  Mnozenie \n " +
                "3. transponowanie macierzy wynikowej \n Dodac nową macierz \n" +
                "Q  - quit");
        return  scanner.next().toUpperCase().charAt(0);
    }

    private void transposeMatrix(Matrix m){
        m.transpose();
        matrixDisplayer.showMessage("Transposed matrix: \n");
        matrixDisplayer.displayMatrix(m);
    }

//    private void multiplyMatrices(Matrix m1){
//        Matrix m2 = addNewMatrix();
//        matrixDisplayer.showMessage("Second matrix:");
//        matrixDisplayer.displayMatrix(m2);
//        try{
//            Matrix res = Matrix.multiplication(m1,m2);
//            matrixDisplayer.showMessage("result of multiplication: ");
//            matrixDisplayer.displayMatrix(res);
//        }catch (IllegalArgumentException iae){
//            matrixDisplayer.showError(iae.getMessage());
//        }
//    }
private void multiplyMatrices(Matrix m1, Matrix m2) {
    try {
        Matrix res = Matrix.multiplication(m1, m2);
        matrixDisplayer.showMessage("result of multiplication: ");
        matrixDisplayer.displayMatrix(res);
    } catch (IllegalArgumentException iae) {
        matrixDisplayer.showError(iae.getMessage());
    }
}

    private Matrix addNewMatrix(){
        int sizeX2 = getIntInput("X: ");
        int sizeY2 = getIntInput("Y: ");
        Matrix m = new Matrix(sizeX2, sizeY2);
        m.init();
        addMatrixToTheList(m);
        return m;
    }

    private void addMatrixToTheList(Matrix m){
        matrices.add(m);
    }
    private void displayMatricesList(){
        matrixDisplayer.showMessage(matrices);
    }


}
