/**
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
public interface IGestCinema {
    public void creerFilm(String titreFilm, String descriptif, String realisateur, int annee);
    public int calculeChiffreAffaires();
    public void nouvelleSemaine();
    public float tauxRemplissage(String titreFilm);
}

