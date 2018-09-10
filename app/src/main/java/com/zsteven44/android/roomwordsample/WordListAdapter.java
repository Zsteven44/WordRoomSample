package com.zsteven44.android.roomwordsample;

import android.content.Context;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import java.util.List;

public class WordListAdapter extends RecyclerView.Adapter<WordListAdapter.WordViewHolder> {


    class WordViewHolder extends RecyclerView.ViewHolder {
        private final TextView wordItemView;

        private WordViewHolder(@NonNull final View itemView) {
            super(itemView);
            wordItemView = itemView.findViewById(R.id.textView);
        }

    }

    private final LayoutInflater mInflater;
    private List<Word> mWords;

    WordListAdapter(@NonNull final Context context) {
        mInflater = LayoutInflater.from(context);
    }

    @NonNull
    public WordViewHolder onCreateViewHolder(@NonNull final ViewGroup parent,
                                             final int viewType) {
        View itemView = mInflater.inflate(R.layout.recyclerview_item,parent, false);
        return new WordViewHolder(itemView);
    }

    @Override
    public void onBindViewHolder(@NonNull final WordViewHolder holder,
                                 final int position) {
        if (mWords != null) {
            Word current = mWords.get(position);
            holder.wordItemView.setText(current.getWord());
        } else {
            holder.wordItemView.setText("No Word");
        }
    }

    void setWords(@NonNull final List<Word> words){
        mWords = words;
        notifyDataSetChanged();
    }

    public int getItemCount() {
        if (mWords != null)
            return mWords.size();
        else return 0;

    }
}
