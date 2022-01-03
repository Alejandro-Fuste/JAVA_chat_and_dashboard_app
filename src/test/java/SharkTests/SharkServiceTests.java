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
    static SharkDAO sharkDAO = new SharkDAOImplemented();
    static SharkService sharkService = new SharkServiceImplemented(sharkDAO);

    @Test(expectedExceptions = UsernameOrPasswordIncorrect.class,
            expectedExceptionsMessageRegExp = "Either your username or password or both are incorrect!")
    void sharkLoginService() {
        Shark shark = sharkService.sharkLoginService("Bobby", "Mavs1");
    }
}
