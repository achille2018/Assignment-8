//AUYHOR SAGANG TANWOUO ACHILLE 


//THIS FILE IS FOR THE MAIN .ON THIS PART YOY CAN SEE 
//ALL THE FUNCTION IS NECCESARY TO POSTER GAMES WINDOWS


//I creat my package which call GAMECREATION IS JUST THE SIMPLE FOLDER THAT I can put all my package 
package GAMECREATION;

import javax.swing.JFrame;

public class Main{
    public static void main(String[] args) {
        JFrame obj = new JFrame();
        Gameplay gameplay = new Gameplay();
         obj.setBounds(10,10,700,600);
         obj.setTitle("Breakout Ball");
         obj.setResizable(false);
         obj.setVisible(true);
         obj.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
         obj.add(gameplay);
        
    }
}

