package com.example.linbin_91.festival.fragment;

import android.content.Intent;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.GridView;
import android.widget.TextView;

import com.example.linbin_91.festival.ChooseMessageActivity;
import com.example.linbin_91.festival.R;
import com.example.linbin_91.festival.bean.Festival;
import com.example.linbin_91.festival.bean.FestivalUtil;

/**
 * Created by linbin_91 on 2015/10/17.
 */
public class FestivalFragment  extends Fragment{
    private GridView mGridView;
    private LayoutInflater mInflater;
    private ArrayAdapter<Festival> mAdapter;
    @Nullable
    @Override
    public View onCreateView(LayoutInflater inflater,  ViewGroup container,  Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_festival,container,false);
        return  view;
    }

    @Override
    public void onViewCreated(final View view, @Nullable Bundle savedInstanceState) {
        super.onViewCreated(view, savedInstanceState);
        mInflater = LayoutInflater.from(getActivity());
        mGridView = (GridView) view.findViewById(R.id.id_gv_festival);
        mGridView.setAdapter(mAdapter = new ArrayAdapter<Festival>(getActivity(),-1, FestivalUtil.getInstance().getFestivals()){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = mInflater.inflate(R.layout.festival_item,parent,false);
                }

                TextView tv = (TextView) convertView.findViewById(R.id.id_tv_festival_name);
                tv.setText(getItem(position).getName());

                return  convertView;

            }
        });

        mGridView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                //int id =
                Intent intent = new Intent(getActivity(), ChooseMessageActivity.class);
                intent.putExtra("festival_id",mAdapter.getItem(position).getId());
                startActivity(intent);
            }
        });
    }
}
