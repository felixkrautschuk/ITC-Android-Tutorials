package com.example.felix.navigationdrawertutorial_learn2crack;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.os.Bundle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.ListView;


public class MainActivity extends Activity
{
    String[] menu;
    DrawerLayout drawerLayout;
    ListView listView;
    ArrayAdapter<String> arrayAdapter;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        menu = getResources().getStringArray(R.array.items);
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        listView = (ListView) findViewById(R.id.left_drawer);
        arrayAdapter = new ArrayAdapter<String>(this,android.R.layout.simple_list_item_1,menu);
        listView.setAdapter(arrayAdapter);
        listView.setSelector(android.R.color.holo_blue_dark);
        listView.setOnItemClickListener(new AdapterView.OnItemClickListener()
        {
            @Override
            public void onItemClick(AdapterView<?> arg0, View v, int position, long id)
            {
                drawerLayout.closeDrawers();
                Bundle args = new Bundle();
                args.putString("Menu", menu[position]);
                Fragment detail = new DetailFragment();
                detail.setArguments(args);
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, detail).commit();
            }
        });
    }
}
