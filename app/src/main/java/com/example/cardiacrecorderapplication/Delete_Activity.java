package com.example.cardiacrecorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Delete_Activity extends AppCompatActivity {
    private ArrayList<Record> arrayList;
    private RecyclerView recyclerView;
    AlertDialog.Builder builder;


    private RecyclerAdapter.RecyclerViewClicklistener listener;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        recyclerView = findViewById(R.id.Recycler_view);
        arrayList = new ArrayList<>();
        builder=new AlertDialog.Builder(this);


        setUserInfo();
        setUserAdapter();


    }

    private void setUserInfo() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        arrayList = databaseHelper.fetchAlldata();

    }

    private void setUserAdapter() {
        setOnclickListener_Delete();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    private void setOnclickListener_Delete() {
        listener=new RecyclerAdapter.RecyclerViewClicklistener() {
            @Override
            public void onClick(View v, int position) {

                builder.setMessage("Are you sure you want to delete ?")
                        .setCancelable(false)
                        .setPositiveButton("YES", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {

                                String datee = arrayList.get(position).getDate();
                                String timee = arrayList.get(position).getTime();

                                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                                databaseHelper.DeleteData(datee, timee);

                                Intent intent = new Intent(getApplicationContext(),ViewList.class);
                                startActivity(intent);
                            }
                        })
                        .setNegativeButton("NO", new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int id) {
                                //  Action for 'NO' Button
                                dialog.dismiss();

                            }
                        });

                AlertDialog alert = builder.create();
                // alert.setTitle("Delete From List");
                alert.show();

            }
        };


    }
}

//    public void setOnclickListener()
//    {
//
//          listener = new RecyclerAdapter.RecyclerViewClicklistener() {
//            @Override
//            public void onClick(View v, int position) {
//                String datee = arrayList.get(position).getDate();
//                String timee = arrayList.get(position).getTime();
//
//                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
//
//                databaseHelper.DeleteData(datee, timee);
//
//                Intent intent = new Intent(getApplicationContext(),ViewList.class);
//                startActivity(intent);
//            }
//
//        };
//
//            }
//        };
//    }
