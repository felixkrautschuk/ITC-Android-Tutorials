package com.example.felix.navigationbackanduptutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;


public class SecondActivity extends Activity implements View.OnClickListener
{
    Button buttonStartThirdActivity;
    Intent intentThirdActivity;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);

        buttonStartThirdActivity = (Button) findViewById(R.id.buttonStartThirdActivity);
        buttonStartThirdActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view == buttonStartThirdActivity)
        {
            intentThirdActivity = new Intent(this, ThirdActivity.class);
            startActivity(intentThirdActivity);
        }
    }
}
