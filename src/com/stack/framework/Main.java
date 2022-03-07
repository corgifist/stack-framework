package com.stack.framework;

import com.stack.framework.boot.Boot;
import com.stack.framework.display.AbstractDisplay;
import com.stack.framework.tests.DisplayTest;
import org.lwjgl.LWJGLException;
import org.lwjgl.opengl.GLContext;

import javax.swing.*;

public class Main {
    public static void main(String[] args) throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        Boot.setSeq(Main::runtime);
        AbstractDisplay.createDisplay();
        Framework.run();
    }

    private static void runtime() {
        DisplayTest display = new DisplayTest();
        display.prepare();
        display.run();
    }
}
