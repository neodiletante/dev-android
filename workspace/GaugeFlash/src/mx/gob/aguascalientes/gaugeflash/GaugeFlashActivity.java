package mx.gob.aguascalientes.gaugeflash;

import android.app.Activity;
import android.os.Bundle;
import android.webkit.WebView;

public class GaugeFlashActivity extends Activity {
    /** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //WebView webview = new WebView(this); 
        //webview.getSettings().setJavaScriptEnabled(true);
        //webview.getSettings().setPluginsEnabled(true); 
        //setContentView(webview); 
       // webview.loadUrl("file:///android_asset/www/AngularGauge.swf");
      //  String html = "<object width=\"550\" height=\"400\"> <param name=\"movie\" value=\"file:///android_asset/www/AngularGauge.swf\"> <embed src=\"file:///android_asset/www/AngularGauge.swf\" width=\"550\" height=\"400\"> </embed> </object>";

        //String mimeType = "text/html";
		//String encoding = "utf-8";
		
	   // webview.loadDataWithBaseURL("null", html, mimeType, encoding, "");
        setContentView(R.layout.main);    
        WebView mWebView;
        mWebView = (WebView) findViewById(R.id.webview);    
        mWebView.getSettings().setPluginsEnabled(true);
        mWebView.getSettings().setJavaScriptEnabled(true);    
        mWebView.loadUrl("file:///android_asset/www/graf.html");
        
        WebView mWebView2;
        mWebView2 = (WebView) findViewById(R.id.webview2);    
        mWebView2.getSettings().setPluginsEnabled(true);
        mWebView2.getSettings().setJavaScriptEnabled(true);    
        mWebView2.loadUrl("file:///android_asset/www/graf.html");
        /*
        WebView webview = new WebView(this); 
        webview.getSettings().setPluginsEnabled(true); 
        webview.getSettings().setJavaScriptEnabled(true);
        setContentView(webview); 
        webview.loadUrl("file:///android_asset/www/graf.html"); 
        */
	    
	    
    }
}