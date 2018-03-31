package com.soleimanian.mohsen.clock;

import android.app.Fragment;
import android.graphics.Typeface;
import android.os.Bundle;
import android.os.Handler;
import android.os.SystemClock;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

public class StopWatchFragment extends Fragment {

    TextView show_time;

    Button start;
    Button pause;
    Button reset;

    long startTime ;
    long originalTime ;
    long timeinPause;
    long updateTimeAftePause ;

    boolean ispause = false;
    boolean isstart = false;
    boolean isreset = false;

    Handler handler = new Handler();

    Runnable updateTime = new Runnable() {
        @Override
        public void run() {
            originalTime = SystemClock.uptimeMillis() - startTime;
            updateTimeAftePause = timeinPause + originalTime;
            int secs = (int)(updateTimeAftePause/1000);
            int min = secs/60;
            secs=secs%60;
            int miliseconds = (int)(updateTimeAftePause%1000);
            show_time.setText(String.valueOf(min) + " : " + String.valueOf(secs)
            + " : " + String.valueOf(miliseconds));

            handler.postDelayed(this,0);
        }
    };
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {
        return inflater.inflate(R.layout.fragment_watch_stop , container , false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);

        findviews(view);
        configureOnClick();

    }

    private void configureOnClick() {
        start.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isstart)
                    return;
                isstart = true;
                ispause = false;
                isreset = false;
                startTime = SystemClock.uptimeMillis();
                handler.postDelayed(updateTime,0);
            }
        });
        pause.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (ispause)
                    return;
                ispause = true;
                isstart = false;
                isreset = false;
                timeinPause += originalTime;
                handler.removeCallbacks(updateTime);
            }
        });
        reset.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if (isreset)
                    return;
                isreset = true;
                isstart = false;
                ispause = false;
                timeinPause = 0;
                show_time.setText("0 : 00 : 000");
                handler.removeCallbacks(updateTime);
            }
        });
    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity.isStopWatchSelected=false;
    }

    private void findviews(View view) {
        show_time = (TextView) view.findViewById(R.id.time_show);
        start = (Button) view.findViewById(R.id.btn_start);
        pause = (Button) view.findViewById(R.id.btn_pause);
        reset = (Button) view.findViewById(R.id.btn_reset);
        setfont();
    }

    private void setfont() {
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"font/digital7.otf");
        show_time.setTypeface(type);
    }
}
