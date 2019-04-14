package com.rui.dialog_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.rui.dialog_demo.boucedialog.BounceViewActivity;
import com.rui.dialog_demo.dialogfragment.fliterfragment_sidebar.FliterDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;
    /**
     * 当需要记住状态时，我们就定义一个全部变量保存改fragment，以便第二次暂时
     */
    FliterDialogFragment fliterDialogFragment;
    long lastTime = 0l;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn, R.id.btn1, R.id.btn2, R.id.btn3})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startActivity(new Intent(MainActivity.this, BounceViewActivity.class));
                break;
            case R.id.btn1:
                if (fliterDialogFragment == null) {
                    fliterDialogFragment = FliterDialogFragment.newInstance();
                }
                fliterDialogFragment.show(getSupportFragmentManager(), "FliterDialogFragment");
                Log.i("MainActivity", fliterDialogFragment.toString());
                break;
            case R.id.btn2:
                if (lastTime != 0l) {
                    Log.d("------------------>", "" + (System.currentTimeMillis() - lastTime));
                }
                lastTime = System.currentTimeMillis();
                break;
            case R.id.btn3:
                startActivity(new Intent(MainActivity.this, WebviewActivity.class));
                break;
        }
    }
}
