package com.sebanes.sebanes_labexer3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;

public class MainActivity2 extends AppCompatActivity {

    TextView tvFile, tvData;
    EditText etFilename;
    SharedPreferences sharedPreferences;
    FileInputStream fis;
    String data;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvFile = (TextView) findViewById(R.id.tvFile);
        tvData = (TextView) findViewById(R.id.tvData);
        etFilename = (EditText) findViewById(R.id.etFilename);

        data = getIntent().getStringExtra("filename");

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_WORLD_READABLE);
    }

    public void loadSharedPreference(View view) {
        String file = sharedPreferences.getString("filename", "");
        String data = sharedPreferences.getString("data", "");

        tvFile.setText(file);
        tvData.setText(data);
    }

    public void loadInternalStorage(View view) {
        StringBuffer sb = new StringBuffer();
        int read = 0;

        try {
            fis = openFileInput(data);
            while((read = fis.read()) != -1) {
                sb.append((char)read);
            }
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvFile.setText(data);
        tvData.setText(sb.toString());
    }

    public void loadInternalCache(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput(data);
            while((read = fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvFile.setText(data);
        tvData.setText(buffer.toString());
    }

    public void loadExternalCache(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput(data);
            while((read = fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvFile.setText(data);
        tvData.setText(buffer.toString());
    }

    public void loadExternalStorage(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput(data);
            while((read = fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvFile.setText(data);
        tvData.setText(buffer.toString());
    }

    public void loadExternalPubStor(View view) {
        StringBuffer buffer = new StringBuffer();
        int read = 0;
        try {
            fis = openFileInput(data);
            while((read = fis.read()) != -1) {
                buffer.append((char)read);
            }
            fis.close();
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }

        tvFile.setText(data);
        tvData.setText(buffer.toString());
    }

    public void previous(View view) {
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
    }
}
