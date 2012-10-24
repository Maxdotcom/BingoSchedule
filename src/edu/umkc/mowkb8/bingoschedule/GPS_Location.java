package edu.umkc.mowkb8.bingoschedule;

import android.location.Location;
import android.location.LocationListener;
import android.location.LocationManager;
import android.os.Bundle;
import android.app.Activity;
import android.content.Context;
import android.util.Log;
import android.view.Menu;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class GPS_Location {
	
	private LocationManager lm;
	private TextView GPS_loc;
	private String lat;
	private String lon;
	private Context mContext;

    
    public GPS_Location(Context mContext) {
        this.mContext = mContext;
    	
        lat = "0";
        lon = "0";
        
        lm = (LocationManager) mContext.getSystemService(Context.LOCATION_SERVICE);
        
        
    }
    public void getLoc() {
    	String provider = LocationManager.GPS_PROVIDER;
    	Location l = lm.getLastKnownLocation(provider);
    	if (l != null)
    	{
    		lat = String.valueOf(l.getLatitude());
    		lon = String.valueOf(l.getLongitude());
    	} else {
    		lat = "0";
    		lon = "0";
    	}
    	
    	
    }
    public String getLat() {
    	if (lat != null)
    	{
    		return lat;
    	} else {
    		return "0";
    	}
    }
    
    public String getLon() {
    	if (lon != null)
    	{
    		return lon;
    	} else {
    		return "0";
    	}
    }
}

