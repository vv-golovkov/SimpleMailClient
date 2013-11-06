package com.mail.app.client.mvc.view.core;

import java.util.ArrayList;
import java.util.List;

import com.smartgwt.client.types.Alignment;
import com.smartgwt.client.widgets.Canvas;
import com.smartgwt.client.widgets.Label;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;

public abstract class AbstractHeaderSupportView extends AbstractViewProvider {
    private VLayout mainViewport;

    private VLayout mainLayout;

    private HLayout header;

    public AbstractHeaderSupportView() {
        /****** MAIN VIEWPORT ******/
        mainViewport = new VLayout(0);
        mainViewport.setWidth("100%");
        mainViewport.setHeight("100%");

        /********* HEADER ********/
        Label icon = new Label();
        icon.setIcon("play.png");
        icon.setAlign(Alignment.CENTER);
        icon.setIconSize(64);

        Label title = new Label("--- QWERTY ---");
        title.setWrap(false);
        title.setStyleName("titleStyle");
        icon.setWidth("80px");
        title.setWidth("*");

        header = new HLayout(0);
        header.setWidth("100%");
        header.setHeight(80);
        header.setBackgroundColor("#333333");
        header.setMembers(icon, title);

        /****** MAIN LAYOUT ******/
        mainLayout = new VLayout(0);
//        mainLayout.setPadding(15);
//        mainLayout.setBackgroundColor("#777777");
        mainLayout.setBackgroundColor("#EEEEEE");
    }

    protected abstract void drawUIWithMembers(VLayout mainLayout);

    @Override
    protected void drawUI() {
        List<Canvas> members = new ArrayList<Canvas>();

        final Label separateLabel = createDefaultSeparateLabel("");
        members.add(header);
        members.add(separateLabel);

        drawUIWithMembers(mainLayout);
        members.add(mainLayout);
        mainViewport.setMembers(members.toArray(new Canvas[members.size()]));
        members.clear();
        if (mainViewport.isDrawn()) {
            mainViewport.redraw();
        } else
            mainViewport.draw();
    }

    protected Label createDefaultSeparateLabel(final String title) {
        final Label label = new Label(title);
        label.setStyleName("informationSeparatorStyle");
        label.setWidth("100%");
        label.setHeight("1em");
        return label;
    }

    protected HLayout getHeader() {
        return header;
    }
}
