package com.example.relatrios;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;

import android.content.Intent;
import android.database.Cursor;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getSupportActionBar().hide();

        TextView tit = findViewById(R.id.txt_tit);
        TextView nome = findViewById(R.id.txt_nome);
        TextView status = findViewById(R.id.txt_stts);
        TextView desc = findViewById(R.id.txt_desc);
        TextView cod = findViewById(R.id.txt_cod);
        Button cnf = findViewById(R.id.btn_cnf);
        ImageView add = findViewById(R.id.img_add);
        EditText edtnome = findViewById(R.id.edt_nome);
        EditText edtstatus = findViewById(R.id.edt_stts);
        EditText edtdesc = findViewById(R.id.edt_desc);
        EditText edtcod = findViewById(R.id.edt_cod);

        cnf.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

                String nm = edtnome.getText().toString();
                String st = edtstatus.getText().toString();
                String dc = edtdesc.getText().toString();
                String cd = edtcod.getText().toString();

                Intent intent = new Intent(MainActivity.this, dados.class);
                intent.putExtra("nome_edt", nm);
                intent.putExtra("status_edt", st);
                intent.putExtra("descricao_edt", dc);
                intent.putExtra("codigo_edt", cd);

                startActivity(intent);
            }
        });
    }
}