package batch16.android.devf.com.quizapp;

import android.content.Intent;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import batch16.android.devf.com.quizapp.R;

public class LoginActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText etUser;
    private Button btnIniciar;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        etUser = (EditText) findViewById(R.id.et_user);
        btnIniciar = (Button) findViewById(R.id.btn_iniciar);

        btnIniciar.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {

        switch (view.getId()) {
            case R.id.btn_iniciar:

                String usuario = etUser.getText().toString();
                if (!usuario.isEmpty()) {
                    //Almacenar el dato del usuario con un Shared Preferences.
                    SharedPreferences preferences = this.getSharedPreferences("preferenciasQuiz", MODE_PRIVATE);
                    SharedPreferences.Editor editor = preferences.edit();
                    editor.putString("USUARIO", usuario);
                    editor.commit();

                    Intent intent = new Intent(this, MainActivity.class);
                    startActivity(intent);

                } else {
                    Toast.makeText(this, "Ingresa tu usuario", Toast.LENGTH_SHORT).show();
                }
                break;
        }

    }
}
