
package chessgame;

import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class King extends Piece
{

public King( Color color)
{
    super( color);

   //uploading image
    if(color==Color.BLACK)
    {
        image= new ImageIcon("bking.PNG");
    }
    if(color==Color.WHITE)
    {
        image= new ImageIcon("wking.PNG");
    }
}


   
    @Override
public ArrayList<Integer> PiecePath(int initialpos_x, int initialpos_y, Board b)
{
   int initID = (initialpos_x*8)+initialpos_y;

    if(initialpos_x-1 >= 0)
     {
            //allow movement upward one step
         
             if (b.spots[(initialpos_x-1)*8+initialpos_y].IsEmpty())
               
               {
                     arr_path.add((initialpos_x-1)*8+(initialpos_y));
               }
             
             else
               
               {
                    if(b.spots[(initialpos_x-1)*8+initialpos_y].piece.color != b.spots[initID].piece.color) 
                      
                      {
                          arr_path.add((initialpos_x-1)*8+(initialpos_y));
                      }

               }
             
             //move upward to the right one step
            if(initialpos_y+1 < 8)
             
               {
                     if(b.spots[(initialpos_x-1)*8+initialpos_y+1].IsEmpty())
                       
                       {
                           arr_path.add((initialpos_x-1)*8+(initialpos_y+1));
                       }
                     
                     else
                     
                       {
                            if(b.spots[(initialpos_x-1)*8+initialpos_y+1].piece.color != b.spots[initID].piece.color) 
                  
                               {
                                    arr_path.add((initialpos_x-1)*8+(initialpos_y+1));
                               }
                       }

                }
            
            //move upward to the left one step
            
            if(initialpos_y-1 >= 0)
                {
                     if(b.spots[(initialpos_x-1)*8+initialpos_y-1].IsEmpty())
                      
                       {
                            arr_path.add((initialpos_x-1)*8+(initialpos_y-1));
                       }
                    
                     else
                       
                      {
                         if(b.spots[(initialpos_x-1)*8+initialpos_y-1].piece.color != b.spots[initID].piece.color) 
                            {
                                arr_path.add((initialpos_x-1)*8+(initialpos_y-1));
                            }
                       }
                }
     }
        
    
    if(initialpos_x+1<8)
        {
            //move downward one step
            
             if(b.spots[(initialpos_x+1)*8+initialpos_y].IsEmpty())
             
               {
                   arr_path.add((initialpos_x+1)*8+(initialpos_y));
               }
             else
              
               {
                 if(b.spots[(initialpos_x+1)*8+initialpos_y].piece.color != b.spots[initID].piece.color) 
                        
                        {
                            arr_path.add((initialpos_x+1)*8+(initialpos_y));
                        }
               }
             
            //move downward to the left one step
            
             if(initialpos_y+1<8)
                {
                  if(b.spots[(initialpos_x+1)*8+initialpos_y+1].IsEmpty())
                    
                    {
                       arr_path.add((initialpos_x+1)*8+(initialpos_y+1));
                    }
                  
                  else
                  
                    {
                         if(b.spots[(initialpos_x+1)*8+initialpos_y+1].piece.color != b.spots[initID].piece.color) 
                           
                            {
                                arr_path.add((initialpos_x+1)*8+(initialpos_y+1));
                            }  
                    }
                }
             
             //move downward to the right one step
             
             if(initialpos_y-1>=0)
                {
                    if(b.spots[(initialpos_x+1)*8+initialpos_y-1].IsEmpty())
                      
                           {
                               arr_path.add((initialpos_x+1)*8+(initialpos_y-1));
                           }
                    else
                      
                      {
                         if(b.spots[(initialpos_x+1)*8+initialpos_y-1].piece.color != b.spots[initID].piece.color) 
                           
                           {
                              arr_path.add((initialpos_x+1)*8+(initialpos_y-1));
                           }
                      }
                }
        }   
        
    
    //move to the left one step
    
    if(initialpos_y-1>=0)    
        
        {   
            if(b.spots[(initialpos_x)*8+initialpos_y-1].IsEmpty())
               
                {
                    arr_path.add((initialpos_x)*8+(initialpos_y-1));
                }
           
            else
            
                {
                    if(b.spots[(initialpos_x)*8+initialpos_y-1].piece.color != b.spots[initID].piece.color) 
                
                        {
                            arr_path.add((initialpos_x)*8+(initialpos_y-1));
                        }
                }
        }
    
     //move to the right one step    
    
    if(initialpos_y+1<8)
    
       {
            if(b.spots[(initialpos_x)*8+initialpos_y+1].IsEmpty()) 
   
                {
                    arr_path.add((initialpos_x)*8+(initialpos_y+1));
                }
            
            else
            
                {
                 if(b.spots[(initialpos_x)*8+initialpos_y+1].piece.color != b.spots[initID].piece.color) 
                   
                        {
                            arr_path.add((initialpos_x)*8+(initialpos_y+1));
                        }
               }
        }

        return arr_path;
    }
}
//end class king

