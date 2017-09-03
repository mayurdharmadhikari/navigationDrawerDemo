package com.cminnovision.NavigationDrawer;

import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.NavigationView;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.MenuItem;
import android.view.View;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {
    private Toolbar mToolbar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        mToolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(mToolbar);
        showNavigationBar();
    }

    private void showNavigationBar() {
        final NavigationView navigationView = (NavigationView) findViewById(R.id.navigation_menu);
        final DrawerLayout drawerLayout = (DrawerLayout) findViewById(R.id.drawer);
        ActionBarDrawerToggle actionBarDrawerToggle = new ActionBarDrawerToggle(this, drawerLayout, mToolbar, R.string.drawer_open, R.string.drawer_close) {
            @Override
            public void onDrawerClosed(View v) {
            }

            @Override
            public void onDrawerOpened(View v) {
            }
        };
        drawerLayout.addDrawerListener(actionBarDrawerToggle);
        actionBarDrawerToggle.syncState();

        navigationView.setNavigationItemSelectedListener(new NavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem menuItem) {
                switch (menuItem.getItemId()) {
                    // To add new menu items, open menu.xml and add new menu.
                    case R.id.nav_drawer_account_settings:
                        Toast.makeText(getApplicationContext(), "Settings clicked", Toast.LENGTH_LONG).show();
                        drawerLayout.closeDrawers();
                        break;
                    case R.id.nav_drawer_help:
                        Toast.makeText(getApplicationContext(), "Help", Toast.LENGTH_SHORT).show();
                        break;
                    case R.id.nav_drawer_feedback:
                        Toast.makeText(getApplicationContext(), "Feedback", Toast.LENGTH_SHORT).show();
                        drawerLayout.closeDrawers();
                        break;
                }
                // if you want to show last selected menu item then you should return true.
                return false;
            }
        });
    }
}