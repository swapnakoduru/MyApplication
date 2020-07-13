package com.itware.myapplication.ui.Adapter;

import android.content.Context;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.itware.myapplication.R;
import com.itware.myapplication.ui.models.AnswerMast;

import java.util.List;


public class SpinnerAdapter extends BaseAdapter {
    private List<AnswerMast> returnList;
    //ArrayList<HashMap<String, String>> returnList;
    Context context;
    LayoutInflater inflter;

    public SpinnerAdapter(Context context, List<AnswerMast> returnList) {
        this. returnList = returnList;
        this.context = context;
        inflter = (LayoutInflater.from(context));
    }


    @Override
    public int getCount() {
        return returnList.size();
    }

    @Override
    public Object getItem(int i) {
        return null;
    }

    @Override
    public long getItemId(int i) {
        return 0;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        view = inflter.inflate(R.layout.item_spinner, null);
        TextView names = (TextView) view.findViewById(R.id.textView);
        Log.i("city list",""+returnList.get(i));
        names.setText((CharSequence) returnList.get(i).getAnswer());
        return view;
    }
}

