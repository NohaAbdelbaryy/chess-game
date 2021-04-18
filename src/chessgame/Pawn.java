
package chessgame;



import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class Pawn extends Piece
{
    //constractor pawn
    public Pawn( Color color)
    {
        super( color);
        //upload image
        if(color==Color.BLACK)
        {
            image= new ImageIcon("bpawn.PNG");
        }
        if(color==Color.WHITE)
        {
            image= new ImageIcon("wpawn.PNG");
        }
    }

//function picecpath in pawn
    @Override
    public ArrayList<Integer> PiecePath(int initialpos_x, int initialpos_y, Board b)
    { 
        
        //alllegalmove in white
       if(this.color==Color.WHITE)       
       {
           if(b.spots[(initialpos_x-1)*8+initialpos_y].IsEmpty())
           {
               arr_path.add((initialpos_x-1)*8+(initialpos_y));
             
               if(pawncounter==0&&b.spots[(initialpos_x-2)*8+initialpos_y].IsEmpty())
            {
                arr_path.add((initialpos_x-2)*8+(initialpos_y));
            }
           }
           
       
            
         
           if(initialpos_x-1>=0&&initialpos_y+1<8)
           {
            if(!b.spots[(initialpos_x-1)*8+initialpos_y+1].IsEmpty())
            {
               if(b.spots[(initialpos_x-1)*8+initialpos_y+1].piece.color != Color.WHITE) 
               {
            arr_path.add((initialpos_x-1)*8+(initialpos_y+1));
               }
            }
           }
           
           
           
            if(initialpos_x-1>=0&&initialpos_y-1>=0)
           {
            if(!b.spots[(initialpos_x-1)*8+initialpos_y-1].IsEmpty())
            {
                if(b.spots[(initialpos_x-1)*8+initialpos_y-1].piece.color!= Color.WHITE)
                arr_path.add((initialpos_x-1)*8+(initialpos_y-1));
            }
            
           }
       }
        //all legalmove in black
       if(this.color==Color.BLACK)
       {
           
           if(b.spots[(initialpos_x+1)*8+initialpos_y].IsEmpty())
            {
                arr_path.add((initialpos_x+1)*8+(initialpos_y));
             
                if(pawncounter==0&&b.spots[(initialpos_x+2)*8+initialpos_y].IsEmpty())
             {
                 arr_path.add((initialpos_x+2)*8+(initialpos_y));
             }
        
            }
                
        
          
            if(initialpos_x+1<8&&initialpos_y+1<8)
           {
                if(!b.spots[(initialpos_x+1)*8+initialpos_y+1].IsEmpty())
                {
                     if(b.spots[(initialpos_x+1)*8+initialpos_y+1].piece.color != Color. BLACK) 
                   {
                    arr_path.add((initialpos_x+1)*8+(initialpos_y+1));
                   }
               }
            
           }
            
            if(initialpos_x+1<8&&initialpos_y-1>=0)
           {
                 
        
            if(!b.spots[(initialpos_x+1)*8+initialpos_y-1].IsEmpty())
                {
                             if(b.spots[(initialpos_x+1)*8+initialpos_y-1].piece.color != Color. BLACK) 
                             {
                             arr_path.add((initialpos_x+1)*8+(initialpos_y-1));
                             }
                }
           }
     
        }
       return arr_path;

}
     
}
//end class pawn



