package batch16.android.devf.com.quizapp;

import android.content.SharedPreferences;
import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.quizapp.fragments.QuestionFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    List<String> listPreguntas = new ArrayList<>();
    List<Integer> listRespuestas = new ArrayList<>();
    QuestionFragment questionFragment;
    int preguntasPosicion = 0;
    int respuesatsCorrectas = 0;

    //[1,2,3,4,5,6] PREGUNTAS
    //[1,0,1,0,0,1] RESPUESTAS

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
        listPreguntas.add("2 + 3 son 5???");
    }

    private void initRespuestas() {
        //VERDADERO 1
        //FALSO 0
        listRespuestas.add(0);
        listRespuestas.add(1);
    }

    private void initView() {
        ImageView ivLeft = (ImageView) findViewById(R.id.iv_left);
        ImageView ivRight = (ImageView) findViewById(R.id.iv_right);

        ivLeft.setOnClickListener(this);
        ivRight.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {

            case R.id.iv_left:
                if (preguntasPosicion > 0) {
                    cambiarFragment(preguntasPosicion--);
                } else {
                    Toast.makeText(this, "No puedes ir mas atras", Toast.LENGTH_SHORT).show();
                }
                break;

            case R.id.iv_right:
                if (questionFragment.getRespuesta() == listRespuestas.get(preguntasPosicion)) {
                    respuesatsCorrectas++;
                }

                if (preguntasPosicion == listPreguntas.size() - 1) {

                    //Obtener datos por el SharedPreferences
                    SharedPreferences preferences = this.getSharedPreferences("preferenciasQuiz",MODE_PRIVATE);
                    String usuario = preferences.getString("USUARIO","USUARIO GENERICO");
                    Toast.makeText(this, "Tus respuestas correctas fueron " + respuesatsCorrectas + " user: " + usuario , Toast.LENGTH_SHORT).show();
                    preguntasPosicion = 0;
                }

                preguntasPosicion++;
                cambiarFragment(preguntasPosicion);
                break;
        }

    }
}
 