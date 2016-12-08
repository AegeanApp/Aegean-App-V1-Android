package com.aegeanapp.george.test_aegean_app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Sitisi extends ActionBarActivity {
    private Spinner dropdown;
    private Spinner dropdown2;
  //  private Spinner dropdown3;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitisi);
        getSupportActionBar().setTitle("Πρόγραμμα Σίτισης");//setting title in actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//energopoiisi tou back button

        dropdown = (Spinner) findViewById(R.id.list1);
        dropdown2 = (Spinner) findViewById(R.id.list2);
      //  dropdown3 = (Spinner) findViewById(R.id.list3);
        //1h lista gia ebdomades
        String[] items = new String[]{"1η Εβδομάδα", "2η Εβδομάδα", "3η Εβδομάδα", "4η Εβδομάδα"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        //2h lista gia ebdomades
        String[] items2 = new String[]{"Μεσημεριανό", "Βραδινό"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items2);
        dropdown2.setAdapter(adapter2);
     /*   //3h gia imera ths evdomadas
        String[] items3 = new String[]{"Δευτέρα", "Τρίτη","Τετάρτη","Πέμπτη","Παρασκευή","Σάββατο","Κυριακή"};
        ArrayAdapter<String> adapter3 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items3);
        dropdown3.setAdapter(adapter3);*/
    }

    private String val_list1;
    private String val_list2;
  //  private String val_list3;

    public void weekOnClick(View v) {

        val_list1 = (String) dropdown.getSelectedItem();
        val_list2 = (String) dropdown2.getSelectedItem();
      //  val_list3 = (String) dropdown3.getSelectedItem();

        int week = 0, daytime = 0;

        if (val_list2.equals("Βραδινό"))
            daytime = 2;
        else
            daytime = 1;


        if (val_list1.equals("1η Εβδομάδα")) {
            week = 1;
        } else if (val_list1.equals("2η Εβδομάδα")) {
            week = 2;
        } else if (val_list1.equals("3η Εβδομάδα")) {
            week = 3;
        } else if (val_list1.equals("4η Εβδομάδα")) {
            week = 4;
        }


        Intent i = new Intent(this, FoodActivity.class);

        //Create the bundles
        Bundle bundle1 = new Bundle();
        Bundle bundle2 = new Bundle();
        String weekSt = String.valueOf(week);
        String daytimeSt = String.valueOf(daytime);
        //Add your data to bundle
        bundle1.putString("week", weekSt);
        bundle1.putString("daytime", daytimeSt);
        //Add the bundle to the intent
        i.putExtras(bundle1);
        i.putExtras(bundle2);

        startActivity(i);


    }


    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home) {
            finish();//na mporei to back button na paei pisw
        }

        return super.onOptionsItemSelected(item);
    }
   /* public void Dialog(String msg) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener() {
                    //exits the application
                    public void onClick(DialogInterface dialog, int id) {
                        return;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }*/
}
