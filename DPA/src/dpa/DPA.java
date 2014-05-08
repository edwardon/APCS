/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package dpa;
import java.util.Date;
import java.io.*;
/**
 *
 * @author Eddy
 */
public class DPA {

    /**
     * @param args the command line arguments
     */
    
    
    private static String[] activities;
    private static String[] times;
    static PrintWriter writer;
    public static void main(String[] args) {
        try {
        writer = new PrintWriter("DPA.txt","UTF-8");
        activities = new String[] {"Basketball","Walking","Cycling","Soccer",
            "Weights","Swimming","Jogging","Volleyball","Pilates"};
        times = new String[] {"30 minutes", "45 minutes", "25 minutes", "60 minutes", "90 minutes"};
        printActivity(1,11,9);
        }
        catch (IOException e) {}
        finally {
            try {
                writer.close();
            }
            catch(Exception e) {}      
        }
    }
    public static void printActivity(int year, int dayNums, int month) {
        writer.println(month + "/" + dayNums + "/" + (2010 + year) + ":  "
            + activities[ (int) (Math.random() * 9) ] + " for " + times[ (int) (Math.random() * 5) ]);
        if (year == 4 && dayNums == 7 && month == 5)
            return;
        
        else if (month == 2 && dayNums >= 28) {
            printActivity(year,1,3);
        }
        else if (month >= 12 && dayNums >= 31) {
            printActivity(year+1,1,1);
        }
        else if (month % 2 == 0 && dayNums >= 30) {
            printActivity(year,1,month+1);
        }
        else if (month % 2 != 0 && dayNums >= 31) {
            printActivity(year,1,month+1);
        }
        else {
            printActivity(year,dayNums+1,month);
        }
    }
                
    
    
}
