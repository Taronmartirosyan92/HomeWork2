package com.example.sargis.tarproject2;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.CheckBox;
import android.widget.EditText;


public class SecondActivity extends AppCompatActivity {
    public static final String MY_SECOND_KAY = "mySecondKay";
    public static final String MY_SECOND_KAY2 = "mySecondKay2";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_second);
        final EditText editNameSecond = findViewById(R.id.secondNameId);
        final EditText editLastNameSecond = findViewById(R.id.secondLastNameId);
        final String myValue = getIntent().getExtras().getString(MainActivity.MY_KAY);
        final String mValue = getIntent().getExtras().getString(MainActivity.MY_KAY2);
        editNameSecond.setText(myValue);
        editLastNameSecond.setText(mValue);
        Button button = findViewById(R.id.save);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final String str = editNameSecond.getText().toString();
                final String str2 = editLastNameSecond.getText().toString();
                Intent intent = new Intent(SecondActivity.this, MainActivity.class);
                intent.putExtra(MY_SECOND_KAY, str);
                intent.putExtra(MY_SECOND_KAY2, str2);
                startActivity(intent);
            }
        });
    }
}
