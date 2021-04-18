/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;


import java.awt.Color;
import javax.swing.ImageIcon;
import java.util.ArrayList;



public class Knight extends Piece
{
   //constractor knight
    public Knight( Color color)
    {
        super( color);
        
        //upload image
        if(color==Color.BLACK)
        
        {
        image= new ImageIcon("bknight.PNG");
        
        }
        if(color==Color.WHITE)
        
        {
        image= new ImageIcon("wknight.PNG");
        
        }
    }
    
    //function picecpath in knight
    
    //all legal moves
    @Override
    
    public ArrayList<Integer> PiecePath(int initialpos_x, int initialpos_y, Board b) 
    
    {
        int initID = (initialpos_x)*8+(initialpos_y);

        
        if(initialpos_x+2 <= 7 && initialpos_y-1 >= 0)  //check if the index is out of bounds 
        {    
               // legal move in the near top left spot
            
               if(b.spots[(initialpos_x+2)*8+initialpos_y-1].IsEmpty())
               
                   {
                        arr_path.add((initialpos_x+2)*8+(initialpos_y-1));
                   }     
              else
                   { 
                        //don't add a piece that has the same color
                   if(b.spots[initID].piece.color != b.spots[(initialpos_x+2)*8+(initialpos_y-1)].piece.color)
                        
                        {
                            arr_path.add((initialpos_x+2)*8+(initialpos_y-1));
                        }
                
           }
               
        }
       
        
        if(initialpos_x-2 >= 0 && initialpos_y-1 >= 0)//check if the index is out of bounds 
        {
              // legal move in the near down left spot
           if(b.spots[(initialpos_x-2)*8+initialpos_y-1].IsEmpty())
                   {
                    arr_path.add((initialpos_x-2)*8+(initialpos_y-1));
                   }    
            else
           {
               //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x-2)*8+(initialpos_y-1)].piece.color) 
               { 
               
                   arr_path.add((initialpos_x-2)*8+(initialpos_y-1));
               }
                
           }
        } 
       
        
        
        if(initialpos_x+2 <= 7 && initialpos_y+1 <= 7)//check if the index is out of bounds 
        {
            // legal move in the near top right spot
            if(b.spots[(initialpos_x+2)*8+initialpos_y+1].IsEmpty())
                   {
                    arr_path.add((initialpos_x+2)*8+(initialpos_y+1));
                   }         
             else
           {
               //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x+2)*8+(initialpos_y+1)].piece.color)
               {
                   arr_path.add((initialpos_x+2)*8+(initialpos_y+1));
               }
                
           }
        }
       
        
        if(initialpos_x-2 >= 0 && initialpos_y+1 <= 7)//check if the index is out of bounds 
        {
            // legal move in the near down right spot
           if(b.spots[(initialpos_x-2)*8+initialpos_y+1].IsEmpty())
                   {
                    arr_path.add((initialpos_x-2)*8+(initialpos_y+1));
                   }        
            else
           {
               //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x-2)*8+(initialpos_y+1)].piece.color)
               {
                   arr_path.add((initialpos_x-2)*8+(initialpos_y+1));
               }
                
           }
        }
        
       
        
        if(initialpos_x+1 <= 7&&initialpos_y-2 >= 0)//check if the index is out of bounds 
        {
            // legal move in the far top left spot
          if(b.spots[(initialpos_x+1)*8+initialpos_y-2].IsEmpty())
                   {
                    arr_path.add((initialpos_x+1)*8+(initialpos_y-2));
                   }          
             else
           {
                //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x+1)*8+(initialpos_y-2)].piece.color)
               {
                   arr_path.add((initialpos_x+1)*8+(initialpos_y-2));
               }
                
           }
        }
      
        
        
        if(initialpos_x-1 >= 0 && initialpos_y-2 >= 0)//check if the index is out of bounds 
        {
            // legal move in the far down right spot
          if(b.spots[(initialpos_x-1)*8+initialpos_y-2].IsEmpty())
                   {
                    arr_path.add((initialpos_x-1)*8+(initialpos_y-2));
                   }       
            else
           {
               //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x-1)*8+(initialpos_y-2)].piece.color)
               {
                   arr_path.add((initialpos_x-1)*8+(initialpos_y-2));
               }
                
           }
        }
     
         
        if(initialpos_x+1 <= 7 && initialpos_y+2 <= 7 )//check if the index is out of bounds 
        {
            // legal move in the far top right spot
           if(b.spots[(initialpos_x+1)*8+initialpos_y+2].IsEmpty())
                   {
                    arr_path.add((initialpos_x+1)*8+(initialpos_y+2));
                   }       
             else
           {
               //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x+1)*8+(initialpos_y+2)].piece.color)
               {
                   arr_path.add((initialpos_x+1)*8+(initialpos_y+2));
               }
                
           }
        }
      
         
         
        if(initialpos_x-1 >= 0 && initialpos_y+2 <= 7)//check if the index is out of bounds 
        {
            // legal move in the far down right spot
             if(b.spots[(initialpos_x-1)*8+initialpos_y+2].IsEmpty())
                   {
                    arr_path.add((initialpos_x-1)*8+(initialpos_y+2));
                   }          
              else
           {
              //don't add a piece that has the same color
               if(b.spots[initID].piece.color != b.spots[(initialpos_x-1)*8+(initialpos_y+2)].piece.color)
               {
                   arr_path.add((initialpos_x-1)*8+(initialpos_y+2));
               }
                
           }
        }
        

        return arr_path;
    }

   
    
}
//end class knight
