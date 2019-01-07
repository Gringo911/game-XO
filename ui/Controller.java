// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:34:41
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Controller.java

package ui;


import ttt.core.Game;

import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Controller extends MouseAdapter
{

    public Controller(Game game)
    {
        this.game = game;
    }

    public void mousePressed(MouseEvent e)
    {

        if(!game.isGameover())
        {

            int x = e.getPoint().x;
            int y = e.getPoint().y;
            if(x >= game.getX() && y >= game.getY() && x < game.getX() + game.getWidth() && y < game.getY() + game.getHeight())
            {
                game.setLocation(x, y);
                game.doTurn();
            }
        } else
        {
            game.start();
            game.doTurn();
        }
    }

    private Game game;
}
