package com.xenum.skyrim;

import android.app.Activity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;


/**
 * Created by tanwer on 27/07/2016.
 */
public class ControllerActivity extends Activity implements View.OnClickListener {
    @Override
    public void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.control);
        // Set up click listeners for all the buttons
        View upButton = this.findViewById(R.id.up_button);
        upButton.setOnClickListener(this);
        View homeButton = this.findViewById(R.id.home_button);
        homeButton.setOnClickListener(this);
        View downButton = this.findViewById(R.id.down_button);
        downButton.setOnClickListener(this);
        View rightButton = this.findViewById(R.id.right_button);
        downButton.setOnClickListener(this);
        View leftButton = this.findViewById(R.id.left_button);
        downButton.setOnClickListener(this);
        /*View exitButton = this.findViewById(R.id.exit_button);
        exitButton.setOnClickListener(this);*/
    }

    public void onClick(View v)
    {
        switch (v.getId())
        {
            case R.id.up_button:
                goUp();
                break;
            case R.id.home_button:
                //Intent i = new Intent(this, About.class);
                //startActivity(i);
                goHome();
                break;
            case R.id.down_button:
                goDown();
                //finish();
                break;
            case R.id.right_button:
                goRight();
                break;
            case R.id.left_button:
                goLeft();
                break;
        }
    }

    @Override
    public void onResume() {
        super.onResume();
    }

    @Override
    public void onPause() {
        super.onPause();
    }

    @Override
    public void onStop() {  // the activity is no long visible
        super.onStop();
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
    }

    public void goUp(){
        Toast.makeText(this, "Ascending", Toast.LENGTH_SHORT).show();
    }
    public void goDown(){
        Toast.makeText(this, "Descending", Toast.LENGTH_SHORT).show();
    }
    public void goHome(){
        Toast.makeText(this, "Going Home, Hurray", Toast.LENGTH_SHORT).show();
    }
    public void goRight(){
        Toast.makeText(this, "Ahead", Toast.LENGTH_SHORT).show();
    }
    public void goLeft(){
        Toast.makeText(this, "Back", Toast.LENGTH_SHORT).show();
    }
}
