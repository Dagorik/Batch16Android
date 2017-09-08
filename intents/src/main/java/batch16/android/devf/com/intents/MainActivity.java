package batch16.android.devf.com.intents;

import android.content.Intent;
import android.net.Uri;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;

public class MainActivity extends AppCompatActivity {

    Button btnOK, btnLink, btnLlamada;
    EditText usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = (Button) findViewById(R.id.btn_ok);
        usuario = (EditText) findViewById(R.id.et_usuario);
        btnLink = (Button) findViewById(R.id.btn_link);
        btnLlamada = (Button) findViewById(R.id.btn_llamada);


        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoUsuario = usuario.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra("usuario", textoUsuario);
                startActivity(intent);
            }
        });

        btnLink.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                abrirLink();
            }
        });

        btnLlamada.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                hacerLlamda();
            }
        });
    }

    private void hacerLlamda() {
        Intent intent = new Intent(Intent.ACTION_DIAL, Uri.parse("tel:5566081086"));
        startActivity(intent);
    }

    private void abrirLink() {
        String uri = "http://google.com";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(uri));
        startActivity(intent);

    }
}
