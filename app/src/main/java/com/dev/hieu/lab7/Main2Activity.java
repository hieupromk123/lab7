package com.dev.hieu.lab7;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main2Activity extends AppCompatActivity {
    private Button btnall;
    private Button btndoraemon;
    private Button btnnobita;
    private ImageView imgview;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);
        btnall = (Button) findViewById(R.id.btnall);
        btndoraemon = (Button) findViewById(R.id.btndoraemon);
        btnnobita = (Button) findViewById(R.id.btnnobita);
        imgview = (ImageView) findViewById(R.id.imgview);

        btnall.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showimage("All");
            }
        });
        btndoraemon.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showimage("Doraemon");
            }
        });
        btnnobita.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                showimage("Nobita");
            }
        });
    }
    private void showimage(String img){
        ObjectAnimator anim = ObjectAnimator.ofFloat(imgview,"translationX",0f,500f);
        anim.setDuration(2000);
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(imgview,"alpha",1f,0f);
        anim1.setDuration(2000);
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(imgview,"translationX",-500f,0f);
        anim2.setDuration(2000);
        ObjectAnimator anim3 = ObjectAnimator.ofFloat(imgview,"alpha",0f,1f);
        anim3.setDuration(2000);

        AnimatorSet ans = new AnimatorSet();
        ans.play(anim2).with(anim3).after(anim).after(anim1);
        ans.start();
        final String imgName = img;

        anim1.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                if (imgName == "Nobita"){
                    imgview.setImageResource(R.drawable.nobita);
                }
                if (imgName == "Doraemon"){
                    imgview.setImageResource(R.drawable.doraemon);
                }
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }

        });
    }
}
