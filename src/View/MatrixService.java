package View;


import Model.Matrix;

public class MatrixService {
    private final Matrix m3 = new Matrix();

    public void display() {
        System.out.print("[");
        for( int i = 0; i < m3.getSizeX(); i++ ) {
            for(int j = 0; j < m3.getSizeY(); j++ ) {
                System.out.println(m3.getMatrix()[i][j]);
            }
            System.out.println("\n");
        }
        System.out.print("]");
    }


    
}
