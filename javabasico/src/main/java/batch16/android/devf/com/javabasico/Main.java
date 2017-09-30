package batch16.android.devf.com.javabasico;

/**
 * Created by Dagorik on 29/09/17.
 */

public class Main {

    public static void main(String[] args) {

        Perro pug = new Perro("pug");
        pug.come();
        pug.ladra();

        Perro labrador = new Perro("labrador");
        labrador.come();
        labrador.ladra();

    }
}
