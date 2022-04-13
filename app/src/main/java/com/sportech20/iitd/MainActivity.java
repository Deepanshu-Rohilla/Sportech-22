package com.sportech20.iitd;

import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.net.Uri;
import android.os.Bundle;
import android.os.Handler;
import android.text.Html;
import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.appcompat.app.ActionBar;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentTransaction;

import com.etebarian.meowbottomnavigation.MeowBottomNavigation;
import com.google.android.material.appbar.AppBarLayout;
import com.google.firebase.database.collection.LLRBNode;
import com.sportech20.iitd.Admin.AdminLogin;
import com.sportech20.iitd.sponsors.SponsorsFragment;

import kotlin.Unit;
import kotlin.jvm.functions.Function1;

class nav_bar_ids{
    static  final int Home=1;
    static  final int Sports=2;
    static  final int About=3;

}


public class MainActivity extends AppCompatActivity implements HomeFrag.OnFragmentInteractionListener, AboutFrag.OnFragmentInteractionListener, PhotoGallery.OnFragmentInteractionListener,CampusMap.OnFragmentInteractionListener, SponsorsFragment.OnFragmentInteractionListener, ScheduleFragment.OnFragmentInteractionListener {


    static MeowBottomNavigation bottomNavigation;
    static CampusMap campusMap;
    SponsorsFragment newSportsFrag;
    HomeFrag homeFrag;
    boolean doubleBackToExitPressedOnce = false;

    ActionBar actionBar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        changeFragment(new HomeFrag());

        setupBottomNav();
        actionBar = getSupportActionBar();
        actionBar.setBackgroundDrawable(new ColorDrawable(Color.parseColor("#FFFFFF")));
        //actionBar.setTitle(Html.fromHtml("<font color=\"black\">" + getString(R.string.app_name) + "</font>"));
        actionBar.setDisplayOptions(ActionBar.DISPLAY_SHOW_CUSTOM);
        actionBar.setDisplayShowCustomEnabled(true);
        actionBar.setCustomView(R.layout.custom_action_bar);
        actionBar.setElevation(0);

    }

    void setupBottomNav(){

        bottomNavigation = findViewById(R.id.meowBottomNavigation);


        bottomNavigation.add(new MeowBottomNavigation.Model(nav_bar_ids.Home,R.drawable.ic_home_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(nav_bar_ids.Sports,R.drawable.ic_photo_album_black_24dp));
        bottomNavigation.add(new MeowBottomNavigation.Model(nav_bar_ids.About,R.drawable.ic_map_black_24dp));
        bottomNavigation.setBackgroundBottomColor(R.color.colorAccent);
//        bottomNavigation.getBar().setBackgroundColor(getResources().getColor(R.color.bottom_tabs));
       bottomNavigation.setSelectedIconColor(0);
        homeFrag=new HomeFrag();
        campusMap=new CampusMap();
        newSportsFrag=new SponsorsFragment();
        //bottomNavigation.setBackground(getDrawable(R.drawable.bottom_bar));
        bottomNavigation.show(1,true);
        bottomNavigation.setOnClickMenuListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {
                // YOUR CODES

                switch (model.getId()){
                    case nav_bar_ids.Home:
                    changeFragment(homeFrag);
                    break;
                    case nav_bar_ids.Sports:
                        changeFragment(newSportsFrag);
                        break;
                    case nav_bar_ids.About:
                        changeFragment(campusMap);
                        break;
                        default:

            }
                return null;
            }
        });

        bottomNavigation.setOnShowListener(new Function1<MeowBottomNavigation.Model, Unit>() {
            @Override
            public Unit invoke(MeowBottomNavigation.Model model) {

                switch (model.getId()){
                    case nav_bar_ids.Home:
                        changeFragment(homeFrag);
                        break;
                    case nav_bar_ids.Sports:
                        changeFragment(newSportsFrag);
                        break;
                    case nav_bar_ids.About:
                        changeFragment(campusMap);
                        break;
                    default:

                }
                // YOUR CODES
                return null;
            }
        });
    }
    void changeFragment(Fragment fragment)
    {
        FragmentTransaction transaction = getSupportFragmentManager().beginTransaction();
        transaction.replace(R.id.frame_container, fragment);
        transaction.addToBackStack("");
        transaction.commit();
    }


    @Override
    public void onFragmentInteraction(Uri uri) {

    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        MenuInflater menuInflater=getMenuInflater();
        menuInflater.inflate(R.menu.options_menu,menu);
/*        MenuInflater inflater = getMenuInflater();
        inflater.inflate(R.menu.menu,menu);*/
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        switch (item.getItemId()) {
            case R.id.rate_option:
            case R.id.review_option:
                startActivity(new Intent(Intent.ACTION_VIEW, Uri.parse("market://details?id="+getPackageName())));

                break;

            case R.id.feedback_option:
                Toast.makeText(this, "Opening Google Form", Toast.LENGTH_SHORT).show();
                CommonFunctions.openURL("https://docs.google.com/forms/u/0/d/e/1FAIpQLSfPtchppH5f9Zno7dxyfRMMLZP6hEOf2xVSEXpU593vZ1faHg/formResponse",this);
                break;
            case R.id.menu_admin:
                startActivity(new Intent(MainActivity.this, AdminLogin.class));


        }
        return true;
        //return super.onOptionsItemSelected(item);
        //return super.onOptionsItemSelected(item);
    }

    @Override
    public void onBackPressed() {

        if (doubleBackToExitPressedOnce) {
            finishAffinity();

            System.exit(0);
            super.onBackPressed();
            return;
        }

        this.doubleBackToExitPressedOnce = true;
        Toast.makeText(this, "Press back again to exit", Toast.LENGTH_SHORT).show();

        new Handler().postDelayed(new Runnable() {

            @Override
            public void run() {
                doubleBackToExitPressedOnce=false;
            }
        }, 1200);

    }
}
