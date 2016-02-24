/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpaint;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.JPanel;
import java.awt.event.*;
import java.awt.geom.AffineTransform;
import java.awt.image.BufferedImage;
import java.util.Scanner;
import javax.swing.*;

/**
 *
 * @author melodytribble
 */
public class CanvasPanel extends JPanel implements MouseListener, MouseMotionListener{
  
    public static CanvasPanel inst;
    
    int startX, startY, widthX, heightY, endX, endY, strokeSize;
    int shape = 6;  
    String text;
    Graphics2D gc;
    BufferedImage grid;
    
    Color currentColor = Color.MAGENTA;


    
    CanvasPanel(){
        addMouseListener(this);
        addMouseMotionListener(this);
        startX = 0;
        startY = 0;
        widthX = 50;
        heightY = 50;
      
    }
    
    public static CanvasPanel getInstance(){
        if(inst == null)
            inst =  new CanvasPanel();
         return inst;
    }

 
    public void paintComponent(Graphics g)
    { 
        super.paintComponent(g);  
        Graphics2D g2 = (Graphics2D)g;//g2 paints on panel itself
        int w = this.getWidth();//gets dimentions of Canvas panel
        int h = this.getHeight();
        
        if(grid == null){            
            grid = (BufferedImage)(this.createImage(w,h));//Creates a image of the same dimentions
            g2.setBackground(Color.CYAN);
            gc = grid.createGraphics();//gc is paintbrush for buffered image
           
         }
         g2.drawImage(grid, null, 0, 0);//starting in the top left corner. paints image onto panel
    }
    
    public void setShape(int x){
        shape = x;
    }
    
    public void setStroke(int y){
        strokeSize = y;
    }
    
    public void draw(){
        
        gc.setStroke(new BasicStroke(strokeSize));
        gc.setColor(currentColor);
        
        if(shape ==1){//draws line
            gc.drawLine(startX, startY, endX, endY);
            repaint();
            
        }else if(shape == 2){//draws rectangle
            gc.fillRect(startX, startY, widthX, heightY);
            repaint();
            
        }else if(shape == 3){//draws oval
            System.out.println("oval");
            gc.fillOval(startX, startY, widthX, heightY);
            repaint();
            
        }else if(shape == 4){//outline of rectangle
            gc.drawRect(startX, startY, widthX, heightY);
            repaint();
            
        }else if(shape == 5){//outline of oval
            gc.drawOval(startX, startY, widthX, heightY);
            repaint();
            
        }else if(shape == 7){//draws line
            gc.drawLine(startX, startY, widthX+startX, heightY+startY);
            repaint();
        
        }else if(shape == 8){//switches to text
            text = "text";
            text = JOptionPane.showInputDialog("Enter Text");
            gc.drawString(text, startX, startY);
            repaint();
        }
        
    }
    public void loadImage(){//loads image onto background
        Image img = getToolkit().getImage("/Users/melodytribble/NetBeansProjects/SwingPaint/colorSwatch.png");
        gc.drawImage(img, new AffineTransform(), this);
        repaint();
    }
    public void clear(){//erases drawing
        
        gc.clearRect(0, 0, this.getWidth(),this.getHeight());
            repaint();
    }
    
    public Color getColor(){
        return currentColor;
    }
    
    public void setColor(Color c){
        currentColor = c;
    }
    
    public void mousePressed(MouseEvent e){
        
        repaint();
        startX = e.getX();
        startY = e.getY();
    }  
    
    public void mouseReleased(MouseEvent e){
        
        if(shape == 1){//called when line button is active
            endX = e.getX();
            endY = e.getY();
        }else{//shape isn't 1 or a line
            if(startX>e.getX()){
                int endX = startX;
                startX = e.getX();
                widthX = endX - startX;
            }else{
                widthX = e.getX()-startX;
            }
            if(startY >e.getY()){
                int endY = startY;
                startY = e.getY();
                heightY = endY - startY;
            }else{
                heightY = e.getY() -startY; 
            }
        }       
        draw();
    }
    public void mouseDragged(MouseEvent e){
        if (shape ==7){//called when trace button is active
            widthX = e.getX()-startX;
            heightY = e.getY() -startY; 
            draw();
            startX = e.getX();
            startY = e.getY();
        }
        
    }
    
    public void mouseExited(MouseEvent e){
    //    setBackground(Color:DARK GREY)
    }
    
    public void mouseEntered(MouseEvent e){
       // setBackground(Color:DARK GREY)
        }
    
    public void mouseClicked(MouseEvent e){}

    public void mouseMoved(MouseEvent e) {
    }

   
}
