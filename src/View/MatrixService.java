package View;


import Model.Matrix;

import javax.sound.midi.Soundbank;

public class MatrixService {

    public void displayMatrix(Matrix fantastic) {
        System.out.print("[\n");
            for( int i = 0; i < fantastic.getSizeX(); i++ ) {
                for(int j = 0; j < fantastic.getSizeY(); j++ ) {
                    System.out.print(fantastic.getMatrix()[i][j] + " ");
                }
                System.out.print("\n");
            }
            System.out.print("]\n");
    }

    public void displayTransposedMatrix(Matrix matrix) {
        System.out.print("[\n");
        for (int i = 0; i < matrix.getSizeY(); i++) {
            for (int j = 0; j < matrix.getSizeX(); j++) {
                System.out.print(matrix.getMatrix()[j][i] + " ");
            }
            System.out.print("\n");
        }
        System.out.print("]\n");
    }


    public  <T> void showMessage(T message){
        System.out.println(message);
    }

    public void showError(String errorMessage){
        System.err.println("Error: " + errorMessage);
    }
    
}
