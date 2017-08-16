package com.lightingcontour.onlyvoice;

import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

/*
* 用透明Activity过渡.
*
* */

public class StartActivity extends AppCompatActivity {

    Context context;
    Boolean flag = true;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.layout_start);
        getSupportActionBar().hide();

        context = StartActivity.this;

        if (flag)
        {
            Intent intent = new Intent(context,GuideActivity.class);
            startActivity(intent);
            finish();
        }
    }
}
