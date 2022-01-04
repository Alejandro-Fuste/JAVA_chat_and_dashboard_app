package sharktests;

import com.landeros.customexceptions.UsernameOrPasswordIncorrect;
import com.landeros.databaseinteraction.SharkDAO;
import com.landeros.databaseinteraction.SharkDAOImplemented;
import com.landeros.entities.Shark;
import com.landeros.service.SharkService;
import com.landeros.service.SharkServiceImplemented;
import org.testng.annotations.Test;

public class SharkServiceTests {

    // made static so that they are accessible without having to instantiate SharkServiceTests class
    static SharkDAO sharkDAO = new SharkDAOImplemented(); // change to Mochito
    static SharkService sharkService = new SharkServiceImplemented(sharkDAO);

    // stub this one
    @Test(expectedExceptions = UsernameOrPasswordIncorrect.class,
            expectedExceptionsMessageRegExp = "Either your username or password or both are incorrect!")
    void sharkLoginService() {
        Shark shark = sharkService.sharkLoginService("Bobby", "Mavs1");
    }

    // add stubbing test to make sure correct object is returned
    // positive test: show method handles correct login ifo
    // negative: show method handles bad username, password, and both at the same time
    // stub DAO results
}
