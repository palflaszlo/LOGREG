package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    private felhasznalo adatbazis;
    private EditText felhh, jelssz;
    private Button buttonBejelnt, buttonRegisztr;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        init();



        buttonBejelnt.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String FH = felhh.getText().toString();
                String JSZ = jelssz.getText().toString();

                Boolean result = adatbazis.bejEllenorzes(FH, JSZ);

                if(FH.trim().isEmpty() || JSZ.trim().isEmpty()){
                    Toast.makeText(MainActivity.this, "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (result)
                    Toast.makeText(MainActivity.this, "Bejelentkezés sikeres!", Toast.LENGTH_SHORT).show();
                else
                    Toast.makeText(MainActivity.this, "Bejelentkezés nem sikerült!", Toast.LENGTH_SHORT).show();
            }
        });

        buttonRegisztr.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent = new Intent(MainActivity.this,RegisterActivity.class);
                startActivity(intent);
                finish();
            }
        });
    }

    public void init()
    {
        adatbazis = new felhasznalo(MainActivity.this);
        felhh = findViewById(R.id.felh);
        jelssz = findViewById(R.id.jelsz);
        buttonBejelnt = findViewById(R.id.btnBej);
        buttonRegisztr = findViewById(R.id.btnReg);

    }


}
