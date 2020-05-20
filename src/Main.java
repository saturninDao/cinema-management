/*
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
import java.io.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main{
    static Scanner sc;
    static int saisie;
    static Cinema cinema;
    static Cinema cinesPourLeFichier;
    static Cinema cineBUff;

    public static void main(String ...arg) throws IOException {
        System.out.println("********************************* APPLICATION DE GESTION DE CINEMA VERSION SERIALISE *******************************");
        cinema = cineBUff;
        ajoutUneSeance();
        //gestionDesDonnees();
        // Declarons notre fichier pour la serialization
    }

    public static void ajoutUneSeance() throws IOException {

        System.out.println("             1: Ajouter des seances");
        System.out.println("             0: Quitter le progamme");
        System.out.println("             2: Voir les donnees du fichier serialise (veillez enregistrer des seances avant de consulter)");
        sc = new Scanner(System.in);
        saisie = sc.nextInt();

        switch (saisie) {
            case 1 -> {
                System.out.println("     Combien de seances ajouter ?");
                sc = new Scanner(System.in);
                saisie = sc.nextInt();
                cinema = new Cinema();

                if (saisie > 0) {
                    for (int i = 0; i < saisie; i++) {
                        //titre du film
                        System.out.println(".......................Seance " + (i + 1) + ".................");
                        System.out.println("                       Saisir le titre du film " + (i + 1));
                        String titre = (new Scanner(System.in)).nextLine();

                        //nom du realisateur du film
                        System.out.println("                       Saisir le nom du realisateur du film " + titre);
                        String realisateur = (new Scanner(System.in)).nextLine();

                        //descriptif du film
                        System.out.println("                       Saisir une description du film " + titre);
                        String descriptif = (new Scanner(System.in)).nextLine();

                        //annee de sortie du film
                        System.out.println("                       Saisir l'annee de sortie du film " + titre);
                        int annee = (new Scanner(System.in)).nextInt();

                        //nom de la salle de difusion
                        System.out.println("                       Saisir un nom de la salle d'exposition film " + titre);
                        String libelesalle = (new Scanner(System.in)).nextLine();

                        //nombre de place de la salle
                        System.out.println("                       saisir le nombre de place de la salle " + libelesalle);
                        int nombredePlace = (new Scanner(System.in)).nextInt();

                        //jour et heure de diffusion
                        System.out.println("                       saisir le jour et l'heure de la diffusion ");
                        String jourhoraire = (new Scanner(System.in)).nextLine();

                        //Le fil est il a laffiche
                        System.out.println("                       Le fil est il a laffiche (true/falseBonsoir" +
                                ")? ");
                        boolean aLaffiche = (new Scanner(System.in)).nextBoolean();

                        cinema.setSeances(
                                new Seance(
                                        new Film(titre, realisateur, annee, descriptif, aLaffiche),
                                        jourhoraire,
                                        (new Salle(nombredePlace, libelesalle)),
                                        5,
                                        2,
                                        0,
                                        0,
                                        0,
                                        0
                        ));

                        cinesPourLeFichier = cinema;

                            try {
                                FileOutputStream fichier = new FileOutputStream("fichier12.txt");
                                ObjectOutputStream oos = new ObjectOutputStream(fichier);
                                oos.writeObject(cinema);
                                oos.close();
                                fichier.close();
                                System.out.println("Le fichier serialisé a bien été écrit.");
                            } catch (IOException e) {
                                e.printStackTrace();
                            }

                    }
                    gestionDesDonnees();
                } else {
                    System.out.println("Erreu de saisie");
                }
            }
            case 0 -> System.out.println("/.....................Merci d'avoir utiliser le programme......................../");
            case 2 -> lireLeFichier();
            default -> ajoutUneSeance();
        }
        }


    private static void gestionDesDonnees() {
        System.out.println(" A :******* Recherche d'un renseignement ou achat de ticket************* ");
        System.out.println(" B :******* Gestion  administratif du Cinema  ************* ");
        sc = new Scanner(System.in);

        switch (sc.nextLine()){
            case "A":
                System.out.println("                       3: Voir les seances de diffusion de la semaine");
                System.out.println("                       4: voir la liste des films a l'affiche");
                System.out.println("                       5: Obtenir une description sur un film ");
                System.out.println("                       6: Acheter un ticket ");
                System.out.println("                       0: quitter");
                gettingInformation();

            case "B":
                System.out.println("                       3: Creer nouveau film");
                System.out.println("                       4: calculer le chiffre d'affaire ");
                System.out.println("                       5: nouvelle Semaine ");
                System.out.println("                       6: taux de remplissage ");
                System.out.println("                       0: quitter");
                administrationCinema();

            default:
                gestionDesDonnees();
        }

    }

    private static void administrationCinema() {
        sc = new Scanner(System.in);
        //titre du film
        //nom du realisateur du film
        //descriptif du film
        //annee de sortie du film
        //titre du film
        switch (sc.nextInt()) {
            case 3 -> {
                System.out.println("                       Saisir le titre du film ");
                String titre = (new Scanner(System.in)).nextLine();
                System.out.println("                       saisir le nom du realisateur du film");
                String realisateur = (new Scanner(System.in)).nextLine();
                System.out.println("                       saisir une description du film");
                String descriptif = (new Scanner(System.in)).nextLine();
                System.out.println("                       saisir l'annee de sortie du film");
                int annee = (new Scanner(System.in)).nextInt();
                cinema.creerFilm(titre, descriptif, realisateur, annee);
                gestionDesDonnees();
            }
            case 4 -> {
                System.out.println("Le chiffre d'affaire est :" + cinema.calculeChiffreAffaires());
                gestionDesDonnees();
            }
            case 5 -> {
                cinema.nouvelleSemaine();
                System.out.println("Nouvelle semaine debuter ");
                gestionDesDonnees();
            }
            case 6 -> {
                System.out.println("                       Saisir le titre du film ");
                String titrefilm = (new Scanner(System.in)).nextLine();
                System.out.println("le taux de remplissage pour le film " + titrefilm + " est " + cinema.tauxRemplissage(titrefilm));
                gestionDesDonnees();
            }
            case 0 -> gestionDesDonnees();
            default -> administrationCinema();
        }
    }

    private static void gettingInformation() {
        sc = new Scanner(System.in);
        //Information sur les sceances prevue pour le cinema
        //Liste des films a l'affiche
        //description d'un film
        //achat des ticket pour un film
        switch (sc.nextInt()) {
            case 3 -> {
                for (String seance : cinema.lesSeances()) {
                    System.out.println(seance);
                }
                gestionDesDonnees();
            }
            case 4 -> {
                for (String film : cinema.filmsALAffiche()) {
                    System.out.println(film);
                }
                gestionDesDonnees();
            }
            case 5 -> {
                System.out.println("Entrer le nom du film");
                String nom = (new Scanner(System.in)).nextLine();
                System.out.println(cinema.descriptifFilm(nom));
                gestionDesDonnees();
            }
            case 6 -> {
                System.out.println("Entrer le nom du film a suivre ");
                String titre = (new Scanner(System.in)).nextLine();
                System.out.println("Entrer le jour et l'horaire ");
                String jour_horaire = (new Scanner(System.in)).nextLine();
                System.out.println("Entrer le tarif ");
                int tarif = (new Scanner(System.in)).nextInt();
                try {
                    cinema.achetePlace(titre, jour_horaire, tarif);
                    gestionDesDonnees();
                } catch (PasDeSeanceException e) {
                    System.out.println(e.getMessage());
                }
            }
            case 0 -> gestionDesDonnees();
            default -> gettingInformation();
        }
    }


    public static void lireLeFichier() throws IOException {
        //On récupère maintenant les données !

        try {
            System.out.println("Affichage des données dans le fichier :");
            System.out.println("*************************\n");
            FileInputStream fileIn = new FileInputStream("fichier12.txt");
            ObjectInputStream in = new ObjectInputStream(fileIn);
            cineBUff = (Cinema) in.readObject();
            cinema = cineBUff;
            in.close();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        } finally {
            //System.out.println(filmo.titreFilm);
            System.out.println(cineBUff.lesSeances());
        }
    }
    }


