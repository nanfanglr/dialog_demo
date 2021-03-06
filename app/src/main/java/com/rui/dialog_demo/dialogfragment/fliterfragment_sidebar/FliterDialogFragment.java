package com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.DisplayMetrics;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.rui.dialog_demo.R;

import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * 从右侧弹出的筛选界面（仿淘宝），用recyclerviewrecyclerview嵌套实现，状态保存、重置均已实现
 * 1、嵌套recyclerview间共享RecycledViewPool，优化性能
 * 2，recyclerview局部刷新
 * Created by rui on 2018/9/11
 */
public class FliterDialogFragment extends DialogFragment {

    @BindView(R.id.rv_data)
    RecyclerView rvData;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.tv_comfirm)
    TextView tvComfirm;
    Unbinder unbinder;

    /**
     * 存储原来的数据，以便保存当前页面的选择状态
     */
    private List<ParentModel> testData;
    private FliterAdapter adapter;

    public static FliterDialogFragment newInstance() {
        FliterDialogFragment dialogFragment = new FliterDialogFragment();
        Bundle bundle = new Bundle();
//        bundle.putSerializable("orderDetailModel", orderDetailModel);
        dialogFragment.setArguments(bundle);
        return dialogFragment;
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.FliterDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        initParams();
        initView();
    }

    private void initView() {
        adapter = new FliterAdapter(testData == null ? TestData.getTestData() : testData);
        LinearLayoutManager manager = new LinearLayoutManager(getActivity());
        //手动开启共享RecycledViewPool特性
        //LinearLayoutManager或其子类（如GridLayoutManager），需要手动开启这个特性
        manager.setRecycleChildrenOnDetach(true);
        rvData.setLayoutManager(manager);
        adapter.bindToRecyclerView(rvData);
    }

    //这里没有用到以下的优化，但是当RecyclerView加载卡顿时可以考虑以下的优化方式：
    //可以指定缓存的大小，通过调用myPool.setMaxRecycledViews(0, 10);来设置每种类型的View的容量。
    //需要注意的是对于ViewType的定义，对同一个RecycerViewPool要统一，
    // 因为在RecyclerView的实现中，是以ViewType来作Key来获取对应的对象池。否则就会出现奇怪的问题。
    //RecycledViewPool   缓存的不同 类型viewType 的数量是不限的，
    // 但是每个viewType 的具体ViewHolder 最多为5个。
    // 可以通过setMaxRecycledViews方法 设置某个viewType 的最大尺寸。
    //    pool = rvData.getRecycledViewPool();
    //    pool.setMaxRecycledViews(viewType, maxRvs);
    //    for (int i = 0; i < 10; i++) {
    //        pool.putRecycledView(rvData.getAdapter().createViewHolder(rvData, viewType));
    //    }

    private void initParams() {
        Dialog dialog = getDialog();
        Window window = getDialog().getWindow();
        // 设置宽度为屏宽、靠近屏幕底部。
        if (window != null) {
            /***
             * dialog 默认的样式@android:style/Theme.Dialog 对应的style 有pading属性 就能够水平占满
             ***/
            window.getDecorView().setPadding(0, 0, 0, 0);
            WindowManager.LayoutParams lp = window.getAttributes();
            lp.width = (int) (getScreenWidthAndHight(getActivity())[0] * 0.75);
            lp.height = ViewGroup.LayoutParams.MATCH_PARENT;
            lp.gravity = Gravity.END;
            window.setAttributes(lp);
            setCancelable(true);
            dialog.setCanceledOnTouchOutside(true);
        }
    }

    /**
     * 获取屏幕的像素
     *
     * @param context
     * @return
     */
    private int[] getScreenWidthAndHight(Context context) {
        int[] wh = new int[2];
        DisplayMetrics dm = context.getResources().getDisplayMetrics();
        wh[0] = dm.widthPixels;
        wh[1] = dm.heightPixels;
        return wh;
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        unbinder.unbind();
        //这一句代码，目的是保存原来数据
        testData = adapter.getData();
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @Override
    public void onViewCreated(@NonNull View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
    }

    @OnClick({R.id.tv_reset, R.id.tv_comfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reset:
                resetData();
                break;
            case R.id.tv_comfirm:
                //先组装参数
                getSearchParams();
                //组装完毕，发送事件到前一个页面更新搜索页面

                dismiss();
                break;
        }
    }

    /**
     * 重置列表数据
     */
    private void resetData() {
        List<ParentModel> data = adapter.getData();
        for (ParentModel p : data) {
            p.setExpand(false);
            for (ChildModel c : p.getChildModels()) {
                c.setSelect(false);
            }
        }
        adapter.notifyDataSetChanged();
    }

    /**
     * 组装搜索参数
     */
    private void getSearchParams() {
        List<ParentModel> data = adapter.getData();
        // TODO: 2018/9/12 以下添加处理组装搜索参数相关代码
    }
}
