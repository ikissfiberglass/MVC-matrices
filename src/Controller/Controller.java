package Controller;

import Model.Matrix;
import View.MatrixService;
import java.util.*;

public class Controller  {
    private final MatrixService matrixDisplayer = new MatrixService();
    private final Scanner scanner = new Scanner(System.in);
    private Matrix res;

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
                case '1': //TODO transposition
                    matrixDisplayer.showMessage("Which matrix would you like to transpose? \n" + "1 = the first one \n2 = second");
                    try {
                        if (scanner.nextInt() == 1) {
                            transposeMatrix(m1);
                        } else if (scanner.nextInt() == 2) {
                            transposeMatrix(m2);
                        }
                    } catch (InputMismatchException ime) {
                        matrixDisplayer.showError("Enter only numbers\n");
                    }
                    break;
                case '2': // TODO multiplication
                    try {
                        res = multiplyMatrices(m1, m2);
                        matrixDisplayer.displayMatrix(res);
                    } catch (IllegalArgumentException iae) {
                        matrixDisplayer.showError(iae.getMessage());
                    }
                    break;
                case '3': // TODO result matrix transposition
                    try {
                        transposeMatrix(res);
                    } catch (NullPointerException e) {
                        matrixDisplayer.showError("Please, multiply the matrices first");
                    }
                    break;
                case '4':
                    displayInputMatrices(m1,m2);
                    break;
                case '5':
                        try {
                            if(res == null){
                                throw new NullPointerException("Result matrix hasn't been defined yet");
                            }else {
                                matrixDisplayer.displayMatrix(res);
                            }
                        } catch (NullPointerException npe) {
                            matrixDisplayer.showError(npe.getMessage());
                        }
                    break;
                case 'Q':
                    isRunning = false;
                    matrixDisplayer.showMessage("Exit programz");
                    break;
                case 'R': //reboot
                    menu();
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
                matrixDisplayer.showError("Please, input a number");
                scanner.next();
            }
        }
    }

    private char getOption(){
        matrixDisplayer.showMessage("Wybierz opcje: ");
        matrixDisplayer.showMessage(" 1. Transponowanie \n 2. Mnozenie \n " +
                "3. Transponowanie macierzy wynikowej \n 4. Wyświetlenie macierze wajściowych \n 5. Wyświetlenie macierzy wynikowej \n" +
                "Q  - quit\nR - reset matrices");
        return  scanner.next().toUpperCase().charAt(0);
    }

    private void transposeMatrix(Matrix m){
        matrixDisplayer.showMessage("Transposed matrix: \n");
        matrixDisplayer.displayTransposedMatrix(m);
    }

    private Matrix multiplyMatrices(Matrix m1, Matrix m2) {
        try{
            return Matrix.multiplication(m1,m2);
        }catch (IllegalArgumentException | NullPointerException e){
            matrixDisplayer.showError(e.getMessage());
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

    private void displayInputMatrices(Matrix m1, Matrix m2) {
        matrixDisplayer.showMessage("First matrix:\n");
        matrixDisplayer.displayMatrix(m1);
        matrixDisplayer.showMessage("Second matrix:\n");
        matrixDisplayer.displayMatrix(m2);
    }
}
