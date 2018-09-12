package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

/**
 * Created by rui on 2018/9/11
 */
public class ChildModel {
    private int id;
    private String name;
    /**
     * 标识是否选中
     */
    private boolean isSelect;

    public ChildModel() {
    }

    public ChildModel(int id, String name) {
        this.id = id;
        this.name = name;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name == null ? "" : name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public boolean isSelect() {
        return isSelect;
    }

    public void setSelect(boolean select) {
        isSelect = select;
    }
}
