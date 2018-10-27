package com.hassan.alaa.tabstest;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    EditText userEditTxt;
    EditText passEditTxt;
    CheckBox rememberChbox;
    Button loginBtn;

    final String file = "com.hassan.alaa.tabstest.preferances";
    SharedPreferences sharedPreferences;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userEditTxt = findViewById(R.id.userEditTxt);
        passEditTxt = findViewById(R.id.passEditTxt);
        rememberChbox = findViewById(R.id.rememberChbox);
        loginBtn = findViewById(R.id.loginBtn);

        loginBtn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                sharedPreferences = getSharedPreferences(file, Context.MODE_PRIVATE);
                SharedPreferences.Editor editor = sharedPreferences.edit();
                if ((userEditTxt.getText().toString().trim().length() != 0) || (passEditTxt.getText().toString().trim().length() != 0)) {
                    editor.putString("username", userEditTxt.getText().toString());
                    editor.putString("Password", passEditTxt.getText().toString());
                    if (rememberChbox.isChecked()){
                        editor.putBoolean("remember me", true);
                    } else
                        editor.putBoolean("remember me", false);
                    editor.apply();
                    Intent intent = new Intent(MainActivity.this, List.class);
                    startActivity(intent);
                    }else {
                    AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
                    builder.setTitle("Login failed").setMessage("Please enter username and password.")
                            .setCancelable(false).setPositiveButton("Ok", new DialogInterface.OnClickListener() {
                                @Override
                                public void onClick(DialogInterface dialog, int which) {
                                    dialog.dismiss();
                                }
                            });
                    AlertDialog dialog = builder.create();
                    dialog.show();
                }
            }
        });
    }
}
