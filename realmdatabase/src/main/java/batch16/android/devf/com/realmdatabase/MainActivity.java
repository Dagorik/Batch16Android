package batch16.android.devf.com.realmdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import batch16.android.devf.com.realmdatabase.Models.User;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.internal.RealmCore;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        Realm.init(this);

        RealmConfiguration realmConfiguration = new RealmConfiguration.Builder()
                .name("Test") //Nombre de la base de datos
                .schemaVersion(1) //Numero de version de la base de datos
                .deleteRealmIfMigrationNeeded()
                .build();

        Realm.setDefaultConfiguration(realmConfiguration);

    }


}
