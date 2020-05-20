/*
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
import java.io.Serializable;
import java.util.*;

public class Cinema implements ICinema,IGestCinema,Serializable {

    private final List<Seance> seances = new ArrayList<>();
    private final List<Film> baseDuCinema = new ArrayList<>();

    public Cinema(){}


    public void setSeances(Seance seance) {
        this.seances.add(seance);
    }

    @Override
    public List<String> lesSeances() {
        List<String>descriptifsDesSeancesDeLaSemaine = new ArrayList<>();
        for (Seance seance : seances) {
            descriptifsDesSeancesDeLaSemaine.add(
                    "Film: " + seance.film.getTitreFilm()
                            + "  Date: " + seance.dateEtHoraireDeProjection
                            + "  Salle: " + seance.salle.getNomDeLaSalle()
                            + "  \n");
        }
        return descriptifsDesSeancesDeLaSemaine;
    }

    @Override
    public String descriptifFilm(String titreFilm) {
        String descriptifDunFilmDemande ="";
        for (Seance seance : seances) {
            if (titreFilm.equals(seance.getFilm().getTitreFilm())) {
                descriptifDunFilmDemande = seance.getFilm().getDescriptif();
            }
        }
        return descriptifDunFilmDemande;
    }

    @Override
    public List<String> filmsALAffiche() {
        Set<String> set = new HashSet<>();
        List<String> filmsALaffiche = new ArrayList<>(set);
        for (Seance seance : seances) {
            if (seance.getFilm().isaLaffiche()){
                set.add(seance.getFilm().getTitreFilm());
            }
        }
        filmsALaffiche.addAll(set);
        return filmsALaffiche;
    }

    @Override
    public boolean achetePlace(String titreFilm, String jourHoraire, int tarif) throws PasDeSeanceException {
        for (Seance seance: seances){
            if (!seance.film.getTitreFilm().equals(titreFilm) | !seance.dateEtHoraireDeProjection.equals(jourHoraire)) {
                throw new PasDeSeanceException();
            }

            if (seance.estComplete()){
                return false;
            }else {
                switch (tarif) {
                    case 5:
                        seance.setPlaceTarifNormal();
                        break;
                    case 2:
                        seance.setPlaceTarifReduit();
                    case 0:
                        seance.setPlaceTarifGratuit();
                    default:
                        seance.setPlaceTarifNormal();
                }
            }
        }
        return true;
    }

    @Override
    public void creerFilm(String titreFilm, String descriptif, String realisateur, int annee) {
        Film film = new Film(titreFilm, realisateur, annee, descriptif, false);
        baseDuCinema.add(film);
    }

    @Override
    public int calculeChiffreAffaires() {
        int chiffreAffaireTotalAretourner =0;
        for (Seance seance: seances){
            chiffreAffaireTotalAretourner += (seance.getPlacesGratuites()*seance.getTarifGratuit())
                    +(seance.getPlaceTarifNormal()*seance.getTarifNormal())
                    +(seance.getPlaceTarifReduit()*seance.getTarifReduit());
        }
        return chiffreAffaireTotalAretourner;
    }

    @Override
    public void nouvelleSemaine() {
        seances.clear();
    }

    @Override
    public float tauxRemplissage(String titreFilm) {
        float tauxDeRemplissage = 0;

        for (Seance seance: seances){
            // Calculons la somme des places occupés

            if (seance.film.getTitreFilm().equals(titreFilm)) {
                float sommeDesPlacesOccupes = (seance.getPlaceTarifGratuit()) + (seance.getPlaceTarifNormal()) + (seance.getPlaceTarifReduit());

                // Calculons la somme des places disponibles
                float sommeDesPlacesDisponibles = seance.salle.getNombreDePlace() - sommeDesPlacesOccupes;

                //Calculons maintenant le taux le remplissage en question
                tauxDeRemplissage = sommeDesPlacesOccupes / sommeDesPlacesDisponibles;
                //tauxDeRemplissage  = sommeDesPlacesDisponibles;
            }

        }
        return tauxDeRemplissage;
    }
}
