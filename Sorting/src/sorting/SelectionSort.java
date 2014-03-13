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
public class SelectionSort {

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) 
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
        
        System.out.println("Selection Sorting..." );
        
        selectionSort(array);
       
        //done
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
        System.out.println("Done sorting.");
        
    }
    
    public static void selectionSort(int[] array)
    {
         //Selection sort code:
        int n = 0;
        int foundIndex = 0;
        boolean canSwap = false;
        
        
        while (n < array.length - 1) 
        /*n = leftbound, sub 1 because when the interval length is 1 
        it's already sorted. */
            
        {
            canSwap = false; 
            int smallest = array[n]; //smallest on the interval [n,array.length)
            
            for (int i = n + 1; i < array.length; i++)
            {
                if (array[i] < smallest)
                {
                    smallest = array[i];
                    foundIndex = i;
                    canSwap = true;
                }
            }
            
            // swap
            if (canSwap)
            {
                int temp = array[n];
                array[n] = array[foundIndex];
                array[foundIndex] = temp;    
            }
          
            n++;
        }
        
        
    }
}
