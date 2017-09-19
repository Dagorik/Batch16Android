package batch16.android.devf.com.quizapp;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.quizapp.fragments.QuestionFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> listPreguntas = new ArrayList<>();
    List<Integer> listRespuestas = new ArrayList<>();
    QuestionFragment questionFragment;
    int preguntasPosicion = 0;
    int respuetasPosicion = 0;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initPreguntas();
        initRespuestas();
        cambiarFragment(preguntasPosicion);
    }

    private void cambiarFragment(int preguntasPosicion) {
        questionFragment = new QuestionFragment(listPreguntas.get(preguntasPosicion));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, questionFragment)
                .commit();
    }


    private void initPreguntas() {
        listPreguntas.add("2 + 2 son 9???");
    }

    private void initRespuestas() {
        listRespuestas.add(0);
    }

    private void initView() {
        Button btnDerecha = (Button) findViewById(R.id.btn_derecha);
        Button btnIzquierda = (Button) findViewById(R.id.btn_izquierda);

        btnDerecha.setOnClickListener(this);
        btnIzquierda.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

    }
}
