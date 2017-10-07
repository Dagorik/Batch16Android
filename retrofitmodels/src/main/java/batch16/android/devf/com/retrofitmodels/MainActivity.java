package batch16.android.devf.com.retrofitmodels;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;
import android.util.Log;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.retrofitmodels.adapter.BookAdapter;
import batch16.android.devf.com.retrofitmodels.api.ServiceGenerator;
import batch16.android.devf.com.retrofitmodels.api.ServicesInterface;
import batch16.android.devf.com.retrofitmodels.models.Author;
import batch16.android.devf.com.retrofitmodels.models.Book;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private ServicesInterface servicesInterface;
    private List<Book> listLibros = new ArrayList<>();
    RecyclerView recyclerView;
    BookAdapter bookAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        servicesInterface = ServiceGenerator.createService();


        //loadDataFromSingleton();
        //createAuthor();

        listaLibros();

    }

    private void listaLibros() {
        servicesInterface.getAllBooks().enqueue(new Callback<List<Book>>() {
            @Override
            public void onResponse(Call<List<Book>> call, Response<List<Book>> response) {
                listLibros = response.body();
                Log.e("MyListLibros", listLibros.toString());

                setUpRecycler(listLibros);
                bookAdapter.notifyDataSetChanged();

            }

            @Override
            public void onFailure(Call<List<Book>> call, Throwable t) {
                Log.e("MyListLibrosError", t.getMessage());
            }
        });
    }

    private void setUpRecycler(List<Book> bookList){
        recyclerView = (RecyclerView) findViewById(R.id.rv_books);

        GridLayoutManager layoutManager = new GridLayoutManager(this,2);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        recyclerView.setLayoutManager(layoutManager);
        recyclerView.setHasFixedSize(true);


        bookAdapter = new BookAdapter(bookList);

        recyclerView.setAdapter(bookAdapter);

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
