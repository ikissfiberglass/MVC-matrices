package Model;
import View.MatrixService;
import lombok.Getter;
import lombok.NoArgsConstructor;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Matrix {
    private final MatrixService matrixDisplayer = new MatrixService();
//    private static List<Matrix> matrices = new ArrayList<>();

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
//        this.matrices = new ArrayList<>();
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

//    public Matrix transpose() {
//        Matrix transposedMatrix = new Matrix(sizeY, sizeX);
//        for (int i = 0; i < sizeX; i++) {
//            for (int j = 0; j < sizeY; j++) {
//                transposedMatrix.matrix[j][i] = this.matrix[i][j];
//            }
//        }
//        return transposedMatrix;
//    }

    public static Matrix transpose(Matrix m) {
        Matrix transposedMatrix = new Matrix(m.sizeY, m.sizeX);
        try {
            for (int i = 0; i < m.sizeX; i++) {
                for (int j = 0; j < m.sizeY; j++) {
                    transposedMatrix.matrix[i][j] = m.matrix[j][i];
                }
            }
            return transposedMatrix;
        }catch (ArrayIndexOutOfBoundsException aioobe){
            return null;
        }
    }





//    public void addMatrixToTheList(Matrix m){
//        matrices.add(m);
//    }
//
//    public void displayMatricesList(List<Matrix> matrices){
//        if (matrices == null || matrices.isEmpty()){
//            matrixDisplayer.showMessage("Matrices list is empty");
//        }else {
//            for (Matrix matrix : matrices) {
//                System.out.println(matrix);
//            }
//        }
//    }

    //TODO ідею зі списком матриць краще вілкоасти, по завдання треба оперувати одночасно тільки двома матрицями

    @Override
    public String toString(){ //TODO доробити toString
        return "";
    }
}

