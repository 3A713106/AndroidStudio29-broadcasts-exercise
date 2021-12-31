package com.example.androidstudio29;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;

import android.content.SharedPreferences;
import android.view.View;
import android.widget.EditText;


public class MainActivity extends AppCompatActivity {

    EditText textView1;
    EditText textView2;

    SharedPreferences data;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        textView1 = findViewById(R.id.editTextTextPersonName);
        textView2 = findViewById(R.id.editTextTextPersonName2);
    }

    public void save(View view){
        data = getSharedPreferences("set", MODE_PRIVATE);
        data.edit().putString("Name", textView1.getText().toString()).putString("password", textView2.getText().toString()).apply();
    }

    public void clear(View view){
        textView1.setText(null);
        textView2.setText(null);
    }

    public void read(View view){
        data = getSharedPreferences("set", 0);
        textView1.setText(data.getString("Name", ""));
        textView2.setText(data.getString("password", ""));
    }
}