package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class LoggedInActivity extends AppCompatActivity {

    private felhasznalo adatbazis;
    private TextView FelhNEv;
    private Button Kijel;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_logged_in);

        init();

        FelhNEv.setText(adatbazis.adatLekerdezes().getString(4));

        Kijel.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Intent intent = new Intent(LoggedInActivity.this,MainActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }


    public void init(){
        FelhNEv = findViewById(R.id.txtvwFelhNev);
        Kijel = findViewById(R.id.btnKij);
    }
}
