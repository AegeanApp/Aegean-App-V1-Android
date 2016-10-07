package com.example.george.test_aegean_app;

import android.content.DialogInterface;
import android.content.Intent;
import android.net.Uri;
import android.provider.Settings;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.support.v7.app.AlertDialog;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;


public class MainPage extends ActionBarActivity
{

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().setTitle("Aegean App");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }
    @Override
    public void onBackPressed()
    {
        finish();
    }
    public void imageOnClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aegean.gr"));
        startActivity(browserIntent);
    }

    public void icsdOnClick(View v)
    {
        Intent i = new Intent(this, icsd_page.class);
        startActivity(i);
    }

    public void sitisiOnClick(View v)
    {
        Intent s = new Intent(this, Sitisi.class);
        startActivity(s);
    }

    public void saxmOnClick(View v)
    {
        Intent i = new Intent(this, saxm_page.class);
        startActivity(i);
    }

    public void mathOnClick(View v)
    {
        Intent i = new Intent(this, math_page.class);
        startActivity(i);
    }

    public void mapsClick(View v)
    {
        //
        int locationMode = Settings.Secure.getInt(
                getContentResolver(),
                Settings.Secure.LOCATION_MODE,
                Settings.Secure.LOCATION_MODE_OFF // Default value if not found
        );

        if (locationMode == Settings.Secure.LOCATION_MODE_OFF)
        {
            Dialog("Η χρήση της τοποθεσίας σας δεν είναι ενεργή");
        }
        else
        {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == R.id.action_settings)
        {
            return true;
        }

        return super.onOptionsItemSelected(item);
    }

    public void Dialog(String msg)
    {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage(msg)
                .setCancelable(false)
                .setPositiveButton("OK", new DialogInterface.OnClickListener()
                {
                    //exits the application
                    public void onClick(DialogInterface dialog, int id)
                    {
                        return;
                    }
                });
        AlertDialog alert = builder.create();
        alert.show();
    }
}
