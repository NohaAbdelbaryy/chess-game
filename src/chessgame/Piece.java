
package chessgame;


import java.awt.Color;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;

    


public abstract class Piece {

protected Boolean legalmove;
protected ImageIcon image;
protected ImageIcon imagenull;
protected int pawncounter;
protected Border border;
protected final Color color;
protected ArrayList<Integer> arr_path ;



  public Piece( Color color) 
  {
    this.border = new LineBorder(new Color(0,255,0), 3, true);
    pawncounter = 0;
    this.legalmove = false;
    this.color = color;
    imagenull= new ImageIcon();
    arr_path = new ArrayList <>();
  }


   
   public abstract  ArrayList<Integer> PiecePath(int initialpos_x, int initialpos_y, Board b);//function piecepath 
   
   public  boolean Canmove(Spot finalspot)            // function canmove
    {    
       
        legalmove = arr_path.contains(finalspot.GetID());  //checking for allowing the piece to move in the correct path 
         
        if(legalmove)
            {
                pawncounter++;
            }
   return legalmove;
   
    } 
   
   public void SetBorder(Board b, ArrayList<Integer> path)
   {
      
        for(int i:path)
       {
           b.spots[i].setBorder(border);
       }
       
   }
   public void RemoveBorder(Board b, ArrayList<Integer> path)
   {
      
        for(int i:path)
       {
           b.spots[i].setBorder(null);
       }
       
   }

}
      //end class piece  

