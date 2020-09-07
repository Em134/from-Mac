package com.example.a.androidui;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.graphics.Bitmap;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.ViewGroup;
import android.webkit.WebChromeClient;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

public class ActivityWebView_forsee extends AppCompatActivity {

    WebView mWebview;
    WebSettings mWebSettings;
    TextView beginLoading,endLoading,loading,mtitle;

//   public boolean shouldOverrideUrlLoading(WebView view,
//                                            WebResourceRequest request) {
//        //                view.loadUrl(url);
//        //                return true;
//        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
//            view.loadUrl(request.getUrl().toString());
//        } else {
//            view.loadUrl(request.toString());
//        }
//        return true;
//    }






    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.webpage2);
        Intent intent=getIntent();
        String data=intent.getStringExtra("readurl");


        mWebview = (WebView) findViewById(R.id.webView1);
        beginLoading = (TextView) findViewById(R.id.text_beginLoading);
        endLoading = (TextView) findViewById(R.id.text_endLoading);
        loading = (TextView) findViewById(R.id.text_Loading);
        mtitle = (TextView) findViewById(R.id.title);

        mWebSettings = mWebview.getSettings();

        mWebSettings.setJavaScriptEnabled(true); // 啊啊啊啊啊啊阿！


        mWebview.loadUrl(data);


        //设置不用系统浏览器打开,直接显示在当前Webview
        mWebview.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {

                //第一种。失败
//                if(url == null) return false;
//                try {
//                    if(url.startsWith("bilibili://")
//                        //其他自定义的scheme
//                    ) {
//                        Intent intent = new Intent(Intent.ACTION_VIEW, Uri.parse(url));
//                        startActivity(intent);
//                        return true;
//                    }
//                } catch (Exception e) { //防止crash (如果手机上没有安装处理某个scheme开头的url的APP, 会导致crash)
//                    return false;
//                }


                //第二种，失败
//                try {
//
//                    if (!url.startsWith("http:") ||!url.startsWith("https:")) {
//
//                        Intent intent = new Intent(Intent.ACTION_VIEW,
//
//                                Uri.parse(url));
//
//                        startActivity(intent);
//
//                        return true;
//
//                    }
//
//                }
//
//                catch (Exception e){
//
//                    return false;
//
//                }

                //第三种，失败

//                if(url == null) return false;
//                try {
//
//                    if (url.startsWith("http:") ||url.startsWith("https:")) {
//
//                        view.loadUrl(url);
//                        return false;
//
//                    }else{
//                        Intent intent = new Intent(Intent.ACTION_VIEW);
//
//                        intent.setData(Uri.parse(url)) ;
//
//                        startActivity(intent);
//
//                        return true;
//                    }
//
//                }
//
//                catch (Exception e){
//
//                    return false;
//
//                }






                view.loadUrl(url);
                return true;
            }
        });

        //设置WebChromeClient类
        mWebview.setWebChromeClient(new WebChromeClient() {


            //获取网站标题
            @Override
            public void onReceivedTitle(WebView view, String title) {
                System.out.println("标题在这里");
                mtitle.setText("视频浏览界面");
            }


            //获取加载进度
            @Override
            public void onProgressChanged(WebView view, int newProgress) {
                if (newProgress < 100) {
                    String progress = newProgress + "%";
                    loading.setText(progress);
                } else if (newProgress == 100) {
                    String progress = newProgress + "%";
                    loading.setText(progress);
                }
            }
        });


        //设置WebViewClient类
        mWebview.setWebViewClient(new WebViewClient() {
            //设置加载前的函数
            @Override
            public void onPageStarted(WebView view, String url, Bitmap favicon) {
                System.out.println("开始加载了");
                beginLoading.setText("开始加载了");

            }

            //设置结束加载函数
            @Override
            public void onPageFinished(WebView view, String url) {
                endLoading.setText("结束加载了");

            }
        });
    }


    //点击返回上一页面而不是退出浏览器
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK && mWebview.canGoBack()) {
            mWebview.goBack();
            return true;
        }

        return super.onKeyDown(keyCode, event);
    }

    //销毁Webview
    @Override
    protected void onDestroy() {
        if (mWebview != null) {
            mWebview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
            mWebview.clearHistory();

            ((ViewGroup) mWebview.getParent()).removeView(mWebview);
            mWebview.destroy();
            mWebview = null;
        }
        super.onDestroy();
    }
}



