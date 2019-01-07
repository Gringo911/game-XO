// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:33:11
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   XO.java

package ttt.core;

public class XO
{

    public XO()

    {
        field = new int[3][3];

        player = 1;
    }

    public void cleanField() {

        full = 0;

        player = 1;


        for (int i = 0; i < field.length; i++) {
            for (int j = 0; j < field[i].length; j++)
                field[i][j] = 0;

        }

    }
    public int[][] getField()
    {
        return (int[][])field.clone();
    }

    public int getScoreX()
    {

        return scoreX;
    }

    public int getScoreO()
    {
        return scoreO;
    }

    public int whoWon() {
        int verO;
        int horX;
        int horO;
        int diaX;
        int diaO;
        int mirX;
        int mirO;
        int verX = verO = horX = horO = diaX = diaO = mirX = mirO = 0;
        for(int i = 0; i < 3; i++)
        {
            for(int j = 0; j < 3; j++)
            {
                switch(field[i][j])
                {
                case 1:
                    verX++;
                    break;

                case 2:
                    verO++;
                    break;
                }
                switch(field[j][i])
                {
                case 1:
                    horX++;
                    break;

                case 2:
                    horO++;
                    break;
                }
                switch(field[j][j])
                {
                case 1:
                    diaX++;
                    break;

                case 2:
                    diaO++;
                    break;
                }
                switch(field[j][Math.abs(j - 2)])
                {
                case 1:
                    mirX++;
                    break;

                case 2:
                    mirO++;
                    break;
                }
            }

            if(verX == 3 || horX == 3 || diaX == 3 || mirX == 3)
            {
                giveScoreX();
                return 1;
            }
            if(verO == 3 || horO == 3 || diaO == 3 || mirO == 3)
            {
                giveScoreO();
                return 2;
            }
            verX = verO = horX = horO = diaX = diaO = mirX = mirO = 0;
        }

        return full != 9 ? -1 : 0;
    }

    public boolean put(int x, int y)
    {
        try
        {
            if(field[y][x] == 0)
            {
                field[y][x] = player;
                player = player != 1 ? 1 : 2;
                full++;
                return true;
            }
        }
        catch(IndexOutOfBoundsException exp)
        {
            System.err.println(exp.getMessage());
        }
        return false;
    }

    private void giveScoreX()
    {

        scoreX++;
    }

    private void giveScoreO()
    {
        scoreO++;
    }

    private int field[][];
    private int scoreX;
    private int scoreO;
    private int player;
    private int full;
    public static final int EMPTY = 0;
    public static final int SHAPE_X = 1;//фигуру
    public static final int SHAPE_O = 2;
    public static final int PLAYER_1 = 1;//игрок
    public static final int PLAYER_2 = 2;
    public static final int DRAW = 0;//рисовать
    public static final int NOBODY = -1;//никто
}
