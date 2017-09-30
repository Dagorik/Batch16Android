package batch16.android.devf.com.javabasico;

/**
 * Created by Dagorik on 29/09/17.
 */

public class Perro implements IPerro{

    private int patas;
    private String pelaje;
    private String raza;

    public Perro(String razaDeMain){
        this.raza = razaDeMain;
        System.out.println(raza);
    }

    @Override
    public void ladra() {
        System.out.println("Ladra "+  raza);
    }

    @Override
    public void come() {
        System.out.println("Come "+ raza);
    }

    @Override
    public void reproduce() {

    }
}
