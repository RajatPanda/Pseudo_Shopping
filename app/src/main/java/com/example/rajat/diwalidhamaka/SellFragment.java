package com.example.rajat.diwalidhamaka;


import android.os.Bundle;
import android.support.design.widget.Snackbar;
import android.support.design.widget.TextInputLayout;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Spinner;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class SellFragment extends Fragment {

    TextInputLayout t1,t2;
    Spinner pname_spinner;
    EditText edtqtys,edtprices;
    Button btncalc;
    ArrayList<ItemDetail> itd_sell=new ArrayList<>();
    ArrayList<String> itd_pname=new ArrayList<>();
    Integer qty_limit,qty_req,pos;
    Double price,finalcost;

    public SellFragment() {
        // Required empty public constructor
    }

    public void setPname()
    {
        itd_pname.add(" ");
        for(int i=0;i<itd_sell.size();i++)
            itd_pname.add(itd_sell.get(i).getPname());
    }
    public int item_posn(String el)
    {
        int pos=0;
        for(pos=0;pos<itd_sell.size();pos++)
            if(itd_sell.get(pos).getPname().equals(el))
                return pos;
        return -1;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v = inflater.inflate(R.layout.fragment_sell, container, false);
        pname_spinner = (Spinner) v.findViewById(R.id.spin_pname);
        edtqtys = (EditText) v.findViewById(R.id.edt_qtys);
        edtprices = (EditText) v.findViewById(R.id.edt_prices);
        btncalc = (Button) v.findViewById(R.id.but_calc);
        t1=v.findViewById(R.id.til1);
        t2=v.findViewById(R.id.til2);
        Bundle b = getArguments();
        itd_sell= (ArrayList<ItemDetail>) b.getSerializable("sold_list");
        setPname();
        ArrayAdapter<String> spinpname=new ArrayAdapter<String>(this.getActivity(),android.R.layout.simple_list_item_1,itd_pname);
        pname_spinner.setAdapter(spinpname);
        /**/
        pname_spinner.setOnItemSelectedListener(new AdapterView.OnItemSelectedListener() {
            @Override
            public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
                String name=pname_spinner.getSelectedItem().toString();
                if(i>0)
                {
                    t1.setVisibility(View.VISIBLE);
                    t2.setVisibility(View.VISIBLE);
                    btncalc.setVisibility(View.VISIBLE);
                    pos=item_posn(name);
                    qty_limit=itd_sell.get(pos).getQty();
                    price=itd_sell.get(pos).getPrice();
                }
            }

            @Override
            public void onNothingSelected(AdapterView<?> adapterView) {

            }
        });
        btncalc.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                if(btncalc.getText().equals("Calculate"))
                {
                    String qt=edtqtys.getText().toString();
                    if (!qt.isEmpty())
                    {
                        qty_req=Integer.parseInt(qt);
                        if(qty_req>qty_limit)
                            edtqtys.setError("Quantity Not Available");
                        else
                        {
                            btncalc.setText("Checkout");
                            finalcost=qty_req*price;
                            edtprices.setText(finalcost.toString());
                            itd_sell.get(pos).changeQty(qty_limit-qty_req);
                        }
                    }
                    else
                        edtqtys.setError("Please Enter Quantity");
                }
                else
                {
                    Snackbar.make(view,""+finalcost,Snackbar.LENGTH_SHORT).setAction("Action",null).show();
                }
            }
        });
        return v;
    }

}
