/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package factorials;
import java.util.*;
/**
 *
 * @author Eddy
 */
public class Factorials 
{

    /**
     * @param args the command line arguments
     */
    public static int Factorial (int n)
    {
        if (n < 2)
        {
            return n;
        }
        
        return n*Factorial(n-1);
        
    }
    public static void main(String[] args) 
    {
        System.out.println("Find the factorial of which number?");
        Scanner in = new Scanner(System.in);
        int num = in.nextInt();
        System.out.println(Factorial(num));
    }
    
}
