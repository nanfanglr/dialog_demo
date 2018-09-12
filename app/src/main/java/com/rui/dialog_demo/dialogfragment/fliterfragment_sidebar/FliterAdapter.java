package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.widget.CheckBox;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.chad.library.adapter.base.BaseViewHolder;
import com.rui.dialog_demo.R;
import com.rui.dialog_demo.dialogfragment.GridSpacingItemDecoration;

import java.util.List;

/**
 * Created by rui on 2018/9/11
 */
public class FliterAdapter extends BaseQuickAdapter<ParentModel, BaseViewHolder> {

    private final int FLITER_ITEM_VIEW = 0x6662;
    private GridSpacingItemDecoration itemDecoration3;

    public FliterAdapter(@NonNull List<ParentModel> data) {
        super(R.layout.item_fliter, data);
    }

    /**
     * RecycledViewPool是依据ItemViewType来索引ViewHolder的，
     * 所以你必须确保共享的RecyclerView的Adapter是同一个，或view type 是不会冲突的。
     * 因此必须重写这个方法，以确保共享的RecyclerView的Adapter的viewtype不冲突
     *
     * @param position
     * @return
     */
    @Override
    public int getDefItemViewType(int position) {
        return FLITER_ITEM_VIEW;
    }

    @Override
    protected void convert(BaseViewHolder helper, ParentModel item) {
        helper.setText(R.id.ck_item, item.getName())
                .setChecked(R.id.ck_item, item.isExpand())
        ;
        if (itemDecoration3 == null) {
            itemDecoration3 = new GridSpacingItemDecoration(3, dip2px(mContext, 10), false);
        }
        RecyclerView recyclerview = helper.getView(R.id.rv_item);
        List<ChildModel> childModels = item.getChildModels();
        FliterItemAdapter adapter = new FliterItemAdapter(childModels);
        GridLayoutManager glm = new GridLayoutManager(mContext, 3);
        recyclerview.setRecycledViewPool(getRecyclerView().getRecycledViewPool());
        recyclerview.setLayoutManager(glm);
        recyclerview.removeItemDecoration(itemDecoration3);
        recyclerview.addItemDecoration(itemDecoration3);
        recyclerview.setAdapter(adapter);
        CheckBox ck = helper.getView(R.id.ck_item);
        adapter.setShowAll(item.isExpand());
        ck.setCompoundDrawablesWithIntrinsicBounds(
                0, 0,
                childModels.size() < adapter.getLIMITLOAD() ? 0 : R.drawable.selector_arrow,
                0);
        ck.setOnClickListener(v -> {
            adapter.setShowAll(ck.isChecked());
            item.setExpand(ck.isChecked());
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
