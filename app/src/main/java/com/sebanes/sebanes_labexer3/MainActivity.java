package com.sebanes.sebanes_labexer3;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Environment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileOutputStream;
import java.io.IOException;

public class MainActivity extends AppCompatActivity {
    EditText etData, etFilename;
    SharedPreferences sharedPreferences;
    FileOutputStream fos;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        etData = (EditText) findViewById(R.id.etData);
        etFilename = (EditText) findViewById(R.id.etFilename);

        sharedPreferences = getSharedPreferences("preferences", Context.MODE_WORLD_READABLE);
    }

    public void saveSharedPreference(View view) {
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString("data", etData.getText().toString());
        editor.putString("filename", etFilename.getText().toString());
        editor.commit();
        Toast.makeText(this, "Successfully written in shared preference", Toast.LENGTH_LONG).show();
    }

    public void saveInternalStorage(View view) {
        String message = etData.getText().toString();

        try {
            fos = openFileOutput(etFilename.getText().toString(), Context.MODE_PRIVATE);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        }
        Toast.makeText(this, "Successfully written in internal storage.", Toast.LENGTH_LONG).show();
    }

    public void saveInternalCache(View view) {
        File folder = getCacheDir();
        File file = new File(folder, etFilename.getText().toString());
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to internal cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalCache(View view) {
        File folder = getExternalCacheDir();
        File file = new File(folder, etFilename.getText().toString());
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external cache", Toast.LENGTH_LONG).show();
    }

    public void saveExternalStorage(View view) {
        File folder = getExternalFilesDir("temp");
        File file = new File(folder, etFilename.getText().toString());
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external storage", Toast.LENGTH_LONG).show();
    }

    public void saveExternalPubStor(View view) {
        File folder = Environment.getExternalStoragePublicDirectory(Environment.DIRECTORY_DOWNLOADS);
        File file = new File(folder, etFilename.getText().toString());
        String message = etData.getText().toString();
        FileOutputStream fos = null;
        try {
            fos = new FileOutputStream(file);
            fos.write(message.getBytes());
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        } catch (IOException e) {
            e.printStackTrace();
        } finally {
            try {
                fos.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
        Toast.makeText(this, "Successfully written to external public storage", Toast.LENGTH_LONG).show();
    }

    public void next(View view) {
        Intent intent = new Intent(this, MainActivity2.class);
        intent.putExtra("filename", etFilename.getText().toString());
        startActivity(intent);
    }
}
