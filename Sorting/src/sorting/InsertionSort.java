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
public class InsertionSort 
{
    public static void main(String args[])
    {
        Scanner in = new Scanner(System.in);
        System.out.println("How many integers to sort? Type a number over 100 to"
                +" sort over 100 random integers");
               
        int arraySize = in.nextInt();
        int[] array = new int[arraySize];
        
        if (arraySize >= 100)
        {
             for (int i = 0; i < array.length; i++)
             {
                 array[i] = (int) (Math.random() * array.length);
             }
        }
        else
        {
            System.out.println("Enter the integers to sort: ");

            for (int i = 0; i < array.length; i++)
            {
                array[i] = in.nextInt();
            }
        }
        
        System.out.println("Insertion Sorting..." );
        
        insertionSort(array);
       
        //done
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
        System.out.println("Done sorting.");
    }   
    
    public static void insertionSort(int[] array)
    {
        for (int i = 1; i < array.length; i++) //i = position in the array
        {
            
            for (int n = i;(n > 0) && (array[n-1] > array[n]);n--)
            {
                //the swap
                int temp = array[n];
                array[n] = array[n-1];
                array[n-1] = temp;
            }
        }
    }
}
