/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package sorting;
import java.util.*;
/**
 *
 * @author Eddy
 */
public class BinarySearch {
    
    public static void main(String args[]) {
        int[] array = {1,5,1,2,6,3,6,1,23,6,2,1,2,35,6,2,3,52,3};
        mergeSort(array);
        
        for (int i = 0; i < array.length; i++) {
            System.out.println(array[i]);
        }
        
        System.out.println("Search for which value?");
        Scanner in = new Scanner(System.in);
        int value = in.nextInt();
        int index = binarySearch(array,value);
        
        if (index != -1) {
            System.out.println("Found at index: " + index);
        }
        else {
            System.out.println("Not found...");
        }
                   
    }
    public static int binarySearch(int array[], int value) {   
        // returns the index of the value, if found.
        //base case:
        if (array.length < 2 && array[0] != value) {
            return -1;
            }
        
        int mid = array.length/2;
        if (array[mid] == value) {
            return mid;
        }
        else {
            int leftValue = array[mid - 1];
            if (leftValue <= value) {
                
                if (leftValue == value)
                    return (mid - 1); //found
                
                //toss the whole left side + mid, and pass the right side as a paramenter
                int[] newArray = new int[array.length - mid - 1];
                for (int i = mid+1; i < array.length; i++) {
                    newArray[i - (mid+1)] = array[i];
                }
                return binarySearch(newArray,value);
            }
            else {
                //toss the whole right side + mid, and pass the left side as a paramenter
                int[] newArray = new int[mid - 1];
                for (int i = 0; i < mid - 1; i++) {
                    newArray[i] = array[i];
                }
                return binarySearch(newArray,value);
            }
        }
       
    }
    public static void mergeSort(int array[]) {
        //breaking up the array into individual elements(divide and conquer)
        //Bsae case:
        if (array.length < 2) {
            return;
        }
        int mid = array.length/2;
        int[] left = new int[mid];
        int[] right = new int[array.length - mid]; //could be an odd number of elements
        
        for (int i = 0; i < mid; i++) {
            left[i] = array[i];
        }
        for (int i = mid; i < array.length;i++) {
            right[i - mid] = array[i];
        }   
        
        mergeSort(left);
        mergeSort(right);
        merge(left,right,array);
    }
            
    public static void merge(int[] left, int[] right, int[] array) {
        int indexl = 0;
        int indexr = 0;
        int indexa = 0;
        
        while (indexl < left.length && indexr < right.length) {
            
            if (left[indexl] < right[indexr]) {
                array[indexa] = left[indexl];
                indexa++;
                indexl++;
            }
            else {
                array[indexa] = right[indexr];
                indexa++;
                indexr++;
            }
        }
        while (indexl < left.length) {
            array[indexa] = left[indexl];
            indexa++;
            indexl++;
        }
        while (indexr < right.length) {
            array[indexa] = right[indexr];
            indexa++;
            indexr++;
        }
    }
}
