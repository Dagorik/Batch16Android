package batch16.android.devf.com.animaciones.AnimationTween;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import batch16.android.devf.com.animaciones.R;
import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

public class TweenAnimationAcivity extends AppCompatActivity {

    @BindView(R.id.tween_animation1)
    TextView tvAnimation1;


    @BindView(R.id.imageview)
    ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_tween_animation_acivity);
        ButterKnife.bind(this);
    }

    @OnClick(R.id.tween_animation1)
    public void hacerAnimacion() {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.animacion_tween);
        tvAnimation1.startAnimation(animation);
    }

    @OnClick(R.id.button)
    public void clockwise(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.myanimation);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.button2)
    public void zoom(View view) {
        Animation animation1 = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.clockwise);
        imageView.startAnimation(animation1);
    }

    @OnClick(R.id.button3)
    public void fade(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.fade);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.button4)
    public void blink(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.blink);
        imageView.startAnimation(animation);
    }

    @OnClick(R.id.button5)
    public void move(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.move);
        imageView.startAnimation(animation);
    }

    public void slide(View view) {
        Animation animation = AnimationUtils.loadAnimation(getApplicationContext(), R.anim.slide);
        imageView.startAnimation(animation);
    }
}

