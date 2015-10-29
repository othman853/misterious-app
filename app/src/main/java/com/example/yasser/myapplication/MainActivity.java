package com.example.yasser.myapplication;

import android.app.Fragment;
import android.app.FragmentTransaction;
import android.os.Bundle;
import android.support.design.widget.NavigationView;
import android.support.v4.view.GravityCompat;
import android.support.v4.widget.DrawerLayout;
import android.support.v7.app.ActionBarDrawerToggle;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.MenuItem;

import com.example.yasser.myapplication.sections.ForecastFragment;
import com.example.yasser.myapplication.sections.ForestFragment;
import com.example.yasser.myapplication.sections.HappyBirthdayFragment;
import com.example.yasser.myapplication.sections.MusicFragment;
import com.example.yasser.myapplication.sections.NumbersFragment;
import com.example.yasser.myapplication.sections.PetsFragment;
import com.example.yasser.myapplication.sections.PoetryFragment;
import com.example.yasser.myapplication.sections.SurpriseVideoFragment;
import com.example.yasser.myapplication.util.Constants;

public class MainActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Toolbar toolbar = (Toolbar) findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);


        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, drawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        drawer.setDrawerListener(toggle);
        toggle.syncState();

        NavigationView navigationView = (NavigationView) findViewById(R.id.nav_view);
        navigationView.setNavigationItemSelectedListener(this);
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_about) {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        FragmentTransaction transaction = getFragmentManager().beginTransaction();

        Fragment fragment = new Fragment();
        String tag = "";

        if (id == R.id.numbers) {
            fragment = new NumbersFragment();
            tag = Constants.FragmentTags.NUMBERS;
        } else if (id == R.id.poetries) {
            fragment = new PoetryFragment();
            tag = Constants.FragmentTags.POETRY;
        } else if (id == R.id.pets) {
            fragment = new PetsFragment();
            tag = Constants.FragmentTags.PETS;
        } else if (id == R.id.forest) {
            fragment = new ForestFragment();
            tag = Constants.FragmentTags.FOREST;
        } else if (id == R.id.forecast) {
            fragment = new ForecastFragment();
            tag = Constants.FragmentTags.FORECAST;
        }else if (id == R.id.video) {
            fragment = new SurpriseVideoFragment();
            tag = Constants.FragmentTags.VIDEO;
        } else if (id == R.id.music) {
            fragment = new MusicFragment();
            tag = Constants.FragmentTags.MUSIC;
        } else if (id == R.id.happy_birthday) {
            fragment = new HappyBirthdayFragment();
            tag = Constants.FragmentTags.HAPPY_BIRTHDAY;
        }

        transaction
                .replace(R.id.main_content, fragment, tag)
                .addToBackStack(null);


        transaction.commit();

        DrawerLayout drawer = (DrawerLayout) findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }
}
