package com.example.jm.jimmy_1202150108_modul5;

import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.RadioGroup;
import android.widget.TextView;

public class setting extends AppCompatActivity {
    private TextView warna;
    int colorid;
    AlertDialog.Builder alert;
    SharedPreferences.Editor sharedpref;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_setting);
        setTitle("Settings");

        alert = new AlertDialog.Builder(this);

        SharedPreferences sharedP = getApplicationContext().getSharedPreferences("Preferences", 0);
        sharedpref = sharedP.edit();
        colorid = sharedP.getInt("Colourground", R.color.putih);
        warna = findViewById(R.id.warna);
        warna.setText(getShapeColor(colorid));
    }

    @Override
    public void onBackPressed() {
        Intent intent = new Intent(setting.this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        if(item.getItemId()==android.R.id.home){
            this.onBackPressed();
        }
        return true;
    }


    public String getShapeColor(int i){
        if (i==R.color.merah){
            return "merah";
        }else if (i==R.color.kuning){
            return "kuning";
        }else if (i==R.color.biru) {
            return "biru";
        }else if (i==R.color.oren) {
            return "oren";
        }else{
            return "Default";
        }
    }

    public int getColorid(int i){
        if (i==R.color.merah){
            return R.id.merah;
        }else if (i==R.color.kuning){
            return R.id.kuning;
        }else if (i==R.color.biru){
            return R.id.biru;
        }else if (i==R.color.oren){
            return R.id.oren;
        }else{
            return R.id.putih;
        }
    }

    public void pilihwarna(View view) {
        alert.setTitle("Shape Color");
        View view1 = getLayoutInflater().inflate(R.layout.list_warna, null);
        alert.setView(view1);

        final RadioGroup radG = view1.findViewById(R.id.radio_color);
        radG.check(getColorid(colorid));

        alert.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                //mendapatkan id radio button yang di pilih
                int a = radG.getCheckedRadioButtonId();
                switch (a){
                    case R.id.merah:
                        colorid = R.color.merah;
                        break;
                    case R.id.kuning:
                        colorid = R.color.kuning;
                        break;
                    case R.id.biru:
                        colorid = R.color.biru;
                        break;
                    case R.id.oren:
                        colorid = R.color.oren;
                        break;
                    case R.id.putih:
                        colorid = R.color.putih;
                        break;
                }
                warna.setText(getShapeColor(colorid));
                sharedpref.putInt("Colourground", colorid);
                sharedpref.commit();
            }
        });


        alert.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        alert.create().show();
    }
}