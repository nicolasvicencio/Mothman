package com.example.mothman;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.ListView;

public class ListData extends AppCompatActivity {
    private ListView lvData;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_data);
    }


//    class  AdaptaderData extends ArrayAdapter<Sensor>{
//        AppCompatActivity appCompatActivity;
//
//        public AdapterData(AppCompatActivity context){
//            super(context, R.layout.);
//            appCompatActivity = context;
//        }
//
//        public void getView(int position, View v, ViewGroup parent){
//            LayoutInflater inflater = appCompatActivity.getLayoutInflater();
//            View item = inflater.inflate(R.layout.)
//        }
//
//
//    }




}