package com.example.felix.navigationbackanduptutorial;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

public class MainActivity extends Activity implements View.OnClickListener
{
    Button buttonStartSecondActivity;
    Intent intentSecondActivity;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        buttonStartSecondActivity = (Button) findViewById(R.id.buttonStartSecondActivity);
        buttonStartSecondActivity.setOnClickListener(this);
    }

    @Override
    public void onClick(View view)
    {
        if(view.getId() == R.id.buttonStartSecondActivity)
        {
            intentSecondActivity = new Intent(this, SecondActivity.class);
            startActivity(intentSecondActivity);
        }
    }
}
