package batch16.android.devf.com.batch16android;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.EditText;
import android.widget.TextView;

public class MainActivity extends AppCompatActivity {

    TextView userName;
    EditText edUserName;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        userName = (TextView) findViewById(R.id.tv_user_name);
        edUserName = (EditText) findViewById(R.id.et_user_name);

        Log.e("MyLog", "OnCreate");
    }

    @Override
    protected void onResume() {
        super.onResume();
        Log.e("MyLog", "onResume");
        String texto = userName.getText()+"";
        Log.e("MyLogResume", texto);

    }

    @Override
    protected void onStart() {
        super.onStart();
        Log.e("MyLog", "onStart");
        userName.setText("Batch 16 Android ");

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

        Log.e("MyLogPause",edUserName.getText().toString());
    }

    @Override
    protected void onDestroy() {
        super.onDestroy();
        Log.e("MyLog", "onDestroy");

    }
}
