package com.example.albert.myapplication;

import android.graphics.Color;
import android.os.Bundle;
import android.support.annotation.NonNull;
import android.support.design.widget.BottomNavigationView;
import android.support.v7.app.AppCompatActivity;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.view.MotionEvent;
import android.view.GestureDetector;
import android.support.v4.view.GestureDetectorCompat;

public class MainActivity extends AppCompatActivity implements GestureDetector.OnGestureListener,
GestureDetector.OnDoubleTapListener {

    private TextView mTextMessage;
    private GestureDetectorCompat gestureDetector;
    private Button mButton;

    public int flag = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        mTextMessage = (TextView) findViewById(R.id.message);
        BottomNavigationView navigation = (BottomNavigationView) findViewById(R.id.navigation);
        navigation.setOnNavigationItemSelectedListener(mOnNavigationItemSelectedListener);

        mButton = (Button) findViewById(R.id.button1);
        /*mButton.setOnClickListener(
                new Button.OnClickListener(){
                    public void onClick(View v){
                        mTextMessage.setText("Button Clicked");
                    }
                }
        );*/
        this.gestureDetector = new GestureDetectorCompat(this, this);
        gestureDetector.setOnDoubleTapListener(this);

        /*RelativeLayout layout = new RelativeLayout(this);
        layout.setBackgroundColor(Color.GRAY);

        Button btn = new Button(this);
        btn.setText("Click Me!");
        btn.setBackgroundColor(Color.DKGRAY);

        RelativeLayout.LayoutParams btnDetail = new RelativeLayout.LayoutParams(
                RelativeLayout.LayoutParams.WRAP_CONTENT,
                RelativeLayout.LayoutParams.WRAP_CONTENT
        );

        btnDetail.addRule(RelativeLayout.CENTER_HORIZONTAL);
        btnDetail.addRule(RelativeLayout.CENTER_VERTICAL);

        layout.addView(btn, btnDetail);

        setContentView(layout);*/
    }

    @Override
    public boolean onSingleTapConfirmed(MotionEvent e) {
        mTextMessage.setText("Single Tap");
        return true;
    }

    @Override
    public boolean onDoubleTap(MotionEvent e) {
        mTextMessage.setText("Double Tap");
        return true;
    }

    @Override
    public boolean onDoubleTapEvent(MotionEvent e) {
        mTextMessage.setText("Double Tap Event");
        return true;
    }

    @Override
    public boolean onDown(MotionEvent e) {
        mTextMessage.setText("Down");
        return true;
    }

    @Override
    public void onShowPress(MotionEvent e) {
        mTextMessage.setText("Show Press");
        //return true;
    }

    @Override
    public boolean onSingleTapUp(MotionEvent e) {
        mTextMessage.setText("Single Tap Up");
        return true;
    }

    @Override
    public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
        mTextMessage.setText("Scroll");
        return true;
    }

    @Override
    public void onLongPress(MotionEvent e) {
        mTextMessage.setText("Long Press");
        //return true;
    }

    @Override
    public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
        mTextMessage.setText("Fling");
        return true;
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        this.gestureDetector.onTouchEvent(event);
        return super.onTouchEvent(event);
    }

    private BottomNavigationView.OnNavigationItemSelectedListener mOnNavigationItemSelectedListener
            = new BottomNavigationView.OnNavigationItemSelectedListener() {

        @Override
        public boolean onNavigationItemSelected(@NonNull MenuItem item) {
            switch (item.getItemId()) {
                case R.id.navigation_home:
                    mTextMessage.setText(R.string.title_home);
                    return true;
                case R.id.navigation_dashboard:
                    mTextMessage.setText(R.string.title_dashboard);
                    return true;
                case R.id.navigation_notifications:
                    mTextMessage.setText(R.string.title_notifications);
                    return true;
            }
            return false;
        }

    };

}
