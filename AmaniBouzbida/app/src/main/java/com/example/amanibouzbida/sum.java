package com.example.amanibouzbida;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import static com.example.amanibouzbida.MainActivity.db;
import static com.example.amanibouzbida.MainActivity.getAppFirstInstallTime;
import static com.example.amanibouzbida.MainActivity.getDate;

public class sum extends AppCompatActivity {
    Long date ;
    TextView s , datee;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sum);

        s =findViewById(R.id.s);
        s.setText(Float.toString(db.sum()));
        date= getAppFirstInstallTime(this);
        String d = getDate(date, "dd/MM/yyyy");
        datee=findViewById(R.id.date);
        datee.setText(d);


    }

    @Override
    public void onResume(){
        super.onResume();
        s.setText(Float.toString(db.sum()));
    }
}
