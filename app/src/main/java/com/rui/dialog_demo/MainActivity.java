package com.rui.dialog_demo;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.widget.Button;

import com.rui.dialog_demo.boucedialog.BounceViewActivity;
import com.rui.dialog_demo.dialogfragment.FliterDialogFragment;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends FragmentActivity {

    @BindView(R.id.btn)
    Button btn;
    @BindView(R.id.btn1)
    Button btn1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick({R.id.btn, R.id.btn1})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn:
                startActivity(new Intent(MainActivity.this, BounceViewActivity.class));
                break;
            case R.id.btn1:
                FliterDialogFragment.newInstance().show(getSupportFragmentManager(),"FliterDialogFragment");
                break;
        }
    }
}
