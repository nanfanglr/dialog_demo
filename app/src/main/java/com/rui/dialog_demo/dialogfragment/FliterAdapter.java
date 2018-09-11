package com.rui.dialog_demo.dialogfragment;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.dialog_demo.R;

import java.util.List;

/**
 * Created by rui on 2018/9/11
 */
public class FliterAdapter extends BaseQuickAdapter<ParentModel, BaseViewHolder> {


    private GridSpacingItemDecoration itemDecoration3;

    public FliterAdapter(@NonNull List<ParentModel> data) {
        super(R.layout.item_fliter, data);
    }

    @Override
    protected void convert(BaseViewHolder helper, ParentModel item) {
        helper.setText(R.id.ck_item, item.getName());
        if (itemDecoration3 == null) {
            itemDecoration3 = new GridSpacingItemDecoration(3, dip2px(mContext, 10), false);
        }
        RecyclerView recyclerview = helper.getView(R.id.rv_item);
        FliterItemAdapter adapter = new FliterItemAdapter(item.getChildModels());
        GridLayoutManager glm = new GridLayoutManager(mContext, 3);
        recyclerview.setLayoutManager(glm);
        recyclerview.removeItemDecoration(itemDecoration3);
        recyclerview.addItemDecoration(itemDecoration3);
        recyclerview.setAdapter(adapter);
        CheckBox ck = helper.getView(R.id.ck_item);
        ck.setOnClickListener(v -> {
            
        });

    }


    /**
     * 根据手机的分辨率从 dp 的单位 转成为 px(像素)
     */
    private int dip2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }
}
