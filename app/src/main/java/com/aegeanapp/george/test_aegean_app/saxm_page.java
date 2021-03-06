package com.aegeanapp.george.test_aegean_app;

import android.content.Intent;
import android.graphics.Paint;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;

public class saxm_page extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState)
    {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_saxm_page);
        getSupportActionBar().setDisplayHomeAsUpEnabled(true);//energopoiisi tou back button
        getSupportActionBar().setTitle("S.A.X.M.");//setting title in actionBar
        //underlining startp page texview
        TextView txt= (TextView)findViewById(R.id.start_page);
        txt.setPaintFlags(txt.getPaintFlags() | Paint.UNDERLINE_TEXT_FLAG);

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
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://eclass.aegean.gr"));
        startActivity(browserIntent);

    }
    public void icarusClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("https://sef.samos.aegean.gr/"));
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
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.actuar.aegean.gr"));
        startActivity(browserIntent);
    }
    public void searchPageClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.google.com"));
        startActivity(browserIntent);
    }
    public void MscClick(View v)
    {
        Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse("http://www.actuar.aegean.gr/postgraduate.html"));
        startActivity(browserIntent);
    }

    public void calClick(View v)
    {
        //Intent i = new Intent (this,cal_saxm.class);
        Intent i = new Intent (this , AcademaicCalendarPage.class);
        startActivity(i);

    }

    public void scheduleClick(View v)
    {
        Intent i=new Intent(Intent.ACTION_VIEW,Uri.parse("https://www.math.aegean.gr/images/articles/announcements/2017-2018/orologio%20programma_spring%20semester_actuar.pdf"));//here must be the link that host the pdf(pdf archive?)
      //  i.setType("application/pdf");
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
