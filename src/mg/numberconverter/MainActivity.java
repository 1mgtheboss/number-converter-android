package mg.numberconverter;

import com.google.android.gms.ads.AdListener;
import com.google.android.gms.ads.AdRequest;
import com.google.android.gms.ads.InterstitialAd;

import android.app.Activity;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends Activity {
	
	private InterstitialAd interstitial;

	@Override
	protected void onCreate(Bundle savedInstanceState) {
		super.onCreate(savedInstanceState);
		setContentView(R.layout.activity_main);
		
		// Create the interstitial.
	    interstitial = new InterstitialAd(this);
	    interstitial.setAdUnitId("a15360ef96ab0cb");
	    
	    
	    interstitial.setAdListener(new AdListener() {
	        @Override
	        public void onAdLoaded() {
	          
	        	displayInterstitial();

	          
	        }
	        @Override
	        public void onAdFailedToLoad(int errorCode) {
	          
	        }
	    });
		
	    // Create ad request.
	    
	    AdRequest adRequest = new AdRequest.Builder().build();
	    
	    
	    
	   
	    
	    // Begin loading your interstitial.
	    interstitial.loadAd(adRequest);
		
	}

	@Override
	public boolean onCreateOptionsMenu(Menu menu) {
		// Inflate the menu; this adds items to the action bar if it is present.
		getMenuInflater().inflate(R.menu.main, menu);
		return true;
	}
	
	public void convert(View view) {
		
		try
		{
		
		 // Do something in response to button
		EditText  mEditText1   = (EditText)findViewById(R.id.editText1);
		
		int n=Integer.parseInt(mEditText1.getText().toString());
		TextView textView = (TextView) findViewById(R.id.textView1);
		
		
		textView.setText("Binary: "+Integer.toBinaryString(n)+"\n"+"Octal: "+Integer.toOctalString(n)+"\n"+"Hexadecimal: "+Integer.toHexString(n));
		
		}
		catch(Exception e)
		{
		}
		
		
	}
	
	// Invoke displayInterstitial() when you are ready to display an interstitial.
	  public void displayInterstitial() {
	    if (interstitial.isLoaded()) {
	      interstitial.show();
	    }
	  }

}
