package batch16.android.devf.com.retrofitmodels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.Toast;

import java.util.List;

import batch16.android.devf.com.retrofitmodels.api.ServiceGenerator;
import batch16.android.devf.com.retrofitmodels.api.ServicesInterface;
import batch16.android.devf.com.retrofitmodels.models.Author;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ServicesInterface servicesInterface;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicesInterface = ServiceGenerator.createService();


        //loadDataFromSingleton();
        createAuthor();
    }

    private void createAuthor() {

        Author author = new Author();
        author.setName("SAUL");
        author.setLastName("CORTES");
        author.setNacionalidad("USA");
        author.setBiography("SAUL ES UN ESTUDIANTE DE DEVF QUE CURSO CINTA ROJA Y AHORA ESTA EN CINTA NEGRA ANDROID");
        author.setGender("M");
        author.setAge(31);

        servicesInterface.createAuthor(author).enqueue(new Callback<Author>() {
            @Override
            public void onResponse(Call<Author> call, Response<Author> response) {
                Author author1 = response.body();
                Log.e("MyCreateUser", author1.getId() + "");
                Toast.makeText(MainActivity.this, "USUARIO GUARDADO EXITOSAMENTE", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(Call<Author> call, Throwable t) {
                Toast.makeText(MainActivity.this, t.getMessage(), Toast.LENGTH_SHORT).show();
                Log.e("MyCreateUserError", t.getMessage());
            }
        });


    }

    private void loadDataFromSingleton() {


        servicesInterface.getAllAuthors().enqueue(new Callback<List<Author>>() {
            @Override
            public void onResponse(Call<List<Author>> call, Response<List<Author>> response) {

                for (int i = 0; i < response.body().size(); i++) {
                    Author author = response.body().get(i);
                    Log.e("MyAuthor", author.toString());
                }

            }

            @Override
            public void onFailure(Call<List<Author>> call, Throwable t) {

            }
        });


    }
}
