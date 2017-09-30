package batch16.android.devf.com.realmdatabase;

import android.util.Log;

import batch16.android.devf.com.realmdatabase.Models.Curso;
import batch16.android.devf.com.realmdatabase.Models.User;
import io.realm.Realm;
import io.realm.RealmList;
import io.realm.RealmResults;
import io.realm.Sort;

/**
 * Created by Dagorik on 28/09/17.
 */

public class RealmServices {
    private Realm realm;

    public RealmServices(Realm realm) {
        this.realm = realm;
    }

    //Insertar un usuario
    public void insertarUser(int id, String name, String email, boolean option, int edad) {

        User user = new User();
        user.setId(id);
        user.setName(name);
        user.setEmail(email);
        user.setOption(option);
        user.setEdad(edad);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(user);
        realm.commitTransaction();

    }

    //Busqueda de usuarios
    public RealmResults<User> obtenerUsuarios() {
        //Select * from User
        RealmResults<User> listaUsers = realm.where(User.class).findAll();

        return listaUsers;
    }

    //Busqueda de usuario por ID
    public User obtenerUsuarioID(int id) {
        User user = realm.where(User.class).equalTo("id", id).findFirst();
        return user;
    }

    //Borrar usuario ID
    public void borrarUser(int id) {
        User user = obtenerUsuarioID(id);
        realm.beginTransaction();
        user.deleteFromRealm();
        realm.commitTransaction();
    }

    //Busqueda con parametro
    public RealmResults<User> busquedasAvanzadas() {
        RealmResults<User> results = realm.where(User.class).between("edad", 1, 30).findAll();
        results = realm.where(User.class).beginsWith("name", "J").findAll();
        results = realm.where(User.class).contains("name", "i").findAll();
        results = realm.where(User.class).greaterThan("edad", 25).findAll();
        results = realm.where(User.class).findAll().sort("edad", Sort.ASCENDING);
        results = realm.where(User.class).between("edad", 0, 30).beginsWith("name", "J").findAll();
        results = realm.where(User.class).in("name", new String[]{"David", "Saul"}).findAll();
        results = realm.where(User.class).like("name", "*av*").findAll();
        results = realm.where(User.class).distinct("edad");

//        results = realm.where(User.class).between("edad", 20, 30).findAll();
//        User user = results.where().equalTo("name", "David").findFirst();
//        Log.e("MySubConsulta", user.toString());

        return results;
    }

    //Insertar curso
    public void insertarCurso(int idCurso, String nameCurso){

        RealmResults<User> users = obtenerUsuarios();
        RealmList realmListUsers = new RealmList();

        realmListUsers.addAll(users.subList(0,users.size()));

        Curso curso = new Curso();
        curso.setIdCurso(idCurso);
        curso.setNameCurso(nameCurso);
        curso.setListUserDentroDelCurso(realmListUsers);

        realm.beginTransaction();
        realm.copyToRealmOrUpdate(curso);
        realm.commitTransaction();
    }

    //Obtener todos los cursos
    public RealmResults<Curso> getAllCursos(){

        RealmResults<Curso> cursos = realm.where(Curso.class).findAll();

        return cursos;
    }


}
