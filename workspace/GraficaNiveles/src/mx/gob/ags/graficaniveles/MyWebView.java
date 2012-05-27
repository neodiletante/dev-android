package mx.gob.ags.graficaniveles;

import android.content.Context;
import android.util.Log;
import android.view.MotionEvent;
import android.webkit.WebView;

public class MyWebView extends WebView {
    private int idNumber;
    
	public int getIdNumber() {
		return idNumber;
	}

	public void setIdNumber(int idNumber) {
		this.idNumber = idNumber;
	}

	public MyWebView(Context context) {
		super(context);
		
	}
	
	@Override
	public boolean onTouchEvent(MotionEvent ev) {
		Log.v("Touch Event","ID "+this.getChildCount());
		return true;
		//return super.onTouchEvent(ev);
	}

}
