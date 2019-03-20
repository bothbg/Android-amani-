package com.example.amanibouzbida;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.Toast;

import static com.example.amanibouzbida.MainActivity.db;

public class add extends AppCompatActivity {
    Button btn ;
    EditText esm ;
    EditText soum ;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add);

        btn=findViewById(R.id.b);
        esm=findViewById(R.id.a);
        soum=findViewById(R.id.c);


        btn.setOnClickListener(new View.OnClickListener(){

            public void onClick(View v)
            {
                String nom= esm.getText().toString();
                Float montant =Float.valueOf(soum.getText().toString());
                expanse e = new expanse(nom, montant);
                db.ajoutdepense(e);
                Intent intent = new Intent(add.this, MainActivity.class); startActivity(intent);

            }

        });
    }


}
