package com.soleimanian.mohsen.clock;

import android.app.Activity;
import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class Setting extends Activity {

    RadioButton redColor;
    RadioButton whiteColor;
    RadioGroup setColor;
    Button submit;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.setting_clock);

        configureView();
        setOnClick();

    }

    private void setOnClick() {

        submit.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                int selectId = setColor.getCheckedRadioButtonId();
                RadioButton radioButton = (RadioButton) findViewById(selectId);
               // Log.d("TAG" , ""+radioButton.getText().toString());
                Intent intent = new Intent();
                intent.putExtra("color" , radioButton.getText().toString());
                setResult(1 , intent);
                finish();
            }
        });
    }


    private void configureView() {
        redColor = (RadioButton) findViewById(R.id.red_color);
        whiteColor = (RadioButton) findViewById(R.id.white_color);
        setColor = (RadioGroup) findViewById(R.id.set_color);
        submit = (Button) findViewById(R.id.submit);
    }
}
