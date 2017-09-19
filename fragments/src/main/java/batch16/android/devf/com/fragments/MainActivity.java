package batch16.android.devf.com.fragments;

import android.support.v4.app.FragmentManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.fragments.fragments.BlankFragment;

public class MainActivity extends AppCompatActivity implements View.OnClickListener {

    private BlankFragment fragment;
    private List<String> mListNumero = new ArrayList<>();
    int posicionNumero = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        cargarDatos();
        cambiarFragment(posicionNumero);
    }

    private void cambiarFragment(int posicionNumero) {
        fragment = new BlankFragment(mListNumero.get(posicionNumero));

        FragmentManager fragmentManager = getSupportFragmentManager();
        fragmentManager.beginTransaction()
                .replace(R.id.frame_layout, fragment)
                .commit();

    }

    private void cargarDatos() {
        mListNumero.add("1");
        mListNumero.add("2");
        mListNumero.add("3");
        mListNumero.add("4");
        mListNumero.add("5");
        mListNumero.add("6");
    }

    private void initView() {
        Button button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(this);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.btn:
                cambiarFragment(posicionNumero++);
                if (posicionNumero >= 4) {
                    posicionNumero = 0;
                }
                break;
        }
    }
}
