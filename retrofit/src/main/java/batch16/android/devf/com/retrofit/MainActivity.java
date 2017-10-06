package batch16.android.devf.com.retrofit;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import org.json.JSONException;
import org.json.JSONObject;

import java.io.IOException;
import java.lang.reflect.Proxy;

import okhttp3.ResponseBody;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;
import retrofit2.Retrofit;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        getData();
    }


    public void getData() {
        //Configuracion basica de el objeto Retrofit
        Retrofit retrofit = new Retrofit.Builder()
                .baseUrl("https://api.github.com")
                .build();


        //Crear una instancia de mi interfaz que ya tiene configurada la estructura de mi solicitud
        GitHubService githubService = retrofit.create(GitHubService.class);

        githubService.getUserInfoPath("gmeono94").enqueue(new Callback<ResponseBody>() {
            @Override
            public void onResponse(Call<ResponseBody> call, Response<ResponseBody> response) {

                try {

                    //Body del request
                    String body = response.body().string();
                    //Status code de mi solicitud
                    int code = response.code();
                    Log.e("MyResponse", body);
                    Log.e("MyResponseCode", code + "");

                    //Parsear el JSON y obtener "bio"
                    JSONObject json = new JSONObject(body);
                    String bio = json.getString("bio");
                    Log.e("MyBio", bio);


                } catch (IOException e) {
                    e.printStackTrace();
                } catch (JSONException e) {
                    e.printStackTrace();
                }


            }

            @Override
            public void onFailure(Call<ResponseBody> call, Throwable t) {
                Log.e("MyResponseFailure", t.getMessage());
            }
        });

    }
}
