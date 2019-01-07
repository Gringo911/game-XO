// Decompiled by DJ v3.12.12.101 Copyright 2016 Atanas Neshkov  Date: 28.12.2018 22:34:23
// Home Page:  http://www.neshkov.com/dj.html - Check often for new version!
// Decompiler options: packimports(3) 
// Source File Name:   XOFrame.java

package ui;

import javax.swing.*;

// Referenced classes of package ui:
//            Canvas

public class XOFrame extends JFrame
{

    public XOFrame(Canvas canvas)
    {
        getContentPane().
                add(canvas);
        setLocationRelativeTo(null);
        setSize(300, 250);
        setDefaultCloseOperation(3);
        setTitle("Tic Tac Toe");
        setResizable(false);
    }
}
