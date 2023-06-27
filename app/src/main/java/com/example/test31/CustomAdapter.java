package com.example.test31;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

import java.util.List;

public class CustomAdapter extends ArrayAdapter<Farmacie> {
    TextView numeFar,adresaFar;
    private int resource;
    private List<Farmacie> lista ;
    private LayoutInflater layoutInflater;


    public CustomAdapter(@NonNull Context context, int resource, @NonNull List objects, LayoutInflater layoutInflater) {
        super(context, resource, objects);
        this.resource=resource;
        this.lista=objects;
        this.layoutInflater=layoutInflater;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        View view = layoutInflater.inflate(this.resource, parent, false);

        numeFar = view.findViewById(R.id.numeFarTV);
        adresaFar = view.findViewById(R.id.adresaTV);


        Farmacie farmacie = lista.get(position);

        numeFar.setText(farmacie.getNumeFarmacie());
        adresaFar.setText(farmacie.getAdresa());


        return view;

    }

}