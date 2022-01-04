package sharktests;

import com.investing_app.customexceptions.UsernameOrPasswordIncorrect;
import com.investing_app.databaseinteraction.SharkDAO;
import com.investing_app.entities.Shark;
import com.investing_app.service.SharkService;
import com.investing_app.service.SharkServiceImplemented;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;

public class SharkServiceTests {

    // made static so that they are accessible without having to instantiate SharkServiceTests class
    static SharkDAO sharkDAO;
    static SharkService sharkService;
    static Shark sharkProfile;
    static Shark returnedSharkProfile;

    @BeforeClass
    public void setup() {
       sharkDAO = Mockito.mock(SharkDAO.class);
       sharkService = new SharkServiceImplemented(sharkDAO);
       sharkProfile = new Shark(0, "Lori", "Greiner", "CU Creations",
               "QueenQVC", "qvc1");
       returnedSharkProfile = new Shark(1, "Lori", "Greiner", "CU Creations",
               "QueenQVC", "qvc1");
    }


    // Catching incorrect credentials
    @Test(expectedExceptions = UsernameOrPasswordIncorrect.class)
    public void sharkLoginServiceUsernamePasswordFail() {
        Mockito.when(sharkDAO.getSharkByUsername("Bobby"))
                .thenThrow(new UsernameOrPasswordIncorrect("Either your username or password or both are incorrect!"));
        sharkService.sharkLoginService("Bobby", "bobby1");
    }

    @Test(expectedExceptions = UsernameOrPasswordIncorrect.class)
    public void sharkLoginUsernameFail() {
        Mockito.when(sharkDAO.getSharkByUsername("Kelso"))
                .thenThrow(new UsernameOrPasswordIncorrect("Either your username or password or both are incorrect!"));
        sharkService.sharkLoginService("Teslo", "70sShow1");
    }

    @Test(expectedExceptions = UsernameOrPasswordIncorrect.class)
    public void sharkLoginPasswordFail() {
        Mockito.when(sharkDAO.getSharkByUsername("Kelso"))
                .thenThrow(new UsernameOrPasswordIncorrect("Either your username or password or both are incorrect!"));
        sharkService.sharkLoginService("Keslo", "Show1");
    }

    // Correct credentials
    @Test
    public void sharkLoginSuccess() {
        Mockito.when(sharkDAO.getSharkByUsername("QueenQVC")).thenReturn(returnedSharkProfile);
        Shark result = sharkService.sharkLoginService("QuuenQVC", "qvc1");
        Assert.assertEquals(result, returnedSharkProfile);
    }


    // stub DAO results
    @Test
    public void createSharkProfileReturnedValue() {
        Mockito.when(sharkDAO.createSharkProfile(sharkProfile)).thenReturn(returnedSharkProfile);
        Shark result = sharkService.createSharkProfileService(sharkProfile);
        Assert.assertEquals(result, returnedSharkProfile);
    }






    // add stubbing test to make sure correct object is returned
    // positive test: show method handles correct login info

}
