package com.itware.myapplication.ui;


import android.app.Activity;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.itware.myapplication.R;
import com.itware.myapplication.ui.models.AnswerMast;
import com.itware.myapplication.ui.models.SurverDataModel;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements AdapterView.OnItemSelectedListener {

    private ArrayList<SurverDataModel> list ;
    private Activity mActvity;
    private  ArrayList<AnswerMast> a2;

    public Adapter(Activity activity, ArrayList<SurverDataModel> list) {
        this. list = list;
        mActvity = activity;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {

    }

    @Override
    public void onNothingSelected(AdapterView<?> adapterView) {

    }

    public static class MyViewHolder extends RecyclerView.ViewHolder {
        public TextView textView;
        public EditText edit,phone;
        public Spinner spinner;
        public LinearLayout linear;

        public MyViewHolder(View v) {
            super(v);
            textView = (TextView) v.findViewById(R.id.firstName);
            edit = (EditText) v.findViewById(R.id.edit);
            phone = (EditText) v.findViewById(R.id.phone);
            linear = (LinearLayout) v.findViewById(R.id.linear);
            spinner = (Spinner) v.findViewById(R.id.spinner);

        }
    }

    @Override
    public Adapter.MyViewHolder onCreateViewHolder(ViewGroup parent,
                                                   int viewType) {
        View v =  LayoutInflater.from(parent.getContext())
                .inflate(R.layout.list_items, parent, false);
        MyViewHolder vh = new MyViewHolder(v);

        return vh;
    }

    @Override
    public void onBindViewHolder(MyViewHolder holder, int position) {

        holder.textView.setText(list.get(position).getQuestion());


        AnswerMast answerMast = new AnswerMast();
        answerMast.setAnswer("Select");

        Log.i("swapna","success"+list.get(position).getControlType());
        if (list.get(position).getControlType().equalsIgnoreCase("Dropdown")){
            holder.edit.setVisibility(View.GONE);
            holder.spinner.setVisibility(View.VISIBLE);
            holder.linear.setVisibility(View.GONE);
        }else if (list.get(position).getQuestion().equalsIgnoreCase( "Mobile Number")){
            holder.linear.setVisibility(View.VISIBLE);
            holder.edit.setVisibility(View.GONE);
            holder.spinner.setVisibility(View.GONE);
        }else {
            holder.edit.setVisibility(View.VISIBLE);
            holder.spinner.setVisibility(View.GONE);
            holder.linear.setVisibility(View.GONE);
        }

        a2 = new ArrayList<>();
        a2.add(answerMast);

        if (a2 != null)
            a2.addAll(list.get(position).getAnswerMast());
        SpinnerAdapter spinnerAdapter = new SpinnerAdapter(mActvity, a2);
        holder.spinner.setAdapter(spinnerAdapter);

    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
