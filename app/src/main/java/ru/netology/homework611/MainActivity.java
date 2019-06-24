package ru.netology.homework611;

import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;

import android.content.DialogInterface;
import android.os.Bundle;
import android.util.Log;
import android.view.KeyEvent;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView ourText;
    private static final String TAG = "Lifecycle";
    EditText ourEdit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.d(TAG, "OnCreate" + this);
        ourText = (TextView) findViewById(R.id.our_text);
        ourText.append("\n OnCreate");
        ourEdit = (EditText)findViewById(R.id.edit_text);
    }

    protected void onPostCreate(Bundle savedInstanceState) {
        super.onPostCreate(savedInstanceState);
        Log.d(TAG, "OnPostCreate" + this);
        ourText.append(" OnPostCreate");
    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.d(TAG, "OnStart" + this);
        ourText.append("\n OnStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.d(TAG, "OnResume" + this);
        ourText.append("\n OnResume");
    }

    protected void onPostResume() {
        super.onPostResume();
        Log.d(TAG, "OnPostResume" + this);
        ourText.append(" OnPostResume");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.d(TAG, "OnPause" + this);
        ourText.append("\n OnPause");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.d(TAG, "OnStop" + this);
        ourText.append("\n OnStop");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.d(TAG, "OnDestroy" + this);
        ourText.append("\n OnDestroy");
    }

    @Override
    public void onBackPressed() {
        Log.d(TAG,"OnBackPress"+this);
       String text = ourEdit.getText().toString();
        if(text.isEmpty()){
            finish();}
            else{
        new AlertDialog.Builder(MainActivity.this)
                .setMessage("Are you sure you want to exit?")
                .setNegativeButton("cancel", null)
                .setPositiveButton("exit", new DialogInterface.OnClickListener() {
                            @Override
                            public void onClick(DialogInterface dialog, int which) {
                            finish();
                            }
                        }
                )
                .show();
    }
    }
    public boolean onKeyLongPress(int keyCode, KeyEvent event){
        super.onKeyLongPress(keyCode, event);
        ourText.append("\n LongPress"+this);
        Log.d(TAG,"OnKeyLongPress"+this);
        return onKeyLongPress(keyCode,event);
    }
       public boolean onKeyDown(int keyCode, KeyEvent event){
           ourText.append("\n KeyCode"+keyCode);
        super.onKeyDown(keyCode, event);
        Log.d(TAG, "OnKeyCode"+this);
        return onKeyDown(keyCode, event);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        String text = ourEdit.getText().toString();
        Log.d(TAG,"OnSaveInstanceState"+this);
        outState.putString("Saved text", text);
        super.onSaveInstanceState(outState);
    }
    @Override
    protected void onRestoreInstanceState(Bundle savedInstanceState) {
        String text;
        Log.d(TAG,"OnRestoreInstanceState"+this);
        super.onRestoreInstanceState(savedInstanceState);
        text = savedInstanceState.getString("Saved text");
        ourEdit.setText(text);
    }
}
