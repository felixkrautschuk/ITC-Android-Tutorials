package com.example.felix.navigationdrawertutorial3_icon;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.ListView;


public class MainActivity extends Activity
{
    private String[] navigationDrawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ObjectDrawerItem[] objectDrawerItems;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        navigationDrawerItemTitles= getResources().getStringArray(R.array.navigation_drawer_items_array);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        objectDrawerItems = new ObjectDrawerItem[8];
        objectDrawerItems[0] = new ObjectDrawerItem(R.drawable.home, "Home");
        objectDrawerItems[1] = new ObjectDrawerItem(R.drawable.android, "Android");
        objectDrawerItems[2] = new ObjectDrawerItem(R.drawable.windows, "Windows");
        objectDrawerItems[3] = new ObjectDrawerItem(R.drawable.linux, "Linux");
        objectDrawerItems[4] = new ObjectDrawerItem(R.drawable.raspberry, "Raspberry Pi");
        objectDrawerItems[5] = new ObjectDrawerItem(R.drawable.apple, "Apple");
        objectDrawerItems[6] = new ObjectDrawerItem(R.drawable.videos, "Videos");
        objectDrawerItems[7] = new ObjectDrawerItem(R.drawable.contact, "Contact Us");
    }


    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        return super.onOptionsItemSelected(item);
    }
}
