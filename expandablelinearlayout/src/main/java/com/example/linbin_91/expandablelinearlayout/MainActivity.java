package com.example.linbin_91.expandablelinearlayout;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.view.Window;
import android.webkit.WebSettings;


public class MainActivity extends ActionBarActivity {

    private GestureWebView mWebView;
    private String url = "http://www.baidu.com";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        initDatas();
        initView();
    }

    private void initView() {
        mWebView = (GestureWebView) findViewById(R.id.id_web);
        WebSettings centerSetting = mWebView.getSettings();
        centerSetting.setSavePassword(false);
        centerSetting.setJavaScriptEnabled(true);

        mWebView.loadUrl(url);
    }

    private void initDatas() {
    }
}