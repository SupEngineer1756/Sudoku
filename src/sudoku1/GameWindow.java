/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Main.java to edit this template
 */
package sudoku1;

import java.awt.Color;

/**
 *
 * @author RafikMedici
 */

    /*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */

import java.awt.Graphics;
import java.awt.Graphics2D;
import java.awt.event.KeyEvent;
import java.awt.event.KeyListener;
import java.awt.event.MouseEvent;
import java.awt.event.MouseListener;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.util.logging.Level;
import java.util.logging.Logger;
import javax.imageio.ImageIO;
import javax.swing.JFrame;

/**
 *
 * @author houariac
 */
public class GameWindow  extends JFrame implements MouseListener, KeyListener {

    Game game;
    Boolean caseclicked;
    int[] Caseclicked = new int[2];
    File[] numbers = {new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\one.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\two.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\three.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\four.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\five.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\six.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\seven.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\eight.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\nine.bmp")};
    File[] numbersright = {new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\oneright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\tworight.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\threeright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\fourright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\fiveright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\sixright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\sevenright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\eightright.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\nineright.bmp")};
    File[] numberswrong = {new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\onewrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\twowrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\threewrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\fourwrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\fivewrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\sixwrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\sevenwrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\eightwrong.bmp"),
        new File("Z:\\Mes documents\\java\\java\\Sudoku1\\Sudoku1\\ninewrong.bmp")};

    public GameWindow() {
        game = new Game(60);
        //game.solvegame();
        this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        this.setLayout(null);
        this.setSize(1000, 1000);
        this.setVisible(true);
        this.addMouseListener(this);
        this.addKeyListener(this);
        Graphics g = getGraphics();
        this.paint(g);
        this.paintComponent(g);
        System.out.println("emp= "+game.getemptycases());

    }

    @Override
    public void paint(Graphics g) {
        super.paint(g);
        Graphics2D g2= (Graphics2D) g;
        for (int i = 0; i < 900; i = i + 100) {
            for (int j = 0; j < 900; j = j + 100) {
                g2.setColor(Color.BLACK);
                g2.drawRect( i, j, 100, 100);
                    g2.setColor(Color.WHITE);
                    g2.fillRoundRect(i, j, 95, 95, 0, 0);
                    g2.fillRoundRect(i, j, 95, 95, 0, 0);
                 
            }
        }

    }

    public void paintComponent(Graphics g) {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (game.gametable[i][j].s != 0) {
                        this.paintnormally(g, i, j, game.gametable[i][j].s);
                }
            }
        }
    }

    public void paintnormally(Graphics g, int x, int y, int k) {

        try {
            BufferedImage img = ImageIO.read(numbers[k - 1]);
            g.drawImage(img, x * 100, y * 100, null);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paintwrong(Graphics g, int x, int y, int k) {
        try {
            BufferedImage img = ImageIO.read(numberswrong[k - 1]);
            g.drawImage(img, x * 100, y * 100, null);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void paintright(Graphics g, int x, int y, int k) {
        try {
            BufferedImage img = ImageIO.read(numbersright[k - 1]);
            g.drawImage(img, x * 100, y * 100, null);
        } catch (IOException ex) {
            Logger.getLogger(GameWindow.class.getName()).log(Level.SEVERE, null, ex);
        }
    }

    public void mousedragged(MouseEvent e) {

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        caseclicked = true;
        Caseclicked[0] = (int)(e.getX()/100);
        Caseclicked[1] = (int)(e.getY()/100);
        System.out.println(Caseclicked[0]+","+Caseclicked[1]);
    }

    @Override
    public void keyPressed(KeyEvent e) {
        Graphics g = getGraphics();
        if (caseclicked = true) {
            int k = (int) (e.getKeyChar()-48);
            System.out.println(k);
            if (game.solution[Caseclicked[0]][Caseclicked[1]].s==k) {
                game.Gamemove(Caseclicked[0], Caseclicked[1], k);
                this.paintright(g, Caseclicked[0], Caseclicked[1], k);
                
            } else {
                this.paintwrong(g, Caseclicked[0], Caseclicked[1], k);
                
            }
        }
    }

    @Override
    public void mouseEntered(MouseEvent e) {

    }

    ;

    @Override
    public void mouseExited(MouseEvent e) {

    }

    ;

    @Override
    public void mousePressed(MouseEvent e) {

    }

    @Override
    public void mouseReleased(MouseEvent e) {
    }



    public static void main(String[] args) {
        // TODO code application logic here
        new GameWindow();
    }

    @Override
    public void keyTyped(KeyEvent e) {
       
    }


    @Override
    public void keyReleased(KeyEvent e) {
    }
    
}
