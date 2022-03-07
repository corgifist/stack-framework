package com.stack.framework.tests;

import com.stack.framework.display.AbstractDisplay;
import com.stack.framework.geometry.RawModel;
import com.stack.framework.render.Loader;
import com.stack.framework.render.Renderer;

import static org.lwjgl.opengl.GL11.GL_VERTEX_ARRAY;
import static org.lwjgl.opengl.GL11.glEnableClientState;

public class DisplayTest extends AbstractDisplay {

    float[] vertices = {
            -0.5f,0.5f,0,	//V0
            -0.5f,-0.5f,0,	//V1
            0.5f,-0.5f,0,	//V2
            0.5f,0.5f,0		//V3
    };

    int[] indices = {
            0,1,3,	//Top left triangle (V0,V1,V3)
            3,1,2	//Bottom right triangle (V3,V1,V2)
    };

    private RawModel triangle;

    public void prepare() {
        renderer = new Renderer();
        loader = new Loader();
        triangle = loader.loadToVAO(vertices, indices);
    }

    @Override
    public void userRender() {
        renderer.render(triangle);
    }

    @Override
    public void update() {
    }

    @Override
    public void exit() {
        System.out.println("Exi");
    }
}
