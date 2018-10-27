package com.hassan.alaa.tabstest;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Handler;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

public class Splash_Screen extends AppCompatActivity {
    final String file = "com.hassan.alaa.tabstest.preferances";
    SharedPreferences sharedPreferences;
    Boolean rememberCheckBox = false;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash__screen);

        sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE);
        rememberCheckBox = sharedPreferences.getBoolean("remember me", false);
        int length = 3000;
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
               if (rememberCheckBox == true){
                Intent intent = new Intent(Splash_Screen.this, List.class);
                Splash_Screen.this.startActivity(intent);
                Splash_Screen.this.finish();
                } else {
                   Intent intent = new Intent(Splash_Screen.this, MainActivity.class);
                   Splash_Screen.this.startActivity(intent);
                   Splash_Screen.this.finish();
               }
            }
        }, length);


    }
}
