package com.rui.dialog_demo.boucedialog;

import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.dialog_demo.R;

import java.util.List;

/**
 * Created by Administrator on 2016/3/10.
 */
public class BottonDialogAdapter extends BaseQuickAdapter<DialogItem, BaseViewHolder> {


    public BottonDialogAdapter(@LayoutRes int layoutResId, @Nullable List<DialogItem> data) {
        super(layoutResId, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, DialogItem item) {
        helper.setText(R.id.tv_item, item.getItemName())
                .setImageResource(R.id.iv_item, item.getIconId());

    }
}
