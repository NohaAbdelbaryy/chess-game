
package chessgame;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;



public class Queen extends Piece{
    //constactor queen
    public Queen( Color color) {
        super( color);
     
          //upload image  
        if(color==Color.BLACK)
        {
            image= new ImageIcon("bqueen.png");
           
        }
        if(color==Color.WHITE)
        {
            image= new ImageIcon("wqueen.png");
            
        }
    }


    //function piecepath
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
        //all legal moves in the down right diagonal
       
        for(int i=1, j=1; i<8&&j<8;i++,j++)
       {     
           //check if index is out of bounds
          
           if(initialpos_x+i>=8||initialpos_y+j>=8)
            {
                break;
            }
           
           if(b.spots[(initialpos_x+i)*8+(initialpos_y+j)].IsEmpty())
           {
               arr_path.add((initialpos_x+i)*8+(initialpos_y+j));
                
           }
           else
           {
               if(b.spots[initID].piece.color!=b.spots[(initialpos_x+i)*8+(initialpos_y+j)].piece.color)
               {
                   arr_path.add((initialpos_x+i)*8+(initialpos_y+j));
               }
                break;
           }

                 
               
       }
              

            //all legal moves in the up right diagonal
           
            for(int i=1, j=1; i<8&&j<8;i++,j++)
          { 
          
             if(initialpos_x-i<0||initialpos_y+j>=8)
            {
             break ;
           
            }
            if (b.spots[(initialpos_x-i)*8+(initialpos_y+j)].IsEmpty())
            {
                arr_path.add((initialpos_x-i)*8+(initialpos_y+j));
               
            }
            else 
            {
                if(b.spots[initID].piece.color!=b.spots[(initialpos_x-i)*8+(initialpos_y+j)].piece.color)
                {
                arr_path.add((initialpos_x-i)*8+(initialpos_y+j));  
                }
                break;
            }

             
           
         }
            

          //all legal moves in the up left diagonal
          
          for(int i=1, j=1; i<8&&j<8;i++,j++)
         {     
               if(initialpos_x-i<0||initialpos_y-j<0)
               {
                   break;
               }
               if (b.spots[(initialpos_x-i)*8+(initialpos_y-j)].IsEmpty())
               {
                    arr_path.add((initialpos_x-i)*8+(initialpos_y-j));
                    
               }
               else 
               {
                    if(b.spots[initID].piece.color!=b.spots[(initialpos_x-i)*8+(initialpos_y-j)].piece.color)
                    {
                        arr_path.add((initialpos_x-i)*8+(initialpos_y-j));
                    }
                    break ;
               }

                   
                    

           } 
            

           //all legal moves in the down left diagonal
           
           for(int i=1, j=1; i<8&&j<8;i++,j++)
           {    
                if(initialpos_x+i>=8||initialpos_y-j<0)
                {
                      break;
                }
                if(b.spots[(initialpos_x+i)*8+(initialpos_y-j)].IsEmpty())
                {
                     arr_path.add((initialpos_x+i)*8+(initialpos_y-j));
                    
                }
                else 
                {
                    if(b.spots[initID].piece.color!=b.spots[(initialpos_x+i)*8+(initialpos_y-j)].piece.color)
                    {
                     arr_path.add((initialpos_x+i)*8+(initialpos_y-j));
                    }
                     break ;
                }

                   
               
            }
           
        return arr_path;
    }

   
}
//end class queen

