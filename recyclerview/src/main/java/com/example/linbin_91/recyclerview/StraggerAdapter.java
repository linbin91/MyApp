package com.example.linbin_91.recyclerview;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by linbin_91 on 2015/10/28.
 */
public class StraggerAdapter extends RecyclerView.Adapter<StraggerAdapter.StraggerViewHoder>{

    private Context context;
    private List<String> mDatas;
    private LayoutInflater mInflater;
    private List<Integer> mHeights;

    public StraggerAdapter(Context context, List<String> mDatas) {
        this.context = context;
        this.mDatas = mDatas;
        mInflater = LayoutInflater.from(context);

        mHeights = new ArrayList<Integer>();
        for (int i = 0; i < mDatas.size(); i++){
            mHeights.add((int) (100 + Math.random() * 300));
        }
    }

    public  interface  OnClickListener{
        public  void onClickListener(View view, int pos);
        public  void onLongClickListener(View view, int pos);
    }

    public  OnClickListener mOnClickListener;

    public  void setOnClickListener(OnClickListener listener){
        this.mOnClickListener = listener;
    }
    @Override
    public StraggerViewHoder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = mInflater.inflate(R.layout.item,parent,false);

        return new StraggerViewHoder(view);
    }

    @Override
    public int getItemCount() {
        return mDatas.size();
    }

    @Override
    public void onBindViewHolder(final StraggerViewHoder holder, final int position) {
        ViewGroup.LayoutParams lp = holder.itemView.getLayoutParams();
        lp.height = mHeights.get(position);
        holder.itemView.setLayoutParams(lp);
        holder.tv.setText(mDatas.get(position));

        if (mOnClickListener != null){
            holder.itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int pos = holder.getLayoutPosition();
                    mOnClickListener.onClickListener(holder.itemView, pos);
                }
            });

            holder.itemView.setOnLongClickListener(new View.OnLongClickListener() {
                @Override
                public boolean onLongClick(View v) {
                    int pos = holder.getLayoutPosition();
                       mOnClickListener.onLongClickListener(holder.itemView,pos);
                    return false;
                }
            });
        }

    }

    class  StraggerViewHoder extends RecyclerView.ViewHolder{

        public TextView tv;
        public StraggerViewHoder(View itemView) {
            super(itemView);

            tv = (TextView) itemView.findViewById(R.id.id_tv);
        }
    }


    public  void addData(int pos){
        mDatas.add(pos,"insert one");
        notifyItemInserted(pos);
    }

    public  void removeData(int pos){
        mDatas.remove(pos);
        notifyItemRemoved(pos);
    }
}
