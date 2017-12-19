package com.example.rajat.diwalidhamaka;

import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.util.ArrayList;

public class MainActivity extends AppCompatActivity {
    ArrayList<ItemDetail> list_item = new ArrayList<ItemDetail>();
    @Override
    public void onBackPressed() {
        FragmentManager fg=getSupportFragmentManager();
        Fragment currentFragment = fg.findFragmentById(R.id.frag_page1);
        if(!(((Page1) getSupportFragmentManager().findFragmentByTag("pg1")) != null
                && ((Page1) getSupportFragmentManager().findFragmentByTag("pg1")).isVisible()))
        {
            Page1 pg1=new Page1();
            FragmentTransaction ft = fg.beginTransaction();
            Bundle b = new Bundle();
            b.putSerializable("list",list_item);
            pg1.setArguments(b);
            ft.replace(R.id.activity_main, pg1,"pg1");
            ft.commit();        //Confirmation command
        }
        else
        {
            super.onBackPressed();
        }
    }
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Page1 pg1=new Page1();
        FragmentManager fg=getSupportFragmentManager();
        FragmentTransaction ft = fg.beginTransaction();
        Bundle b = new Bundle();
        b.putSerializable("list",list_item);
        pg1.setArguments(b);
        ft.add(R.id.activity_main,pg1,"pg1");
        ft.commit();        //Confirmation command
    }
}
