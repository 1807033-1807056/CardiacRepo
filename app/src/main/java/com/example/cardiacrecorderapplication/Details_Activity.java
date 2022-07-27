package com.example.cardiacrecorderapplication;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

public class Details_Activity extends AppCompatActivity {
    TextView username;
    TextView contact;
    TextView Time;
    TextView Date;
    TextView Systolic;
    TextView Diastolic;
    TextView heartRate;
    TextView Age;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        username=findViewById(R.id.details_username);

        contact=findViewById(R.id.details_contactNumber);
        Time=findViewById(R.id.time_details);
        Date=findViewById(R.id.date_details);
        Systolic=findViewById(R.id.systolic_details);
        Diastolic=findViewById(R.id.Diastolic_Details);
        heartRate=findViewById(R.id.heart_rate);


        Bundle extras=getIntent().getExtras();
        if(extras!=null)
        {
            String username1=extras.getString("Username");
            String contact1=extras.getString("Contact");
            String Time1=extras.getString("Time");
            String Date1=extras.getString("Date");
            String heartRate1=extras.getString("Heart_Rate");
            String systolic1=extras.getString("Systolic");
            String diastolic1=extras.getString("Diastolic");
            String age1=extras.getString("Age1");

            username.setText("Username is : " + username1);
            contact.setText("Contact number is: "+ contact1);
            Time.setText("Time is : "+Time1);
            Date.setText("Date is : "+ Date1);
            heartRate.setText("Heart Rate is : "+ heartRate1);
            Systolic.setText("Systolic pressure is : " + systolic1);
            Diastolic.setText("Diastolic pressure is : " + diastolic1);


        }

    }

}