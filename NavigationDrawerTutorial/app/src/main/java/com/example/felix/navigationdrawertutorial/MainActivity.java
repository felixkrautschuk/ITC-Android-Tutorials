package com.example.felix.navigationdrawertutorial;

import android.app.Activity;
import android.os.Bundle;
import android.support.v4.app.ActionBarDrawerToggle;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

public class MainActivity extends Activity
{
    private DrawerLayout drawerLayout;
    private ListView drawerList;
    private ActionBarDrawerToggle drawerToggle;
    private CharSequence title;
    private String[] drawerTitles;
    private String[] drawerSubtitles;
    private int[] drawerIcons;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        title = getTitle();
        drawerLayout = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawerList = (ListView) findViewById(R.id.left_drawer);
        drawerLayout.setDrawerShadow(R.drawable.drawer_shadow, GravityCompat.START);

        //Hole die Titel aus einem Array aus der strings.xml
        drawerTitles = getResources().getStringArray(R.array.drawerTitles_array);
        //Hole die Untertitel aus einem Array aus der strings.xml
        drawerSubtitles = getResources().getStringArray(R.array.drawerSubtitles_array);
        //Setzt die Icons zu den Einträgen
        drawerIcons = new int[] {android.R.drawable.ic_menu_info_details, android.R.drawable.ic_menu_edit, android.R.drawable.ic_menu_delete};

        //Erstellt den neuen MenuAdapter aus der Klasse MenuListAdapter
        MenuListAdapter mMenuAdapter = new MenuListAdapter(this, drawerTitles, drawerSubtitles, drawerIcons);
        drawerList.setAdapter(mMenuAdapter);
        drawerList.setOnItemClickListener(new DrawerItemClickListener());

        //Bereitet die ActionBar auf den Navigation Drawer vor
        this.getActionBar().setDisplayHomeAsUpEnabled(true);
        this.getActionBar().setHomeButtonEnabled(true);

        //Fügt den Navigation Drawer zur ActionBar hinzu
        drawerToggle = new ActionBarDrawerToggle(this, drawerLayout, R.drawable.ic_drawer, R.string.drawer_open, R.string.drawer_close)
        {
            public void onDrawerClosed(View view)
            {
                getActionBar().setTitle(title);
                invalidateOptionsMenu();
            }

            public void onDrawerOpened(View drawerView)
            {
                getActionBar().setTitle(R.string.app_name);
                invalidateOptionsMenu();
            }
        };
        drawerLayout.setDrawerListener(drawerToggle);
    }

    //Fügt das Menü hinzu / ActionBar Einträge
    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.main, menu);
        return super.onCreateOptionsMenu(menu);
    }

    //Versteckt die ActionBar-Einträge, sobald der Drawer ausgefahren is
    @Override
    public boolean onPrepareOptionsMenu(Menu menu)
    {
        boolean drawerOpen = drawerLayout.isDrawerOpen(drawerList);
        //menu.findItem(R.id.action_settings).setVisible(!drawerOpen);
        return super.onPrepareOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        //Öffnet und schließt den Navigation Drawer bei Klick auf den Titel/das Icon in der ActionBar
        if (item.getItemId() == android.R.id.home)
        {
            if (drawerLayout.isDrawerOpen(drawerList))
            {
                drawerLayout.closeDrawer(drawerList);
            }
            else
            {
                drawerLayout.openDrawer(drawerList);
            }
        }

        //Gibt den ActionBar-Buttons Funktionen
        switch (item.getItemId())
        {
            default:
                return super.onOptionsItemSelected(item);
        }
    }

    // Listener für die Navigation Drawer Einträge - Achtung: Zählung beginnt bei 0!
    private class DrawerItemClickListener implements ListView.OnItemClickListener
    {
        @Override
        public void onItemClick(AdapterView<?> parent, View view, int position, long id)
        {
            if (position == 0)
            {
                title = drawerTitles[position];
                getActionBar().setTitle(title);
            }
            else if (position == 1)
            {
                title = drawerTitles[position];
                getActionBar().setTitle(title);
            }
            else if (position == 2)
            {
                title = drawerTitles[position];
                getActionBar().setTitle(title);
            }

            drawerList.setItemChecked(position, true);
            drawerLayout.closeDrawer(drawerList);
        }

        /*
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
        */
    }
}

