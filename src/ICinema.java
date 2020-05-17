/**
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
import java.util.List;

public interface ICinema {
    public List<String> lesSeances();
    public String descriptifFilm(String titreFilm);
    public List<String> filmsALAffiche();
    public boolean achetePlace(String titreFilm, String jourHoraire, int tarif)
            throws PasDeSeanceException;
}
