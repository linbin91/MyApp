package com.example.linbin_91.framgent;

import android.app.Activity;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created by linbin_91 on 2015/10/16.
 */
public class FragmentTwo extends Fragment {

    private static final String TAG = "FramentOne";

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        Log.i(TAG, "super.onAttach(activity)22;");
    }

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        Log.i(TAG,"super.onCreate(savedInstanceState22");
    }

    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragmenttwo,container,false);
        Log.i(TAG,"super.onCreateView)22");
        return view;
    }

    @Override
    public void onActivityCreated(Bundle savedInstanceState) {
        super.onActivityCreated(savedInstanceState);
        Log.i(TAG,"onActivityCreated22");
    }

    @Override
    public void onStart() {
        super.onStart();
        Log.i(TAG,"onStart22");
    }

    @Override
    public void onResume() {
        super.onResume();
        Log.i(TAG,"onResume22");
    }

    @Override
    public void onPause() {
        super.onPause();

        Log.i(TAG,"onPause22");
    }

    @Override
    public void onStop() {
        super.onStop();
        Log.i(TAG,"onStop22");
    }

    @Override
    public void onDestroyView() {
        super.onDestroyView();
        Log.i(TAG,"onDestroyView22");
    }

    @Override
    public void onDestroy() {
        super.onDestroy();
        Log.i(TAG,"onDestroy22");
    }

    @Override
    public void onDetach() {
        super.onDetach();
        Log.i(TAG,"onDetach22");
    }
}
