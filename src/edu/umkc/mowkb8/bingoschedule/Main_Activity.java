package edu.umkc.mowkb8.bingoschedule;

import android.os.Bundle;
import android.app.Activity;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import edu.umkc.mowkb8.bingoschedule.GPS_Location;
//import android.view.View.OnClickListener;


public class Main_Activity extends Activity {
	
	private Button check_in_button;
	private TextView gps_loc_tv;
	private GPS_Location g;
	

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        
        g = new GPS_Location(this);
        g.getLoc();
        
        gps_loc_tv = (TextView) findViewById(R.id.gps_loc_tv);
       
        check_in_button = (Button) findViewById(R.id.check_in_button);
        check_in_button.setOnClickListener(myOnClickListener);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.gps_activity, menu);
        return true;
    }
	View.OnClickListener myOnClickListener = new View.OnClickListener() {
	    	
			
			@Override
			public void onClick(View v) {
				String lat = g.getLat();
				String lon = g.getLon();
				gps_loc_tv.setText("lat="+lat+", lon="+lon);
				//gps_loc_tv.setText("shit");
		    	
		    	
				
			}
		};
}
