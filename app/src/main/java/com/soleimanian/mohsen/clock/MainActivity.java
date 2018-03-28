package com.soleimanian.mohsen.clock;

import android.media.MediaPlayer;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.TextView;

import java.time.Clock;
import java.util.Date;

public class MainActivity extends AppCompatActivity {

    TextView clock;
    TextView chronometer;

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
                ClockFragment clockFragment = new ClockFragment();
                getFragmentManager().beginTransaction().add(R.id.fragment_container, clockFragment).addToBackStack(null).commit();
            }
        });
    }

    private void findviews() {
        clock = (TextView) findViewById(R.id.text_clock);
        chronometer = (TextView) findViewById(R.id.text_chronometer);

    }
}

