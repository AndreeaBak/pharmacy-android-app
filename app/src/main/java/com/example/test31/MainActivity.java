package com.example.test31;

import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {

    public static final int REQUEST_CODE_ADD = 200;
    public static final String ADD_CODE = "FarmacieAdaugata";

    public static final int REQUEST_CODE_INREGISTRARI = 300;
    public static final String INREGISTRARI_CODE="FarmacieInreg";

    List<Farmacie> listaFarmacii = new ArrayList<>();
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        Button btnAdauga = findViewById(R.id.btnAdauga);
        btnAdauga.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), AdaugaInregistrare.class);
                startActivityForResult(intent, REQUEST_CODE_ADD);
            }
        });

        Button btnVizualizare = findViewById(R.id.btnVizualizareDate);
        btnVizualizare.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(getApplicationContext(), ListaInregistrari.class);
                intent.putExtra(INREGISTRARI_CODE, (Serializable) listaFarmacii);
                setResult(RESULT_OK, intent);
                startActivity(intent);
            }
        });
    }

    @Override
    protected void onActivityResult(int requestCode, int resultCode, @Nullable Intent data) {
        super.onActivityResult(requestCode, resultCode, data);
        if(requestCode==REQUEST_CODE_ADD && resultCode==RESULT_OK && data !=null){
            Farmacie farmacie = (Farmacie) data.getSerializableExtra(AdaugaInregistrare.CODE_ADDFARM);
            if(farmacie != null)
                listaFarmacii.add(farmacie);
        }
    }
}