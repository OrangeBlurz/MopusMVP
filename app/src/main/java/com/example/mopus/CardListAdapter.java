package com.example.mopus;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

public class CardListAdapter extends RecyclerView.Adapter<CardListAdapter.CardListViewHolder> {
    private List<FFTCGCard> cardList = new ArrayList<>();

    @NonNull
    @Override
    public CardListViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext())
                .inflate(R.layout.card_list_item, parent, false);
        return new CardListViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CardListViewHolder holder, int position) {
        FFTCGCard card = cardList.get(position);
        holder.cardName.setText(card.getName());
        holder.cardCost.setText(card.getCost());
        holder.cardType.setText(card.getType());
        holder.cardJob.setText(card.getJob());
        holder.cardSet.setText(card.getSet());
        holder.cardText.setText(card.getText());
        holder.cardRarity.setText(card.getRarity());
        holder.cardPower.setText(card.getPower());
    }

    @Override
    public int getItemCount() {
        return cardList.size();
    }

    public void setCardList(List<FFTCGCard> cardList) {
        this.cardList = cardList;
        notifyDataSetChanged();
    }

    class CardListViewHolder extends RecyclerView.ViewHolder {
        TextView cardName;
        TextView cardCost;
        TextView cardType;
        TextView cardJob;
        TextView cardSet;
        TextView cardText;
        TextView cardRarity;
        TextView cardPower;
        public CardListViewHolder(@NonNull View itemView) {
            super(itemView);
            cardName = itemView.findViewById(R.id.card_name);
            cardCost = itemView.findViewById(R.id.card_cost);
            cardType = itemView.findViewById(R.id.card_type);
            cardJob = itemView.findViewById(R.id.card_job);
            cardSet = itemView.findViewById(R.id.card_set);
            cardText = itemView.findViewById(R.id.card_text);
            cardRarity = itemView.findViewById(R.id.card_rarity);
            cardPower = itemView.findViewById(R.id.card_power);

            itemView.setOnClickListener(new View.OnClickListener() {
                @Override
                public void onClick(View v) {
                    int position = getAdapterPosition();
                    if (listener != null && position != RecyclerView.NO_POSITION) {
                        listener.onClick(cardList.get(position));
                    }
                }
            });
        }
    }

    OnItemClickListener listener;
    public interface OnItemClickListener {
        void onClick(FFTCGCard card);
    }
    public void setListener(OnItemClickListener listener) {
        this.listener = listener;
    }
}
