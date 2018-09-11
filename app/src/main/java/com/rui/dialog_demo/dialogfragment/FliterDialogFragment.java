package com.rui.dialog_demo.dialogfragment;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.DialogFragment;
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

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by rui on 2018/9/11
 */
public class FliterDialogFragment extends DialogFragment {
    @BindView(R.id.rv_Data)
    RecyclerView rvData;
    @BindView(R.id.tv_reset)
    TextView tvReset;
    @BindView(R.id.tv_comfirm)
    TextView tvComfirm;
    Unbinder unbinder;

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
        setStyle(DialogFragment.STYLE_NO_TITLE, R.style.RightDialog);
    }

    @Override
    public void onStart() {
        super.onStart();
        initParams();
        initView();
    }

    private void initView() {

    }

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
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_filter, container, false);
        unbinder = ButterKnife.bind(this, view);
        return view;
    }

    @OnClick({R.id.tv_reset, R.id.tv_comfirm})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.tv_reset:
                break;
            case R.id.tv_comfirm:
                dismiss();
                break;
        }
    }
}
