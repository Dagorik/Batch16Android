package batch16.android.devf.com.realmdatabase.Models;

import io.realm.RealmList;
import io.realm.RealmObject;
import io.realm.annotations.PrimaryKey;

/**
 * Created by Dagorik on 28/09/17.
 */

public class Curso extends RealmObject {

    @PrimaryKey
    private int idCurso;
    private String nameCurso;
    private RealmList<User> listUserDentroDelCurso;


    public int getIdCurso() {
        return idCurso;
    }

    public void setIdCurso(int idCurso) {
        this.idCurso = idCurso;
    }

    public String getNameCurso() {
        return nameCurso;
    }

    public void setNameCurso(String nameCurso) {
        this.nameCurso = nameCurso;
    }

    public RealmList<User> getListUserDentroDelCurso() {
        return listUserDentroDelCurso;
    }

    public void setListUserDentroDelCurso(RealmList<User> listUserDentroDelCurso) {
        this.listUserDentroDelCurso = listUserDentroDelCurso;
    }

    @Override
    public String toString() {
        return "Curso{" +
                "idCurso=" + idCurso +
                ", nameCurso='" + nameCurso + '\'' +
                ", listUserDentroDelCurso=" + listUserDentroDelCurso +
                '}';
    }
}
