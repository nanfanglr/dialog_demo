package com.rui.dialog_demo.dialogfragment;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2018/9/11
 */
public class ParentModel {
    private int id;
    private String name;
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
}
