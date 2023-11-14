package com.example.quoteofthedayapp;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import java.util.List;

public class MyQuotesAdapter extends RecyclerView.Adapter<MyQuotesAdapter.ViewHolder> {


    private List<String> quotes;


    public MyQuotesAdapter(List<String> quotes) {
        this.quotes = quotes;
    }


    public void setQuotes(List<String> quotes) {
        this.quotes = quotes;
    }



    @NonNull
    @Override
    public ViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_quote, parent, false);
        return new ViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull ViewHolder holder, int position) {
        String quote = quotes.get(position);
        holder.itemQuoteTextView.setText(quote);

    }

    @Override
    public int getItemCount() {
        return quotes.size();
    }

    static class ViewHolder extends RecyclerView.ViewHolder {
        TextView itemQuoteTextView;



        ViewHolder(@NonNull View itemView) {
            super(itemView);
            itemQuoteTextView = itemView.findViewById(R.id.itemQuoteTextView);
        }
    }
}


















}
