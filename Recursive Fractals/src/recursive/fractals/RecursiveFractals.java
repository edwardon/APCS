/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package recursive.fractals;
import java.awt.Color;
import joyce.*;
/**
 *
 * @author Eddy
 */
public class RecursiveFractals {

    /**
     * @param args the command line arguments
     */
    
    public static void main(String[] args) {
        // TODO code application logic here
        Graph world = new Graph("Tree Fractal",1000,1000);
        JLine line = new JLine(new JPoint(0,-9), new JPoint(0,0));
        line.setBorderColor(Color.BLUE);
        world.draw(line);
        
        makeBranch(world,3,line,true,Math.PI/4.0);
        makeBranch(world,3,line,false,Math.PI/4.0);
    }
    public static void makeBranch(Graph world,int level,JLine startLine,boolean left,double angle) {
        if (level < 1)
            return;
        
        double distx = ((startLine.getEnd().getX() - startLine.getStart().getX()))*0.66;
        double disty = ((startLine.getEnd().getY() - startLine.getStart().getY()))*0.66;
        
        double dist = (Math.sqrt(Math.pow(distx,2) + Math.pow(disty,2)));
  
        double startX = startLine.getEnd().getX();
        double startY = startLine.getEnd().getY();
        
        if (left) {
            JLine lineLeft = new JLine(startX,startY,
            (startX-dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            lineLeft.setBorderColor(Color.RED);
            world.draw(lineLeft);
            
            makeBranch(world,level-1,lineLeft,true,angle-Math.PI/8.0);
            //
            lineLeft = new JLine(startX,startY,
            (startX-dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            makeBranch(world,level-1,lineLeft,false,angle-Math.PI/8.0);
        }
        else {
            
            JLine lineRight = new JLine(startX,startY,
           (startX+dist)*Math.cos(angle),(startY+(dist))*Math.sin(angle));
            lineRight.setBorderColor(Color.BLUE);
            world.draw(lineRight);
            makeBranch(world,level-1,lineRight,true,angle-Math.PI/8.0);
            makeBranch(world,level-1,lineRight,false,angle-Math.PI/8.0);
        }
        /*if (left) {
            JLine lineLeft = new JLine(startX,startY,
            (startX-dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            lineLeft.setBorderColor(Color.RED);
            world.draw(lineLeft);
            
            JLine lineRight = new JLine(startX,startY,
            (startX-dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            lineRight.setBorderColor(Color.RED);
            world.draw(lineRight);
            makeBranch(world,level-1,lineLeft,true,angle-Math.PI/8.0);
            makeBranch(world,level-1,lineRight,true,angle-Math.PI/8.0);
        }
        else {
            
            JLine lineLeft = new JLine(startX,startY,
            (startX+dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            lineLeft.setBorderColor(Color.BLUE);
            world.draw(lineLeft);
            
            JLine lineRight = new JLine(startX,startY,
            (startX+dist)*Math.cos(angle),(startY+dist)*Math.sin(angle));
            lineRight.setBorderColor(Color.BLUE);
            world.draw(lineRight);
            
            makeBranch(world,level-1,lineLeft,false,angle-Math.PI/8.0);
            makeBranch(world,level-1,lineRight,false,angle-Math.PI/8.0);
        }*/
        
       

    }
    
}
