package com.hcmus.trello.board_screen;

import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;
import com.hcmus.trello.R;
import java.util.ArrayList;

public class MyListAdapter extends  RecyclerView.Adapter<MyListAdapter.ListViewHolder>{

    private static final String TAG = "MyListAdapter";

    private ArrayList<String> mListName;
    private OnItemListener mOnItemListener;

    public MyListAdapter(ArrayList<String> mListName, OnItemListener mOnItemListener) {
        Log.d(TAG, "MyListAdapter: ");
        this.mListName = mListName;
        this.mOnItemListener = mOnItemListener;
    }
    public void setData(ArrayList<String> list)
    {
        mListName = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public ListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        Log.d(TAG, "onCreateViewHolder: ");
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_list, parent, false);
        return new ListViewHolder(view, mOnItemListener);
    }

    @Override
    public void onBindViewHolder(@NonNull ListViewHolder holder, int position) {
        String name = mListName.get(position);
        Log.d(TAG, "onBindViewHolder: " + name);
        holder.tvListName.setText(name);
    }

    @Override
    public int getItemCount() {
        Log.d(TAG, "getItemCount: ");
        if(mListName != null)
            return mListName.size();
        return 0;
    }

    public class ListViewHolder extends RecyclerView.ViewHolder implements View.OnClickListener {
        private ImageView ivStar;
        private TextView tvListName;
        private ImageView ivMoreHoriz;
        private OnItemListener onItemListener;
        public ListViewHolder(@NonNull View itemView, OnItemListener listener) {

            super(itemView);
            Log.d(TAG, "ListViewHolder: ");
            onItemListener = listener;
            ivStar = itemView.findViewById(R.id.iv_star);
            tvListName = itemView.findViewById(R.id.tv_listName);
            ivMoreHoriz = itemView.findViewById(R.id.iv_morehoriz);

            ivStar.setOnClickListener(this);
            ivMoreHoriz.setOnClickListener(this);
            tvListName.setOnClickListener(this);
        }

        @Override
        public void onClick(View v) {
            if (v.getId() == ivStar.getId())
                onItemListener.onStarClick(getAdapterPosition());
            if (v.getId() == ivMoreHoriz.getId())
                onItemListener.onMoreHorizClick(getAdapterPosition());
            if(v.getId() == tvListName.getId())
                onItemListener.onListNameClick(getAdapterPosition());
        }
    }

    interface OnItemListener{
        void onStarClick(int position);
        void onMoreHorizClick(int position);
        void onListNameClick(int position);
    }
}
