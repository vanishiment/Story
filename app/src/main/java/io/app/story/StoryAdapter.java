package io.app.story;

import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class StoryAdapter extends RecyclerView.Adapter<StoryAdapter.VH>{

    List<String> mData;

    public StoryAdapter() {

        mData = new ArrayList<>();
        for (int i = 0; i < 30; i++) {
            mData.add(String.valueOf(i));
        }

    }

    @Override
    public VH onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.story_item,parent,false);
        return new VH(view);
    }

    @Override
    public void onBindViewHolder(VH holder, int position) {

    }

    @Override
    public int getItemCount() {
        return mData.size();
    }

    static class VH extends RecyclerView.ViewHolder{

        VH(View itemView) {
            super(itemView);
        }
    }
}
