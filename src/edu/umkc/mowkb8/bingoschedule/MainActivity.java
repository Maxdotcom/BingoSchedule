package edu.umkc.mowkb8.bingoschedule;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.widget.TextView;

public class MainActivity extends Activity implements LocationListener {
	
	private LocationManager lm;
	private TextView tv;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        tv = (TextView) findViewById(R.id.loc);
        lm = (LocationManager) getSystemService(Context.LOCATION_SERVICE);
        lm.requestLocationUpdates(LocationManager.GPS_PROVIDER, 500, 1, this);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.activity_main, menu);
        return true;
    }


    @Override
    public void onLocationChanged(Location arg0) {
    	String lat = String.valueOf(arg0.getLatitude());
    	String lon = String.valueOf(arg0.getLongitude());
    	Log.e("GPS", "location changed: lat="+lat+", lon="+lon);
    	tv.setText("lat="+lat+", lon="+lon);
	}
    public void onProviderDisabled(String arg0) {
  	  Log.e("GPS", "provider disabled " + arg0);
    }
    public void onProviderEnabled(String arg0) {
    	Log.e("GPS", "provider enabled " + arg0);
    }
    public void onStatusChanged(String arg0, int arg1, Bundle arg2) {
    	Log.e("GPS", "status changed to " + arg0 + " [" + arg1 + "]");
    }
}

