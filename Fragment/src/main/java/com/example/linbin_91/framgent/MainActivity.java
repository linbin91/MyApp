package com.example.linbin_91.framgent;

import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v7.app.ActionBarActivity;
import android.util.Log;
import android.widget.Button;


public class MainActivity extends ActionBarActivity {

    private static final String TAG = "FramentOne";
    private Button id_bt;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Log.i(TAG, "MainActivity --- onCreate");
        setDefaultFragment();
    }

    private void setDefaultFragment() {
        Fragment fragment = new FramentOne();
        android.support.v4.app.FragmentManager fragmentManager = getSupportFragmentManager();
        android.support.v4.app.FragmentTransaction transaction = fragmentManager.beginTransaction();

        transaction.add(R.id.id_fragment, fragment, "ONE");
        //transaction.addToBackStack(null);
        transaction.commit();

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.i(TAG,"MainActivity --- onStart");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.i(TAG,"MainActivity --- onResume");
    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.i(TAG,"MainActivity --- onStop");
    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.i(TAG,"MainActivity --- onPause");
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"MainActivity --- onDestroy");
    }
}
