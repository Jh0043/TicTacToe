import java.io.*;
import java.util.*;
/**
 * Write a description of class main here.
 *
 * @author (your name)
 * @version (a version number or a date)
 */
public class main
{
    private Scanner console;
    private String[][] Array;
    /**
     * Constructor for objects of class main
     */
    public void main()
    {
        console = new Scanner(System.in);
        
        
        System.out.println("Game");
        System.out.println("");
        Array = new String[3][3];
        
        
        if(askPlayer() == true){
            //Plays with bot
            String winner = "";
            boardReset();
            while(winner.equals("")){
                board();
                askSpot();
                board();
                winner = chkWhoWon();
                if(! winner.equals("")) break;
                bot();
                //board();
                winner = chkWhoWon();
            }
            System.out.println("Winner is " + winner + "!");
            reset();
        }
        else{
            //play without bot
            String winner = "";
            boardReset();
            while(winner.equals("")){
                board();
                askSpot();
                board();
                winner = chkWhoWon();
                if(! winner.equals("")) break;
                askSpot2();
                //board();
                winner = chkWhoWon();
            }
            System.out.println("Winner is " + winner + "!");
            reset();
            
            
        }
        
    }
    public void reset(){
        System.out.println("Would you like to play again?");
        String resetYes = console.next();
        if(resetYes.equals("Yes")){
            main();
        }
    }
    public boolean askPlayer(){
        System.out.println("");
        System.out.println("Would you like to play with CPU? (Yes/No)");
        String CPUyes = console.next();
        if(CPUyes.equals("Yes")){
            return true;
        }
        else return false;
    }
    public void boardReset(){
        for(int col = 0; col < Array.length; col++){
            for(int row = 0; row < Array.length; row++){
                Array[col][row] = ".";
            }
        }
    }
    public void askSpot(){
        System.out.println("");
        System.out.println("which column do you want to play");
        int colNum = console.nextInt();
        System.out.println("which row do you want to play");
        int rowNum = console.nextInt();
        checkSpot(colNum, rowNum);
        
    }
    public void checkSpot(int askCol, int askRow){
        if(Array[askCol][askRow].equals(".")){
            Array[askCol][askRow] = "X";
        }
        else{
            System.out.println("");
            System.out.println("Spot taken, please choose again");
            askSpot();
        }
    }
    public void askSpot2(){
        System.out.println("");
        System.out.println("which column do you want to play");
        int colNum = console.nextInt();
        System.out.println("which row do you want to play");
        int rowNum = console.nextInt();
        checkSpot2(colNum, rowNum);
        
    }
    public void checkSpot2(int askCol, int askRow){
        if(Array[askCol][askRow].equals(".")){
            Array[askCol][askRow] = "O";
        }
        else{
            System.out.println("");
            System.out.println("Spot taken, please choose again");
            askSpot2();
        }
    }
    public void bot(){
        int botRow = (int)(Math.random() * 3);
        int botCol = (int)(Math.random() * 3);
        botCheck(botCol, botRow);
    }
    public void botCheck(int bColCheck, int bRowCheck){
        if(Array[bColCheck][bRowCheck].equals(".")){
            Array[bColCheck][bRowCheck] = "O";
        }
        else{
            bot();
        }
        
    }
    public void board(){
        System.out.println("");
        System.out.println("BOARD");
        System.out.println("");
        System.out.println("  0 1 2");
        System.out.print("0 ");
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][0] + " ");
        }
        System.out.println("");
        System.out.print("1 ");
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][1] + " ");
        }
        System.out.println("");
        System.out.print("2 ");
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][2] + " ");
        }
        System.out.println("");
    }
    public String chkWhoWon(){
        if (chkWon("X"))
            return "X";
        if (chkWon("O"))
            return "O";
        return "";
    }
    public boolean chkWon(String XorO){
        for (int col=0; col<3; col++){
            for (int row=0; row<3; row++){
                if (! Array[col][row].equals(XorO))
                    break;
                if (row==2) return true;
            }
        }
        for (int row=0; row<3; row++){
            for (int col=0; col<3; col++){
                if (! Array[col][row].equals(XorO))
                    break;
                if (col==2) return true;
            }
        }
        for (int row=0; row<3; row++){
            int col=row;
            if (! Array[col][row].equals(XorO))
                break;
            if (row==2) return true;
        }
        for (int row=0; row<3; row++){
            int col=2-row;
            if (! Array[col][row].equals(XorO))
                break;
            if (row==2) return true;
        }
        return false;
    }
}
