package com.example.elena.fizzbuzz;

import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Elena on 8/28/2017.
 */

public class FizzBuzzAdapter extends android.support.v7.widget.RecyclerView.Adapter<FizzBuzzAdapter.FizzBuzzViewHolder> {
    private List<Object> mDataList;

    public void setData(List<Object> data){
        mDataList = data;
        notifyDataSetChanged();
    }

    @Override
    public FizzBuzzViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        Context context = parent.getContext();
        int layoutId = R.layout.list_item;
        LayoutInflater inflater = LayoutInflater.from(context);
        View view = inflater.inflate(layoutId, parent, false);
        return new FizzBuzzViewHolder(view);
    }

    @Override
    public void onBindViewHolder(FizzBuzzViewHolder holder, int position) {
        holder.textView.setText(mDataList.get(position).toString());
    }

    @Override
    public int getItemCount() {
        if (mDataList == null)
            return 0;
        return mDataList.size();
    }

    public class FizzBuzzViewHolder extends RecyclerView.ViewHolder{
        TextView textView;

        public FizzBuzzViewHolder(View itemView) {
            super(itemView);
            textView = (TextView)itemView.findViewById(R.id.text_view);
        }
    }
}
