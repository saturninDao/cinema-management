public class Salle {
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
