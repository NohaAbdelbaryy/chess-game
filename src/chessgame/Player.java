
package chessgame;

import java.awt.Color;


public class Player 
{

 private final Color color;
 protected boolean IsTurn = false;


    //constractor player
public Player(Color color)
{
    this.color = color;
    if(this.color == Color.WHITE)
    {
        IsTurn = true;
    }
    else
    {
        IsTurn = false;
    }

}

//function setisturn
public void setIsTurn(boolean IsTurn) 
{
    this.IsTurn = IsTurn;
}
    
}
//end class player

