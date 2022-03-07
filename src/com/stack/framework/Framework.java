package com.stack.framework;

import com.stack.framework.boot.Boot;
import com.stack.framework.catcher.Catcher;
import org.lwjgl.input.Keyboard;

import javax.swing.*;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.nio.file.Files;
import java.nio.file.Path;

public class Framework {

    public static void run() throws UnsupportedLookAndFeelException, ClassNotFoundException, InstantiationException, IllegalAccessException {
        try {
            if (Boot.getSeq() == null) {
                throw new IllegalStateException("Boot sequence is not defined yet!");
            }
            Boot.getSeq().boot();
        } catch (Exception ex) {
            StringWriter sw = new StringWriter();
            PrintWriter pw = new PrintWriter(sw);
            ex.printStackTrace(pw);
            String sStackTrace = sw.toString();
            new Catcher(sStackTrace);
        }
    }

    public static boolean isActiveKey(int key) {
        return Keyboard.isKeyDown(key);
    }

    public static String loadResource(String path) throws IOException {
        return Files.readString(Path.of(path));
    }
}
