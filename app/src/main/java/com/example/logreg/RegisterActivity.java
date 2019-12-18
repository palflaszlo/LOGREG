package com.example.logreg;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class RegisterActivity extends AppCompatActivity {

    private felhasznalo adatbazis;
    private EditText emaill, felh, jelszoo, TeljesNev;
    private Button buttonRegist, buttonVissza;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
        init();
        buttonVissza.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                adatRogzites();

                Intent intent = new Intent(RegisterActivity.this, MainActivity.class);
                startActivity(intent);
                finish();
            }
        });

    }

    public void init()
    {
        adatbazis = new felhasznalo(this);
        emaill = findViewById(R.id.email);
        felh = findViewById(R.id.felhNev);
        jelszoo = findViewById(R.id.jelszo);
        TeljesNev = findViewById(R.id.Teljesnev);
        buttonRegist = findViewById(R.id.btnRegist);
        buttonVissza = findViewById(R.id.btnVissza);
    }

    public void adatRogzites()
    {
        String emailll = emaill.getText().toString();
        String felhh = felh.getText().toString();
        String jelsz = jelszoo.getText().toString();
        String Teljesnev = TeljesNev.getText().toString();
        Boolean eredmeny = adatbazis.adatRogzites( emailll,  felhh,  jelsz,  Teljesnev);

        if(emailll.trim().isEmpty() || felhh.trim().isEmpty() || jelsz.trim().isEmpty() || Teljesnev.trim().isEmpty()){
            Toast.makeText(this, "Minden mezőt ki kell tölteni", Toast.LENGTH_SHORT).show();
            return;
        }

        if (eredmeny)
            Toast.makeText(this, "Regisztráció sikeres!", Toast.LENGTH_SHORT).show();
        else
            Toast.makeText(this, "Regisztráció nem sikerült!", Toast.LENGTH_SHORT).show();

    }


}
