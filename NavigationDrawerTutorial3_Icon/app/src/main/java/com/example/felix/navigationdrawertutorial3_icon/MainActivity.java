package com.example.felix.navigationdrawertutorial3_icon;

import android.app.Activity;
import android.app.Fragment;
import android.app.FragmentManager;
import android.content.res.Configuration;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;


public class MainActivity extends Activity
{
    private String[] navigationDrawerItemTitles;
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ObjectDrawerItem[] objectDrawerItems;
    private DrawerItemCustomAdapter adapter;
    private ActionBarDrawerToggle drawerToggle;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        setTitle("NavigationDrawer");

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

        adapter = new DrawerItemCustomAdapter(this, R.layout.listview_item_row, objectDrawerItems);
        drawerList.setAdapter(adapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close)
        {
            public void onDrawerOpened(View drawerView)
            {
                getActionBar().setTitle(getTitle());
                invalidateOptionsMenu();
            }

            public void onDrawerClosed(View view)
            {
                getActionBar().setTitle(getTitle());
                invalidateOptionsMenu();
            }
        };

        drawerLayout.setDrawerListener(drawerToggle);
        getActionBar().setDisplayHomeAsUpEnabled(true);
        getActionBar().setHomeButtonEnabled(true);
    }

    @Override
    protected void onPostCreate(Bundle savedInstanceState)
    {
        super.onPostCreate(savedInstanceState);
        drawerToggle.syncState();
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig)
    {
        super.onConfigurationChanged(newConfig);
        drawerToggle.onConfigurationChanged(newConfig);
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
        if (drawerToggle.onOptionsItemSelected(item))
        {
            return true;
        }
        return super.onOptionsItemSelected(item);
    }

    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            selectItem(position);
        }

        private void selectItem(int position)
        {
            Fragment fragment = null;

            switch (position)
            {
                case 0:
                    Toast.makeText(getApplicationContext(), "Home", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 1:
                    Toast.makeText(getApplicationContext(), "Android", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 2:
                    Toast.makeText(getApplicationContext(), "Windows", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 3:
                    Toast.makeText(getApplicationContext(), "Linux", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 4:
                    Toast.makeText(getApplicationContext(), "Raspberry Pi", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 5:
                    Toast.makeText(getApplicationContext(), "Apple", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 6:
                    Toast.makeText(getApplicationContext(), "Videos", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
                case 7:
                    Toast.makeText(getApplicationContext(), "Contact Us", Toast.LENGTH_SHORT).show();
                    drawerLayout.closeDrawer(drawerList);
                    break;
            }

            if (fragment != null)
            {
                FragmentManager fragmentManager = getFragmentManager();
                fragmentManager.beginTransaction().replace(R.id.content_frame, fragment).commit();

                drawerList.setItemChecked(position, true);
                drawerList.setSelection(position);
                getActionBar().setTitle(navigationDrawerItemTitles[position]);
                drawerLayout.closeDrawer(drawerList);
            }
        }
    }
}
