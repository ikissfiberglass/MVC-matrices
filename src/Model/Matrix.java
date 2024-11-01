package Model;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.Random;

public class Matrix {
    @Getter
    private int sizeX;

    @Getter
    private int sizeY;

    @Getter
    private int[][] matrix;

    public Matrix(){
//        this.matrix = new int[3][3];
        throw new IllegalArgumentException("No dimensions( ");
    }

    public Matrix(int sizeX, int sizeY) {
        this.sizeX = sizeX;
        this.sizeY = sizeY;
        this.matrix = new int[sizeX][sizeY];
    }

    public void init() {
        Random rand = new Random();
        for( int i = 0; i < sizeX; i++ ) {
            for(int j = 0; j < sizeY; j++ ) {
                this.matrix[i][j] = rand.nextInt(100);
            }
        }

    }

    public static Matrix multiplication(Matrix m1, Matrix m2) {
        if(m1.sizeY != m2.sizeX){
            throw new IllegalArgumentException("Wrong matrix size ");
        }
        Matrix result = new Matrix(m1.sizeX, m2.sizeY);

        for (int i = 0; i < m1.sizeX; i++) {
            for (int j = 0; j < m2.sizeY; j++) {
                int sum = 0;
                for (int k = 0; k < m1.sizeY; k++) {
                    sum += m1.matrix[i][k] * m2.matrix[k][j];
                }
                result.matrix[i][j] = sum;
            }
        }
        return result;
    }

    public Matrix transpose() {
        Matrix transposedMatrix = new Matrix(sizeY, sizeX);
        for (int i = 0; i < sizeX; i++) {
            for (int j = 0; j < sizeY; j++) {
                transposedMatrix.matrix[j][i] = this.matrix[i][j];
            }
        }
        return transposedMatrix;
    }

}

