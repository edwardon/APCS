package sorting;
import java.util.*;
/**
 *
 * @author Eddy
 */
public class MergeSort 
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
        
        System.out.println("Merge Sorting..." );
        
        mergeSort(array);
       
        //done
        for (int i = 0; i < array.length; i++)
        {
            System.out.println(array[i]);
        }
        
        System.out.println("Done sorting.");
    }   
    
    public static void mergeSort(int[] array)
    {
        if (array.length < 2)
        {
            return; //already divided into one element
        }
        int middle = array.length / 2;
        
        int[] left = new int[middle];
        int[] right = new int[array.length - middle];
        
        for(int i = 0; i < middle; i++)
        {
            left[i] = array[i];
        }
        
        for(int i = middle; i < array.length; i++)
        {
            right[i - middle] = array[i];
        }
        
        mergeSort(left);
        mergeSort(right);
        
        merge(array,left,right);
        
    }
    
    public static void merge(int arrayA[], int[] arrayL, int[] arrayR)
    {
        // merging two sorted arrays
        int indexL = 0;
        int indexR = 0;
        int indexA = 0;
        
        while(indexL < arrayL.length && indexR < arrayR.length)
        {
            if (arrayL[indexL] <= arrayR[indexR])
            {
                arrayA[indexA] = arrayL[indexL];
                indexA++;
                indexL++;                  
            }
            else
            {
                arrayA[indexA] = arrayR[indexR];
                indexA++;
                indexR++;
            }
        }
        //leftovers
        while (indexL < arrayL.length)
        {
            arrayA[indexA] = arrayL[indexL];
            indexA++;
            indexL++;
        }
        while (indexR < arrayR.length)
        {
            arrayA[indexA] = arrayR[indexR];
            indexA++;
            indexR++;
        }
    }
}