package com.dev.hieu.lab7;

import android.animation.ObjectAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class MainActivity extends AppCompatActivity {
    private ImageView imgview;
    private Button btnrotate;
    private Button btnmoving;
    private Button btnzoom;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        imgview = (ImageView) findViewById(R.id.imgview);
        btnrotate = (Button) findViewById(R.id.btnrotate);
        btnmoving = (Button) findViewById(R.id.btnmoving);
        btnzoom = (Button) findViewById(R.id.btnzoom);

        btnrotate.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                 int dest = 360;
                 if (imgview.getRotation()==360){
                    System.out.println(imgview.getAlpha());
                    dest =0;
                 }
                ObjectAnimator animator1 = ObjectAnimator.ofFloat(imgview,"rotation",dest);
                 animator1.setDuration(2000);
                 animator1.start();
            }
        });
        btnmoving.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ObjectAnimator animation = ObjectAnimator.ofFloat(imgview, "translationX", 100f);
                animation.setDuration(2000);
                animation.start();
            }
        });
        btnzoom.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Animation animation = AnimationUtils.loadAnimation(MainActivity.this,R.anim.zoom);
                imgview.startAnimation(animation);
            }
        });
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.nav_menu,menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        switch (item.getItemId()){
            case R.id.itembai2:
                Intent intent = new Intent(MainActivity.this,Main2Activity.class);
                startActivity(intent);
                break;
            case R.id.itembai3:
                Intent intent1 = new Intent(MainActivity.this,Main3Activity.class);
                startActivity(intent1);
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
