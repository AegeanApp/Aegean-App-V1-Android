package com.aegeanapp.george.test_aegean_app;

import android.content.ActivityNotFoundException;
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
import android.widget.Toast;


public class MainPage extends ActionBarActivity {

    private View v;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main_page);
        getSupportActionBar().setTitle("Aegean App");
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_main_page, menu);
        return true;
    }

    @Override
    public void onBackPressed() {
        finish();
    }

    public void imageOnClick(View v) {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://www.aegean.gr"));
        startActivity(browserIntent);
    }

    public void icsdOnClick(View v) {
        Intent i = new Intent(this, icsd_page.class);
        startActivity(i);
    }

    public void sitisiOnClick(View v) {
        Intent s = new Intent(this, Sitisi.class);
        startActivity(s);
    }

    public void saxmOnClick(View v) {
        Intent i = new Intent(this, saxm_page.class);
        startActivity(i);
    }

    public void mathOnClick(View v) {
        Intent i = new Intent(this, math_page.class);
        startActivity(i);
    }

    public void mapsClick(View v) {
        //
        int locationMode = Settings.Secure.getInt(
                getContentResolver(),
                Settings.Secure.LOCATION_MODE,
                Settings.Secure.LOCATION_MODE_OFF // Default value if not found
        );

        if (locationMode == Settings.Secure.LOCATION_MODE_OFF) {
            Dialog("Η χρήση της τοποθεσίας σας δεν είναι ενεργή");
        } else {
            Intent i = new Intent(this, MapsActivity.class);
            startActivity(i);
        }

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();
        //When Product action item is clicked
        if (id == R.id.rate) {

            Uri uri = Uri.parse("market://details?id=" + this.getPackageName());
            Intent goToMarket = new Intent(Intent.ACTION_VIEW, uri);
            // To count with Play market backstack, After pressing back button,
            // to taken back to our application, we need to add following flags to intent.
            goToMarket.addFlags(Intent.FLAG_ACTIVITY_NO_HISTORY |
                    Intent.FLAG_ACTIVITY_NEW_DOCUMENT |
                    Intent.FLAG_ACTIVITY_MULTIPLE_TASK);
            try {
                startActivity(goToMarket);
            } catch (ActivityNotFoundException e) {
                startActivity(new Intent(Intent.ACTION_VIEW,
                        Uri.parse("http://play.google.com/store/apps/details?id=" + this.getPackageName())));
            }

        }
        //When Search action item is clicked
        else if (id == R.id.contact) {

            Intent i = new Intent(Intent.ACTION_SEND);
            i.setType("message/rfc822");
            i.putExtra(Intent.EXTRA_EMAIL, new String[]{"georgemakrakis88@gmail.com","arg95ful@gmail.com","aegean_app@hotmail.com"});
            i.putExtra(Intent.EXTRA_SUBJECT, "AegeanApp_Feedback");
            try {
                startActivity(Intent.createChooser(i, "Send mail..."));
            } catch (android.content.ActivityNotFoundException ex) {
                Toast.makeText(MainPage.this, "There are no email clients installed.", Toast.LENGTH_SHORT).show();
            }

        }
             //When About action item is clicked
        else if (id == R.id.about)
        {
            Intent i = new Intent(MainPage.this,AboutPage.class);
            startActivity(i);
        }
        return super.onOptionsItemSelected(item);
    }

    public void Dialog(String msg) {
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
    }
}
