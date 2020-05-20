import java.io.Serializable;

/*
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
public class Seance implements Serializable {
    public Film film;
    String dateEtHoraireDeProjection;
    Salle salle;
    private int tarifNormal = 5;
    private int tarifReduit = 2;
    private int tarifGratuit = 0;

    private int placeTarifNormal;
    private int placeTarifReduit;
    private int placeTarifGratuit;

    public Seance(Film film, String dateEtHoraireDeProjection, Salle salle, int tarifNormal, int tarifReduit, int tarifGratuit, int placeTarifNormal, int placeTarifReduit, int placeTarifGratuit) {
        this.film = film;
        this.dateEtHoraireDeProjection = dateEtHoraireDeProjection;
        this.salle = salle;
        this.tarifNormal = tarifNormal;
        this.tarifReduit = tarifReduit;
        this.tarifGratuit = tarifGratuit;
        this.placeTarifNormal = placeTarifNormal;
        this.placeTarifReduit = placeTarifReduit;
        this.placeTarifGratuit = placeTarifGratuit;
    }

    public void setTarifNormal(int tarifNormal) {
        this.tarifNormal = tarifNormal;
    }

    public void setTarifReduit(int tarifReduit) {
        this.tarifReduit = tarifReduit;
    }

    public int getTarifGratuit() {
        return tarifGratuit;
    }

    public void setTarifGratuit(int tarifGratuit) {
        this.tarifGratuit = tarifGratuit;
    }

    public int getPlaceTarifNormal() {
        return placeTarifNormal;
    }

    public void setPlaceTarifNormal() {
        this.placeTarifNormal++;
    }

    public int getPlaceTarifReduit() {
        return placeTarifReduit;
    }

    public void setPlaceTarifReduit() {
        this.placeTarifReduit++;
    }

    public int getPlaceTarifGratuit() {
        return placeTarifGratuit;
    }

    public void setPlaceTarifGratuit() {
        this.placeTarifGratuit++;
    }

    public int getTarifNormal() {
        return tarifNormal;
    }

    public int getTarifReduit() {
        return tarifReduit;
    }

    public int getPlacesGratuites() {
        return tarifGratuit;
    }

    public int prixReelTarif(int tarif){
        if (tarif==tarifNormal){
            return tarifNormal;
        }else if (tarif==tarifReduit){
            return tarifNormal;
        }else if(tarif==tarifGratuit) {
            return tarifGratuit;
        }else {
            return tarifNormal;
        }
    }

    public void setFilm(Film film) {
        this.film = film;
    }

    public void setDateEtHoraireDeProjection(String dateEtHoraireDeProjection) {
        this.dateEtHoraireDeProjection = dateEtHoraireDeProjection;
    }

    public void setSalle(Salle salle) {
        this.salle = salle;
    }

    public Seance(Film film, String dateEtHoraireDeProjection, Salle salle) {}

    public Film getFilm() {
        return film;
    }

    public String getDateEtHoraireDeProjection() {
        return dateEtHoraireDeProjection;
    }

    public Salle getSalle() {
        return salle;
    }

    public boolean estComplete(){
        return getPlacesGratuites()+getPlaceTarifNormal()+getPlaceTarifReduit() == salle.getNombreDePlace();
    }
}
