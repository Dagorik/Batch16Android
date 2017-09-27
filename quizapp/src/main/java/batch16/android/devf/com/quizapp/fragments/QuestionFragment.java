package batch16.android.devf.com.quizapp.fragments;

import android.content.Context;
import android.net.Uri;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import batch16.android.devf.com.quizapp.R;

public class QuestionFragment extends Fragment implements View.OnClickListener {

    String title;
    TextView pregunta;
    Button btnTrue, btnFalse;
    int respuesta;


    public QuestionFragment() {
        // Required empty public constructor
    }

    public QuestionFragment(String title) {
        this.title = title;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {

        View view = inflater.inflate(R.layout.fragment_question, container, false);

        pregunta = (TextView) view.findViewById(R.id.tv_pregunta);
        btnTrue = (Button) view.findViewById(R.id.btn_true);
        btnFalse = (Button) view.findViewById(R.id.btn_false);

        pregunta.setText(title);

        btnTrue.setOnClickListener(this);
        btnFalse.setOnClickListener(this);

        return view;
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn_true:
                respuesta = 1;
                btnTrue.setBackgroundResource(R.color.colorTrue);
                btnFalse.setBackgroundResource(R.color.colorAmbar);
                break;
            case R.id.btn_false:
                respuesta = 0;
                btnFalse.setBackgroundResource(R.color.colorFalse);
                btnTrue.setBackgroundResource(R.color.colorAmbar);
                break;

        }
    }


    public int getRespuesta() {
        return respuesta;
    }
}
