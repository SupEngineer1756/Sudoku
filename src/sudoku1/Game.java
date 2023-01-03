/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sudoku1;

import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Random;

/**
 *
 * @author houariac
 */
public class Game {

    //attributes
    public Scase gametable[][] = new Scase[9][9];
    int Emptycases;
    Scase[][] solution = new Scase[9][9];
    ArrayList<Integer>[][] Stable = new ArrayList[9][9];

    //constructors
    public Game(int difficulty) {
        this.Emptycases = 81 - difficulty;
        this.setgame();
        this.setstable();
        Random rand = new Random();
        int dif = difficulty;
        int p = 0;
        int[] list = {1, 2, 3, 4, 5, 6, 7, 8, 9};
        this.shuffle(list);
        ArrayList<Integer> nlist = new ArrayList<Integer>();
        int n = 1;
        while (n <= 9) {
            int i = rand.nextInt(10);
            if (!nlist.contains(i)) {
                nlist.add(i);
                n++;
            }
        }

        for (int k : list) {
            if (gametable[p][0].s == 0) {
                gametable[p][0].s = k;
                System.out.println("(" + p + "," + "0" + ")" + " " + k);
                System.out.println(gametable[p][0].s);
                p++;
            }
        }
        for (int j = 1; j < 9; j++) {
            if ((j % 3) == 2 || j % 3 == 1) {
                for (int i = 0; i < 9; i++) {
                    gametable[(i +1-3) % 9][j].s = gametable[i][j - 1].s;
                    System.out.println("(" + i + "," + j + ")" + " ");
                    System.out.println(gametable[(i + 6) % 9][j].s);
                }
            }
            if (j % 3 == 0) {
                for (int i = 0; i < 9; i++) {
                    gametable[(i ) % 9][j].s = gametable[i][j - 1].s;
                    System.out.println("(" + i + "," + j + ")" + " ");
                    System.out.println(gametable[(i + 6) % 9][j].s);
                }
            }
        }
        for (int l = 0; l < 9; l++) {
            for (int m = 0; m < 9; m++) {
                solution[l][m] = new Scase(gametable[l][m].s, gametable[l][m].Case);
            }
        }
        for (int o = 0; o < Emptycases; o++) {
            int i = rand.nextInt(9);
            int j = rand.nextInt(9);
            gametable[i][j].s = 0;
        }

    }

    public void shuffle(int[] list) {
        Random rand = new Random();
        for (int i = 0; i < 9; ++i) {
            int j = rand.nextInt(i, 9);
            int temp = list[j];
            list[j] = list[i];
            list[i] = temp;
        }
    }

    public boolean isValid(int i, int j, int k) {
        boolean isValid = true;
        for (int l = 0; l < 9; l++) {
            if (this.gametable[i][l].s == k) {
                isValid = false;
            }
        }
        for (int l = 0; l < 9; l++) {
            if (this.gametable[l][j].s == k) {
                isValid = false;
            }
        }

        for (int l = 0; l < 9; l++) {
            for (int m = 0; m < 9; m++) {
                if (gametable[l][m].Case == gametable[i][j].Case) {
                    if (gametable[l][m].s == k) {
                        isValid = false;
                    }
                }
            }
        }

        return isValid;
    }

    public int getemptycases() {
        int emp = 0;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (gametable[i][j].s == 0) {
                    emp++;
                }
            }
        }
        return emp;
    }

    public void setgame() {
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3; j++) {
                this.gametable[i][j] = new Scase(0, 1);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 0; j < 3; j++) {
                this.gametable[i][j] = new Scase(0, 2);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 0; j < 3; j++) {
                this.gametable[i][j] = new Scase(0, 3);
            }
        }
        //
        for (int i = 0; i < 3; i++) {
            for (int j = 3; j < 6; j++) {
                this.gametable[i][j] = new Scase(0, 4);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 3; j < 6; j++) {
                this.gametable[i][j] = new Scase(0, 5);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 3; j < 6; j++) {
                this.gametable[i][j] = new Scase(0, 6);
            }
        }
        //
        for (int i = 0; i < 3; i++) {
            for (int j = 6; j < 9; j++) {
                this.gametable[i][j] = new Scase(0, 7);
            }
        }
        for (int i = 3; i < 6; i++) {
            for (int j = 6; j < 9; j++) {
                this.gametable[i][j] = new Scase(0, 8);
            }
        }
        for (int i = 6; i < 9; i++) {
            for (int j = 6; j < 9; j++) {
                this.gametable[i][j] = new Scase(0, 9);
            }
        }

    }
//methods

    public void setstable() {
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (gametable[i][j].s == 0) {
                    this.Stable[i][j] = new ArrayList<Integer>();
                }
            }
        }

    }

    public void setcase(int i, int j, int k) {
        this.gametable[i][j].s = k;
    }

    /*public boolean isValid(int i, int j, int k) {
        boolean isValid = true;
        if (k != 0) {
            for (int l = 0; l < 9; l++) {
                if (this.gametable[i][l] == k) {
                    isValid = false;
                }
            }
            for (int l = 0; l < 9; l++) {
                if (this.gametable[l][j] == k) {
                    isValid = false;
                }
            }
            //first codebloc
            if ((i + 1) % 3 == 0) {
                if ((j + 1) % 3 == 0) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 2) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = -1; m < 2; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 1) {
                    for (int l = 0; l < 3; l++) {
                        for (int m = -2; m < 1; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
            }
            //second codebloc
            if ((i + 1) % 3 == 2) {
                if ((j + 1) % 3 == 0) {
                    for (int l = -1; l < 2; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 2) {
                    for (int l = -1; l < 2; l++) {
                        for (int m = -1; m < 2; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 1) {
                    for (int l = -1; l < 2; l++) {
                        for (int m = -2; m < 1; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
            }
            //third codebloc
            if ((i + 1) % 3 == 1) {
                if ((j + 1) % 3 == 0) {
                    for (int l = -2; l < 1; l++) {
                        for (int m = 0; m < 3; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 2) {
                    for (int l = -2; l < 1; l++) {
                        for (int m = -1; m < 2; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
                if ((j + 1) % 3 == 1) {
                    for (int l = -2; l < 1; l++) {
                        for (int m = -2; m < 1; m++) {
                            if (this.gametable[i - l][j - m] == k) {
                                isValid = false;
                            }
                        }
                    }
                }
            }
        } else {
            isValid = true;
        }
        
    
        return isValid;
    }
     */
    public void Gamemove(int i, int j, int k) {
        if (this.solution[i][j].s == k) {
            this.setcase(i, j, k);
            Emptycases--;
        } else {
            System.out.println("WRONG HAHA");
        }
    }

    public boolean issolved(int[][] table) {
        boolean issolved = true;
        while (issolved) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (table[i][j] == 0) {
                        issolved = false;
                    }
                }
            }
        }
        return issolved;
    }

    public void solvegame() {
        int emptycases = Emptycases;
        for (int i = 0; i < 9; i++) {
            for (int j = 0; j < 9; j++) {
                if (solution[i][j].s == 0) {
                    for (int k = 1; k < 10; k++) {
                        if (this.isValid(i, j, k)) {
                            Stable[i][j].add(k);
                        }

                    }
                    if (Stable[i][j].size() == 1) {
                        this.solution[i][j].s = Stable[i][j].get(0);
                        emptycases--;
                        System.out.println(emptycases);
                        System.out.println("(" + i + "," + j + ") = " + Stable[i][j].get(0));

                    }
                    if (Stable[i][j].size() > 1) {
                        //System.out.println(Stable[i][j].toString());
                    }
                }
            }
        }
        while (emptycases > 0) {
            for (int i = 0; i < 9; i++) {
                for (int j = 0; j < 9; j++) {
                    if (gametable[i][j].s == 0) {
                        ArrayList<Integer> toRemove = new ArrayList();
                        for (Integer num : Stable[i][j]) {
                            if (!this.isValid(i, j, num)) {
                                toRemove.add(num);
                            }
                        }
                        Stable[i][j].removeAll(toRemove);
                        if (Stable[i][j].size() == 1) {
                            this.solution[i][j].s = Stable[i][j].get(0);
                            System.out.println("(" + i + "," + j + ") = " + Stable[i][j].get(0));
                            emptycases--;
                            System.out.println(emptycases);

                        }
                        if (Stable[i][j].size() > 1) {
                            //System.out.println(Stable[i][j].toString());
                        }
                    }
                }
            }
        }

    }
}
