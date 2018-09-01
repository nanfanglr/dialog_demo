package com.rui.dialog_demo.boucedialog;

import android.app.Dialog;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.Gravity;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.widget.TextView;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.dialog_demo.R;

/**
 * Created by Administrator on 2017/9/20.
 */
public class BottonDialogWithBounce<
        ADAPTER extends BaseQuickAdapter
        , LAYOUTMANAGER extends RecyclerView.LayoutManager>
        extends Dialog {

    private BounceView bounceView;
    private TextView tvCancel;
    private ADAPTER adapter;
    private LAYOUTMANAGER layoutmanager;

    public BottonDialogWithBounce(Context context, ADAPTER adapter, LAYOUTMANAGER layoutmanager) {
        this(context, R.style.UdDialogTheme, adapter, layoutmanager);
    }

    private BottonDialogWithBounce(Context context
            , int themeResId, ADAPTER adapter, LAYOUTMANAGER layoutmanager) {
        super(context, themeResId);
        this.layoutmanager = layoutmanager;
        this.adapter = adapter;
        initDialog();
        initView();
    }

    private void initDialog() {
        //去掉dialog的标题
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        /** 设置与屏幕等宽 */
        Window window = getWindow();
        /***
         * dialog 默认的样式@android:style/Theme.Dialog 对应的style 有pading属性 就能够水平占满
         ***/
        window.getDecorView().setPadding(0, 0, 0, 0);
        WindowManager.LayoutParams lp = window.getAttributes();
        lp.width = WindowManager.LayoutParams.MATCH_PARENT;
        lp.height = WindowManager.LayoutParams.WRAP_CONTENT;
        lp.gravity = Gravity.BOTTOM;
        window.setAttributes(lp);
        setContentView(R.layout.botton_bounce_dialog);
    }

    private void initView() {
        tvCancel = (TextView) findViewById(R.id.tv_cancel);
        tvCancel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dismiss();
            }
        });
        final RecyclerView rv = (RecyclerView) findViewById(R.id.rv_Data);

        bounceView = (BounceView) findViewById(R.id.bounceview);
        bounceView.setAnimatorListener(new BounceView.BounceAnimatorListener() {
            @Override
            public void showContent() {
                rv.setLayoutManager(layoutmanager);
                rv.setAdapter(adapter);
                rv.scheduleLayoutAnimation();
                tvCancel.setVisibility(View.VISIBLE);
            }
        });
    }

    @Override
    public void show() {
        super.show();
        if (bounceView != null) bounceView.show();

    }
}
