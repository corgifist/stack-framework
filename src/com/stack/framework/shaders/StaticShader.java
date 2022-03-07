package com.stack.framework.shaders;

public class StaticShader extends ShaderProgram{

    private static final String VERTEX_FILE = "shaders/default.vert";
    private static final String FRAGMENT_FILE = "shaders/default.frag";

    public StaticShader() {
        super(VERTEX_FILE, FRAGMENT_FILE);
    }

    @Override
    protected void bindAttributes() {
        super.bindAttribute(0, "position");
    }
}
