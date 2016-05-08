package com.epustovit.lesson3;


import android.app.Activity;
import android.content.res.AssetManager;
import android.os.Bundle;
import android.widget.TextView;

import java.io.IOException;
import java.io.InputStream;


public class MainActivity extends Activity {

    public final String FILE_NAME = "programmers_cat.txt";

    

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        TextView txtFileName = (TextView)findViewById(R.id.txtFileName);

        AssetManager assetManager = getAssets();

        // to load text file
        InputStream input;
        try{
            input = assetManager.open(FILE_NAME);

            int size = input.available();
            byte[] buffer = new byte[size];
            input.read(buffer);
            input.close();

            // byte buffer into a string
            String text = new String(buffer);

            txtFileName.setText(text);
        }catch (IOException e){
            e.printStackTrace();
        }

    }


}
