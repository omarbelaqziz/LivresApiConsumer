package com.example.apconsumer;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.recyclerview.widget.RecyclerView;

import com.squareup.picasso.Picasso;

import java.util.List;

public class CustomAdapter extends BaseAdapter {
    private List<Book> booksList;
    private LayoutInflater layoutInflater;
    private Context context;

    public CustomAdapter(Context context, List<Book> booksList){
        this.context = context;
        this.booksList = booksList;
        layoutInflater = LayoutInflater.from(context);
    }

    @Override
    public int getCount() {
        return booksList.size();
    }

    @Override
    public Object getItem(int i) {
        return booksList.get(i);
    }

    @Override
    public long getItemId(int i) {
        return i;
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        ViewHolder viewHolder;
        if (view == null){
            view = layoutInflater.inflate(R.layout.books_list, null);
            viewHolder = new ViewHolder();
            viewHolder.image = (ImageView) view.findViewById(R.id.imageView);
            viewHolder.title = (TextView) view.findViewById(R.id.textView);
            viewHolder.author = (TextView) view.findViewById(R.id.textView2);
            view.setTag(viewHolder);
        }
        else {
            viewHolder = (ViewHolder) view.getTag();
        }
        Book item = this.booksList.get(i);
        viewHolder.title.setText(item.getTitle());
        viewHolder.author.setText(item.getAuthor());
        Picasso.with(context)
                .load(item.getCover())
                .into(viewHolder.image);
        return null;
    }

    static  class ViewHolder{
        ImageView image;
        TextView title;
        TextView author;
    }
}
