package batch16.android.devf.com.retrofitmodels.api;

import android.content.Context;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;


/**
 * Created by Dagorik on 05/10/17.
 */

public class ServiceGenerator {

    private static Retrofit retrofit;

    private static Retrofit.Builder builder =
            new Retrofit.Builder()
                    .addConverterFactory(GsonConverterFactory.create())
                    .baseUrl("https://goodreads-devf-aaron.herokuapp.com");

    public static ServicesInterface createService() {

        if (retrofit == null) {
            retrofit = builder.build();
        }

        return retrofit.create(ServicesInterface.class);
    }

}
