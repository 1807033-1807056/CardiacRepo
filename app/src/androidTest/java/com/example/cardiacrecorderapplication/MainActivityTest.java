package com.example.cardiacrecorderapplication;

import static androidx.test.espresso.Espresso.onView;
import static androidx.test.espresso.action.ViewActions.click;
import static androidx.test.espresso.matcher.ViewMatchers.withId;

import androidx.test.espresso.Espresso;
import androidx.test.espresso.action.ViewActions;
import androidx.test.espresso.assertion.ViewAssertions;
import androidx.test.espresso.matcher.ViewMatchers;
import androidx.test.ext.junit.rules.ActivityScenarioRule;
import androidx.test.ext.junit.runners.AndroidJUnit4;
import androidx.test.filters.LargeTest;

import org.junit.Rule;
import org.junit.Test;
import org.junit.runner.RunWith;

@RunWith(AndroidJUnit4.class)
@LargeTest



public class MainActivityTest {



    @Rule
    public ActivityScenarioRule<MainActivity> activityRule =
            new ActivityScenarioRule<>(MainActivity.class);



    @Test
    public void testAppName() {
        onView(ViewMatchers.withText("My Application")).check(ViewAssertions.matches(ViewMatchers.isDisplayed())); //Check the name on the screen
    }
   @Test
    public void Add_Record_Test()
   {
        onView(ViewMatchers.withId(R.id.add_button)).perform(click());
        onView(withId(R.id.Heart_rate)).perform(ViewActions.typeText("80"));
        onView(withId(R.id.Diastolic_ID)).perform(ViewActions.typeText("75"));
        onView(withId(R.id.Systolic_Id)).perform(ViewActions.typeText("90"));
        Espresso.pressBack();

        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.Recycler_view)).perform(click());
        onView(withId(R.id.home_button)).perform(click());
        onView(withId(R.id.update_id)).perform(click());
        onView(withId(R.id.Recycler_view)).perform(click());

        onView(withId(R.id.Heart_rate)).perform(ViewActions.typeText("90"));
        onView(withId(R.id.Diastolic_ID)).perform(ViewActions.typeText("100"));
        onView(withId(R.id.Systolic_Id)).perform(ViewActions.typeText("90"));
        Espresso.pressBack();
        onView(withId(R.id.button_Add)).perform(click());
        onView(withId(R.id.Recycler_view)).perform(click());
        onView(withId(R.id.home_button)).perform(click());

        onView(withId(R.id.Delete_ID)).perform(click());
        onView(withId(R.id.Recycler_view)).perform(click());










   }

}