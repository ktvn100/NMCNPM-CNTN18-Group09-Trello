package com.hcmus.trello;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.FrameLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;


public class RecycleViewAdapterCard extends RecyclerView.Adapter<RecycleViewAdapterCard.CardHolder> {
    Context context;
    List list;

    public RecycleViewAdapterCard(Context context, List list)
    {
        this.list = list;
        this.context = context;
    }

    public class CardHolder extends RecyclerView.ViewHolder {
        TextView mCardName;
        Button btn_del;
        FrameLayout fl_card;

        public CardHolder(@NonNull View itemView) {
            super(itemView);
            mCardName = (TextView) itemView.findViewById(R.id.card_name);
            btn_del = (Button) itemView.findViewById(R.id.delete_card);
            fl_card = (FrameLayout) itemView.findViewById(R.id.card);

            btn_del.setOnClickListener(new View.OnClickListener(){
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    list.deleteCard(list.getCard(position));
                    RecycleViewAdapterCard.this.notifyDataSetChanged();
                }
            });

            fl_card.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    Card card = list.getCard(position);
                    Intent intent = new Intent(context, CardActivity.class);
                    intent.putExtra("MyCard", card);
                    context.startActivity(intent);
                }
            });
        }
    }

    @NonNull
    @Override
    public CardHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.card_item, parent, false);
        return new CardHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardHolder holder, int position) {
        holder.mCardName.setText(list.getCard(position).getName());
    }

    @Override
    public int getItemCount() {
        return list.getCountCard();
    }


}
