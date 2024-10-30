import Model.Matrix;

public class Main {

    //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
    public static void main(String[] args) {
//TODO catch
        try{
            Matrix matrix = new Matrix(10,10);
            matrix.init();
        }catch(IllegalArgumentException e){
            System.out.println(e.getMessage());
        }



    }
}


