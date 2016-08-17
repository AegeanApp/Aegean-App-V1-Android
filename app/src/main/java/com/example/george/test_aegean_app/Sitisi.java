package com.example.george.test_aegean_app;

import android.content.Intent;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Spinner;


public class Sitisi extends ActionBarActivity {
    private Spinner dropdown;
    private Spinner dropdown2;
    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sitisi);
        getSupportActionBar().setTitle("Πρόγραμμα Σίτισης");//setting title in actionBar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//energopoiisi tou back button

        dropdown = (Spinner)findViewById(R.id.list1);
        dropdown2 = (Spinner)findViewById(R.id.list2);
        //1h lista gia ebdomades
        String[] items = new String[]{"1η Εβδομάδα", "2η Εβδομάδα", "3η Εβδομάδα","4η Εβδομάδα"};
        ArrayAdapter<String> adapter = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items);
        dropdown.setAdapter(adapter);
        //2h lista gia ebdomades
        String[] items2 = new String[]{"Μεσημεριανό", "Βραδινό"};
        ArrayAdapter<String> adapter2 = new ArrayAdapter<>(this, android.R.layout.simple_spinner_item, items2);
        dropdown2.setAdapter(adapter2);
    }
    private String val_list1;
    private String val_list2;
    public void okOnClick(View v)
    {
        val_list1 = (String) dropdown.getSelectedItem();
        val_list2 = (String)dropdown2.getSelectedItem();
        if(val_list1.equals("1η Εβδομάδα") && val_list2.equals("Βραδινό"))
        {
            Intent i =new Intent(this,proti_ebdomada_brady.class);
            startActivity(i);
        }
        else if(val_list1.equals("1η Εβδομάδα") && val_list2.equals("Μεσημεριανό"))
        {
            Intent i =new Intent(this,proti_ebdomada_mesimeri.class);
            startActivity(i);
        }
        else if(val_list1.equals("2η Εβδομάδα") && val_list2.equals("Μεσημεριανό"))
        {
            Intent i =new Intent(this,deuteri_ebomaxa_mesimeri.class);
            startActivity(i);
        }
        else if(val_list1.equals("2η Εβδομάδα") && val_list2.equals("Βραδινό"))
        {
            Intent i =new Intent(this,deuteri_ebdomada_brady.class);
            startActivity(i);
        }
        else if(val_list1.equals("3η Εβδομάδα") && val_list2.equals("Μεσημεριανό"))
        {
            Intent i =new Intent(this,triti_ebdomada_mesimeri.class);
            startActivity(i);
        }
        else if(val_list1.equals("3η Εβδομάδα") && val_list2.equals("Βραδινό"))
        {
            Intent i =new Intent(this,triti_ebdomada_brady.class);
            startActivity(i);
        }
        else if(val_list1.equals("4η Εβδομάδα") && val_list2.equals("Μεσημεριανό"))
        {
            Intent i =new Intent(this,tetarti_ebdomada_mesimeri.class);
            startActivity(i);
        }
        else if(val_list1.equals("4η Εβδομάδα") && val_list2.equals("Βραδινό"))
        {
            Intent i =new Intent(this,tetarti_ebdomada_brady.class);
            startActivity(i);
        }
    }
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_sitisi, menu);
        return true;
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id==android.R.id.home) {
            finish();//na mporei to back button na paei pisw
        }

        return super.onOptionsItemSelected(item);
    }
}
