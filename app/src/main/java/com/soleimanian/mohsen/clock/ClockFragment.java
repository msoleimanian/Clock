package com.soleimanian.mohsen.clock;

import android.app.Fragment;
import android.graphics.Typeface;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.os.Handler;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;
import java.util.Date;

public class ClockFragment extends Fragment {

    TextView day;
    TextView houres;
    TextView minutes;
    TextView seconds;
    Button tellTheClock;

    MediaPlayer clock;
    MediaPlayer mHoures;
    MediaPlayer mMinutes;

    boolean isPM ;
    boolean isClick = false;
    boolean sw = true;

    Thread updatetimepersecond = new Thread();

    Handler updateTime = new Handler();
    private Runnable updatepersecond  = new Runnable() {
        @Override
        public void run() {
            Date date = new Date();
            int intHours = date.getHours();
            int intMinutes = date.getMinutes();
            int intSeconds = date.getSeconds();
            int intDay = date.getDay();
            houres.setText(String.valueOf(intHours));
            minutes.setText(String.valueOf(intMinutes));
            seconds.setText(String.valueOf(intSeconds));
            day.setText(dayNormalize(intDay));
            updateTime.postDelayed(this,0);
        }

    };

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, @Nullable ViewGroup container, Bundle savedInstanceState) {

        return inflater.inflate(R.layout.fragment_clock ,container,false);
    }

    @Override
    public void onViewCreated(View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        findviews(view);
        configureOnClick();
        updateTime();

    }

    private void configureOnClick() {
        tellTheClock.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tellClock();
            }
        });
    }

    private void tellClock() {
        Log.d("TAG" , ""+isClick);
        if (isClick)
            return;

        isClick = true;
        String strHoures =  houres.getText().toString();
        String strMinutes = (String) minutes.getText();
        String strSeconder = (String) seconds.getText();

        clock = MediaPlayer.create(getActivity(),R.raw.clock);
        clock.start();
        if(Integer.parseInt(strHoures)>12){
            strHoures = String.valueOf(Integer.parseInt(strHoures)-12);
            isPM = true;
        }

        switch (strHoures) {
            case "1" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c1o);
                break;
            case "2" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c2o);
                break;
            case "3" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c3o);
                break;
            case "4" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c4o);
            //    mHoures.start();
                break;
            case "5" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c5o);
               // mHoures.start();
                break;
            case "6" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c6o);
               // mHoures.start();
                break;
            case "7" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c7o);
               // mHoures.start();
                break;
            case "8" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c8o);
                //mHoures.start();
                break;
            case "9" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c9o);
                //mHoures.start();
                break;
            case "10" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c10o);
                //mHoures.start();
                break;
            case "11" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c11o);
                //mHoures.start();
                break;
            case "12" :
                mHoures = MediaPlayer.create(getActivity(),R.raw.c12o);
                //mHoures.start();
                break;
        }
        Handler handler = new Handler();
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mHoures.start();
            }
        },3000);

        switch (strMinutes){
            case "1" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c1min);
                break;
            case "2" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c2min);
                break;
            case "3" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c3min);
                break;
            case "4" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c4min);
                break;
            case "5" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c5min);
                break;
            case "6" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c6min);
                break;
            case "7" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c7min);
                break;
            case "8" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c8min);
                break;
            case "9" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c9min);
                break;
            case "10" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c10min);
                break;
            case "11" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c11min);
                break;
            case "12" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c12min);
                break;
            case "13" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c13min);
                break;
            case "14" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c14min);
                break;
            case "15" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c15min);
                break;
            case "16" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c16min);
                break;
            case "17" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c17min);
                break;
            case "18" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c18min);
                break;
            case "19" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c19min);
                break;
            case "20" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c20min);
                break;
            case "21" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c21min);
                break;
            case "22" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c22min);
                break;
            case "23" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c23min);
                break;
            case "24" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c24min);
                break;
            case "25" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c25min);
                break;
            case "26" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c26min);
                break;
            case "27" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c27min);
                break;
            case "28" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c28min);
                break;
            case "29" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c29min);
                break;
            case "30" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c30min);
                break;
            case "31" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c31min);
                break;
            case "32" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c32min);
                break;
            case "33" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c33min);
                break;
            case "34" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c34min);
                break;
            case "35" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c35min);
                break;
            case "36" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c36min);
                break;
            case "37" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c37min);
                break;
            case "38" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c38min);
                break;
            case "39" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c39min);
                break;
            case "40" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c40min);
                break;
            case "41" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c41min);
                break;
            case "42" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c42min);
                break;
            case "43" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c43min);
                break;
            case "44" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c44min);
                break;
            case "45" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c45min);
                break;
            case "46" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c46min);
                break;
            case "47" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c47min);
                break;
            case "48" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c48min);
                break;
            case "49" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c49min);
                break;
            case "50" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c50min);
                break;
            case "51" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c51min);
                break;
            case "52" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c52min);
                break;
            case "53" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c53min);
                break;
            case "54" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c54min);
                break;
            case "55" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c55min);
                break;
            case "56" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c56min);
                break;
            case "57" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c57min);
                break;
            case "58" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c58min);
                break;
            case "59" :
                mMinutes = MediaPlayer.create(getActivity() , R.raw.c59min);
                break;
            default:
                break;
        }
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                mMinutes.start();
            }
        },6000);
        handler.postDelayed(new Runnable() {
            @Override
            public void run() {
                if (isPM){
                    clock = MediaPlayer.create(getActivity() , R.raw.badezohr);
                    isPM= false;
                }
                else
                    clock = MediaPlayer.create(getActivity() , R.raw.sob);
                clock.start();
                isClick = false;
            }
        },9000);


    }
    private void updateTime() {
//         updatetimepersecond = new Thread(){
//            @Override
//            public void run() {
//                Log.d("TAG" , ""+isInterrupted());
//                while (!isInterrupted()){
//                    try {
//                        Log.d("TAG" , "in the while ");
//                        Thread.sleep(1000);
//                        getActivity().runOnUiThread(new Runnable() {
//                            @Override
//                            public void run() {
//                                Date date = new Date();
//                                int intHours = date.getHours();
//                                int intMinutes = date.getMinutes();
//                                int intSeconds = date.getSeconds();
//                                int intDay = date.getDay();
//                                houres.setText(String.valueOf(intHours));
//                                minutes.setText(String.valueOf(intMinutes));
//                                seconds.setText(String.valueOf(intSeconds));
//                                day.setText(dayNormalize(intDay));
//
//                            }
//                        });
//                    } catch (InterruptedException e) {
//                        e.printStackTrace();
//                    }
//                }
//            }
//        };
//        updatetimepersecond.start();

        updateTime.postDelayed(updatepersecond,0);

    }

    @Override
    public void onPause() {
        super.onPause();
        MainActivity.isClockSelected = false;
//        Log.d("TAG" , "the frament is pause ");
//        updatetimepersecond.interrupt();
//        updatetimepersecond.stop();
//        Log.d("TAG2 " , ""+updatetimepersecond.isInterrupted());
        updateTime.removeCallbacks(updatepersecond);
    }

    private String dayNormalize(int day) {
        String result;
        switch (day){
            case 0 :
                result = "Sunday";
                break;
            case 1 :
                result = "Monday";
                break;
            case 2 :
                result = "TuseDay";
                break;
            case 3 :
                result = "Wednesday";
                break;
            case 4 :
                result = "Thursday";
                break;
            case 5 :
                result = "Friday";
                break;
            default  :
                result = "Saturday";
                break;
        }
        return result;
    }
    private void findviews(View view) {
        day = view.findViewById(R.id.line2);
        houres = view.findViewById(R.id.text_hourse);
        minutes = view.findViewById(R.id.text_minutes);
        seconds = view.findViewById(R.id.text_second);
        tellTheClock = view.findViewById(R.id.button_tell);
        setfont();
    }

    private void setfont() {
        Typeface type = Typeface.createFromAsset(getActivity().getAssets(),"font/digital7.otf");
        day.setTypeface(type);
        houres.setTypeface(type);
        minutes.setTypeface(type);
        seconds.setTypeface(type);

    }
}
