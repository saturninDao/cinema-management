/**
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
public class Film {
    private String titreFilm;
    private String realisateur;
    private int annee;
    private String descriptif;
    private boolean aLaffiche;

    public Film(String titreFilm, String realisateur, int annee, String descriptif, boolean aLaffiche) {
        this.titreFilm = titreFilm;
        this.realisateur = realisateur;
        this.annee = annee;
        this.descriptif = descriptif;
        this.aLaffiche = aLaffiche;
    }

    public Film(String titreFilm, String annee, boolean aLaffiche) {}

    public String getTitreFilm() {
        return titreFilm;
    }

    public String getRealisateur() {
        return realisateur;
    }

    public boolean isaLaffiche() {
        return aLaffiche;
    }

    public int getAnnee() {
        return annee;
    }

    public void setAnnee(int annee) {
        this.annee = annee;
    }

    public String getDescriptif() {
        return descriptif;
    }
}
