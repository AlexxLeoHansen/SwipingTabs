package com.jos.swipingtabs;

import android.content.Context;
import android.support.v4.view.PagerAdapter;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.EditText;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.TextView;

/**
 * Created by jos on 04-03-17.
 * MyPagerAdapter receive Context parameter
 * This method is a must if you want to create an PagerAdapter in your app.
 * Slide between different pages or tabs.
 */


public class MyPagerAdapter extends PagerAdapter {

    public EditText tName,tEmail,tPhone;    //form.xml views
    public TextView sName,sEmail,sPhone;    //show_form.xml views
    public RadioButton rbG, rbH;            //form.xml radiobuttons
    public RadioGroup rg;

    private Context mContext;
    private ViewGroup newContainer;

    public MyPagerAdapter(Context context){
        super();
        mContext = context;
    }
    @Override
    public int getCount() {

        //return the number of pages

        return 2;
    }

    @Override
    public boolean isViewFromObject(View view, Object object) {

        //Check that the view inflated is an object
        return view == object;
    }

    @Override
    public Object instantiateItem(ViewGroup container, int position) {

        //Get an inflater to put a layout inside views from the context
        LayoutInflater inflater = LayoutInflater.from(mContext);

        //Check the page position to get Form or Show_Form layouts. Screen 0 or 1, Form or Show Form

        switch(position){
            case 0:
                /*Inflate Form layout in the container (root view) and attach to the ViewGroup hierarchy as
                a child*/
                newContainer = (ViewGroup) inflater.inflate(R.layout.form, container, false);
                /*Get the views (buttons and so on) for Form layout. Because you want them to be
                //accessible from MainActivity.*/
                getViewsForm();
                break;

            case 1:
                newContainer = (ViewGroup) inflater.inflate(R.layout.show_form, container, false);
                getViewsShow();
                break;
        }

        //necessary set the view as a child
        container.addView(newContainer);

        //now we return the new viewgroup with our specific layout added to that page
        return newContainer;

    }

    @Override
    public CharSequence getPageTitle(int position) {
        //Set the tabs titles
        switch (position){
            case 0:
                return "FORM";
            case 1:
                return "SHOW RESULT";

            default:
                return "error getting Page Title";
        }
    }

    @Override //Destroy the view from the root view hierarchy
    public void destroyItem(ViewGroup container, int position, Object object) {
        container.removeView((View)object);
    }

    public void getViewsForm(){
        tName = (EditText) newContainer.findViewById(R.id.t_name);
        tPhone = (EditText) newContainer.findViewById(R.id.t_phone);
        tEmail = (EditText) newContainer.findViewById(R.id.t_email);
        rg = (RadioGroup) newContainer.findViewById(R.id.rg);
        rbG = (RadioButton) newContainer.findViewById(R.id.rb1);
        rbH = (RadioButton) newContainer.findViewById(R.id.rb2);
    }
    public void getViewsShow(){
        sName = (TextView) newContainer.findViewById(R.id.s_name);
        sPhone = (TextView) newContainer.findViewById(R.id.s_phone);
        sEmail = (TextView) newContainer.findViewById(R.id.s_email);
    }
}


