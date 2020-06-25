package com.appstone.coordinatorlayout;

import androidx.appcompat.app.AppCompatActivity;
import androidx.swiperefreshlayout.widget.SwipeRefreshLayout;

import android.os.Bundle;
import android.os.Handler;
import android.widget.Toast;

import java.text.SimpleDateFormat;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    SwipeRefreshLayout refreshLayout;

    //GET
    //POST
    //PUT
    //DELETE


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        refreshLayout = findViewById(R.id.referesh_layout);

        refreshLayout.setOnRefreshListener(new SwipeRefreshLayout.OnRefreshListener() {
            @Override
            public void onRefresh() {
                closeRefreshAfterTimeOut();
            }
        });

        Calendar cal = Calendar.getInstance();

        SimpleDateFormat dateFromat = new SimpleDateFormat("YYYY-MM-dd hh:mm aa");
        String currentTime = dateFromat.format(cal.getTime());

        Toast.makeText(this, currentTime, Toast.LENGTH_LONG).show();

    }

    private void closeRefreshAfterTimeOut() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                refreshLayout.setRefreshing(false);
            }
        }, 5000);
    }
}
