package space.konstiantyn.projektgame;

import android.annotation.SuppressLint;
import android.app.Dialog;
import android.content.Intent;
import android.graphics.Color;
import android.graphics.drawable.ColorDrawable;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.view.Window;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.appcompat.app.AppCompatActivity;

import java.util.Random;

public class Level3 extends AppCompatActivity {

    Dialog dialog;
    Dialog dialogEnd;

    public int  numLeft;
    public int numRight;
    Array array = new Array();
    Random random = new Random();
    public int count = 0;

    @SuppressLint("ResourceAsColor")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.universal);

        TextView text_levels = findViewById(R.id.text_levels);
        text_levels.setText(R.string.level3);
        text_levels.setTextColor(R.color.black95);

        final ImageView img_left = (ImageView)findViewById(R.id.img_left);

        img_left.setClipToOutline(true);

        final ImageView img_right = (ImageView)findViewById(R.id.img_right);

        img_right.setClipToOutline(true);

        final TextView text_left = findViewById(R.id.text_left);
        text_left.setTextColor(R.color.black95);
        final TextView text_right = findViewById(R.id.text_right);
        text_right.setTextColor(R.color.black95);

        Window w = getWindow();
        w.setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        //
        ImageView background = (ImageView)findViewById(R.id.background);
        background.setImageResource(R.drawable.level3);
        //
        dialog = new Dialog(this);
        dialog.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialog.setContentView(R.layout.previewdialog);
        dialog.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialog.setCancelable(false);

        ImageView previewimg = (ImageView)dialog.findViewById(R.id.previewing);
        previewimg.setImageResource(R.drawable.previewimg3);

        //установка фон диалог окна
        LinearLayout dialogfon = (LinearLayout)dialog.findViewById(R.id.dialogfon);
        dialogfon.setBackgroundResource(R.drawable.previewbackground3);

        //установка фон диалог окна
        TextView textdescription = (TextView)dialog.findViewById(R.id.textdescription);
        textdescription.setText(R.string.levelthree);

        TextView btnclose = (TextView)dialog.findViewById(R.id.btnclose);
        btnclose.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
               try {
                   Intent intent = new Intent(Level3.this, GameLevels.class);
                   startActivity(intent);
                   finish();
               }catch (Exception e){

               }
               dialog.dismiss();
            }
        });

        Button btncontinue = (Button)dialog.findViewById(R.id.btncontinue);
        btncontinue.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                dialog.dismiss();

            }
        });
        dialog.show();

        //________________________________________________________________________

        dialogEnd = new Dialog(this);
        dialogEnd.requestWindowFeature(Window.FEATURE_NO_TITLE);
        dialogEnd.setContentView(R.layout.dialogend);
        dialogEnd.getWindow().setBackgroundDrawable(new ColorDrawable(Color.TRANSPARENT));
        dialogEnd.getWindow().setLayout(WindowManager.LayoutParams.MATCH_PARENT,WindowManager.LayoutParams.MATCH_PARENT);
        dialogEnd.setCancelable(false);

        //fon start
        LinearLayout dialogfonEnd = (LinearLayout)dialogEnd.findViewById(R.id.dialogfon);
        dialogfonEnd.setBackgroundResource(R.drawable.previewbackground3);
        //for end

        //fact start
        TextView textdescriptionEnd = (TextView)dialogEnd.findViewById(R.id.textdescriptionEnd);
        textdescriptionEnd.setText(R.string.levelthreeEnd);

        //fact end

        TextView btnclose2 = (TextView)dialogEnd.findViewById(R.id.btnclose);
        btnclose2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();
            }
        });

        Button btncontinue2 = (Button)dialogEnd.findViewById(R.id.btncontinue);
        btncontinue2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {
                    Intent intent = new Intent(Level3.this, Level4.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }
                dialogEnd.dismiss();

            }
        });

        //________________________________________________________________________




        Button btn_back = (Button)findViewById(R.id.button_back);
        btn_back.setBackgroundResource(R.drawable.button_stroke_black95_press_white);
        btn_back.setTextColor(R.color.black95);
        btn_back.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                try {

                    Intent intent = new Intent(Level3.this, GameLevels.class);
                    startActivity(intent);
                    finish();
                }catch (Exception e){

                }

            }
        });

        final int[] progress = {
                R.id.point1, R.id.point2, R.id.point3, R.id.point4, R.id.point5,
                R.id.point6, R.id.point7, R.id.point8, R.id.point9, R.id.point10,
                R.id.point11, R.id.point12, R.id.point13, R.id.point14, R.id.point15,
                R.id.point6, R.id.point17, R.id.point18, R.id.point19, R.id.point20,
        };

        final Animation a = AnimationUtils.loadAnimation(Level3.this, R.anim.alpha);

        numLeft = random.nextInt(21);
        img_left.setImageResource(array.images3[numLeft]);
        text_left.setText(array.texts3[numLeft]);

        numRight = random.nextInt(21);

        while (numLeft==numRight){
            numRight = random.nextInt(21);
        }

        img_right.setImageResource(array.images3[numRight]);
        text_right.setText(array.texts3[numRight]);

        img_left.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_right.setEnabled(false);
                    if (numLeft > numRight) {
                        img_left.setImageResource(R.drawable.img_true);
                    } else {
                        img_left.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if(numLeft>numRight) {
                        if(count<20){
                            count=count+1;
                        }
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else{
                        if(count>0){
                            if(count==1) {
                                count = 0;
                            }else{
                                count=count-2;
                            }

                        }
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }

                    if(count==20) {
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(21);
                        img_left.setImageResource(array.images3[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]);

                        numRight = random.nextInt(21);

                        while (numLeft==numRight){
                            numRight = random.nextInt(21);
                        }

                        img_right.setImageResource(array.images3[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]);
                        img_right.setEnabled(true);

                    }


                }
                return true;
            }
        });


        img_right.setOnTouchListener(new View.OnTouchListener() {
            @Override
            public boolean onTouch(View v, MotionEvent event) {
                if (event.getAction() == MotionEvent.ACTION_DOWN) {
                    img_left.setEnabled(false);
                    if (numLeft < numRight) {
                        img_right.setImageResource(R.drawable.img_true);
                    } else {
                        img_right.setImageResource(R.drawable.img_false);
                    }
                } else if (event.getAction() == MotionEvent.ACTION_UP) {
                    if(numLeft<numRight) {
                        if(count<20){
                            count=count+1;
                        }
                        for (int i=0; i<20; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }
                    }else{
                        if(count>0){
                            if(count==1) {
                                count = 0;
                            }else{
                                count=count-2;
                            }

                        }
                        for (int i=0; i<19; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points);
                        }
                        for (int i=0; i<count; i++){
                            TextView tv = findViewById(progress[i]);
                            tv.setBackgroundResource(R.drawable.style_points_green);
                        }

                    }

                    if(count==20) {
                        dialogEnd.show();
                    }else{
                        numLeft = random.nextInt(21);
                        img_left.setImageResource(array.images3[numLeft]);
                        img_left.startAnimation(a);
                        text_left.setText(array.texts3[numLeft]);

                        numRight = random.nextInt(21);

                        while (numLeft==numRight){
                            numRight = random.nextInt(21);
                        }

                        img_right.setImageResource(array.images3[numRight]);
                        img_right.startAnimation(a);
                        text_right.setText(array.texts3[numRight]);
                        img_left.setEnabled(true);

                    }


                }
                return true;
            }
        });


    }
    @Override
    public void onBackPressed(){
        try {

            Intent intent = new Intent(Level3.this, GameLevels.class);
            startActivity(intent);
            finish();
        }catch (Exception e){

        }

    }

}