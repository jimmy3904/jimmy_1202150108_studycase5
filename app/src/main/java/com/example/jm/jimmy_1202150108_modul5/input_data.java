package com.example.jm.jimmy_1202150108_modul5;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

public class input_data extends AppCompatActivity {

    private EditText todo, deskripsi, prioritas;
    private Database db1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_input_data);

        todo = (EditText) findViewById(R.id.aktifitas);
        deskripsi = (EditText) findViewById(R.id.dekripsi);
        prioritas = (EditText) findViewById(R.id.prioritas);
        db1 = new Database(this);
    }

    @Override
    public void onBackPressed() {
        //membuat intent menuju MainActivity
        Intent intent = new Intent(input_data.this, MainActivity.class);
        startActivity(intent);
        this.finish();
    }

    public void tambah(View view) {
        if (db1.inputdata(new TambahData(todo.getText().toString(), deskripsi.getText().toString(), prioritas.getText().toString()))){
            Toast.makeText(this, "To Do List Ditambahkan !", Toast.LENGTH_SHORT).show();
            startActivity(new Intent(input_data.this, MainActivity.class));
            this.finish();
        }else {
            Toast.makeText(this, "List tidak boleh kosong", Toast.LENGTH_SHORT).show();
            todo.setText(null);
            deskripsi.setText(null);
            prioritas.setText(null);
        }
    }
}
