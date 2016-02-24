/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpaint;


import java.awt.Color;
import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import javax.swing.*;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import javax.swing.border.TitledBorder;
import javax.swing.colorchooser.AbstractColorChooserPanel;
/**
 *
 * @author melodytribble
 */
public class ButtonPanel extends JPanel implements ActionListener{

    private static ButtonPanel inst;
    private JButton clearButton, fillRectButton, fillOvalButton, emptRectButton, emptOvalButton, lineButton, traceButton, chooseColorButton,
                    smallLine, medLine, largeLine, textButton, zoomInButton, zoomOutButton;
    private ImageIcon oval, rectangle, foval, frectangle, clear, line, trace, color, sLine, mLine, lLine, type,in, out;
    Graphics g;
    
    public static ButtonPanel getInstance(){
         
        if(inst == null)
           inst =  new ButtonPanel();
        return inst;
    }

    ButtonPanel(){
        setBackground(Color.DARK_GRAY);
        setLayout(new FlowLayout());
        
        BufferedImage i = new BufferedImage(30, 30, 2);//zooms in
        Graphics2D gi = i.createGraphics();
        gi.setColor(CanvasPanel.getInstance().getColor());
        gi.drawString("+",10,18);
        in = new ImageIcon(i);
        zoomInButton = new JButton(in);
        zoomInButton.addActionListener(this);
        add(zoomInButton);
        setVisible(true);
        
        BufferedImage o = new BufferedImage(30, 30, 2);//zooms out
        Graphics2D go = o.createGraphics();
        go.setColor(CanvasPanel.getInstance().getColor());
        go.drawString("-",10,18);
        out = new ImageIcon(o);
        zoomOutButton = new JButton(out);
        zoomOutButton.addActionListener(this);
        add(zoomOutButton);
        setVisible(true);
        
        BufferedImage tx = new BufferedImage(30, 30, 2);//creates text button
        Graphics2D text = tx.createGraphics();
        text.setColor(CanvasPanel.getInstance().getColor());
        text.drawString("T",12,20);
        type = new ImageIcon((tx));
        textButton = new JButton(type);
        textButton.addActionListener(this);
        add(textButton);
        setVisible(true);
        
        BufferedImage sm = new BufferedImage(30, 30, 2);//creates small stroke button
        Graphics2D small = sm.createGraphics();
        small.setColor(CanvasPanel.getInstance().getColor());
        //sline.setStroke(new BasicStroke(1)) how do I make this a small line
        small.setStroke(new BasicStroke(1));
        small.drawLine(7,7,18,18);
        sLine = new ImageIcon((sm));
        smallLine = new JButton(sLine);
        smallLine.addActionListener(this);
        add(smallLine);
        setVisible(true);
        
        BufferedImage md = new BufferedImage(30, 30, 2);//creates med stroke button
        Graphics2D medium = md.createGraphics();
        medium.setColor(CanvasPanel.getInstance().getColor());
        medium.setStroke(new BasicStroke(5));
        medium.drawLine(7,7,18,18);
        mLine = new ImageIcon((md));
        medLine = new JButton(mLine);
        medLine.addActionListener(this);
        add(medLine);
        setVisible(true);
        
        BufferedImage lg = new BufferedImage(30, 30, 2);//creates large stroke button
        Graphics2D large = lg.createGraphics();
        large.setColor(CanvasPanel.getInstance().getColor());
        large.setStroke(new BasicStroke(10));
        large.drawLine(7,7,18,18);
        lLine = new ImageIcon((lg));
        largeLine = new JButton(lLine);
        largeLine.addActionListener(this);
        add(largeLine);
        setVisible(true);
     

        BufferedImage col = new BufferedImage(30, 30, 2);//creates change color button
        Graphics2D gcol = col.createGraphics();
        gcol.setColor(Color.blue);
        gcol.fillRect(5,5,18,18);
        color = new ImageIcon(col);
        chooseColorButton = new JButton(color); 
        chooseColorButton.addActionListener(this);
        add(chooseColorButton);

        
        BufferedImage clr = new BufferedImage(30, 30, 2);//creates clear button
        Graphics2D gcl = clr.createGraphics();
        gcl.setColor(CanvasPanel.getInstance().getColor());
        gcl.drawString("X",12,20);
        clear = new ImageIcon(clr);
        clearButton = new JButton(clear);
        clearButton.addActionListener(this);
        add(clearButton);
        setVisible(true);
        
        BufferedImage ln = new BufferedImage(30, 30, 2);//creates line button
        Graphics2D gline = ln.createGraphics();
        gline.setColor(CanvasPanel.getInstance().getColor());
        gline.drawLine(5,5,18,18);
        line = new ImageIcon(ln);
        lineButton = new JButton(line);
        lineButton.addActionListener(this);
        add(lineButton);
        setVisible(true);
        
        BufferedImage trc = new BufferedImage(30, 30, 2);//creates freehand draw button
        Graphics2D gtrace = trc.createGraphics();
        gtrace.setColor(CanvasPanel.getInstance().getColor());
        gtrace.drawString("S", 12, 20);
        trace = new ImageIcon(trc);
        traceButton = new JButton(trace);
        traceButton.addActionListener(this);
        add(traceButton);
        setVisible(true);

        BufferedImage frec = new BufferedImage(30, 30, 2);//creates a filled rectangle button
        Graphics2D gr = frec.createGraphics();
        gr.setColor(CanvasPanel.getInstance().getColor());
        gr.fillRect(5,5,18,18);
        frectangle = new ImageIcon(frec);
        fillRectButton = new JButton(frectangle);
        fillRectButton.addActionListener(this);
        add(fillRectButton);
        setVisible(true);
        
        BufferedImage ov = new BufferedImage(30, 30, 2);//creates a filled oval button
        Graphics2D gc = ov.createGraphics();
        gc.setColor(CanvasPanel.getInstance().getColor());
        gc.fillOval(5,5,18,18);
        foval = new ImageIcon(ov);
        fillOvalButton = new JButton(foval);
        fillOvalButton.addActionListener(this);
        add(fillOvalButton);
        setVisible(true);
        
        BufferedImage erct = new BufferedImage(30, 30, 2);//creates outline rectangle button
        Graphics2D grempty = erct.createGraphics();
        grempty.setColor(CanvasPanel.getInstance().getColor());
        grempty.drawRect(5,5,18,18);
        rectangle = new ImageIcon(erct);
        emptRectButton = new JButton(rectangle);
        emptRectButton.addActionListener(this);
        add(emptRectButton);
        
        BufferedImage eoval = new BufferedImage(30, 30, 2);//creates outline oval button
        Graphics2D goempty = eoval.createGraphics();
        goempty.setColor(CanvasPanel.getInstance().getColor());
        goempty.drawOval(5,5,18,18);
        oval = new ImageIcon(eoval);
        emptOvalButton = new JButton(oval);
        emptOvalButton.addActionListener(this);
        add(emptOvalButton);
        
        
    }

     public void actionPerformed(ActionEvent ae){
         
        String command = ae.getActionCommand();

                if(ae.getSource()==clearButton){//calls clear method
                    CanvasPanel.getInstance().clear();
                    
                }else if(ae.getSource()==lineButton){//set's shape to line
                    CanvasPanel.getInstance().setShape(1);
                    
                }else if(ae.getSource()==fillRectButton){//sets shape to filled rectangle
                    CanvasPanel.getInstance().setShape(2);
                   
                }else if(ae.getSource()==fillOvalButton){//sets shape to filled oval
                    CanvasPanel.getInstance().setShape(3);
                    
                }else if(ae.getSource()==emptRectButton){//sets shape to rectangle
                    CanvasPanel.getInstance().setShape(4);                    
                    
                }else if(ae.getSource()==emptOvalButton){//sets shape to oval
                    CanvasPanel.getInstance().setShape(5);  
                    
                }else if(ae.getSource()==traceButton){//sets shape to free draw
                    CanvasPanel.getInstance().setShape(7);
                
                }else if(ae.getSource()==chooseColorButton){//creates a color pallet chooser
                    
                    JColorChooser cc = new JColorChooser();
                    JFrame colorFrame = new JFrame();
                    colorFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
                    colorFrame.setSize(500, 500);//sets open size
                    colorFrame.setVisible(true);//make window 
                    JPanel colorPanel = new JPanel();
                    colorPanel.add(cc, BorderLayout.NORTH);
                    colorFrame.add(colorPanel);
                    Color color=JColorChooser.showDialog(this,"Select a color",Color.black); 
                    System.out.println(color);
                    CanvasPanel.getInstance().setColor(color);

                    
                }else if(ae.getSource()==smallLine){//sets stroke size small
                    CanvasPanel.getInstance().setStroke(1);
                    
                }else if(ae.getSource()==medLine){//sets stroke size to med
                    CanvasPanel.getInstance().setStroke(3);
                    
                }else if(ae.getSource()==largeLine){//sets stroke size to large
                    CanvasPanel.getInstance().setStroke(10);
                
                }else if(ae.getSource()==textButton){//changes paint function to text
                    CanvasPanel.getInstance().setShape(8);                    
                
//                }else if(ae.getSource()==zoomInButton){
//                    CanvasPanel.getInstance().zoomIn();
//                    
//                }else if(ae.getSource()==zoomOutButton){
//                    CanvasPanel.getInstance().zoomOut();
                }

                
        System.out.println(ae.getActionCommand());
     }

}   
    

