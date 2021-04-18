
package chessgame;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class Rook extends Piece {

    public Rook( Color color) {
        super( color);
     //upload image
        if(color==Color.BLACK)
        {
        image= new ImageIcon("brook.PNG");
        
        }
        if(color==Color.WHITE)
        {
        image= new ImageIcon("wrook.PNG");
        
        }
    }

    
   //function piecepath in rook
    @Override
    public ArrayList<Integer> PiecePath(int initialpos_x, int initialpos_y, Board b) {
       
    int initID = (initialpos_x)*8+(initialpos_y);
        //all legalmovein down
        
        for(int i=1 ; i<8;i++)
        {
            
            if((initialpos_x+i)>=8)
            {
                break;
            }
             
            
            if((b.spots[(initialpos_x+i)*8+(initialpos_y)].IsEmpty()))
            
            {
                arr_path.add((initialpos_x+i)*8+(initialpos_y));
            }
            
             else
            {
                if(b.spots[initID].piece.color!=b.spots[(initialpos_x+i)*8+(initialpos_y)].piece.color)
                
                {
                    
                arr_path.add((initialpos_x+i)*8+(initialpos_y));
                
                }
                 break;
            }
        }
        //all legalmove up
        for(int i=1 ; i<8;i++)
        {
            if((initialpos_x-i)<0)
            {
                break;
            }
            
            if(b.spots[((initialpos_x-i)*8+initialpos_y)].IsEmpty())
            
            {
                arr_path.add((initialpos_x-i)*8+(initialpos_y));
            }
            else
            {
                if(b.spots[initID].piece.color!=b.spots[(initialpos_x-i)*8+(initialpos_y)].piece.color)
                
                {
                arr_path.add((initialpos_x-i)*8+(initialpos_y));
                }
                break;
            }
        
           
    
        }
        //all legalmove right
        for(int i=1 ; i<8;i++)
        {
            
            if((initialpos_y+i)>=8)
            {
             
                break;
        
            }
            if(b.spots[((initialpos_x)*8+initialpos_y+i)].IsEmpty())
            
            {
                arr_path.add((initialpos_x)*8+(initialpos_y+i));
            }
            else
            {
                if(b.spots[initID].piece.color!=b.spots[(initialpos_x)*8+(initialpos_y+i)].piece.color)
                
                {
                arr_path.add((initialpos_x)*8+(initialpos_y+i));
                }
                break;
            }
                
        }
        //all legalmove left
        for(int i=1 ; i<8;i++)
        {
             if((initialpos_y-i)<0)
             {
             
                 break;
             }
             if(b.spots[((initialpos_x)*8+initialpos_y-i)].IsEmpty())
            
            {
                 arr_path.add((initialpos_x)*8+(initialpos_y-i));
            }
             else
            {
                if(b.spots[initID].piece.color!=b.spots[(initialpos_x)*8+(initialpos_y-i)].piece.color)
                
                {
                 arr_path.add((initialpos_x)*8+(initialpos_y-i));
                }
                break;
            }
        }
        
        return arr_path;   
    }
}
//eng class rook
