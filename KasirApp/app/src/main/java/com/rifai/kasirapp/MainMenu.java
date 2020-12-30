package com.rifai.kasirapp;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;

public class MainMenu extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        //make activity fullscreen
        requestWindowFeature(Window.FEATURE_NO_TITLE);
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,WindowManager.LayoutParams.FLAG_FULLSCREEN);

        super.onCreate(savedInstanceState);

        //Hide the action bar
        getSupportActionBar().hide();

        setContentView(R.layout.activity_main_menu);
    }

    public void listProdukTampil(View view) {
        Intent ListProdukIntent = new Intent(MainMenu.this,ListProdukActivity.class);
        startActivity(ListProdukIntent);
    }

    public void listPenjualanTampil(View view) {
        Intent ListPenjualanIntent = new Intent(MainMenu.this,ListPenjualanActivity.class);
        startActivity(ListPenjualanIntent);
    }
}