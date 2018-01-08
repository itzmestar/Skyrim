package com.xenum.skyrim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.content.Intent;
import android.view.View.OnClickListener;
import android.widget.Toast;

import com.xenum.skyrim.com.xenum.skyrim.wifi.WiFiDirectActivity;

public class MainActivity extends Activity implements OnClickListener
{

    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.main);
        // Set up click listeners for all the buttons
        View continueButton = this.findViewById(R.id.control_button);
        continueButton.setOnClickListener(this);
        View newButton = this.findViewById(R.id.locate_button);
        newButton.setOnClickListener(this);
        View aboutButton = this.findViewById(R.id.comm_button);
        aboutButton.setOnClickListener(this);
        View exitButton = this.findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.control_button:
                Intent i = new Intent(this, ControllerActivity.class);
                startActivity(i);
                break;
            case R.id.locate_button:
                //Intent i = new Intent(this, About.class);
                //startActivity(i);
                showGPS();
                break;
            case R.id.exit_button:
                Toast.makeText(this, "Bye Bye", Toast.LENGTH_LONG).show();
                finish();
                break;
            case R.id.comm_button:
                Intent j = new Intent(this, WiFiDirectActivity.class);
                startActivity(j);
                break;
        }
    }
    public void showGPS()
    {
        LocateMe gps = new LocateMe(MainActivity.this);

        // check if GPS enabled
        if(gps.canGetLocation()){

            double latitude = gps.getLatitude();
            double longitude = gps.getLongitude();

            // \n is for new line
            Toast.makeText(getApplicationContext(), "Your Location is - \nLat: " + latitude + "\nLong: " + longitude, Toast.LENGTH_LONG).show();
        }else{
            // can't get location
            // GPS or Network is not enabled
            // Ask user to enable GPS/network in settings
            gps.showSettingsAlert();
        }
    }
}