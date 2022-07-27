package com.example.cardiacrecorderapplication;

import androidx.annotation.RequiresApi;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Build;
import android.os.Bundle;
import android.text.Editable;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;

import java.sql.Date;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Calendar;

public class AddRecord extends AppCompatActivity {

    Button add;
    EditText systolic, diastolic, heart_rate;
    TextView textView;
    Calendar calendar;
    SimpleDateFormat simpleDateFormat;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_record);
        add=findViewById(R.id.button_Add);


        add.setOnClickListener(new View.OnClickListener() {
            @RequiresApi(api = Build.VERSION_CODES.O)
            @Override
            public void onClick(View view) {
                systolic=findViewById(R.id.Systolic_Id);
                diastolic=findViewById(R.id.Diastolic_ID);
                heart_rate=findViewById(R.id.Heart_rate);


                calendar=Calendar.getInstance();

                String date,dateTime;
                simpleDateFormat= new SimpleDateFormat("yyyy-MM-dd");
                date = simpleDateFormat.format(calendar.getTime()).toString();

                simpleDateFormat=new SimpleDateFormat("HH:mm:ss");
                dateTime=simpleDateFormat.format(calendar.getTime()).toString();








                String comnt=" ";

                Record record=new Record();
                String sys=systolic.getText().toString();
                String dias=diastolic.getText().toString();
                String heart=heart_rate.getText().toString();

                int sis=Integer.parseInt(sys);
                int dis=Integer.parseInt(dias);

                if(sis>140|| dis>90)
                {
                    comnt="High Pressure";
                }
                if(sis<90 || dis<60)
                {
                    comnt="Low Pressure";
                }

                else
                {
                    comnt="Normal Condition";
                }




                record.setName("John");
                record.setAge("56");
                record.setContactNumber("01815633123");
                record.setComment(comnt);
                record.setHeart_Rate(heart);
                record.setSystolic(sys);
                record.setDiastolic(dias);
                record.setTime(dateTime);
                record.setDate(date);


                DatabaseHelper helper=new DatabaseHelper(getApplicationContext());
                helper.AddRecord(record);

                Intent intent = new Intent(getApplicationContext(),ViewList.class);
                startActivity(intent);

            }
        });
    }


}