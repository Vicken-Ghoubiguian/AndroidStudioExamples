package com.example.testytheglace;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.View;
import android.widget.Button;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Scroller;
import android.widget.Switch;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    int i = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        //
        ImageView imageViewDesVraisGuerriers = findViewById(R.id.imageViewDesVraisGuerriers);
        imageViewDesVraisGuerriers.setBackgroundColor(Color.YELLOW);

        //
        TextView culteDeKenny = findViewById(R.id.culteDeKenny);

        Switch whatAWonderfulSwitch = findViewById(R.id.affSouthPark);
        whatAWonderfulSwitch.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {

                if(isChecked) {

                    culteDeKenny.setAlpha(0.0f);

                } else {

                    culteDeKenny.setAlpha(1.0f);

                }
            }
        });

        Button myWonderfulButton = findViewById(R.id.ceciEstLeBouttonDesVraisGuerriers);
        myWonderfulButton.setOnClickListener(new View.OnClickListener(){

            @Override
            public void onClick(View v) {

                i += 1;

                if(i % 2 != 0) {

                    imageViewDesVraisGuerriers.setBackgroundColor(Color.CYAN);

                } else {

                    imageViewDesVraisGuerriers.setBackgroundColor(Color.YELLOW);
                }
            }
        });

        //
        EditText enteringDeTousLesVraisGuerriers = findViewById(R.id.enteringDeTousLesVraisGuerriers);

        //
        EditText textPassword = findViewById(R.id.enteringofPW);

        textPassword.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence s, int start, int count, int after) {}

            @Override
            public void onTextChanged(CharSequence s, int start, int before, int count) {

                enteringDeTousLesVraisGuerriers.setText(textPassword.getText());
            }

            @Override
            public void afterTextChanged(Editable s) {}
        });
    }
}