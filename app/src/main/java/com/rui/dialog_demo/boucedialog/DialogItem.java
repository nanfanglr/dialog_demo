package com.rui.dialog_demo.boucedialog;

import android.support.annotation.DrawableRes;

/**
 * Created by linet on 16/10/8.
 */

public class DialogItem {

    private int iconId;
    private String itemName;

    public DialogItem(@DrawableRes int iconId, String itemName) {
        this.iconId = iconId;
        this.itemName = itemName;
    }

    public int getIconId() {
        return iconId;
    }

    public void setIconId(int iconId) {
        this.iconId = iconId;
    }

    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }
}
