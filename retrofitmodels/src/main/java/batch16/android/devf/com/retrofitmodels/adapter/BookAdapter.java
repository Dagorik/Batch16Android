package batch16.android.devf.com.retrofitmodels.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.squareup.picasso.Picasso;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.retrofitmodels.R;
import batch16.android.devf.com.retrofitmodels.models.Book;

/**
 * Created by Dagorik on 06/10/17.
 */

public class BookAdapter extends RecyclerView.Adapter<BookAdapter.BookViewHolder>{

    List<Book> bookList = new ArrayList<>();

    public BookAdapter(List<Book> bookList) {
        this.bookList = bookList;
    }

    @Override
    public BookViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_book,parent,false);
        return new BookViewHolder(view);
    }

    @Override
    public void onBindViewHolder(BookViewHolder bookViewholder, int position) {
        Book book = bookList.get(position);
        bookViewholder.tvTitle.setText(book.getTitle());
        bookViewholder.tvDate.setText(book.getDatePublished());
        bookViewholder.pintarImagenDesdeUnaURL(book.getUrlCover());
    }

    @Override
    public int getItemCount() {
        return bookList.size();
    }

    public class BookViewHolder extends RecyclerView.ViewHolder {
        public TextView tvTitle, tvDate;
        public ImageView iv_picasso;
        public Context context;

        public BookViewHolder(View itemView) {
            super(itemView);
            tvTitle = (TextView) itemView.findViewById(R.id.tv_title);
            tvDate = (TextView) itemView.findViewById(R.id.tv_date);
            iv_picasso = (ImageView) itemView.findViewById(R.id.iv_book);
            context = itemView.getContext();
        }

        public void pintarImagenDesdeUnaURL(String url){
            Picasso.with(context).load(url).into(iv_picasso);
        }
    }
}
