package com.example.rajat.diwalidhamaka;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class ShowFragment extends Fragment {

    ListView lv2;
    ArrayList<ItemDetail> it_show=new ArrayList<ItemDetail>();
    public ShowFragment() {
        // Required empty public constructor
    }


    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_show, container, false);
        lv2= (ListView) v.findViewById(R.id.livi2);
        Bundle bn = getArguments();
        it_show= (ArrayList<ItemDetail>) bn.getSerializable("show_list");
        //Toast.makeText(getActivity(), ""+it_show, Toast.LENGTH_SHORT).show();
        lv2.setAdapter(new ShowDetails(getActivity(),it_show));
        return v;
    }
}
