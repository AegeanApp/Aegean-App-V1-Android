package com.aegeanapp.george.test_aegean_app;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.ActionBarActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;


public class icsd_page extends ActionBarActivity
{

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);

        setContentView(R.layout.activity_icsd_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//energopoiisi tou back button
        getSupportActionBar().setTitle("I.C.S.D.");//setting title in actionBar
        //underlining startp page texview
        TextView txt = (TextView) findViewById(R.id.start_page);
        txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);


    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu)
    {
        // Inflate the menu; this adds items to the action bar if it is present.
        getMenuInflater().inflate(R.menu.menu_icsd_page, menu);
        return true;
    }

    private void copyFile(InputStream in, OutputStream out) throws IOException//taken from http://stackoverflow.com/questions/12889608/how-to-open-pdf-file-in-android-from-the-assets-folder?lq=1
    {
        byte[] buffer = new byte[1024];
        int read;
        while ((read = in.read(buffer)) != -1)
        {
            out.write(buffer, 0, read);
        }
    }

    public void eclassClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eclass.icsd.aegean.gr"));
        startActivity(browserIntent);

    }

    public void icarusClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://icarus-icsd.aegean.gr/"));
        startActivity(browserIntent);
    }

    public void mailClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://webmail.aegean.gr/owa/auth/logon.aspx?replaceCurrent=1&url=https%3a%2f%2fwebmail.aegean.gr%2fowa"));
        startActivity(browserIntent);
    }

    public void eudoxusClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://eudoxus.gr/"));
        startActivity(browserIntent);
    }

    public void startPageClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsd.aegean.gr/"));
        startActivity(browserIntent);
    }

    public void MscClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://msc.icsd.aegean.gr"));
        startActivity(browserIntent);
    }

    public void CalClick(View v)
    {
        //Intent i = new Intent(this, cal_icsd.class);
    Intent i = new Intent (this , AcademaicCalendarPage.class);
        startActivity(i);
    }

    public void scheduleClick(View v)
    {
        /*
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.icsd.aegean.gr/website_files/grammateia_files/announcements/339224911.pdf"));//here must be the link that host the pdf(pdf archive?)
        browserIntent.setType("application/pdf");
        startActivity(browserIntent);
        */

        Intent i = new Intent(Intent.ACTION_VIEW,Uri.parse("http://www.icsd.aegean.gr/website_files/grammateia_files/announcements/3943535.pdf"));
        startActivity(i);

    }

    @Override
    public boolean onOptionsItemSelected(MenuItem item)
    {
        // Handle action bar item clicks here. The action bar will
        // automatically handle clicks on the Home/Up button, so long
        // as you specify a parent activity in AndroidManifest.xml.
        int id = item.getItemId();

        //noinspection SimplifiableIfStatement
        if (id == android.R.id.home)
        {
            finish();//na mporei to back button na paei pisw
        }

        return super.onOptionsItemSelected(item);
    }
}
