package com.example.test31;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import java.util.ArrayList;
import java.util.List;

public class ListaInregistrari extends AppCompatActivity {
    ListView listView;
    List<Farmacie> listFarm = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lista_inregistrari);

        listView = findViewById(R.id.lv);

        Intent intent = getIntent();

        if(intent.hasExtra(MainActivity.INREGISTRARI_CODE)){
            listFarm = (List<Farmacie>) intent.getSerializableExtra(MainActivity.INREGISTRARI_CODE);
          //  ArrayAdapter<Farmacie> customAdapter = new ArrayAdapter<>(getApplicationContext(), android.R.layout.simple_list_item_1, listFarm);
            CustomAdapter customAdapter = new CustomAdapter(getApplicationContext(), R.layout.activity_custom_adapter, listFarm, getLayoutInflater());
            listView.setAdapter(customAdapter);
            customAdapter.notifyDataSetChanged();
        }
    }
}