/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package swingpaint;

import java.awt.*;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import javax.imageio.ImageIO;
import javax.swing.*;

/**
 *
 * @author melodytribble
 */
public class MyFrame extends JFrame implements ActionListener {

    public static MyFrame inst;
    BufferedImage image;
    Graphics2D gc;

    public static MyFrame getInstance() {
        if (inst == null) {
            inst = new MyFrame();
        }

        return inst;
    }

    MyFrame() {

        super("Swing Paint");
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);//will stop program when X is hit
        Container c = getContentPane();
        this.setJMenuBar(setUpBar());
        c.add(CanvasPanel.getInstance(), BorderLayout.CENTER);
        c.add(ButtonPanel.getInstance(), BorderLayout.NORTH);
        setSize(1000, 1000);//sets open size
        setVisible(true);//make window 

    }

    public JMenuBar setUpBar() {//sets up a menu bar

        JMenuBar bar = new JMenuBar();
        setSize(1000, 1000);
        JMenu file = new JMenu("File");
        JMenu edit = new JMenu("Edit");
        JMenu choices = new JMenu("Choices");
        JMenu help = new JMenu("Help");

        JMenuItem one = new JMenuItem("Save");
        one.addActionListener(this);
        JMenuItem two = new JMenuItem("Load");
        two.addActionListener(this);
        JMenuItem three = new JMenuItem("three");
        three.addActionListener(this);
        three.setEnabled(false); //making it not clickable
        JMenuItem four = new JMenuItem("four");
        four.addActionListener(this);
        JMenuItem five = new JMenuItem("five");
        five.addActionListener(this);
        JMenuItem about = new JMenuItem("about");
        about.addActionListener(this);

        file.add(one);
        file.add(new JSeparator());
        file.add(two);

        edit.add(four); //reverse Order
        edit.add(new JLabel("place holder"));
        edit.add(three);

        choices.add(five);

        help.add(about);

        bar.add(file);
        bar.add(edit);
        bar.add(choices);
        bar.add(help);
        setVisible(true);

        return bar;
    }

    public void actionPerformed(ActionEvent ae) {
        String command = ae.getActionCommand();

        if (command.equals("about")) {

            JWindow window = new JWindow();
            window.setBounds(500, 150, 300, 200);
            window.setVisible(true);

            repaint();

            try {
                Thread.sleep(5000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            window.setVisible(false);
            window.dispose();
        }

//            final SplashScreen splash = SplashScreen.getSplashScreen();
//            if (splash == null) {
//                System.out.println("SplashScreen.getSplashScreen() returned null");
//                return;
//            }
//            Graphics2D g = splash.createGraphics();
//            if (g == null) {
//                System.out.println("g is null");
//                return;
//        }
//        splash.update();
//        splash.close();
//        JFrame aboutFrame = new JFrame();
//        aboutFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
//        aboutFrame.setSize(200, 200);//sets open size
//        aboutFrame.setVisible(true);//make window 
//        }
        if (command.equals("Save")) {//saves image

            BufferedImage bImg = new BufferedImage(CanvasPanel.getInstance().getWidth(), CanvasPanel.getInstance().getHeight(), BufferedImage.TYPE_INT_RGB);
            Graphics2D cg = bImg.createGraphics();
            CanvasPanel.getInstance().paintAll(cg);
            try {
                if (ImageIO.write(bImg, "png", new File("./output_image.png"))) {
                    System.out.println("-- saved");
                }
            } catch (IOException e) {
                // TODO Auto-generated catch block
                e.printStackTrace();
            }
        }
        if (command.equals("Load")) {
            CanvasPanel.getInstance().loadImage();
        }

        System.out.println(ae.getActionCommand());

    }

// public void paintComponent(Graphics g){ 
//     
//        super.paintComponent(g);  
//        Graphics2D g2 = (Graphics2D)g;//g2 paints on panel itself
//        int w = this.getWidth();//gets dimentions of Canvas panel
//        int h = this.getHeight();
//        
//        if(image == null){            
//            image = (BufferedImage)(this.createImage(w,h));//Creates a image of the same dimentions
//            gc = image.createGraphics();//gc is paintbrush for buffered image
//           
//         }
//         g2.drawImage(image, null, 0, 0);//starting in the top left corner. paints image onto panel
//    }
}
