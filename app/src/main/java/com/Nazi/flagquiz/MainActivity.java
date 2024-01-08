package com.Nazi.flagquiz;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    private TextView textviewStart;
    private Button buttonstart;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        textviewStart=findViewById(R.id.textViewStart);
        buttonstart=findViewById(R.id.buttonStart);

        copyDatabase();

        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, QuizActivity.class);
                startActivity(intent);


            }
        });
    }
    public void copyDatabase()
    {
        try{
            DatabaseCopyHelper helper = new DatabaseCopyHelper(MainActivity.this);
            helper.createDataBase();
            helper.openDataBase();

        }catch (Exception e)
        {
            e.printStackTrace();
        }

    }

}