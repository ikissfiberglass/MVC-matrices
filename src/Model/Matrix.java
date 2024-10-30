package Model;
import java.util.Random;

public class Matrix {
    private int sizeX;
    private int sizeY;
    private int[][] matrix;

    public Matrix() {}

    public Matrix(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.matrix = new int[sizeX][sizeY];
    }

    public int getSizeX() {
        return sizeX;
    }
    public int getSizeY() {
        return sizeY;
    }
    public int[][] getMatrix(   ) {
        return matrix;
    }



    public void init() {
        Random rand = new Random();
        for( int i = 0; i < sizeX; i++ ) {
            for(int j = 0; j < sizeY; j++ ) {
                this.matrix[i][j] = rand.nextInt(100);
            }
        }

    }

    public void display() {
        System.out.print("[");
        for( int i = 0; i < sizeX; i++ ) {
            for(int j = 0; j < sizeY; j++ ) {
                System.out.print(this.matrix[i][j] + " ");
            }
            System.out.println("\n");
        }
        System.out.print("]");

    }

    public void multiplication(Matrix m1, Matrix m2) throws IllegalArgumentException {
        if(m1.sizeY != m2.sizeX){
            throw new IllegalArgumentException("Wrong matrix size ");
        }



    }


}

