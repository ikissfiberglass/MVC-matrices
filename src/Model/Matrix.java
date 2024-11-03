package Model;
import View.MatrixService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private final MatrixService matrixDisplayer = new MatrixService();

    @Getter
    private int sizeX;

    @Getter
    private int sizeY;

    @Getter
    private int[][] matrix;


    public Matrix(){
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
            throw new IllegalArgumentException("Wrong matrices dimensions ");
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

//    public static Matrix transpose(Matrix m) { НОРМ
//        Matrix transposedMatrix = new Matrix(m.sizeY, m.sizeX);
//        try {
//            for (int i = 0; i < m.sizeY; i++) {
//                for (int j = 0; j < m.sizeX; j++) {
//                    transposedMatrix.matrix[j][i] = m.matrix[i][j];
//                }
//            }
//            return transposedMatrix;
//        }catch (ArrayIndexOutOfBoundsException aioobe){
//            System.err.println("EXCEPTION FROM MODEL CLASS");
//            return new Matrix(0,0);
//        }
//    }

    public static Matrix transpose(Matrix m) {
        int rows = m.sizeY;
        int columns = m.sizeX;
        Matrix transposedMatrix = new Matrix(columns, rows);
        try {
            for (int i = 0; i < rows; i++) {
                for (int j = 0; j < columns; j++) {
                    transposedMatrix.matrix[j][i] = m.matrix[i][j];
                }
            }
            return transposedMatrix;

        } catch (ArrayIndexOutOfBoundsException aioobe) {
            System.err.println("EXCEPTION FROM MODEL CLASS");
            return new Matrix(0, 0);
        }
    }


//    public static Matrix transpose(Matrix m) {
//        Matrix transposedMatrix = new Matrix(m.sizeY, m.sizeX);
//        for (int i = 0; i < m.sizeY; i++) {
//            for (int j = 0; j < m.sizeX; j++) {
//                transposedMatrix.matrix[j][i] = m.matrix[i][j];
//            }
//        }
//        return transposedMatrix;
//    } аутпут кидає в stderr + "Error: і Y вимір транспонованої матриці"

//просто якась хуйня
//    public static Matrix transpose(Matrix m) throws IndexOutOfBoundsException{
////        Matrix res = m;
//        Matrix res = new Matrix(m.sizeY, m.sizeX);
//        try {
//            for (int i = 0; i < m.sizeX; i++) {
//                    for (int j = 0; j < m.sizeY; j++) {
//                        res.matrix[i][j] = m.matrix[j][i];
//                    }
//                }
//            return res;
//        } catch (IndexOutOfBoundsException iae) {
//            throw new ArrayIndexOutOfBoundsException("something went wrong(transpose) ");
//            //якась діч тому що res має ті самі виміри, що  і початкова матриця. А мають бути початково обернені
//        }
//    }


    @Override
    public String toString(){ //TODO доробити toString
        return "";
    }
}

