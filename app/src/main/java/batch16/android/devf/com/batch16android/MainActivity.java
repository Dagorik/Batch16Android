package batch16.android.devf.com.batch16android;

import android.graphics.Color;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    TextView userName;
    EditText edUserName;
    Button btnOk;
    Button btnGuardar;
    Button btnPrueba, btnPrueba2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.tv_user_name);
        edUserName = (EditText) findViewById(R.id.et_user_name);
        btnOk = (Button) findViewById(R.id.btn_ok);
        btnGuardar = (Button) findViewById(R.id.btn_guardar);
        btnPrueba = (Button) findViewById(R.id.btn_prueba);
        btnPrueba2 = (Button) findViewById(R.id.btn_prueba2);

        btnOk.setOnClickListener(this);
        btnGuardar.setOnClickListener(this);
        btnPrueba.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(MainActivity.this, "Boton de prueba", Toast.LENGTH_SHORT).show();
            }
        });


        Log.e("MyLog", "OnCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyLog", "onResume");


    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyLog", "onStart");

    }

    @Override
    protected void onStop() {
        super.onStop();
        Log.e("MyLog", "onStop");


    }

    @Override
    protected void onPause() {
        super.onPause();
        Log.e("MyLog", "onPause");

    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyLog", "onDestroy");

    }

    @Override
    public void onClick(View view) {

        String name = edUserName.getText().toString();

        switch (view.getId()) {

            case R.id.btn_ok:

                if (name.isEmpty()) {
                    Snackbar.make(view, "Ingresa un nombre porfis", Snackbar.LENGTH_SHORT).show();
                } else {
                    Toast.makeText(this, "HOLA " + name, Toast.LENGTH_SHORT).show();
                }

                break;

            case R.id.btn_guardar:

                if (name.isEmpty()) {
                    Snackbar.make(view, "Ingresa un nombre porfis", Snackbar.LENGTH_SHORT).show();
                } else {
                    userName.setText("Usuario: " + name);
                }

                break;
        }


    }

    public void botonPuchado(View view) {
        Toast.makeText(this, "Segundo boton de prueba", Toast.LENGTH_SHORT).show();
    }
}
