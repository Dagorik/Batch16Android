package batch16.android.devf.com.retrofitmodels.models;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

/**
 * Created by Dagorik on 06/10/17.
 */

public class Book {

    @SerializedName("title")
    @Expose
    private String title;
    @SerializedName("isbn")
    @Expose
    private String isbn;
    @SerializedName("prologue")
    @Expose
    private String prologue;
    @SerializedName("author")
    @Expose
    private int author;
    @SerializedName("date_published")
    @Expose
    private String datePublished;
    @SerializedName("url_cover")
    @Expose
    private String urlCover;

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getIsbn() {
        return isbn;
    }

    public void setIsbn(String isbn) {
        this.isbn = isbn;
    }

    public String getPrologue() {
        return prologue;
    }

    public void setPrologue(String prologue) {
        this.prologue = prologue;
    }

    public int getAuthor() {
        return author;
    }

    public void setAuthor(int author) {
        this.author = author;
    }

    public String getDatePublished() {
        return datePublished;
    }

    public void setDatePublished(String datePublished) {
        this.datePublished = datePublished;
    }

    public String getUrlCover() {
        return urlCover;
    }

    public void setUrlCover(String urlCover) {
        this.urlCover = urlCover;
    }

    @Override
    public String toString() {
        return "Book{" +
                "title='" + title + '\'' +
                ", isbn='" + isbn + '\'' +
                ", prologue='" + prologue + '\'' +
                ", author=" + author +
                ", datePublished='" + datePublished + '\'' +
                ", urlCover='" + urlCover + '\'' +
                '}';
    }
}
