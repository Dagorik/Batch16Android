package batch16.android.devf.com.intents;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class Main2Activity extends AppCompatActivity {

    TextView tvUsuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main2);

        tvUsuario = (TextView) findViewById(R.id.usuario);

        Bundle extras = getIntent().getExtras();
        String usuario = extras.getString("usuario");

        tvUsuario.setText(usuario);


    }
}
