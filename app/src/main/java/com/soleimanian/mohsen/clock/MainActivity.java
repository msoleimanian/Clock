package com.soleimanian.mohsen.clock;

import android.app.Activity;
import android.support.v7.app.ActionBarActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.TextView;

public class MainActivity extends Activity {

    TextView clock;
    TextView stopWatch;

    static boolean  isClockSelected = false;
    static boolean isStopWatchSelected = false ;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        findviews();
        configureOnClick();
    }



    private void configureOnClick() {
        clock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isClockSelected)
                    return;
                if (isStopWatchSelected)
                    getFragmentManager().popBackStack();
                isClockSelected = true;
                isStopWatchSelected = false;
                ClockFragment clockFragment = new ClockFragment();
                getFragmentManager().beginTransaction().add(R.id.fragment_container, clockFragment).addToBackStack("one").commit();
            }
        });
        stopWatch.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isStopWatchSelected)
                    return;
                if (isClockSelected)
                    getFragmentManager().popBackStackImmediate();
                isStopWatchSelected = true;
                isClockSelected = false;
                StopWatchFragment stopWatchFragment = new StopWatchFragment();
                getFragmentManager().beginTransaction().add(R.id.fragment_container,stopWatchFragment).addToBackStack("two").commit();
            }
        });
    }

    private void findviews() {
        clock = (TextView) findViewById(R.id.text_clock);
        stopWatch = (TextView) findViewById(R.id.text_chronometer);

    }
}

