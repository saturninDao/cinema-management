import java.io.Serializable;

/*
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
public class Salle implements Serializable {
    private int nombreDePlace;
    private String nomDeLaSalle;

    public Salle(int nombreDePlace, String nomDeLaSalle) {
        this.nombreDePlace = nombreDePlace;
        this.nomDeLaSalle = nomDeLaSalle;
    }

    public void setNombreDePlace(int nombreDePlace) {
        this.nombreDePlace = nombreDePlace;
    }

    public String getNomDeLaSalle() {
        return nomDeLaSalle;
    }

    public void setNomDeLaSalle(String nomDeLaSalle) {
        this.nomDeLaSalle = nomDeLaSalle;
    }

    public int getNombreDePlace() {
        return nombreDePlace;
    }
}
