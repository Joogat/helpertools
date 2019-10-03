package com.joogat.helper;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import com.joogat.logger.L;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        L.e(5);
        L.e("hello");
    }
}
