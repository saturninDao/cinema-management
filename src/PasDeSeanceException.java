/**
 * @author : Saturnin Dao
 * @since : 17/05/2020, dim. 01:19
 **/
public class PasDeSeanceException extends Exception {

    public PasDeSeanceException() {
        super("Le film que vous demandez n'existe pas ou les horaires que vous avez n'ont pas été trouvé");
    }

}
