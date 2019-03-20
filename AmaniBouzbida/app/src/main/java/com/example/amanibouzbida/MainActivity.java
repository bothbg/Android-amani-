package com.example.amanibouzbida;

import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.pm.ApplicationInfo;
import android.content.pm.PackageInfo;
import android.content.pm.PackageManager;
import android.os.Build;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ListView;
import android.widget.Toast;

import java.io.File;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;

public class MainActivity extends AppCompatActivity {

    ListView listegraphique ;
    public static adapter Adapter ;
    public static DBadapter db ;

    public  ArrayList<expanse> MaListeJava ;

    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        listegraphique=findViewById(R.id.liste);
        MaListeJava=new ArrayList<expanse>();
        db= new DBadapter(this);
        MaListeJava= db.liste();

        Adapter=new adapter(this,R.layout.expanse_item,MaListeJava);

        listegraphique.setAdapter(Adapter);




        listegraphique.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            public void onItemClick(AdapterView<?> parent, final View view, final int position, long id){
                new AlertDialog.Builder(MainActivity.this)
                        .setTitle("supprimer ")
                        .setMessage("nefsa5helek ?")
                        .setPositiveButton(android.R.string.yes, new DialogInterface.OnClickListener() {
                            public void onClick(DialogInterface dialog, int which) {

                                db.remove(MaListeJava.get(position).getId());
                                MaListeJava=db.liste();

                                Adapter=new adapter(MainActivity.this,R.layout.expanse_item,MaListeJava);

                                listegraphique.setAdapter(Adapter);
                                 }})
                        .setNegativeButton(android.R.string.no, null)
                        .setIcon(android.R.drawable.ic_dialog_alert)
                        .show();


            }

        }     );


    }



    public boolean onCreateOptionsMenu(Menu menu) {
        super.onCreateOptionsMenu(menu);
        getMenuInflater().inflate(R.menu.menu,menu);
        return true ;
    }


    public boolean onOptionsItemSelected(MenuItem item) {
        if( item.getItemId()==R.id.add)
        {
            Intent intent = new Intent(MainActivity.this, add.class); startActivity(intent);
        }

        if( item.getItemId()==R.id.sum)
        {
            Intent intent = new Intent(MainActivity.this, sum.class); startActivity(intent);
        }
        return true ;
    }
    @Override
    public void onResume(){
        super.onResume();
        MaListeJava=db.liste();
        Adapter=new adapter(this,R.layout.expanse_item,MaListeJava);
        listegraphique.setAdapter(Adapter);

    }

// code mil internet
    public static long getAppFirstInstallTime(Context context){
        PackageInfo packageInfo;
        try {
            if(Build.VERSION.SDK_INT>8 ){
                packageInfo = context.getPackageManager().getPackageInfo(context.getPackageName(), 0);
                return packageInfo.firstInstallTime;
            }else{
                ApplicationInfo appInfo = context.getPackageManager().getApplicationInfo(context.getPackageName(), 0);
                String sAppFile = appInfo.sourceDir;
                return new File(sAppFile).lastModified();
            }
        } catch (PackageManager.NameNotFoundException e) {
            return 0;
        }
    }
    public static String getDate(long milliSeconds, String dateFormat) {
        // Create a DateFormatter object for displaying date in specified format.
        SimpleDateFormat formatter = new SimpleDateFormat(dateFormat);

        // Create a calendar object that will convert the date and time value in milliseconds to date.
        Calendar calendar = Calendar.getInstance();
        calendar.setTimeInMillis(milliSeconds);
        return formatter.format(calendar.getTime());
    }





}
