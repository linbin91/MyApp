package com.example.linbin_91.festival;

import android.app.Activity;
import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.TextView;

import com.example.linbin_91.festival.bean.FestivalUtil;
import com.example.linbin_91.festival.bean.Message;

/**
 * Created by linbin_91 on 2015/10/17.
 */
public class ChooseMessageActivity extends Activity{
    private ListView mListView;
    private FloatingActionButton mActionButton;
    private  int mFestivalId;
    private LayoutInflater mInflater;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.choose_message);
        mFestivalId = getIntent().getIntExtra("festival_id",-1);
        initView();
        initEven();

    }

    private void initEven() {
        mActionButton.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {

            }
        });
    }

    private void initView() {
        mListView = (ListView) findViewById(R.id.id_lv_msgs);
        mActionButton = (FloatingActionButton) findViewById(R.id.id_toSend);
        mInflater = LayoutInflater.from(this);
        mListView.setAdapter(new ArrayAdapter<Message>(this,-1, FestivalUtil.getInstance().getmMegs(mFestivalId)){
            @Override
            public View getView(int position, View convertView, ViewGroup parent) {
                if (convertView == null){
                    convertView = mInflater.inflate(R.layout.item_msg,parent,false);
                }


                TextView content = (TextView) convertView.findViewById(R.id.id_tv_content);
                Button send = (Button) convertView.findViewById(R.id.id_bt_send);

                content.setText(getItem(position).getContent());
                send.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View v) {

                    }
                });
                return  convertView;
            }
        });
    }


}
