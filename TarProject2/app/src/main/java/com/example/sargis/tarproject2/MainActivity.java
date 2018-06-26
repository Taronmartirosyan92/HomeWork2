package com.example.sargis.tarproject2;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    public static final String MY_KAY = "bro";
    public static final String MY_KAY2 = "bro2";
    private LinearLayout linearLayout;


    @SuppressLint("SetTextI18n")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        linearLayout = findViewById(R.id.layoutMain);
        final EditText editName = findViewById(R.id.nameId);
        final EditText editLastName = findViewById(R.id.lastNameId);
        final Button button = findViewById(R.id.sendButton);
        final TextView textViewName = findViewById(R.id.hiteText);
        final TextView textViewLastName = findViewById(R.id.hiteText2);
        final CheckBox checkBox = findViewById(R.id.checkBoxId);

        myMethod(checkBox.isChecked());
        checkBox.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton buttonView, boolean isChecked) {
                myMethod(isChecked);
            }
        });

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str = editName.getText().toString();
                final String str2 = editLastName.getText().toString();
                Intent intent = new Intent(MainActivity.this, SecondActivity.class);
                intent.putExtra(MY_KAY, str);
                intent.putExtra(MY_KAY2, str2);
                startActivity(intent);
            }
        });

        try {
            final String backNameText = getIntent().getExtras().getString(SecondActivity.MY_SECOND_KAY);
            textViewName.setText(getString(R.string.yourName) + backNameText);
            final String backLastText = getIntent().getExtras().getString(SecondActivity.MY_SECOND_KAY2);
            textViewLastName.setText(getString(R.string.YourLastName) + backLastText);
        } catch (NullPointerException e) {
            textViewName.getText();
            textViewLastName.getText();
        }
    }

    private void myMethod(boolean checked) {
        if (checked) {
            linearLayout.setBackgroundResource(R.drawable.falcon1);
        } else {

            linearLayout.setBackgroundResource(R.drawable.falco2);
        }
    }
}
