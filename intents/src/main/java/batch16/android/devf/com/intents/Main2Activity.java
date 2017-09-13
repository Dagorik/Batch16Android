package batch16.android.devf.com.intents;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvUsuario;
    Button btnRegresarResult;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsuario = (TextView) findViewById(R.id.usuario);
        btnRegresarResult = (Button) findViewById(R.id.btn_regresar_for_result2);

        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString(Constantes.INTENT_KEY_USERNAME);
        if (extras != null) {
            tvUsuario.setText(usuario);
        }

        btnRegresarResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent returnIntent = new Intent();
                returnIntent.putExtra(Constantes.INTENT_KEY_SALUDOS, "HOLA DESDE LA SEGUNDA ACTIVIDAD");
                setResult(RESULT_OK, returnIntent);
                finish();
            }
        });


    }
}
