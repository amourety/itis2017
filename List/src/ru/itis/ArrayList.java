package ru.itis;

import java.util.Scanner;

/**
 * Created by amour on 26.09.2017.
 */
public class ArrayList {
    int array[] = new int[10];
    int count = 0;
    void addElement(int element){
        if (count <= array.length) {
            array[count] = element;
            count++;

        }
        else
        {
            System.out.println("Переполнен");
        }
    }
    void showArray(){
        for(int i = 0; i < count; i++){
            System.out.print(array[i] + " ");
        }
    }
}
