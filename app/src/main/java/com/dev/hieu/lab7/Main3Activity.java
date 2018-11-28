package com.dev.hieu.lab7;

import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;

public class Main3Activity extends AppCompatActivity {
    private ImageView dongho;
    private ImageView kimgio;
    private ImageView kimgiay;
    private ImageView kimphut;
    private Button run;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main3);
        dongho = (ImageView) findViewById(R.id.dongho);
        kimgio = (ImageView) findViewById(R.id.kimgio);
        kimgiay = (ImageView) findViewById(R.id.kimgiay);
        kimphut = (ImageView) findViewById(R.id.kimphut);
        run = (Button) findViewById(R.id.run);
run.setOnClickListener(new View.OnClickListener() {
    @Override
    public void onClick(View v) {

        int dest = 360;
        if (kimgiay.getRotation()==360){
            System.out.println(kimgiay.getAlpha());
            dest =0;
        }
        ObjectAnimator animator1 = ObjectAnimator.ofFloat(kimgiay,"rotation",dest);
        animator1.setDuration(30000);
        animator1.start();
        int dest1 = 360;
        if (kimphut.getRotation()==360){
            System.out.println(kimphut.getAlpha());
            dest =0;
        }
        ObjectAnimator animator2 = ObjectAnimator.ofFloat(kimphut,"rotation",dest1);
        animator2.setDuration(60000);
        animator2.start();
        int dest2 = 360;
        if (kimgio.getRotation()==360){
            System.out.println(kimgio.getAlpha());
            dest =0;
        }
        ObjectAnimator animator3 = ObjectAnimator.ofFloat(kimgio,"rotation",dest2);
        animator3.setDuration(120000);
        animator3.start();

    }
});
    }
}
