/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;

/**
 *
 * @author ENVY
 */
public class GameGUI
{
        private final JFrame frame = new JFrame();
        private final JPanel NavPanel1 = new JPanel();
        private final JPanel NavPanel2 = new JPanel();
        private final JPanel NavPanel3 = new JPanel();
        private final JPanel NavPanel4 = new JPanel();
        private final Player player1 = new Player(Color.WHITE);
        private final Player player2 = new Player(Color.BLACK);    
        private final Board board = new Board(player1, player2);
        private final ImageIcon imagep1;
        private final ImageIcon imagep2;
        private final ImageIcon imagep3;
        private final ImageIcon imagep4;
        private final JLabel labelp1;
        private final JLabel labelp2;
        private final JLabel labelp3;
        private final JLabel labelp4;
        
    public GameGUI()
    {
        frame.setTitle("Chess Game");
        frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);   //Frame
        frame.setLayout(new BorderLayout());
        frame.setResizable(true);

        NavPanel1.setBackground(new Color(0xF6F6F6));
        NavPanel1.setPreferredSize(new Dimension(100,150));
        NavPanel2.setBackground(new Color(0xF6F6F6));            //Navpanel
        NavPanel2.setPreferredSize(new Dimension(100,150));
        NavPanel3.setBackground(new Color(0xF6F6F6));
        NavPanel3.setPreferredSize(new Dimension(50,100));
        NavPanel4.setBackground(new Color(0xF6F6F6));
        NavPanel4.setPreferredSize(new Dimension(30,100));
        
        imagep1=new  ImageIcon("panal1.png");
        imagep2=new  ImageIcon("panal2.png");                  
        imagep3=new  ImageIcon("panal3.png");        //numbers vertical
        imagep4=new  ImageIcon("panal4.png");       //letters  horizontal 
        
        labelp1=new JLabel();
        labelp2=new JLabel();
        labelp3=new JLabel();
        labelp4=new JLabel();
        labelp1.setSize(100,150);
        labelp2.setSize(100,150);               //labels
        labelp1.setIcon(imagep1);
        labelp2.setIcon(imagep2);
        labelp3.setIcon(imagep3);
        labelp4.setIcon(imagep4);
        
        NavPanel1.add(labelp1);
        NavPanel2.add(labelp2);
        NavPanel1.add(labelp4);
        NavPanel3.add(labelp3);
        
        frame.add(board.container,BorderLayout.CENTER); 
        frame.add(NavPanel1,BorderLayout.NORTH);
        frame.add(NavPanel2,BorderLayout.SOUTH);
        frame.add(NavPanel3,BorderLayout.WEST);
        frame.add(NavPanel4,BorderLayout.EAST);
        frame.pack();
        frame.setVisible(true);

    }
    
    
}
//end class GameGUI
