/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku1;
import javax.swing.JFrame;
import javax.swing.JLabel;
/**
 *
 * @author houariac
 */
public class NewWindow {
        JFrame framesud = new JFrame();
    JLabel label = new JLabel("Sudoku!");
    String[][] playerchoicestrarr= new String[9][9];
        int[][] playerchoicearr = new int[9][9];
        IntegerField[][] gameboard = new IntegerField[9][9];
        Game Gameplayed;
    NewWindow(){
        framesud.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        framesud.setLayout(null);
        framesud.setSize(500,500);
        framesud.setVisible(true);
        
    }
}
