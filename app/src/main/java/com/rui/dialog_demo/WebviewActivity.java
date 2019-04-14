package com.rui.dialog_demo;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.webkit.WebView;

import butterknife.BindView;
import butterknife.ButterKnife;

public class WebviewActivity extends AppCompatActivity {

    @BindView(R.id.webview)
    WebView webview;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_webview);
        ButterKnife.bind(this);
        String content = "<h1 align='center'>AWESOME!</h1>"
                + "<h3 align='center'>You have successfully place your order!</h3>"
                + "<p align='center'> Your order had summited,if there are price different with TaoBao,our customer service willreview the price and update the price same as TaoBao,please wait for a moment!</p>"
                + "<h3 align='center'>Attention</h3>"
                + "<p>1.After the merchandise warehouse AsiaSB will be base on the acTual weight of goods or volurne talculation of freightdown the difference.</p>"
                + "<p>2.If you find the purchase price with TaoBao and other platforms are inconsistent,Please do not worry,customerservice is for your audit orders,after the reviewwill update the price and Taobao platform consistent!</p>";
        webview.loadDataWithBaseURL(null, content, "text/html", "UTF-8", null);
    }
}
