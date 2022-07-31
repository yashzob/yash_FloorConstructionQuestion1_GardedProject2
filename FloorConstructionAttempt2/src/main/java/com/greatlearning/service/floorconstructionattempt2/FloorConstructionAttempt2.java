/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Project/Maven2/JavaApp/src/main/java/${packagePath}/${mainClassName}.java to edit this template
 */
package com.greatlearning.service.floorconstructionattempt2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;

/**
 *
 * @author DELL
 */
public class FloorConstructionAttempt2 {

    public static void main(String[] args) {
        int[] inputValues = GetUserValue();
        int[] sortedValues = SortArrayAsc(inputValues);
        int startIndex = 0;
        int endIndex = sortedValues.length - 1;
        List temp = new ArrayList();
        while (endIndex >= 0) {
            if (temp.contains(sortedValues[endIndex])) {
                System.out.print(", "+sortedValues[endIndex]);
                temp.remove(Integer.valueOf(sortedValues[endIndex]));
                endIndex--;
            }
            else if (inputValues[startIndex] != sortedValues[endIndex]) {
                temp = AddToTemp(startIndex, endIndex, sortedValues, inputValues, temp);                
                System.out.println();
                System.out.print("Day " + (startIndex + 1) + ": ");
                startIndex++;
            } 
            else if (inputValues[startIndex] == sortedValues[endIndex]) {
                System.out.println();
                System.out.print("Day " + (startIndex + 1) + ": " + sortedValues[endIndex]);
                endIndex--;
            }
        }
    }

    private static List AddToTemp(int startIndex, int endIndex, int[] sortedValues, int[] inputValues, List temp) {
        if (!temp.contains(sortedValues[endIndex])) {
            temp.add(inputValues[startIndex]);
        }
        return temp;
    }

    private static int[] GetUserValue() {
        Scanner sc = new Scanner(System.in);
        //get the number of floor
        System.out.println("Enter the number of floor in the building ");
        int size = sc.nextInt();
        // get the floor size in each day
        int inputfloorsize[] = new int[size];
        System.out.println("Enter the size of each floor");
        for (int i = 0; i < size; i++) {
            inputfloorsize[i] = sc.nextInt();
        }

        return inputfloorsize;
    }

    private static int[] SortArrayAsc(int[] input) {
        int sortedArray[] = new int[input.length];
        System.arraycopy(input, 0, sortedArray, 0, input.length);
        Arrays.sort(sortedArray);
        return sortedArray;
    }
}
