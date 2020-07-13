package com.itware.myapplication.ui.Adapter;


import android.app.Activity;
import android.text.Editable;
import android.text.TextWatcher;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.Spinner;
import android.widget.TextView;
import android.widget.Toast;

import androidx.recyclerview.widget.RecyclerView;

import com.itware.myapplication.R;
import com.itware.myapplication.ui.MainActivity;
import com.itware.myapplication.ui.models.AnswerMast;
import com.itware.myapplication.ui.models.SurverDataModel;

import java.util.ArrayList;

public class Adapter extends RecyclerView.Adapter<Adapter.MyViewHolder> implements AdapterView.OnItemSelectedListener {

    private ArrayList<SurverDataModel> list ;
    private Activity mActvity;
    private  ArrayList<AnswerMast> a2;
    private ArrayList<MyViewHolder> mHolder = new ArrayList<>();

    public Adapter(Activity activity, ArrayList<SurverDataModel> list) {
        this. list = list;
        mActvity = activity;

    }

    @Override
    public void onItemSelected(AdapterView<?> adapterView, View view, int i, long l) {
        //todo write function for selected item
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
    public void onBindViewHolder(MyViewHolder holder, final int position) {

        mHolder.add(holder);
        holder.textView.setText(list.get(position).getQuestion());


        AnswerMast answerMast = new AnswerMast();
        answerMast.setAnswer("Select");
        answerMast.setAid("00");
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

//            holder.edit.setError(list.get(position).getRequiredValidatorMessage());
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

    public boolean validateUi(){
        for (int i = 0; i < list.size(); i++){
            if (list.get(i).getControlType().equalsIgnoreCase("Dropdown")){
                if(mHolder.get(i).spinner.getSelectedItemPosition() == 0){
                    Toast.makeText(mActvity, list.get(i).getRequiredValidatorMessage(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else if (list.get(i).getQuestion().equalsIgnoreCase( "Mobile Number")){
                if(mHolder.get(i).phone.getText().toString().length() < 10){
                    Toast.makeText(mActvity, list.get(i).getRequiredValidatorMessage(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            }else {
                if(mHolder.get(i).edit.getText().toString().length() == 0){
                    Toast.makeText(mActvity, list.get(i).getRequiredValidatorMessage(), Toast.LENGTH_SHORT).show();
                    return false;
                }
            }

        }

        return true;
    }


    @Override
    public int getItemCount() {
        return list.size();
    }
}
