package com.rui.dialog_demo.dialogfragment;

import android.support.annotation.NonNull;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.dialog_demo.R;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by rui on 2018/9/11
 */
public class FliterItemAdapter extends BaseQuickAdapter<ChildModel, BaseViewHolder> {

    private List<ChildModel> selectList;

    public FliterItemAdapter(@NonNull List<ChildModel> data) {
        super(R.layout.item_fliter_child, data);
        selectList=new ArrayList<>();
    }

    public List<ChildModel> getSelectList() {
        if (selectList == null) {
            return new ArrayList<>();
        }
        return selectList;
    }

    @Override
    public int getItemCount() {
        return 6;
    }

    @Override
    protected void convert(BaseViewHolder helper, ChildModel item) {
        helper.setText(R.id.ck_item_chirld, item.getName());
        CheckBox checkBox = helper.getView(R.id.ck_item_chirld);
        checkBox.setOnClickListener(view -> {
            if (checkBox.isChecked()) {
                item.setSelect(true);
                selectList.add(item);
            } else {
                item.setSelect(false);
                selectList.remove(item);
            }
        });

    }
}
