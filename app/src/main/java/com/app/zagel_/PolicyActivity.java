package com.app.zagel_;

import android.content.DialogInterface;
import android.content.Intent;
import android.media.AudioManager;
import android.media.MediaPlayer;
import android.net.Uri;
import android.os.Bundle;
import android.os.CountDownTimer;
import android.view.KeyEvent;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.appcompat.app.ActionBarDrawerToggle;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.Toolbar;
import androidx.core.view.GravityCompat;
import androidx.drawerlayout.widget.DrawerLayout;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.google.android.material.navigation.NavigationView;

import java.util.ArrayList;

public class PolicyActivity extends AppCompatActivity
        implements NavigationView.OnNavigationItemSelectedListener {

    MyDB objDB;
    ArrayList<DBmodel> objmodelarrayList;
    RecyclerView recyclerView;
    public DrawerLayout mDrawer;
    MediaPlayer mMediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_policy);

        Toolbar toolbar = findViewById(R.id.toolbar);
        setSupportActionBar(toolbar);

        mDrawer = findViewById(R.id.drawer_layout);
        NavigationView navigationView = findViewById(R.id.nav_view);
        ActionBarDrawerToggle toggle = new ActionBarDrawerToggle(
                this, mDrawer, toolbar, R.string.navigation_drawer_open, R.string.navigation_drawer_close);
        mDrawer.addDrawerListener(toggle);
        toggle.syncState();
        navigationView.setNavigationItemSelectedListener(this);


        objDB = new MyDB(this,"policy");
        objmodelarrayList = new ArrayList<>();

        recyclerView = findViewById(R.id.recyclerview);

        mMediaPlayer = new MediaPlayer();
        mMediaPlayer = MediaPlayer.create(this , R.raw.mainactivity);
        mMediaPlayer.setAudioStreamType(AudioManager.STREAM_MUSIC);
        mMediaPlayer.setLooping(false);
        onPause();
        CountDownTimer cntr_aCounter = new CountDownTimer(25000, 1000) {
            @Override
            public void onTick(long l) {

                mMediaPlayer.start();
            }

            @Override
            public void onFinish() {
                mMediaPlayer.stop();
            }
        };cntr_aCounter.start();

        showData();
    }

    @Override
    public void onBackPressed() {
        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        if (drawer.isDrawerOpen(GravityCompat.START)) {
            drawer.closeDrawer(GravityCompat.START);
        } else {
            super.onBackPressed();
        }
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();



        return super.onOptionsItemSelected(item);
    }

    @SuppressWarnings("StatementWithEmptyBody")
    @Override
    public boolean onNavigationItemSelected(MenuItem item) {
        // Handle navigation view item clicks here.
        int id = item.getItemId();

        if (id == R.id.nav_home) {
            startActivity(new Intent(PolicyActivity.this,MainActivity.class));
            finish();

        } else if (id == R.id.nav_policy){
            startActivity(new Intent(PolicyActivity.this,PolicyActivity.class));
            finish();
        }

        else if (id == R.id.nav_football){
            startActivity(new Intent(PolicyActivity.this,FootballActivity.class));
            finish();
        }

        else if (id == R.id.nav_economy){
            startActivity(new Intent(PolicyActivity.this,EconomieActivity.class));
            finish();
        }

        else if (id == R.id.nav_celebrities){
            startActivity(new Intent(PolicyActivity.this,CelebrityActivity.class));
            finish();
        }

        else if (id == R.id.nav_share) {

            Intent share = new Intent(Intent.ACTION_SEND);
            share.setType("text/plain");
            share.putExtra(Intent.EXTRA_SUBJECT,"My App");
            String applink = "https://play.google.com/store/apps/details?id=com.rwida.projectsql";
            share.putExtra(Intent.EXTRA_SUBJECT,"Try My App" + applink);
            startActivity(Intent.createChooser(share, "Share Via"));

        } else if (id == R.id.nav_send) {

            String txt = "Hello !! \n Please enter your Suggestion : ";
            Intent sendemail = new Intent(Intent.ACTION_SEND);
            sendemail.setData(Uri.parse("mailto:"));
            sendemail.setType("message/rfc822");
            sendemail.putExtra(Intent.EXTRA_EMAIL,"www.rwidaosama33@gmail.com");
            sendemail.putExtra(Intent.EXTRA_SUBJECT,"A5bary app");
            sendemail.putExtra(Intent.EXTRA_TEXT,txt);
            startActivity(sendemail);

        } else if (id == R.id.nav_exit){

            AlertDialog.Builder builder = new AlertDialog.Builder(PolicyActivity.this);
            builder.setMessage("Are you sure you want to exit?")
                    .setTitle("Confirm exit")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();

        }

        DrawerLayout drawer = findViewById(R.id.drawer_layout);
        drawer.closeDrawer(GravityCompat.START);
        return true;
    }



    public void showData(){
        try {
            objmodelarrayList = objDB.getAllData();
            dbAdapter objDbadapter = new dbAdapter(objmodelarrayList,PolicyActivity.this);
            recyclerView.hasFixedSize();
            recyclerView.setLayoutManager(new LinearLayoutManager(this));
            recyclerView.setAdapter(objDbadapter);
        }
        catch (Exception e){
            Toast.makeText(this, "ShowData:-" + e.getMessage(), Toast.LENGTH_SHORT).show();
        }
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event)
    {
        if(keyCode == KeyEvent.KEYCODE_BACK)
        {
            AlertDialog.Builder builder = new AlertDialog.Builder(PolicyActivity.this);
            builder.setMessage("Are you sure you want to exit?")
                    .setTitle("Confirm exit")
                    .setPositiveButton("yes", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {
                            finish();
                        }
                    })
                    .setNegativeButton("No", new DialogInterface.OnClickListener() {
                        @Override
                        public void onClick(DialogInterface dialogInterface, int i) {

                        }
                    }).show();
            return true;
        }
        return false;
    }

    @Override
    protected void onPause() {
        super.onPause();
        if (this.isFinishing()){
            mMediaPlayer.stop();
        }
    }

}
