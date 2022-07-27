package com.example.cardiacrecorderapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.DefaultItemAnimator;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;

public class ViewList extends AppCompatActivity {

    private ArrayList<Record>arrayList;
    private RecyclerView recyclerView;

    private RecyclerAdapter.RecyclerViewClicklistener listener;

    Button del;
    Button update;




    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_list);

        recyclerView=findViewById(R.id.Recycler_view);
        arrayList=new ArrayList<>();
        del=(Button)findViewById(R.id.delete_data);
        update=(Button)findViewById(R.id.update_data);


        setUserInfo();
        setUserAdapter();


    }


    private void setUserInfo() {
        DatabaseHelper databaseHelper=new DatabaseHelper(getApplicationContext());
        arrayList=databaseHelper.fetchAlldata();

    }

    private void setUserAdapter() {
        setOnclickListener();
        RecyclerAdapter recyclerAdapter=new RecyclerAdapter(arrayList,listener);
        RecyclerView.LayoutManager layoutManager=new LinearLayoutManager(getApplicationContext());
        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setItemAnimator(new DefaultItemAnimator());
        recyclerView.setAdapter(recyclerAdapter);
    }

    public void setOnclickListener()
    {
        listener=new RecyclerAdapter.RecyclerViewClicklistener() {
            @Override
            public void onClick(View v, int position) {
                Intent intent=new Intent(getApplicationContext(),Details_Activity.class);
                intent.putExtra("Username",arrayList.get(position).getName());
                intent.putExtra("Contact", arrayList.get(position).getContactNumber());
                intent.putExtra("Time",arrayList.get(position).getTime());
                intent.putExtra("Date", arrayList.get(position).getDate());
                intent.putExtra("Heart_Rate",arrayList.get(position).getHeart_Rate());
                intent.putExtra("Systolic",arrayList.get(position).getSystolic());
                intent.putExtra("Diastolic",arrayList.get(position).getDiastolic());
                startActivity(intent);
            }
        };
    }






}