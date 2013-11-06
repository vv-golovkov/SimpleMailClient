package com.mail.app.client.mvc.view;

import com.mail.app.client.mvc.view.core.AbstractHeaderSupportView;
import com.smartgwt.client.types.SelectionStyle;
import com.smartgwt.client.widgets.form.DynamicForm;
import com.smartgwt.client.widgets.form.fields.ButtonItem;
import com.smartgwt.client.widgets.form.fields.TextAreaItem;
import com.smartgwt.client.widgets.form.fields.TextItem;
import com.smartgwt.client.widgets.form.fields.events.ClickHandler;
import com.smartgwt.client.widgets.grid.ListGrid;
import com.smartgwt.client.widgets.layout.HLayout;
import com.smartgwt.client.widgets.layout.VLayout;
import com.smartgwt.client.widgets.tree.TreeGrid;

public class BaseView extends AbstractHeaderSupportView {
    private ButtonItem newButton;
    private ButtonItem replyButton;
    private ButtonItem replyToAllButton;
    private ButtonItem forwardButton;
    private ButtonItem receiveButton;
    
    private DynamicForm buttonDm;
    private HLayout baseHorLayout;
    
    private TreeGrid tree;
    private ListGrid grid;
    

    @Override
    protected void buildUI() {
        //------------------------------ mail header
        TextItem subj = new TextItem("q1", "Subject");
        TextItem date = new TextItem("q2", "Date");
        TextItem from = new TextItem("q3", "From");
        TextItem to = new TextItem("q4", "To");
        TextItem cc = new TextItem("q5", "Cc");
        
        subj.setValue("Some subject");
        date.setValue("Thu 05-Nov-2013 17:00");
        from.setValue("Demis Caribidis");
        to.setValue("Vitaliy Golovkov");
        cc.setValue("Garik Harlamov; Timur Batrutdinov;");
        
        subj.setWidth("100%");
        date.setWidth("100%");
        from.setWidth("100%");
        to.setWidth("100%");
        cc.setWidth("100%");
        
        subj.setDisabled(true);
        date.setDisabled(true);
        from.setDisabled(true);
        to.setDisabled(true);
        cc.setDisabled(true);
        
        DynamicForm mailFiledDm = new DynamicForm();
        mailFiledDm.setFields(subj, date, from, to, cc);
        
        VLayout headerVerLayout = new VLayout(0);
        headerVerLayout.addMember(mailFiledDm);
        headerVerLayout.setHeight(133);
        
        //------------------------------ mail body
        TextAreaItem area = new TextAreaItem("w1", "");
        area.setShowTitle(false);
        area.setValue("A lot of text...");
        area.setHeight("*");
        area.setWidth("100%");
        area.setDisabled(true);
        
        DynamicForm bodyAreaDm = new DynamicForm();
        bodyAreaDm.setNumCols(1);
        bodyAreaDm.setHeight("*");
        bodyAreaDm.setFields(area);
        
        VLayout bodyVerLayout = new VLayout(0);
        bodyVerLayout.addMember(bodyAreaDm);
        
        VLayout mailVerLayout = new VLayout(0);
        mailVerLayout.addMember(headerVerLayout);
        mailVerLayout.addMember(bodyVerLayout);
        
        //------------------------------ table
        grid = new ListGrid();
        grid.setBackgroundColor("red");
        grid.setWidth("20%");
        grid.setShowHeader(false);
        
        //------------------------------- tree
        tree = new DirTreeGrid();
        tree.setWidth("15%");
//      directoriesTree.setHeight("80%");
        tree.setSelectionType(SelectionStyle.SINGLE);
        tree.setShowAllRecords(true);
        tree.setShowConnectors(true);
        tree.setNodeIcon("folder_open_closed.png");
        tree.setShowHeader(false);
//        TreeGridField gridField = new TreeGridField(DirectoryTreeNode.DIR_NAME_FIELD);
//        gridField.setCanEdit(true);
//        directoriesTree.setFields(gridField);
        depriveHeaderPrivileges(tree);
        tree.setShowCellContextMenus(true);
        
        //----------------------------- button form
        newButton = new ButtonItem("a1", "New...");
        replyButton = new ButtonItem("a2", "Reply...");
        replyToAllButton = new ButtonItem("a3", "Reply to All...");
        forwardButton = new ButtonItem("a4", "Forward...");
        receiveButton = new ButtonItem("a5", "Receive");
        
        newButton.setWidth(75);
        newButton.setHeight(30);
        replyButton.setWidth(75);
        replyButton.setHeight(30);
        replyToAllButton.setWidth(75);
        replyToAllButton.setHeight(30);
        forwardButton.setWidth(75);
        forwardButton.setHeight(30);
        receiveButton.setWidth(75);
        receiveButton.setHeight(30);
        
        replyButton.setStartRow(false);
        replyToAllButton.setStartRow(false);
        forwardButton.setStartRow(false);
        receiveButton.setStartRow(false);
        
        newButton.setEndRow(false);
        replyButton.setEndRow(false);
        replyToAllButton.setEndRow(false);
        forwardButton.setEndRow(false);
        receiveButton.setEndRow(false);
        
        buttonDm = new DynamicForm();
        buttonDm.setBackgroundColor("#EEEEEE");
        buttonDm.setPadding(3);
        buttonDm.setAutoWidth();
        buttonDm.setNumCols(5);
        buttonDm.setFields(newButton, replyButton, replyToAllButton, forwardButton, receiveButton);
        
        baseHorLayout = new HLayout(0);
        baseHorLayout.addMember(tree);
        baseHorLayout.addMember(grid);
        baseHorLayout.addMember(mailVerLayout);
    }
    
    @Override
    protected void drawUIWithMembers(VLayout mainLayout) {
        mainLayout.addMember(buttonDm);
        mainLayout.addMember(baseHorLayout);
    }
    
    private class DirTreeGrid extends TreeGrid {
//        @Override
//        protected String getCellCSSText(ListGridRecord record, int rowNum, int colNum) {
//            final String STYLE = "font-family:MS Reference Sans Serif;font-style:normal;font-size:11;";
//            String fieldName = getFieldName(colNum);
//            if (DirectoryTreeNode.DIR_NAME_FIELD.equals(fieldName)) {
//                DirectoryTreeNode node = (DirectoryTreeNode) record;
//                if (node.asDirectory().getParentDirectoryId() == 0) {
//                    return STYLE + "background-color:#EEEEEE;";
//                }
//                return STYLE;
//            }
//            return super.getCellCSSText(record, rowNum, colNum);
//        }
    }
    
    private void depriveHeaderPrivileges(ListGrid listGrid) {
        listGrid.setCanSort(false);
        listGrid.setCanGroupBy(false);
        listGrid.setCanPickFields(false);
        listGrid.setCanFreezeFields(false);
        listGrid.setCanResizeFields(true);
        listGrid.setCanAutoFitFields(false);
        listGrid.setCanReorderFields(false);
    }
    
    public void addReceiveButtonHandler(ClickHandler clickHandler) {
        receiveButton.addClickHandler(clickHandler);
    }
}
