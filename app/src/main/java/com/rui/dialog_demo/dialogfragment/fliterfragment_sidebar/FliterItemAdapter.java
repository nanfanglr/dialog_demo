package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

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
    /**
     * 显示item数量的限制值
     */
    public static final int LIMITLOAD = 6;
    private final int FLITER_ITEM_VIEW = 0x6661;
    private List<ChildModel> selectList;
    /**
     * 是否显示全部
     */
    private boolean isShowAll;

    public FliterItemAdapter(@NonNull List<ChildModel> data) {
        super(R.layout.item_fliter_child, data);
        selectList = new ArrayList<>();
    }

    public int getLIMITLOAD() {
        return LIMITLOAD;
    }

    public void setShowAll(boolean showAll) {
        if (mData.size() <= LIMITLOAD) {
            //小于等于限定值，这里不做操作
            return;
        } else {
            //大于限定值，通过局部刷新去提高性能
            isShowAll = showAll;
            if (isShowAll) {
                notifyItemRangeChanged(LIMITLOAD, mData.size() - LIMITLOAD, "fliter");
            } else {
                notifyItemRangeRemoved(LIMITLOAD, mData.size() - LIMITLOAD);
            }
        }
    }

    public List<ChildModel> getSelectList() {
        if (selectList == null) {
            return new ArrayList<>();
        }
        return selectList;
    }

    @Override
    public int getItemCount() {
        if (isShowAll) {
            return super.getItemCount();
        } else {
            return mData.size() > LIMITLOAD ? LIMITLOAD : mData.size();
        }
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
    protected void convert(BaseViewHolder helper, ChildModel item) {
        helper.setText(R.id.ck_item_chirld, item.getName())
                .setChecked(R.id.ck_item_chirld, item.isSelect())
        ;
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
