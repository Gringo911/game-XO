// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:46:03
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Canvas.java

package ui;

import ttt.core.Game;

import javax.swing.*;
import java.awt.*;
import java.util.Observable;
import java.util.Observer;

public class Canvas extends JPanel implements Observer
{

    public Canvas(Game game)
    {
        this.game = game;
        setDoubleBuffered(true);
    }

    public void paint(Graphics g){
        super.paint(g);

        game.render((Graphics2D)g);

        Toolkit.getDefaultToolkit().sync();
        g.dispose();
    }

    public void update(Observable o, Object arg)
    {

        repaint();
    }

    private Game game;
}
