package com.stack.framework.display;

import com.stack.framework.Framework;
import com.stack.framework.render.Loader;
import com.stack.framework.render.Renderer;
import com.stack.framework.utils.Time;
import org.lwjgl.LWJGLException;
import org.lwjgl.input.Keyboard;
import org.lwjgl.opengl.*;

public abstract class AbstractDisplay {

    private static final int FPS_CAP = 120;
    private static int WIDTH = 1280;
    private static int HEIGHT = 720;
    private static String TITLE = "";

    public Loader loader;
    public Renderer renderer;

    public static void updateDisplay() {
        Display.update();
        Display.sync(FPS_CAP);
    }

    public static void closeDisplay() {
        Display.destroy();
    }

    public void run() {
        while (!Display.isCloseRequested()) {
            if (Framework.isActiveKey(Keyboard.KEY_ESCAPE)) {
                exit();
            }
            update();
            renderer.prepare();
            userRender();
            updateDisplay();
        }

        loader.cleanUp();
    }

    public static void createDisplay() {
        ContextAttribs attribs = new ContextAttribs(3, 2)
                .withForwardCompatible(true)
                .withProfileCore(true);

        try {
            Display.setDisplayMode(new DisplayMode(WIDTH, HEIGHT));
            Display.create(new PixelFormat(), attribs);
            Display.setTitle("stack!" + TITLE);
        } catch (LWJGLException e) {
            e.printStackTrace();
        }

        GL11.glViewport(0, 0, WIDTH, HEIGHT);
    }

    public void clean() {
        loader.cleanUp();
    }

    public abstract void userRender();

    public abstract void update();

    public abstract void exit();

    public Loader getLoader() {
        return loader;
    }

    public void setLoader(Loader loader) {
        this.loader = loader;
    }

    public Renderer getRenderer() {
        return renderer;
    }

    public void setRenderer(Renderer renderer) {
        this.renderer = renderer;
    }

    public static String getTITLE() {
        return TITLE;
    }

    public static void setTITLE(String TITLE) {
        AbstractDisplay.TITLE = TITLE;
    }

    public static int getWIDTH() {
        return WIDTH;
    }

    public static void setWIDTH(int WIDTH) {
        AbstractDisplay.WIDTH = WIDTH;
    }

    public static int getHEIGHT() {
        return HEIGHT;
    }

    public static void setHEIGHT(int HEIGHT) {
        AbstractDisplay.HEIGHT = HEIGHT;
    }
}
