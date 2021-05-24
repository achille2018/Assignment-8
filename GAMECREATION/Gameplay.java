package GAMECREATION;

import javax.swing.JPanel;
import java.awt.event.*;
// import java.util.Timer;
import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.Color;
import java.awt.Font;

import javax.swing.Timer;
import javax.swing.plaf.FontUIResource;

import java.awt.Rectangle;

public class Gameplay extends JPanel implements KeyListener,ActionListener {
    private Boolean play = false;
    private int score =0 ;

    private int totalBricks = 21 ;
    private Timer time;

    private int delay = 8;
    private int playerX=310;

    private int ballposX=120;
    private int ballposY=350;
    private int ballXdir=-1;
    private int ballYdir=-2;

    private Generetor map ;




    public Gameplay () {
        map = new Generetor(3, 7);
        addKeyListener(this);
        setFocusable(true);
        setFocusTraversalKeysEnabled(false);
        time = new Timer(delay,this);
        time.start();
        
        

    }

    public void paint(Graphics g){

         //background ,
    g.setColor(Color.black);
    g.fillRect(1, 1, 692, 592);

    //drawing map 
    // map.draw((Graphics2D)g);
    //borders
    g.setColor(Color.yellow);
    g.fillRect(0,0,3,592);
    g.fillRect(0,0,692,3);
    g.fillRect(691,0,3,592);

    //Scores
    g.setColor(Color.yellow);
    g.setFont(new Font("serif",Font.BOLD,25));
    g.drawString(""+score, 590, 30);

    //the paddle
    g.setColor(Color.green);
    g.fillRect(playerX, 550, 100, 8);

    //draw 
    map.draw((Graphics2D)g);

    //Ball 
    g.setColor(Color.yellow);
    g.fillOval(ballposX,ballposY,15, 15);

    if(totalBricks<-0){
        play=false;
        ballXdir=0;
        ballYdir=0;
        g.setColor(Color.red);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("you won ", 260, 300);

        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Press Enter to Restart", 230, 350);

    }

    if(ballposY>570){
        play=false;
        ballXdir=0;
        ballYdir=0;
        g.setColor(Color.red);
        g.setFont(new Font("serif",Font.BOLD,30));
        g.drawString("Game over,score:", 190, 300);
        g.setFont(new Font("serif",Font.BOLD,20));
        g.drawString("Press Enter to Restart", 230, 350);
    }

    g.dispose();


    }

//This part has the object of my game .score ,ball ,the bricks ...
//so I add all the condition is neccesary for my program

    @Override
    public void actionPerformed(ActionEvent e) {
        time.start();
        if(play){
            if (new Rectangle(ballposX,ballposY,20,20).intersects(new Rectangle(playerX,550,100,8))){
                ballYdir =- ballposY;
            }
            A:for(int i = 0 ; i<map.map.length;i++){
                for (int j = 0 ; j<map.map.length;j++){
                    if (map.map[i][j]>0){
                        int brickX = j* map.brickWidth + 80;
                        int brickY = i * map.brickHeight +50;
                        int brickWidth = map.brickWidth;
                        int brickHeight = map.brickHeight;

                        Rectangle rect = new Rectangle(brickX,brickY,brickWidth,brickHeight);
                        Rectangle ballRect = new Rectangle(ballposX,ballposY,20,20);
                        Rectangle brickRect = rect ;

                        if (ballRect.intersects(brickRect)){
                            map.setBrickvalue(0, i, j);
                            totalBricks--;
                            score +=5;

                            if(ballposX + 19 <= brickRect.x || ballposX + 1 >= brickRect.x + brickRect.width){
                                ballXdir = - ballYdir;
                            }else{
                                ballYdir=- ballYdir;
                            }
                            break A;
                        }

                    }
                }

            }




            ballposX+=ballXdir;
            ballposY+=ballYdir;
            if(ballposX<0){
                ballXdir = -ballXdir;

            }  if(ballposY<0){
                ballYdir = - ballYdir;
            }  if(ballposX>670){
                ballXdir = - ballXdir;
            }
        }
        repaint();
    }

    @Override
    public void keyTyped(KeyEvent e) {}

    @Override
    public void keyReleased(KeyEvent e) {}

    @Override
    public void keyPressed(KeyEvent e) {if(e.getKeyCode()== KeyEvent.VK_RIGHT){
        if (playerX>=600){
            playerX=600;
        }
        else{
            moveRight();
        }

    }
    if(e.getKeyCode()== KeyEvent.VK_LEFT){
        if (playerX>=10){
            playerX=10;
        }
        else{
            moveLeft();
        }


    }
    if (e.getKeyCode() == KeyEvent.VK_ENTER){
        if (play){
            play=true;
            ballposX = 120;
            ballposY = 350 ;
            ballXdir = - 1;
            ballYdir = - 2;
            playerX = 310;
            score    = 0;
            totalBricks = 21;
            map = new Generetor (3, 7);
            
            repaint();
        }
    }
}




public void moveRight()
{
play=true;
playerX+=20;
}

public void moveLeft()
{
play=true;
playerX-=20;
}}



//     @Override
//     public void keyReleased(KeyEvent e) {}
// }
//         if(e.getKeyCode()== KeyEvent.VK_RIGHT){
//             if (playerX>=600){
//                 playerX=600;
//             }
//             else{
//                 moveRight();
//             }

//         }
//         if(e.getKeyCode()== KeyEvent.VK_LEFT){
//             if (playerX>=10){
//                 playerX=10;
//             }
//             else{
//                 moveLeft();
//             }


//         }
//     }
    



// public void moveRight()
// {
//     play=true;
//     playerX+=20;
// }

// public void moveLeft()
// {
//     play=true;
//     playerX-=20;
// }
// }
