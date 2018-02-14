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
    
    /**
     * Constructor for objects of class main
     */
    public main()
    {
        console = new Scanner(System.in);
        System.out.println("Game");
        System.out.println("");
        String[][] Array = new String[3][3];
        
        for(int col = 0; col < Array.length; col++){
            for(int row = 0; row < Array.length; row++){
                Array[col][row] = ".";
            }
        }
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][0]);
        }
        System.out.println("");
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][1]);
        }
        System.out.println("");
        for(int i = 0; i < 3; i++){
            System.out.print(Array[i][2]);
        }
        System.out.println("");
        System.out.println("which column do you want to play");
        int colNum = console.nextInt();
        System.out.println("which row do you want to play");
        int rowNum = console.nextInt();
        if(Array[colNum][rowNum].equals(".")){
            Array[colNum][rowNum] = "X";
        }
        
    }
    public void bot(){
        int botRow = (int)(Math.random() * 3);
        int botCol = (int)(Math.random() * 3);
    }
}
