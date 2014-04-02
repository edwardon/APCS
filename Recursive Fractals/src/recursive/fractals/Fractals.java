/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package fractals;
import java.awt.Color;
import joyce.*;
/**
 *
 * @author Edward Onochie
 */
public class Fractals {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        Graph world = new Graph("H Tree",1000,1000);
        JLine line = new JLine(-5,0,5,0);
        world.draw(line);   
        makeH(world,line,15,true);
    }
    
    public static void makeH(Graph world,JLine line, int level,boolean vertical) {
        
        // base case
        if (level < 1) {
            return;
        }
        if (vertical) {
            // make vertical
            JPoint left = line.getStart();
            JPoint right = line.getEnd();
            double length = (left.getX() - right.getX())*0.8;
            
            JLine leftLine = new JLine(left.getX(),(left.getY() + (length/2)),
                     left.getX(),(left.getY() - (length/2))); 
            
            JLine rightLine = new JLine(right.getX(),(right.getY() + (length/2)),
                     right.getX(),(right.getY() - (length/2))); 
             
             world.draw(leftLine);
             world.draw(rightLine);
             
             makeH(world,leftLine,level - 1,false);
             makeH(world,rightLine,level - 1,false);
             // Double recursive, tail recursion
        }
        else {
            // make horizontal
            JPoint top = line.getStart();
            JPoint bottom = line.getEnd();
            double length = (top.getY() - bottom.getY())*0.66;
            
            JLine topLine = new JLine(top.getX() + (length/2),top.getY(),
                    top.getX() - (length/2),top.getY());
            
            JLine bottomLine = new JLine(bottom.getX() + (length/2),bottom.getY(),
                    bottom.getX() - (length/2),bottom.getY());
             
             world.draw(topLine);
             world.draw(bottomLine);
             
             makeH(world,topLine,level - 1,true);
             makeH(world,bottomLine,level - 1,true);
        }  
    }
    
}
