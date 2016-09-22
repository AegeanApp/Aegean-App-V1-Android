package com.example.george.test_aegean_app;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;

public class tetarti_ebdomada_mesimeri extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tetarti_ebdomada_mesimeri);getSupportActionBar().setTitle("4η Εβδομάδα Μεσημεριανό");//allagi tou titlou sto actionbar
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//energopoiisi tou back button
    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
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
