package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

import java.util.ArrayList;
import java.util.List;

import static com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar.FliterItemAdapter.LIMITLOAD;

/**
 * Created by rui on 2018/9/11
 */
public class ParentModel {
    private int id;
    private String name;
    /**
     * 标识是否展开
     */
    private boolean isExpand;
    private List<ChildModel> childModels;

    public ParentModel() {
    }

    public ParentModel(int id, String name, List<ChildModel> childModels) {
        this.id = id;
        this.name = name;
        this.childModels = childModels;
    }

    public List<ChildModel> getChildModels() {
        if (childModels == null) {
            return new ArrayList<>();
        }
        return childModels;
    }

    public void setChildModels(List<ChildModel> childModels) {
        this.childModels = childModels;
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

    public boolean isExpand() {
        return isExpand && childModels.size() > LIMITLOAD;
    }

    public void setExpand(boolean expand) {
        if (childModels.size() <= LIMITLOAD) {
            //小于等于限定值，这里不做操作
            return;
        }
        isExpand = expand;
    }
}
