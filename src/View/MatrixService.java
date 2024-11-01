package View;


import Model.Matrix;

import javax.sound.midi.Soundbank;

public class MatrixService {

    public void displayMatrix(Matrix fantastic) {
        System.out.print(" \n [");
        for( int i = 0; i < fantastic.getSizeX(); i++ ) {
            for(int j = 0; j < fantastic.getSizeY(); j++ ) {
                System.out.println(fantastic.getMatrix()[i][j]);
            }
            System.out.println("\n");
        }
        System.out.print("]");
    }

    public <T> void showMessage(T message){
        System.out.println(message);
    }

    public void showError(String errorMessage){
        System.err.println("Error: " + errorMessage);
    }
    
}
