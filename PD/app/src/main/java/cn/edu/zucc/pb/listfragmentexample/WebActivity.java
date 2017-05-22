package cn.edu.zucc.pb.listfragmentexample;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.KeyEvent;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Toast;


public class WebActivity extends AppCompatActivity {
    private WebView webview;
    String url="http://www.baidu.com";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.web);
        Intent intent = getIntent();
        url = intent.getStringExtra("url");
//https://wiki.52poke.com/wiki/%E6%9C%A8%E6%9C%A8%E6%9E%AD
        webview = (WebView) findViewById(R.id.webview);
        webview.setScrollBarStyle(View.SCROLLBARS_INSIDE_OVERLAY);
        webview.getSettings().setJavaScriptEnabled(true);//设置WebView属性，能够执行Javascript脚本
        //webview.getSettings().setSupportMultipleWindows(true);
        webview.getSettings().setLoadWithOverviewMode(true);//缩放页面
        webview.getSettings().setUseWideViewPort(true);//将图片调整到适合webview的大小
        webview.getSettings().setBuiltInZoomControls(true);
        webview.setHorizontalScrollBarEnabled(false);//滚动条水平不显示
        webview.setVerticalScrollBarEnabled(false); //滚动条垂直不显示

        webview.loadUrl(url);
        webview.setWebViewClient(new WebViewClient(){
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });


        webview.setWebChromeClient(new WebChromeClient() {
            public void onProgressChanged(WebView view, int progress) {
                setProgress(progress * 100);
                if(progress == 100) {
                    setProgressBarIndeterminateVisibility(false);
                    setProgressBarVisibility(false);
                }
            }
        });


        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


    }


    @Override
    //设置回退
    //覆盖Activity类的onKeyDown(int keyCoder,KeyEvent event)方法
//    public boolean onKeyDown(int keyCode, KeyEvent event) {
////        if ((keyCode == KeyEvent.KEYCODE_BACK) && webview.canGoBack()) {
//            webview.goBack(); //goBack()表示返回WebView的上一页面
//            return true;
////        }
////        return false;
//    }

    //调用toolbar布局
    public boolean onCreateOptionsMenu(Menu menu){
        getMenuInflater().inflate(R.menu.base_toolbar_menu,menu);
        return true;
    }
    //toolbar按钮点击事件
    public boolean onOptionsItemSelected(MenuItem item){
        switch(item.getItemId()){
            //导航按钮点击事件，位于toolbar左端
            case R.id.action_item1:
                Toast.makeText(this,"已选择关于我们", Toast.LENGTH_SHORT).
                        show();
                //点击设置按钮后，转至设置界面
                Intent intent = new Intent(Intent.ACTION_VIEW);
                intent.setData(Uri.parse(url));
                startActivity(intent);
                break;
            default:
        }
        return true;
    }



}

