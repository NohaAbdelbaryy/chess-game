package chessgame;


import java.awt.BorderLayout;
import java.awt.Color;
import java.awt.Dimension;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.util.ArrayList;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPanel;


public class Spot extends JPanel implements MouseListener{

  private final int x ;
  private final int y ;
  private final int ID;
  private final Color color; 
  private boolean IsEmpty = false ;
  private boolean legalmove;
  protected Piece piece ;
  protected JLabel label;
  private static int counter ;
  private static Spot InitialSpot ;
  private static Spot FinalSpot;
  private static int IDCheck;
  protected Board board;

    public Spot(int x, int y, Color color , Piece piece , int ID ,Board board) {
        
        this.label = new JLabel();
        this.x = x;
        this.y = y;
        this.piece=piece;
        this.color = color;            
        this.ID = ID ;
        this.setBackground(this.color);
        this.setLayout(null);
        this.setPreferredSize(new Dimension(75, 75));
        this.addMouseListener(this);
        label.setBounds(5, 0, 75,75 );
        this.add(label);
        this.board = board;
    }
    
    public void setPiece(Piece piece )
    
    {
        this.piece = piece;
    }
    
    public Piece getPiece() 
    
    {
        return piece;
    }
        public int GetX() 
    {
        return x;
    }

    public int GetY() 
    
    {
        return y;
    }
    
    public int GetID() 
    
    {
        return ID;
    }
    
    public boolean IsEmpty ()
    
    {
        if (this.piece == null)
        {
            IsEmpty = true;
        }   
        else 
        {
            IsEmpty = false;
        }
        return IsEmpty ;
    }

   //function of mouse action on spots
    
    @Override
   
    public void mouseClicked(MouseEvent e) {
       
        Spot spotTemp = (Spot) e.getSource();       
        
        //first click
        
        if (counter == 0)
        {   
            //check for a piece
            
            if (!board.spots[spotTemp.ID].IsEmpty())
            {    

                //check for turn
                if((board.spots[spotTemp.ID].piece.color == Color.WHITE && board.player1.IsTurn)
                 ||(board.spots[spotTemp.ID].piece.color == Color.BLACK && board.player2.IsTurn))
                {
                    InitialSpot = spotTemp ;
                    ArrayList<Integer> path = board.spots[spotTemp.ID].piece.PiecePath(InitialSpot.x, InitialSpot.y, board);
                   
                    //highlighting piece's path
                    piece.SetBorder(board, path);
                    counter++ ;
                } 

            }
         }
        
        //second click
        else if (counter == 1 )
        {
            
             
               FinalSpot  =  (Spot) e.getSource();
                int initialID = InitialSpot.ID ;
                int finalID = FinalSpot.ID;
                legalmove = board.spots[initialID].piece.Canmove(FinalSpot);
                  
                //checking if the piece's path is not legal                
                if(legalmove == false)
                
                {   //remove the highlighted path 
                    board.spots[initialID].piece.RemoveBorder(board, board.spots[initialID].piece.arr_path);
                    board.spots[initialID].piece.arr_path.clear();
                    
                    counter = 0; //allow to choose another piece
                }
                
                //checking if the chosen path is legal            
                if(legalmove)
               
                {   
                    
                    board.spots[initialID].piece.RemoveBorder(board, board.spots[initialID].piece.arr_path); //remove highlighted path
                    
                    //move the piece to the final spot 
                    board.spots[finalID].label.setIcon(board.spots[initialID].piece.image);    
                    board.spots[initialID].label.setIcon(board.spots[initialID].piece.imagenull) ; 
                    
                    counter = 0 ; //allowing to choose another piece
                 
                    //checking if a king was killed                    
                    if(board.spots[finalID].piece instanceof King)
                    {
                        JFrame gameOver = new JFrame();
                        gameOver.setLayout(new BorderLayout());
                        gameOver.setTitle("GAME OVER");
                        JLabel winLabel = new JLabel();
                        gameOver.setVisible(true);
                         
                       if(board.spots[finalID].piece.color==Color.WHITE)
                       {
                           
                           
                           counter = -1;//to prevent any further moves
                         ImageIcon imageB = new ImageIcon("Black wins.jpg");
                         winLabel.setIcon(imageB);
                          gameOver.add(winLabel);
                       }
                       else if(board.spots[finalID].piece.color==Color.BLACK)
                       {
                           
                         ImageIcon imageW = new ImageIcon("white wins.jpg");
                         winLabel.setIcon(imageW);
                          gameOver.add(winLabel);
                          
                           
                           counter = -1;//to prevent any further moves
                       }
                       gameOver.pack();
                    }
                    
                    //changing piece in the destination spot to the piece that got moved to it
                    
                    board.spots[finalID].setPiece(board.spots[initialID].piece);
                    board.spots[initialID].piece.arr_path.clear();
                    
                    board.spots[initialID].setPiece(null) ; //emptying the past spot from piece after movement
                    
                    InitialSpot = null;
                    FinalSpot = null;
                    
                    //changing turns after finishing the move
                    if(board.player1.IsTurn)
                       {
                            board.player1.setIsTurn(false);
                            board.player2.setIsTurn(true);
                                  
                            if(board.CheckIndex() > -1)
                                {
                                     //checking if a king is checked
                                    IDCheck = board.CheckIndex(); //getting the spot checked for white
                                }
                                   else
                                {
                                    board.spots[IDCheck].setBorder(null);//removing highlight from the spot that was checked
                                }
                       }
                    
                      else if(board.player2.IsTurn)
                       {
                            board.player2.setIsTurn(false);
                            board.player1.setIsTurn(true); 
                            
                            if(board.CheckIndex()>-1) //checking if a king is checked
                            
                                {
                                    IDCheck = board.CheckIndex();//getting the spot checked for black
                                }
                           
                            else
                            
                                {
                                    board.spots[IDCheck].setBorder(null);//removing highlight from the spot that was checked
                                }
                       }
                }
                
                 
            
        }
    
    }
    
    @Override
    public void mousePressed(MouseEvent me) {
                   
       
    }

    @Override
    public void mouseReleased(MouseEvent me) {

    }

    @Override
    public void mouseEntered(MouseEvent me) {
 

    }

    @Override
    public void mouseExited(MouseEvent me) {
  
    }
    
    
}
//end of class spot
