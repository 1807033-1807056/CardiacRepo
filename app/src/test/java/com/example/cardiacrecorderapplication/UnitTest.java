package com.example.cardiacrecorderapplication;

import static org.junit.Assert.assertEquals;

import androidx.test.core.app.ApplicationProvider;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.robolectric.RobolectricTestRunner;

import java.util.ArrayList;

@RunWith(RobolectricTestRunner.class)
public class UnitTest {

    @Before
    public void setUp() throws Exception {
    }
    @Test
    public void AddRecordTest(){
        DatabaseHelper db=new DatabaseHelper(ApplicationProvider.getApplicationContext());
        ArrayList<Record> arrayList;
        // assertEquals(2,1+1);
        arrayList=db.fetchAlldata();
        int l=arrayList.size();

        Record record=new Record();
        record.setName("No one-Arya");
        record.setContactNumber("01010101");
        record.setAge("39434");
        record.setDiastolic("85");
        record.setSystolic("90");
        record.setComment("Just Saved A murder by controlling my temper--33");
        record.setHeart_Rate("Awwwwww");
        record.setTime("00:08:08");
        record.setDate("06-07-22");

        db.AddRecord(record);
        arrayList=db.fetchAlldata();
        assertEquals(l+1, arrayList.size());
    }
    @Test
    public void DeleteRecordTest(){
        DatabaseHelper db=new DatabaseHelper(ApplicationProvider.getApplicationContext());
        ArrayList<Record> arrayList;
        // assertEquals(2,1+1);
        arrayList=db.fetchAlldata();
        int l=arrayList.size();

        Record record=new Record();
        record.setName("No one-Arya");
        record.setContactNumber("01010101");
        record.setAge("39434");
        record.setDiastolic("85");
        record.setSystolic("90");
        record.setComment("Just Saved A murder by controlling my temper--33");
        record.setHeart_Rate("Awwwwww");
        record.setTime("00:08:08");
        record.setDate("06-07-22");

        db.AddRecord(record);
        db.DeleteData("06-07-22","00:08:08");
        arrayList=db.fetchAlldata();
        assertEquals(l, arrayList.size());
    }


    @After
    public void tearDown() throws Exception {
    }

}