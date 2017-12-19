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
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Rajat on 10/28/2017.
 */

public class ShowDetails extends ArrayAdapter<ItemDetail> {

    private final Activity context;
    private final ArrayList<ItemDetail> it;
    public ShowDetails(Activity context, ArrayList<ItemDetail> it) {
        super(context,R.layout.showdetails , it);
        this.context=context;
        this.it = it;
    }

    @NonNull
    @Override
    public View getView(int position, @Nullable View convertView, @NonNull ViewGroup parent) {
        LayoutInflater inflater=context.getLayoutInflater();
        View v=inflater.inflate(R.layout.showdetails,null,true);
        TextView tv1=(TextView) v.findViewById(R.id.show_id);
        TextView tv2=(TextView) v.findViewById(R.id.show_name);
        TextView tv3=(TextView) v.findViewById(R.id.show_qty);
        TextView tv4=(TextView) v.findViewById(R.id.show_price);
        tv1.setText(it.get(position).getId());
        tv2.setText(it.get(position).getPname());
        Integer i=it.get(position).getQty();
        tv3.setText(i.toString());
        Double d=it.get(position).getPrice();
        tv4.setText(d.toString());
        Toast.makeText(context, ""+it.get(position).getId(), Toast.LENGTH_SHORT).show();
        return v;
    }
}
