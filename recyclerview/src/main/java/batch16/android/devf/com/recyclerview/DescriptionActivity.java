package batch16.android.devf.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

public class DescriptionActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_description);


        String mPeso = getIntent().getStringExtra("PESO");
        TextView peso = (TextView) findViewById(R.id.peso);
        peso.setText(mPeso);

    }
}
