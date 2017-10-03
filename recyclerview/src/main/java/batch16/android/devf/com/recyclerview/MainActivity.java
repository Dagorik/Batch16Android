package batch16.android.devf.com.recyclerview;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.GridLayoutManager;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.RecyclerView;

import java.util.ArrayList;
import java.util.List;

import batch16.android.devf.com.recyclerview.adapters.PesoAdapter;
import batch16.android.devf.com.recyclerview.models.Peso;

public class MainActivity extends AppCompatActivity {

    private List<Peso> pesoList = new ArrayList<>();
    RecyclerView rvPesos;
    PesoAdapter pesoAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        initPesos();
        initAdapter();
    }

    private void initPesos() {
        pesoList.add(new Peso("01/01/2018","78"));
        pesoList.add(new Peso("01/02/2018","78"));
        pesoList.add(new Peso("01/03/2018","78"));
        pesoList.add(new Peso("01/04/2018","78"));
        pesoList.add(new Peso("01/05/2018","77"));
        pesoList.add(new Peso("01/06/2018","77"));
        pesoList.add(new Peso("01/07/2018","77"));
        pesoList.add(new Peso("01/08/2018","77"));
        pesoList.add(new Peso("01/09/2018","76"));
        pesoList.add(new Peso("01/10/2018","76"));
        pesoList.add(new Peso("01/11/2018","75"));
        pesoList.add(new Peso("01/12/2018","74"));
    }

    private void initAdapter() {
        rvPesos = (RecyclerView) findViewById(R.id.rv_lista);

        //Creando el layout manager
        //GridLayoutManager
        LinearLayoutManager layoutManager = new LinearLayoutManager(this);
        layoutManager.setOrientation(LinearLayoutManager.VERTICAL);

        //Setenado la configuracion del Recycler View
        rvPesos.setLayoutManager(layoutManager);
        rvPesos.setHasFixedSize(true);

        //Creando un objeto de PesoAdapter
        pesoAdapter = new PesoAdapter(pesoList);

        //Seteo el adaptador al recycler view
        rvPesos.setAdapter(pesoAdapter);
    }
}
