package com.example.test31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;

public class AdaugaInregistrare extends AppCompatActivity {

    public static final String CODE_ADDFARM="FarmacieAdg";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_adauga_inregistrare);

        Intent intent = getIntent();

        EditText ETNumeFar = findViewById(R.id.etNumeFarmacie);
        EditText ETAdresaFar = findViewById(R.id.etAdresa);
        EditText ETNumarAngajati = findViewById(R.id.etNrAngajati);
        RadioGroup rg = findViewById(R.id.radioGroup);

        Button btSal = findViewById(R.id.btnSalvare);
        btSal.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(ETNumeFar.getText().toString().isEmpty())
                    ETNumeFar.setError("Introduceti numele");
                else
                    if(ETAdresaFar.getText().toString().isEmpty())
                        ETAdresaFar.setError("Introduceti adresa");
                    else if(ETNumarAngajati.getText().toString().isEmpty())
                        ETNumarAngajati.setError("Introduceti nr angajati");
                    else{
                        String numeFar = ETNumeFar.getText().toString();
                        String adresaFar = ETAdresaFar.getText().toString();
                        int nrAng = Integer.parseInt(ETNumarAngajati.getText().toString());
                        RadioButton rb = findViewById(rg.getCheckedRadioButtonId());
                        String zona = rb.getText().toString();

                        Farmacie farmacie = new Farmacie(numeFar, adresaFar, zona, nrAng);
                        intent.putExtra(CODE_ADDFARM, farmacie);
                        setResult(RESULT_OK, intent);
                        finish();
                    }
            }
        });
    }
}