package com.example.android.io2014;

import android.os.Bundle;
import android.support.v7.app.ActionBarActivity;
import android.widget.TextView;

public class About extends ActionBarActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);


        TextView tv=(TextView)findViewById(R.id.contact);
        tv.setText("  ABOUT ME" +"\n"  +"\n" +"I am a young,  vibrant and hardworking lady, always eager to learn and increase my knowledge and skills set.I am studying towards  a National Diploma in Information Technology\n" +
                "(Technical Applications) from Tshwane University of Technology.An aspiring Applications Developer"  +"\n"+ "\n"+ "Skilled sets"+"\n"+
                "Research,Web applications development,Progressive web applications,Firebase,C++,JavaScript,HTML and CSS, Java,JSON, Android, SQL,PL\\SQL.");


    }
}
