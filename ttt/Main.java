// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:33:45
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   Main.java

package ttt;
//импорт по ссилке получаем параметры gama
import ttt.core.Game;
//получаеи доступ ко всем классам из пакета
import ui.*;

public class Main
{

    public Main()
    {
    }



    public static void main(String args[])
    {


        Game game = new Game();

        Canvas canvas = new Canvas(game);

        XOFrame frame = new XOFrame(canvas);

        Controller c = new Controller(game);
        game.addObserver(canvas);
        canvas.addMouseListener(c);
        frame.setVisible(true);
    }
}
