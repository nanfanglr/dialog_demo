package com.rui.dialog_demo.boucedialog;

import android.app.Dialog;
import android.content.Context;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.GridLayoutManager;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.chad.library.adapter.base.BaseQuickAdapter;
import com.rui.dialog_demo.R;

import java.util.ArrayList;
import java.util.List;

public class BounceViewActivity extends AppCompatActivity {

    private Dialog dialog;
    private BounceMenu bounceMenu;
    private MyAdapter myAdapter;
    private List<String> stringList;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bounce_view);

        stringList = new ArrayList<>();

        for (int i = 0; i < 20; i++) {
            stringList.add("Data_" + i);
        }

        myAdapter = new MyAdapter(this, stringList) {
            @Override
            protected int ItemLayoutId() {
                return R.layout.item;
            }

            @Override
            protected void onBindHolder(MyViewHolder myViewHolder, int position) {
                TextView textView = myViewHolder.getTextView(R.id.text);
                textView.setText(stringList.get(position));
            }
        };
        final List<DialogItem> list = new ArrayList<>();
        list.add(new DialogItem(R.drawable.icon_gouwu1, "第一个"));
        list.add(new DialogItem(R.drawable.icon_shouye, "第二个"));
        list.add(new DialogItem(R.drawable.icon_wo, "第三个"));

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "点击了我", Toast.LENGTH_SHORT).show();
                dialog = getDialog(BounceViewActivity.this, list, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        dialog.dismiss();
                        Toast.makeText(BounceViewActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });

        findViewById(R.id.text2).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                Toast.makeText(MainActivity.this, "点击了我", Toast.LENGTH_SHORT).show();
                dialog = getDialog2(BounceViewActivity.this, list, new BaseQuickAdapter.OnItemClickListener() {
                    @Override
                    public void onItemClick(BaseQuickAdapter adapter, View view, int position) {
                        dialog.dismiss();
                        Toast.makeText(BounceViewActivity.this, "点击了" + position, Toast.LENGTH_SHORT).show();
                    }
                });

            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        menu.add("Go!").setShowAsAction(MenuItem.SHOW_AS_ACTION_ALWAYS);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if (bounceMenu == null) {
            bounceMenu = BounceMenu.makeMenu(this, R.layout.layout_bounce_menu, myAdapter);
            bounceMenu.show();
        } else {
            bounceMenu.dismiss();
            bounceMenu = null;
        }
        return super.onOptionsItemSelected(item);
    }

    private BottonDialogWithBounce getDialog(
            Context context, List<DialogItem> list,
            BaseQuickAdapter.OnItemClickListener listener) {
        BottonDialogAdapter adapter = new BottonDialogAdapter(R.layout.item_botton_dialog, list);
        GridLayoutManager manager = new GridLayoutManager(context, 3);
//        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        BottonDialogWithBounce<BottonDialogAdapter, GridLayoutManager> dialog = new BottonDialogWithBounce<>(context, adapter, manager);
        adapter.setOnItemClickListener(listener);
        dialog.show();
        return dialog;
    }

    private BottonDialog getDialog2(
            Context context, List<DialogItem> list,
            BaseQuickAdapter.OnItemClickListener listener) {
        BottonDialogAdapter adapter = new BottonDialogAdapter(R.layout.item_botton_dialog, list);
        GridLayoutManager manager = new GridLayoutManager(context, 3);
//        LinearLayoutManager manager = new LinearLayoutManager(context, LinearLayoutManager.HORIZONTAL, false);
        BottonDialog<BottonDialogAdapter, GridLayoutManager> dialog = new BottonDialog<>(context, adapter, manager);
        adapter.setOnItemClickListener(listener);
        dialog.show();
        return dialog;
    }
}
