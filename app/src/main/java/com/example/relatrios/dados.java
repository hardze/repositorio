package com.example.relatrios;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class dados extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dados);
        getSupportActionBar().hide();

        TextView cod1 = findViewById(R.id.cod_hardware1_txt);
        TextView nome1 = findViewById(R.id.nome_hardware1_txt);
        TextView status1 = findViewById(R.id.stts_hardware1_txt);
        TextView desc1 = findViewById(R.id.desc_hardware1_txt);

        String nome = getIntent().getStringExtra("nome_edt");
        String status = getIntent().getStringExtra("status_edt");
        String desc = getIntent().getStringExtra("descricao_edt");
        String cod = getIntent().getStringExtra("codigo_edt");

        nome1.setText(nome);
        status1.setText(status);
        desc1.setText(desc);
        cod1.setText(cod);
    }
}