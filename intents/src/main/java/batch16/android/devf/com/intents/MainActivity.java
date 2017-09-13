package batch16.android.devf.com.intents;

import android.content.Intent;
import android.graphics.Bitmap;
import android.net.Uri;
import android.provider.MediaStore;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    Button btnOK, btnLink, btnLlamada, btnStreetView, btnEscogerApp, btnForResult, btnFoto;
    EditText usuario;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        btnOK = (Button) findViewById(R.id.btn_ok);
        usuario = (EditText) findViewById(R.id.et_usuario);
        btnLink = (Button) findViewById(R.id.btn_link);
        btnLlamada = (Button) findViewById(R.id.btn_llamada);
        btnStreetView = (Button) findViewById(R.id.btn_streetview);
        btnEscogerApp = (Button) findViewById(R.id.btn_escoger_app);
        btnForResult = (Button) findViewById(R.id.btn_for_result);
        btnFoto = (Button) findViewById(R.id.btn_foto);

        btnOK.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String textoUsuario = usuario.getText().toString();
                Intent intent = new Intent(MainActivity.this, Main2Activity.class);
                intent.putExtra(Constantes.INTENT_KEY_USERNAME, textoUsuario);
                startActivity(intent);
                //finish(); Destruye la actividad

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


        btnStreetView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                mostrarSteetVieww();
            }
        });

        btnEscogerApp.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                escogerApp();
            }
        });


        btnForResult.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {

                String txt = usuario.getText().toString();

                if (txt.isEmpty()) {
                    Toast.makeText(view.getContext(), "ÑO", Toast.LENGTH_LONG).show();
                } else {
                    Intent intent = new Intent(view.getContext(), Main2Activity.class);
                    intent.putExtra(Constantes.INTENT_KEY_USERNAME, txt);
                    startActivityForResult(intent, Constantes.REQUEST_CODE_SECOND_ACTIVITY);
                }

            }
        });


        btnFoto.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                tomarFoto();
            }
        });

    }

    private void tomarFoto() {
        Intent intent = new Intent(MediaStore.ACTION_IMAGE_CAPTURE);
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivityForResult(intent, Constantes.REQUEST_CODE_FOTO);
        }
    }


    @Override
    protected void onActivityResult(int requestCode, int resultCode, Intent data) {
        super.onActivityResult(requestCode, resultCode, data);

        Log.e("ESTOY EN EL METODO: ", "onActivityResult");
        Log.e("requestCode", requestCode + "");
        Log.e("resultCode", resultCode + "");

        if (Constantes.REQUEST_CODE_SECOND_ACTIVITY == requestCode) {
            if (resultCode == RESULT_OK) {
                String resultText = data.getStringExtra(Constantes.INTENT_KEY_SALUDOS);
                Toast.makeText(this, resultText, Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this, "BACK", Toast.LENGTH_SHORT).show();
            }
        } else if (Constantes.REQUEST_CODE_FOTO == requestCode) {
            if (resultCode == RESULT_OK) {
                Bundle extra = data.getExtras();
                Bitmap imageBitMao = (Bitmap) extra.get("data");
                ImageView img = (ImageView) findViewById(R.id.imageView);
                img.setImageBitmap(imageBitMao);

            } else {
                Toast.makeText(this, ":(", Toast.LENGTH_SHORT).show();
            }
        }


    }

    private void escogerApp() {

        String texto = "Este es el texto que quieres mandar";

        Intent intent = new Intent(Intent.ACTION_SEND);

//        mage/jpeg
//        audio/mpeg4-generic
//        text/html
//        audio/mpeg
//        audio/aac
//        audio/wav
//        audio/ogg
//        audio/midi
//        audio/x-ms-wma
//        video/mp4
//        video/x-msvideo
//        video/x-ms-wmv
//        image/png
//        image/jpeg
//        image/gif
//        .xml ->text/xml
//                .txt -> text/plain
//                .cfg -> text/plain
//                .csv -> text/plain
//                .conf -> text/plain
//                .rc -> text/plain
//                .htm -> text/html
//                .html -> text/html
//                .pdf -> application/pdf
//                .apk -> application/vnd.android.package-archive


        intent.putExtra(Intent.EXTRA_ALLOW_MULTIPLE, texto);
        intent.setType("text/plain");

        Intent chooser = Intent.createChooser(intent, "Escoge una app");
        //PackageManager es el menu que sale para escoger apps
        if (intent.resolveActivity(getPackageManager()) != null) {
            startActivity(chooser);
        }
    }

    private void mostrarSteetVieww() {
        Uri gmm = Uri.parse("google.streetview:cbll=19.332273,-99.190092");
        Intent intent = new Intent(Intent.ACTION_VIEW, gmm);
        intent.setPackage("com.google.android.apps.maps");
        startActivity(intent);
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
