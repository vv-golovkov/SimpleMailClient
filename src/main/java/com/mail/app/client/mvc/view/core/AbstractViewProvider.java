package com.mail.app.client.mvc.view.core;

public abstract class AbstractViewProvider {

    public final void load() {
        buildUI();
        drawUI();
    }

    protected abstract void buildUI();
    protected abstract void drawUI();
}
