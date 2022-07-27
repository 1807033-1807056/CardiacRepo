package com.example.cardiacrecorderapplication;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

import java.util.ArrayList;

public class Update_Data extends AppCompatActivity {

    private ArrayList<Record> arrayList;
    private RecyclerView recyclerView;

    private RecyclerAdapter.RecyclerViewClicklistener listener;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        recyclerView = findViewById(R.id.Recycler_view);
        arrayList = new ArrayList<>();


        setUserInfo();
        setUserAdapter();

    }

    private void setUserInfo() {
        DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
        arrayList = databaseHelper.fetchAlldata();

    }

    private void setUserAdapter() {
        setOnclickListener_Update();
        RecyclerAdapter recyclerAdapter = new RecyclerAdapter(arrayList, listener);
        RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }


    private void setOnclickListener_Update() {

        listener = new RecyclerAdapter.RecyclerViewClicklistener() {
            @Override
            public void onClick(View v, int position) {
                String datee = arrayList.get(position).getDate();
                String timee = arrayList.get(position).getTime();

                DatabaseHelper databaseHelper = new DatabaseHelper(getApplicationContext());
                databaseHelper.DeleteData(datee, timee);

                Intent intent = new Intent(getApplicationContext(), AddRecord.class);
                startActivity(intent);
            }

        };
    }
}