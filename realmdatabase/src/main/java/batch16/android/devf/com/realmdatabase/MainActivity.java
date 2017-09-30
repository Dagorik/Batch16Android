package batch16.android.devf.com.realmdatabase;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import batch16.android.devf.com.realmdatabase.Models.Curso;
import batch16.android.devf.com.realmdatabase.Models.User;
import io.realm.Realm;
import io.realm.RealmConfiguration;
import io.realm.RealmResults;
import io.realm.internal.RealmCore;

public class MainActivity extends AppCompatActivity {

    private RealmServices realmServices;

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

        realmServices = new RealmServices(Realm.getDefaultInstance());
        realmTareas();
    }

    private void realmTareas() {

        realmServices.insertarUser(3, "David", "david@prueba.com", false, 64);
        realmServices.insertarUser(4, "Saul", "saul@prueba.com", false, 31);
        realmServices.insertarUser(5, "Isra", "isra@prueba.com", true, 26);
        realmServices.insertarUser(6, "Tavo", "tavo@prueba.com", true, 23);
        realmServices.insertarUser(7, "Raul", "raul@prueba.com", false, 22);

        //RealmResults<User> users = realmServices.obtenerUsuarios();
        //Log.e("MyListUsers", users.toString());

        //User user = realmServices.obtenerUsuarioID(2);
        //Log.e("MyUser", user.toString());

        //realmServices.borrarUser(2);

        //users = realmServices.busquedasAvanzadas();
        //Log.e("MyBusqueda", users.toString());

        realmServices.insertarCurso(1, "Android");

        RealmResults<Curso> cursos = realmServices.getAllCursos();
        Log.e("MyCursos", cursos.toString());

        for (int i = 0; i < cursos.get(0).getListUserDentroDelCurso().size(); i++) {
            Log.e("MyCursosUsers", cursos.get(0).getListUserDentroDelCurso().get(i).toString());
        }
    }
}
