package com.dct.listview;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ListView lvTraiCay;
    ArrayList<TraiCay> arrayTraiCay;
    TraiCayAdapter traiCayAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        AnhXa();
        traiCayAdapter = new TraiCayAdapter(this,R.layout.dong_trai_cay,arrayTraiCay);
        lvTraiCay.setAdapter(traiCayAdapter);

        lvTraiCay.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                Intent viewhd = new Intent(MainActivity.this, ViewHolder.class);
                startActivity(viewhd);


            }
        })

        ;
        lvTraiCay.setOnItemLongClickListener(new AdapterView.OnItemLongClickListener() {
            @Override
            public boolean onItemLongClick(AdapterView<?> parent, View view, int position, long id) {
                AlertDialog.Builder dialog = new AlertDialog.Builder(MainActivity.this);
                dialog.setTitle("Xác Nhận");
                dialog.setMessage("Bạn có đồng ý xóa không");
                dialog.setPositiveButton("Đồng ý", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        arrayTraiCay.remove(position);
                        traiCayAdapter.notifyDataSetChanged();
                    }
                });
                dialog.setNegativeButton("Không", new DialogInterface.OnClickListener() {
                    @Override
                    public void onClick(DialogInterface dialog, int which) {
                        dialog.cancel();
                    }
                });
                AlertDialog alertDialog = dialog.create();
                alertDialog.show();;

                return false;
            }
        });
    }

    private void AnhXa() {
        lvTraiCay = findViewById(R.id.listviewTraiCay);
        arrayTraiCay = new ArrayList<>();

        arrayTraiCay.add(new TraiCay("Lemon","Super sour",R.drawable.lemon));
        arrayTraiCay.add(new TraiCay("Apple","Lost of fiber",R.drawable.apple));
        arrayTraiCay.add(new TraiCay("Guava","Vitamin C supplement",R.drawable.guava));
        arrayTraiCay.add(new TraiCay("Kiwi","Verry delicious",R.drawable.kiwi));
        arrayTraiCay.add(new TraiCay("Orange","So sweet",R.drawable.orange));
        arrayTraiCay.add(new TraiCay("Durian","Verry rotten",R.drawable.durian));
        arrayTraiCay.add(new TraiCay("Durian","Verry rotten",R.drawable.durian));

        arrayTraiCay.add(new TraiCay("Durian","Verry rotten",R.drawable.durian));
    }

}