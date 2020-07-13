package com.itware.myapplication.ui;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;

import com.itware.myapplication.Common.APIClient;
import com.itware.myapplication.Common.APIInterface;
import com.itware.myapplication.R;
import com.itware.myapplication.ui.Adapter.Adapter;
import com.itware.myapplication.ui.models.ModelClass;
import com.itware.myapplication.ui.models.SurverDataModel;

import java.util.ArrayList;
import java.util.HashMap;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Adapter adapter;
    RecyclerView listView;
    Button button;
    private ArrayList<SurverDataModel> d1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listView = (RecyclerView) findViewById(R.id.listView);
        button = (Button)findViewById(R.id.button);
//        alert();
        getList();

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                Log.e("validate","is"+adapter.validateUi());
                if (adapter.validateUi() == true)
                {
                    startActivity(new Intent(MainActivity.this, ScannedBarcodeActivity.class));
                }
            }
        });
    }

    private void alert() {
        AlertDialog.Builder builder = new AlertDialog.Builder(MainActivity.this);
        builder.setTitle("")
                .setMessage("Are you sure you want to Proceed?")
                .setPositiveButton("Yes", new DialogInterface.OnClickListener() {

                    @Override
                    public void onClick(DialogInterface dialog, int which) {


                    }
                })
                .setNegativeButton("No", null)
                .show();
        AlertDialog alert = builder.create();
        alert.show();

    }


    public void getList() {
        HashMap<String, String> header = new HashMap<String, String>();
        APIInterface apiInterface = APIClient.getClient().create(APIInterface.class);

        Call<ModelClass> call =apiInterface.getList();
        call.enqueue(new Callback<ModelClass>() {
            @Override
            public void onResponse(Call<ModelClass> call, Response<ModelClass> response) {
                if(response.code() ==200){
                    {
                        Log.w("Responce", ""+response.body().getSurveyData());
                        d1 = (ArrayList<SurverDataModel>) response.body().getSurveyData();
                        adapter = new Adapter(MainActivity.this,d1);
                        listView.setHasFixedSize(true);
                        listView.setLayoutManager(new LinearLayoutManager(MainActivity.this));
                        listView.setAdapter(adapter);

                    }
                }
            }

            @Override
            public void onFailure(Call<ModelClass> call, Throwable t) {

                Log.e("Error","Code not works");
            }
        });

    }

}