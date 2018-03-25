package com.example.jm.jimmy_1202150108_modul5;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.support.v7.widget.helper.ItemTouchHelper;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    private Database db;
    private RecyclerView rv;
    private Adapter adapter;
    private ArrayList<TambahData> data_list;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);


        rv = findViewById(R.id.recycler);
        data_list = new ArrayList<>();
        db = new Database(this);
        db.readdata(data_list);

        SharedPreferences sharedP = this.getApplicationContext().getSharedPreferences("Preferences", 0);
        int color = sharedP.getInt("Colourground", R.color.putih);

        adapter = new Adapter(this,data_list, color);
        rv.setHasFixedSize(true);
        rv.setLayoutManager(new LinearLayoutManager(this));
        rv.setAdapter(adapter);
        hapus();
    }

    public void add(View view) {
        //intent menuju class input_data
        Intent intent = new Intent(MainActivity.this, input_data.class);
        //memulai intent
        startActivity(intent);
    }

    //membuat method untuk menghapus item
    public void hapus(){
        ItemTouchHelper.SimpleCallback touchcall = new ItemTouchHelper.SimpleCallback(0, ItemTouchHelper.RIGHT) {

            @Override
            public boolean onMove(RecyclerView recyclerView, RecyclerView.ViewHolder viewHolder, RecyclerView.ViewHolder target) {
                return false;
            }

            @Override
            public void onSwiped(RecyclerView.ViewHolder viewHolder, int direction) {
                int position = viewHolder.getAdapterPosition();
                TambahData current = adapter.getData(position);
                if(direction==ItemTouchHelper.RIGHT){
                    if(db.removedata(current.getTodo())){
                        adapter.deleteData(position);
                        Snackbar.make(findViewById(R.id.cl), "List di Hapus", 1000).show();
                    }
                }
            }
        };
        ItemTouchHelper touchhelp = new ItemTouchHelper(touchcall);
        touchhelp.attachToRecyclerView(rv);
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_main, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        if (id==R.id.action_settings){
            Intent intent = new Intent(MainActivity.this, setting.class);
            startActivity(intent);
            finish();
        }
        return true;
    }

}
