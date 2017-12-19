package com.example.rajat.diwalidhamaka;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class AddFragment extends Fragment {

    public ArrayList<ItemDetail> itd_add=new ArrayList<ItemDetail>();
    public Button btn_add;
    public EditText edt_id,edt_qty,edt_name,edt_price;
    public String name,e_id,qty,price;
    public AddFragment() {
        // Required empty public constructor
    }

    public void set_string()
    {
        e_id=edt_id.getText().toString();
        name=edt_name.getText().toString();
        qty=edt_qty.getText().toString();
        price=edt_price.getText().toString();
    }
    public int set_incomplete()
    {
        int flag=1;
        if(name.isEmpty())
        {
            edt_name.setError("Please Enter");
            flag=0;
        }
        if(e_id.isEmpty())
        {
            edt_id.setError("Please Enter");
            flag=0;
        }
        if(qty.isEmpty())
        {
            edt_qty.setError("Please Enter");
            flag=0;
        }
        if(price.isEmpty())
        {
            edt_price.setError("Please Enter");
            flag=0;
        }
        return flag;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_add, container, false);
        btn_add=(Button) v.findViewById(R.id.button);
        edt_id=(EditText) v.findViewById(R.id.edt_id);
        edt_name=(EditText) v.findViewById(R.id.edt_name);
        edt_qty=(EditText) v.findViewById(R.id.edt_qty);
        edt_price=(EditText) v.findViewById(R.id.edt_price);
        btn_add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                set_string();
                if(set_incomplete()==1)
                {
                    Integer qty1=Integer.parseInt(qty);
                    Double price1=Double.parseDouble(price);
                    ItemDetail add1=new ItemDetail(e_id,name,qty1,price1);
                    Bundle bn=getArguments();
                    itd_add= (ArrayList<ItemDetail>) bn.getSerializable("data_list");
                    itd_add.add(add1);
                    Toast.makeText(getActivity(), "Item Added", Toast.LENGTH_SHORT).show();
                    edt_id.setText("");
                    edt_name.setText("");
                    edt_qty.setText("");
                    edt_price.setText("");
                }
            }
        });
        return v;
    }

}
