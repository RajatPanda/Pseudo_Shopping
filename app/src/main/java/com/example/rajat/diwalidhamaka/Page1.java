package com.example.rajat.diwalidhamaka;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;


/**
 * A simple {@link Fragment} subclass.
 */
public class Page1 extends Fragment {
    ArrayList <ItemDetail> itd=new ArrayList<>();
    String txt1[]={
            "Add Product",
            "Delete Product",
            "Show Product",
            "Sell Product"
    };
    ListView lv;
    public Page1(){
        // Required empty public constructor
    }
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View v= inflater.inflate(R.layout.fragment_page1, container, false);
        lv= (ListView) v.findViewById(R.id.livi);
        lv.setAdapter(new Page1List(getActivity(),txt1));
        Bundle bn = getArguments();
        itd= (ArrayList<ItemDetail>) bn.getSerializable("list");
        //final ItemDetail tr=new ItemDetail("ab","rajat",3,2.5);
        //if(itd.isEmpty())
        //     Toast.makeText(getActivity(), "dead"+itd, Toast.LENGTH_SHORT).show();
        //itd.add(tr);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int position, long id) {
                if(position==0)
                {
                    AddFragment af = new AddFragment();
                    FragmentManager fg=getFragmentManager();
                    FragmentTransaction ft = fg.beginTransaction();
                    Bundle b= new Bundle();
                    b.putSerializable("data_list",itd);
                    af.setArguments(b);
                    ft.replace(R.id.activity_main,af);
                    ft.commit();        //Confirmation command
                }
                else if(position==1)
                {
                    DeleteFragment df = new DeleteFragment();
                    FragmentManager fg=getFragmentManager();
                    FragmentTransaction ft = fg.beginTransaction();
                    Bundle b= new Bundle();
                    b.putSerializable("delete_list",itd);
                    df.setArguments(b);
                    ft.replace(R.id.activity_main,df);
                    ft.commit();        //Confirmation command
                    //Toast.makeText(getActivity(), ""+itd, Toast.LENGTH_SHORT).show();
                }
                else if(position==2)
                {
                    ShowFragment sf=new ShowFragment();
                    FragmentManager fg=getFragmentManager();
                    FragmentTransaction ft = fg.beginTransaction();
                    Bundle b = new Bundle();
                    b.putSerializable("show_list",itd);
                    sf.setArguments(b);
                    ft.replace(R.id.activity_main,sf);
                    ft.commit();        //Confirmation command
                }
                else if(position==3)
                {
                    SellFragment sef=new SellFragment();
                    FragmentManager fg=getFragmentManager();
                    FragmentTransaction ft = fg.beginTransaction();
                    Bundle b = new Bundle();
                    b.putSerializable("sold_list",itd);
                    sef.setArguments(b);
                    ft.replace(R.id.activity_main,sef);
                    ft.commit();        //Confirmation command
                }
                else
                {

                }
            }
        });
        return v;
    }
}
