package mx.gob.ags.graficaniveles;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.Toast;

public class Second extends Activity {
	public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
 
	setContentView(R.layout.main2);  
	Intent sender=getIntent();
    String extraData=sender.getExtras().getString("ComingFrom");
    Context context = getApplicationContext();
    CharSequence text = extraData;
    int duration = Toast.LENGTH_SHORT;
    Toast toast = Toast.makeText(context, text, duration);
    toast.show();
        WebView mWebView2;
        mWebView2 = (WebView) findViewById(R.id.webview2);    
        mWebView2.getSettings().setPluginsEnabled(true);
        mWebView2.getSettings().setJavaScriptEnabled(true);    
        mWebView2.loadUrl("file:///android_asset/www/bar.html");
       

      
    }
}
