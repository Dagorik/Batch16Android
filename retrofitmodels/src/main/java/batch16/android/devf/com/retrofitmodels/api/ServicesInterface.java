package batch16.android.devf.com.retrofitmodels.api;

import java.util.List;

import batch16.android.devf.com.retrofitmodels.models.Author;
import retrofit2.Call;
import retrofit2.http.Body;
import retrofit2.http.GET;
import retrofit2.http.POST;

/**
 * Created by Dagorik on 05/10/17.
 */

public interface ServicesInterface {

    @GET("/api/v1/authors")
    Call<List<Author>> getAllAuthors();

    @POST("/api/v1/authors/")
    Call<Author> createAuthor(@Body Author author);

}
