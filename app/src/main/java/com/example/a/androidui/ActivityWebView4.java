package com.example.a.androidui;

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

public class ActivityWebView4 extends AppCompatActivity {

        WebView mWebview;
        WebSettings mWebSettings;
        TextView beginLoading,endLoading,loading,mtitle;

        @Override
        protected void onCreate(Bundle savedInstanceState) {
            super.onCreate(savedInstanceState);
            setContentView(R.layout.webpage2);


            mWebview = (WebView) findViewById(R.id.webView1);
            beginLoading = (TextView) findViewById(R.id.text_beginLoading);
            endLoading = (TextView) findViewById(R.id.text_endLoading);
            loading = (TextView) findViewById(R.id.text_Loading);
            mtitle = (TextView) findViewById(R.id.title);

            mWebSettings = mWebview.getSettings();

            mWebview.loadUrl("https://mp.weixin.qq.com/s?__biz=MjA1ODMxMDQwMQ==&mid=2657226418&idx=1&sn=9a937dd2710d50ed860916f03dcff4ac&chksm=49060adc7e7183ca88c23997ad9403b55998cc4a2538e14ce7ecd5c390b123396cda7dcb9d44&mpshare=1&scene=1&srcid=0529SeAuSLQoYLUoRHMxyPvX#rd");


            //设置不用系统浏览器打开,直接显示在当前Webview
            mWebview.setWebViewClient(new WebViewClient() {
                @Override
                public boolean shouldOverrideUrlLoading(WebView view, String url) {
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
                    mtitle.setText("文章阅读界面");
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





//    private Button map;
//    private WebView webview;
//
//
//    @Override
//    protected void onCreate(Bundle savedInstanceState) {
//
//        super.onCreate(savedInstanceState);
//
//        setContentView(R.layout.webpage_1);
//
//        webview = (WebView) findViewById(R.id.webpage1);
//        webview.loadUrl("http://www.baidu.com/");
//
//        webview.setWebViewClient(new WebViewClient(){
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                view.loadUrl(url);
//                return true;
//            }
//        });
//
//
//        webview.getSettings().setUseWideViewPort(true);//将图片调整到适合webView的大小
//        webview.getSettings().setLoadWithOverviewMode(true);//缩放至屏幕大小
//
//        webview.setWebViewClient(new WebViewClient() {
//
//            @Override
//            public void onPageStarted(WebView view, String url, Bitmap favicon) {
//
//                //想在页面开始加载时有操作，在这添加
//                super.onPageStarted(view, url, favicon);
//            }
//
//            @Override
//            public void onPageFinished(WebView view, String url) {
//
//                //想在页面加载结束时有操作，在这添加
//                super.onPageFinished(view, url);
//            }
//
//            @Override
//            public boolean shouldOverrideUrlLoading(WebView view, String url) {
//                //返回值是true的时候WebView打开，为false则系统浏览器或第三方浏览器打开。如果要下载页面中的游戏或者继续点击网页中的链接进入下一个网页的话，重写此方法下，不然就会跳到手机自带的浏览器了，而不继续在你这个webview里面展现了
//                return true;
//            }
//            @Override
//
//            public void onReceivedError(WebView view, int errorCode,
//
//                                        String description, String failingUrl) {
//
//                //想在收到错误信息的时候，执行一些操作，走此方法
//
//            }
//        });
//
//
//    }
//
//
//    @Override
//    public void onBackPressed() {
//        super.onBackPressed();
//    }
//
//
//
//    @Override
//    protected void onDestroy() {
//        if (webview != null) {
//            webview.loadDataWithBaseURL(null, "", "text/html", "utf-8", null);
//            webview.clearHistory();
//
//            ((ViewGroup) webview.getParent()).removeView(webview);
//            webview.destroy();
//            webview = null;
//        }
//        super.onDestroy();
//    }
//}
