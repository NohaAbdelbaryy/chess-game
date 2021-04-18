/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

package chessgame;

import java.awt.Color;
import java.awt.GridLayout;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import javax.swing.BorderFactory;
import javax.swing.ImageIcon;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;



/**
 *
 * @author 10
 */
public class MainMenu implements MouseListener {
    private final JFrame frame = new JFrame();
    private final JLabel label = new JLabel();
    private final JButton button1 = new JButton("START");
    private final  JButton button2 = new JButton("EXIT");
    private final ImageIcon imageE ;
    
    
  
   public MainMenu()
   {
       
       
       button1.setBounds(319, 545, 140, 65);
       button1.setFocusable(false);
       button1.addMouseListener(this);
       button1.setBorder(BorderFactory.createEmptyBorder(0,0,0,0));
       button1.setOpaque(false);
       button1.setContentAreaFilled(false);
       button1.setBorderPainted(false);
       
       button2.setOpaque(false);
       button2.setContentAreaFilled(false);
       button2.setBorderPainted(false);
       button2.setBounds(315, 633, 150, 70);
       button2.setFocusable(false);
       button2.addMouseListener(this);
       
       
       imageE = new ImageIcon("mainmenu.PNG");
       
       
       frame.setTitle("main menu");     
       frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
       frame.setResizable(true);
       label.add(button1);
       label.add(button2);
       frame.setLayout(new GridLayout(1,1));
       label.setBounds(500, 900,900 ,900 );
       label.setIcon(imageE);
       frame.setVisible(true);
       frame.add(label);
       frame.pack();
   }

    //mouselistner functions 
    
@Override
 public void mouseEntered( MouseEvent e)
{
    if(e.getSource()==button1)

   {   

   button1.setForeground(Color.LIGHT_GRAY);
   button1.setOpaque(false);
   button1.setContentAreaFilled(false);
   }
    
    
    if(e.getSource()==button2)

   {  
   button2.setForeground(Color.LIGHT_GRAY);
   button2.setOpaque(false);
   button2.setContentAreaFilled(false);
   }


}

@Override
public void mouseClicked(MouseEvent e) {
   if(e.getSource()==button1)

   {   
       frame.dispose();

      GameGUI gameGUI = new GameGUI();
   }

   else if (e.getSource()==button2){
       frame.dispose();


   }
}

    @Override
    public void mousePressed(MouseEvent me) {
       //code here if needed 
    }

    @Override
    public void mouseReleased(MouseEvent me) {
       //code here if needed
    }

    @Override
    public void mouseExited(MouseEvent me) {
        if(me.getSource()==button1)
          
       {   
       button1.setOpaque(false);
       button1.setContentAreaFilled(false);
       button1.setBorderPainted(false);
       button1.setForeground(Color.BLACK);
       }
        if(me.getSource()==button2)
          
       {   
       button2.setOpaque(false);
       button2.setContentAreaFilled(false);
       button2.setBorderPainted(false);
       button2.setForeground(Color.BLACK);
       }
    }
    
    
    
}
//end main menu 