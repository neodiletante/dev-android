package mx.gob.ags.graficaniveles;


import java.util.ArrayList;
import java.util.List;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.MotionEvent;
import android.view.View;
import android.view.View.OnTouchListener;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.AbsoluteLayout.LayoutParams;
import android.widget.LinearLayout;
import android.widget.ScrollView;
public class GraficaNivelesActivity extends Activity implements OnTouchListener{
	private LinearLayout linearLayout;
	private int id_web = 0;
	//	private final Handler handler = new Handler(this);
	
	/** Called when the activity is first created. */
    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        //setContentView(R.layout.main);    
        //linearLayout = (LinearLayout) findViewById(R.id.lista_gauge);
        linearLayout = new LinearLayout(this);
        linearLayout.setOrientation(LinearLayout.VERTICAL); 
        linearLayout.setBackgroundColor(3549);
        //linearLayout.setMinimumHeight(200);
        ScrollView sv = new ScrollView(this);  
        sv.addView(linearLayout); 
               
       List<ChartValues> chartList = new ArrayList<ChartValues>();
       chartList.add(new ChartValues(1,25,"Progreso Económico, Empleo y Mejores Salarios"));
       chartList.add(new ChartValues(2,47,"Humanización de Justicia, Cultura de Legalidad y Seguridad Pública"));
       chartList.add(new ChartValues(3,99,"Gobierno Eficiente"));
       chartList.add(new ChartValues(4,90,"Bienestar Socioal, Calidad de Vida y Servicios Públicos"));
       chartList.add(new ChartValues(5,70,"Educación de Calidad"));
       chartList.add(new ChartValues(6,10,"Medio Ambiente y Desarrollo Sustentable"));
       for(ChartValues chart : chartList){
    	   drawGaugeChart(chart);
       }
       this.setContentView(sv);
       
      // this.setContentView(linearLayout);
    }
    public void drawGaugeChart(final ChartValues chart){
    	
    	//linearLayout = (LinearLayout) findViewById(R.id.lista_gauge);
    	LinearLayout inner = new LinearLayout(this);
    	
    	final WebView webViewDynamic = new WebView(this);
        webViewDynamic.setId(chart.getId());
        webViewDynamic.setLayoutParams(new LayoutParams(LayoutParams.FILL_PARENT, LayoutParams.WRAP_CONTENT, 0, 0));
        
        inner.addView(webViewDynamic);
        android.view.ViewGroup.LayoutParams params = linearLayout.getLayoutParams();
        params.height = 100;

        params.width=params.WRAP_CONTENT;
        linearLayout.setLayoutParams(params);
        //linearLayout.setLayoutParams(new LinearLayout.LayoutParams(LayoutParams.FILL_PARENT, 100));
        linearLayout.addView(inner);
        
       // linearLayout.addView(webViewDynamic); 
        webViewDynamic.setOnTouchListener(this);
        webViewDynamic.getSettings().setPluginsEnabled(true);
        webViewDynamic.getSettings().setJavaScriptEnabled(true);
        webViewDynamic.setBackgroundColor(3549);
        webViewDynamic.layout(50,50,50,51);
        
       
        webViewDynamic.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url)
            {
                webViewDynamic.loadUrl("javascript:(function() { " +
                        "val="+chart.getVal()+"; " +
                        
                        "var chart = \""+ "AngularGauge"+".swf\";" +
                        "drawChart(val,chart);" +
                        "document.getElementsByTagName('p')[0].innerHTML = '"+ chart.getTitle()+"'; " +
                        "document.getElementsByTagName('p')[0].style.text-align = 'center'; " +
                        
                        //"document.getElementsByTagName('label')[0].style.color = 'red'; " +
                		//"document.getElementsByTagName('body')[0].style.color = 'red'; " +
                        "})()");
            }
        });
       webViewDynamic.loadUrl("file:///android_asset/www/graf.html");
    }
    
    public void lanzar(View view, int idWeb){
    	Intent intent = new Intent(this,Second.class);
    	intent.putExtra("ComingFrom", "Activity " + idWeb);
    	startActivityForResult(intent,0);
    }
	
    @Override
	public boolean onTouch(View v, MotionEvent event) {
		//if (v.getId() == R.id.webview && event.getAction() == MotionEvent.ACTION_DOWN)
    	
    	
    	if(event.getAction() == MotionEvent.ACTION_DOWN){
    		id_web = v.getId();
    	}
    	
    	if ( event.getAction() == MotionEvent.ACTION_UP)
    	{
	       if(v.getId() == id_web){
	    	 String mensaje = String.valueOf(id_web);
	    	 Log.v("Chart Values", mensaje);
    	     lanzar(v,id_web);    
	       }
        }     
		return false; 
	}
    
    /*
    @Override 
    public boolean dispatchTouchEvent(MotionEvent ev) {  
    	Log.v("FROM_DISPATCH_TOUCH_EVENT", "Action = " + ev.getAction());  
    	return false; 
    }
	*/
}