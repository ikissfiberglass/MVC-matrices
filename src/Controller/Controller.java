package Controller;

import Model.Matrix;
import View.MatrixService;

import java.util.Scanner;

public class Controller {
    private final Matrix m = new Matrix();
    private final MatrixService ms = new MatrixService();


    public void menu(){
        Scanner scanner = new Scanner(System.in);
        System.out.println("1. Transponowanie ");

        System.out.println("Wybierz opcje: ");
        int switcher = scanner.nextInt();
        switch(switcher){
            case 1: //TODO transponowanie macierze wejsciowej
                break;
            case 2: // TODO mnozenie
                break;
            case 3:
                break; // TODO transponowanie macierzy wynikowej
        }


    }



}
