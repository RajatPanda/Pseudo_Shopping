package com.example.rajat.diwalidhamaka;

import android.app.Activity;
import android.content.Context;
import android.support.annotation.LayoutRes;
import android.support.annotation.NonNull;
import android.support.annotation.Nullable;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.TextView;

/**
 * Created by Rajat on 10/18/2017.
 */

public class Page1List extends ArrayAdapter<String>{

    private final Activity context;
    private final String[] txt1;

    public Page1List(Activity context, String[] txt1) {
        super(context,R.layout.page1list,txt1);
        this.context=context;
        this.txt1=txt1;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.page1list,null,true);
        TextView tv1=(TextView) v.findViewById(R.id.txt1);
        tv1.setText(txt1[position]);
        return v;
        //return super.getView(position, convertView, parent);
    }
}
