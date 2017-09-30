package batch16.android.devf.com.animaciones;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import batch16.android.devf.com.animaciones.AnimationTween.TweenAnimationAcivity;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.animation1)
    public void animation1() {

        startActivity(new Intent(MainActivity.this, TweenAnimationAcivity.class));

    }

}
