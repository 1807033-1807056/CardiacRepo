package com.example.cardiacrecorderapplication;
import java.sql.Time;
import java.time.LocalDate;
import java.time.LocalTime;
import java.util.Date;

public class Record {
    String name;
    String contactNumber;
    String date;
    String time;
    String Systolic;
    String Diastolic;
    String Heart_Rate;
    String Age;
    String comment=" ";

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getDate() {
        return date;
    }

    public void setDate(String date) {
        this.date = date;
    }

    public String getTime() {
        return time;
    }

    public void setTime(String time) {
        this.time = time;
    }

    public String getSystolic() {
        return Systolic;
    }

    public void setSystolic(String systolic) {
        Systolic = systolic;
    }

    public String getDiastolic() {
        return Diastolic;
    }

    public void setDiastolic(String diastolic) {
        Diastolic = diastolic;
    }

    public String getHeart_Rate() {
        return Heart_Rate;
    }

    public void setHeart_Rate(String heart_Rate) {
        Heart_Rate = heart_Rate;
    }

    public String getAge() {
        return Age;
    }

    public void setAge(String age) {
        Age = age;
    }

    public Record(String name, String age) {
        this.name = name;
        Age=age;

    }

    public Record(String name, String contactNumber, String date, String time, String systolic, String diastolic, String heart_Rate, String age) {
        this.name = name;
        this.contactNumber = contactNumber;
        this.date = date;
        this.time = time;
        Systolic = systolic;
        Diastolic = diastolic;
        Heart_Rate = heart_Rate;
        Age = age;
    }

    public Record() {
    }

    public String getComment() {
        return comment;
    }

    public void setComment(String comm) {
        comment=comm;
    }
}
