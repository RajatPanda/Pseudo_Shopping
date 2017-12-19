package com.example.rajat.diwalidhamaka;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TableLayout;
import android.widget.TextView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class DeleteFragment extends Fragment {

    public EditText edt_del;
    public Button del;
    public TableLayout tb_del;
    public TextView del1,del2,del3,del4;
    public ArrayList<ItemDetail> item_del=new ArrayList<>();
    public DeleteFragment() {
        // Required empty public constructor
    }

    public int item_delete(String del)
    {
        int pos=0;
        for(pos=0;pos<item_del.size();pos++)
            if(item_del.get(pos).getId().equals(del))
                return pos;
        return -1;
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_delete, container, false);
        edt_del=(EditText) v.findViewById(R.id.edt_del_id);
        del=(Button) v.findViewById(R.id.but_del);
        tb_del=(TableLayout) v.findViewById(R.id.del_table1);
        del1=(TextView) v.findViewById(R.id.del_id);
        del2=(TextView) v.findViewById(R.id.del_name);
        del3=(TextView) v.findViewById(R.id.del_qty);
        del4=(TextView) v.findViewById(R.id.del_price);
        //bring Arraylist
        Bundle bn=getArguments();
        item_del= (ArrayList<ItemDetail>) bn.getSerializable("delete_list");
        del.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String id=edt_del.getText().toString();
                if(id.isEmpty())
                    edt_del.setError("Please Enter");
                else
                {
                    int del_pos = item_delete(id);
                    if(del_pos!=-1)
                    {
                        ItemDetail it_del = item_del.get(del_pos);
                        item_del.remove(del_pos);
                        del1.setText(it_del.getId());
                        del2.setText(it_del.getPname());
                        Integer i=it_del.getQty();
                        Double d=it_del.getPrice();
                        del3.setText(i.toString());
                        del4.setText(d.toString());
                        tb_del.setVisibility(View.VISIBLE);
                        Toast.makeText(getActivity(), "Item Deleted", Toast.LENGTH_SHORT).show();
                    }
                    else
                        Toast.makeText(getActivity(), "Element Not Present", Toast.LENGTH_SHORT).show();
                }
            }
        });
        return v;
    }
}
