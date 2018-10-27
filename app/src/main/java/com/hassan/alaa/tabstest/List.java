package com.hassan.alaa.tabstest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.graphics.Color;
import android.support.design.widget.TabLayout;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.Toolbar;
import android.view.Menu;
import android.view.View;
import android.widget.ListView;
import android.widget.TextView;


import java.util.ArrayList;

public class List extends AppCompatActivity {

    TabLayout tabLayout;
    ViewPager viewPager;
    PagerAdapter pagerAdapter;
    TextView logTxt;
    TextView outTxt;
    String username;
    Toolbar toolbar;

    final String file = "com.hassan.alaa.tabstest.preferances";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list);

        sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE);
        username = sharedPreferences.getString("username", "Not Available");

        toolbar = findViewById(R.id.tool_bar);
        setSupportActionBar(toolbar);
        getSupportActionBar().setTitle("  " + username);
        toolbar.setTitleTextColor(Color.WHITE);
        getSupportActionBar().setIcon(R.drawable.manuser);




        tabLayout = findViewById(R.id.tab);
        viewPager = findViewById(R.id.pager);

        pagerAdapter = new PagerAdapter(getSupportFragmentManager());
        viewPager.setAdapter(pagerAdapter);

        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.car).setText("Vehicles"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.television).setText("Electronics"));
        tabLayout.addTab(tabLayout.newTab().setIcon(R.drawable.tshirt).setText("Fashion"));

        viewPager.addOnPageChangeListener(new TabLayout.TabLayoutOnPageChangeListener(tabLayout));

        tabLayout.addOnTabSelectedListener(new TabLayout.OnTabSelectedListener() {
            @Override
            public void onTabSelected(TabLayout.Tab tab) {
                viewPager.setCurrentItem(tab.getPosition());
            }

            @Override
            public void onTabUnselected(TabLayout.Tab tab) {

            }

            @Override
            public void onTabReselected(TabLayout.Tab tab) {

            }
        });

        outTxt = findViewById(R.id.outTxt);
        logTxt = findViewById(R.id.logTxt);

        logTxt.setText("Logged in as " + username);

        outTxt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                SharedPreferences.Editor editor = sharedPreferences.edit();
                editor.putBoolean("remember me", false);
                editor.apply();
                Intent intent = new Intent(List.this, MainActivity.class);
                startActivity(intent);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu, menu);
        return super.onCreateOptionsMenu(menu);
    }
}
