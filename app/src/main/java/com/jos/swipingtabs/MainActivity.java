package com.jos.swipingtabs;

import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    private MyPagerAdapter mpa;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        /*The Viewpager is linked with the PagerAdapter to be able
        to manage everything between distinct tabs' pages and data.
        PagerAdapter must be override GetCount(), isViewFromObject(), instantiateTime(), destroyItem() methods.*/

        ViewPager vp = (ViewPager) findViewById(R.id.vp);

        //Send the context to the PagerAdapter
        mpa = new MyPagerAdapter(this);

        //Set MyPagerAdapter to the ViewPager
        vp.setAdapter(mpa);

        /* If we don't put the ViewPager as parent and TabLayout as child of this in the activity_main layout,
        // we should link them coding.
        // The following method will link the TabLayout with the Viewpager.
        TabLayout.setupWithViewPager(ViewPager object,true)*/

    }

    protected void commitForm(View v){

        //We use the adapter to access to the views of the different layouts.

        mpa.sName.setText(mpa.tName.getText().toString());
        mpa.sPhone.setText(mpa.tPhone.getText().toString());

        switch(mpa.rg.getCheckedRadioButtonId()){
            case R.id.rb1:
                mpa.sEmail.setText(mpa.tEmail.getText().toString()+"@"+mpa.rbG.getText().toString());
                break;
            case R.id.rb2:
                mpa.sEmail.setText(mpa.tEmail.getText().toString()+"@"+mpa.rbH.getText().toString());
                break;
            default:
                mpa.sEmail.setText("You haven't selected any button.");
        }

        Snackbar snack = Snackbar.make(v.getRootView(),"Awesome! You filled the form out succesfully!",Snackbar.LENGTH_SHORT);
        snack.show();
    }
}
