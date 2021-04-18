/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package chessgame;

import java.awt.Color;
import java.awt.GridLayout;
import javax.swing.JPanel;
import javax.swing.border.Border;
import javax.swing.border.LineBorder;


public class Board 
{
     
    
    protected Spot []spots = new Spot[64];
    private final Border border;
    protected JPanel container = new JPanel(); 
    
    private final Rook brook=new Rook(Color.BLACK);
    private final Rook brook2=new Rook(Color.BLACK);
    private final Rook wrook=new Rook(Color.white);
    private final Rook wrook2=new Rook(Color.white);
     
    private final Knight bknight=new Knight(Color.BLACK);
    private final Knight bknight2=new Knight(Color.BLACK);
    private final Knight wknight=new Knight(Color.white);
    private final Knight wknight2=new Knight(Color.white);
     
    private final Bishop bbishop=new Bishop(Color.BLACK);
    private final Bishop bbishop2=new Bishop(Color.BLACK);
    private final Bishop wbishop=new Bishop(Color.white);
    private final Bishop wbishop2=new Bishop(Color.white);
  
    private final Queen bqueen = new Queen(Color.BLACK);
    private final Queen wqueen = new Queen(Color.white);
    private final King  bking=new King(Color.BLACK);
    private final King  wking=new King(Color.white);
      
    private final Pawn bpawn[]=new Pawn[8];
    private final Pawn wpawn[]=new Pawn[8];
     
   
      
    protected Player player1;
    protected Player player2;
    //private int nRows;   
      
    
                
                
    //constractor board 
    public Board(Player player1, Player player2)
    {
         //nRows = 0;
        Piece p = null;
        this.border = new LineBorder(new Color(255,0,0), 3, true);
       
        this.player1=player1;
        this.player2 = player2;
        
        this.InitSpots(0,p);
        this.InitPieces();
        
      
       
        container.setLayout(new GridLayout(8,8));
      
        //Defining Spots
        for (int i = 0  ; i < 64 ; i++)
        {
            container.add(spots[i]);
        }
        
        
    }
    
    private void InitSpots(int nRows, Piece p)
    {
      
        
        for(int i=0;i<64;i+=16)
        {
            
            
            for(int x=0;x<8;x++)
            {
                if(x%2==0)
                {
                    spots[x+i] = new Spot(nRows, x, Color.WHITE, p, x+i, this);
                    
                }
                else
                {
                    spots[x+i] = new Spot(nRows, x, new Color(0x0D2E50), p, x+i, this);
                    
                }
              
            }
            
            nRows++;
             
            for(int j=0;j<8;j++)
            {
                if(j%2==0)
                {
                    spots[(j+8)+i] = new Spot(nRows, j,  new Color(0x0D2E50), p, j+8+i,this);
                    
                }
                else
                {
                    spots[(j+8)+i] = new Spot(nRows, j, Color.WHITE, p, j+8+i, this);
                    
                }
              
                
            }
            nRows++;
            

        }
    }
    private void InitPieces()
    {
        for(int i = 0; i<8;i++)
        {
            bpawn[i]=new Pawn(Color.BLACK);
            wpawn[i]=new Pawn(Color.WHITE);
        }

      
        spots[0].setPiece(brook);
        spots[7].setPiece(brook2);
        spots[1].setPiece(bknight);
        spots[6].setPiece(bknight2);
        spots[2].setPiece(bbishop);
        spots[5].setPiece(bbishop2);
        spots[3].setPiece(bqueen);
        spots[4].setPiece(bking);
        
        for(int i=8,j=0;i<16;i++,j++)
            {
                spots[i].setPiece(bpawn[j]);
            }

        for(int i=0;i<16;i++)
            {
                spots[i].label.setIcon(spots[i].piece.image);
               
            }

        spots[56].setPiece(wrook);
        spots[63].setPiece(wrook2);
        spots[57].setPiece(wknight);
        spots[62].setPiece(wknight2);
        spots[58].setPiece(wbishop);
        spots[61].setPiece(wbishop2);
        spots[59].setPiece(wqueen);
        spots[60].setPiece(wking);

        for(int i=48,j=0;i<56;i++,j++)
            {
                spots[i].setPiece(wpawn[j]);
            }

        for(int i=48;i<64;i++)
            {
                spots[i].label.setIcon(spots[i].piece.image);
            }
    
    }
    
    public int CheckIndex(){
        
        int CheckID = -1;
        for(int i = 0; i<64; i++)
        {
           if (!this.spots[i].IsEmpty())
           {
               
               this.spots[i].piece.PiecePath(this.spots[i].GetX(), this.spots[i].GetY(), this);
               
               for(int ID:this.spots[i].piece.arr_path)
               {
                   
                   if(!this.spots[ID].IsEmpty())
                   {
                       if(this.spots[ID].piece instanceof King)
                       {
                           CheckID = ID ;
                           this.spots[ID].setBorder(border);
                           break;
                       }

                    }
                }
              
                this.spots[i].piece.arr_path.clear();
               
           }
          
        }
        return CheckID;
    }
    
}
//end board