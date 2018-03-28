package com.example.user.bestfriends.books;


import android.content.Context;
import android.content.Intent;
import android.net.Uri;
import android.support.annotation.NonNull;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.user.bestfriends.R;

import java.util.ArrayList;
import java.util.List;

public class BooksAdapter extends RecyclerView.Adapter<BooksAdapter.BooksHolder> {

    private final Context context;
    private ArrayList<Books> listBooks = new ArrayList<>();

    public BooksAdapter(Context context) { this.context = context; }

    @NonNull
    @Override
    public BooksHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_list_books, parent, false);
        return new BooksHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull BooksHolder holder, int position) {
        holder.icon_books.setImageResource(listBooks.get(position).getIcon_books());
        holder.name_books.setText(listBooks.get(position).getName_books());
        holder.listBooksLayout.setOnClickListener(v -> {
            final String website = this.listBooks.get(position).getWebsite();
            Intent browserIntent = new Intent(Intent.ACTION_VIEW, Uri.parse(website));
            context.startActivity(browserIntent);
//            Toast.makeText(context, listBooks.get(position).toString(), Toast.LENGTH_SHORT).show(); "https://drive.google.com/open?id=1Ama-V0GgW2Quw5Ydrit3hyOOYT54uvKb"

        });
    }

    public BooksAdapter(Context context, ArrayList<Books> listBooks){
        this.context = context;
        this.listBooks = listBooks;
    }

    @Override
    public int getItemCount() {
        return listBooks.size();
    }

    public void setListBooks(List<Books> list) {
        listBooks.clear();
        listBooks.addAll(list);
        notifyDataSetChanged();
    }

    public static class BooksHolder extends RecyclerView.ViewHolder {
        ImageView icon_books;
        TextView name_books;
        RelativeLayout listBooksLayout;

        public BooksHolder(View view) {
            super(view);
            icon_books = view.findViewById(R.id.icon_books);
            name_books = view.findViewById(R.id.name_book);
            listBooksLayout = view.findViewById(R.id.listBooksLayout);
        }
    }
}
