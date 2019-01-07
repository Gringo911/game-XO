// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:31:31
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   G

package ttt.core;

import javax.swing.*;

import java.awt.*;

import java.awt.font.TextAttribute;

import java.text.AttributedString;


import java.util.Observable;

import java.util.Random;



public class Game extends Observable
{

    public Game()
    {

        xo = new XO();

        rnd = new Random(System.currentTimeMillis());

        winner = -1;

        locBoard = new Point(50, 10);

        loadResourses();
    }
    private void loadResourses()
    {
        xImage = (new ImageIcon("res/X.png")).getImage();
        oImage = (new ImageIcon("res/O.png")).getImage();
        boardImage = (new ImageIcon("res/board.png")).getImage();
        hmnWon = (new ImageIcon("res/HumanWon.png")).getImage();
        rndWon = (new ImageIcon("res/RndAiWon.png")).getImage();
        drawWon = (new ImageIcon("res/Draw.png")).getImage();
    }

    public boolean isGameover()
    {

        return gameover;
    }

    public int getWidth()
    {

        return boardImage.getWidth(null);
    }

    public int getHeight() {

       return boardImage.getHeight(null);

    }

    public int getX()
    {

        return locBoard.x;
    }

    public int getY()
    {

        return locBoard.y;
    }

    public void setLocation(int x, int y)
    {

        this.x = (x - getX()) / 60;
        this.y = (y - getY()) / 60;
    }

    public void start()
    {
        start = true;

        winner = -1;
    }

    public void doTurn()
    {
        if(start)
        {
            start = false;
            gameover = false;

            xo.cleanField();
        } else

        if(!gameover && xo.put(x, y))
        {

            winner = xo.whoWon();
            gameover = winner != -1;
            if(!gameover)
            {
                int i;
                int j;
                do
                {
                    i = rnd.nextInt(3);
                    j = rnd.nextInt(3);
                } while(!xo.put(i, j));
                winner = xo.whoWon();
                gameover = winner != -1;
            }
        }
        setChanged();
        notifyObservers();
    }

    public void render(Graphics2D g2d)
    {
        g2d.drawImage(boardImage, locBoard.x, locBoard.y, null);
        AttributedString attX = new AttributedString(String.valueOf(xo.getScoreX()));
        AttributedString attO = new AttributedString(String.valueOf(xo.getScoreO()));
        attX.addAttribute(TextAttribute.SIZE, Integer.valueOf(20));
        attX.addAttribute(TextAttribute.FOREGROUND, Color.MAGENTA);
        attO.addAttribute(TextAttribute.FOREGROUND, Color.GREEN);
        attO.addAttribute(TextAttribute.SIZE, Integer.valueOf(20));
        g2d.drawString(attX.getIterator(), locBoard.x - 30, locBoard.y + 20);
        g2d.drawString(attO.getIterator(), locBoard.x + boardImage.getWidth(null) + 20, locBoard.y + 20);
        int gameField[][] = xo.getField();
        for(int i = 0; i < gameField.length; i++)
        {
            for(int j = 0; j < gameField[i].length; j++)
                switch(gameField[i][j])
                {
                case 1:
                    g2d.drawImage(xImage, j * 60 + locBoard.x, i * 60 + locBoard.y, null);
                    break;

                case 2:
                    g2d.drawImage(oImage, j * 60 + locBoard.x, i * 60 + locBoard.y, null);
                    break;
                }

        }

        switch(winner)
        {
        case 1:
            g2d.drawImage(hmnWon, locBoard.x + 15, locBoard.y + boardImage.getHeight(null) + 5, null);
            break;

        case 2:
            g2d.drawImage(rndWon, locBoard.x + 5, locBoard.y + boardImage.getHeight(null) + 5, null);
            break;

        case 0:
            g2d.drawImage(drawWon, locBoard.x + 40, locBoard.y + boardImage.getHeight(null) + 5, null);
            break;
        }
    }

    private int x;
    private int y;
    private boolean start;
    private boolean gameover;
    private XO xo;
    private Random rnd;
    private int winner;
    private Image xImage;
    private Image oImage;
    private Image boardImage;
    private Image hmnWon;
    private Image rndWon;
    private Image drawWon;
    private Point locBoard;

    private final String IMG_X_URL = "res/X.png";
    private final String IMG_O_URL = "res/O.png";
    private final String IMG_BOARD_URL = "res/board.png";
    private final String IMG_HUMAN_WON = "res/HumanWon.png";
    private final String IMG_RND_AI_WON = "res/RndAiWon.png";
    private final String IMG_DRAW = "res/Draw.png";
}
