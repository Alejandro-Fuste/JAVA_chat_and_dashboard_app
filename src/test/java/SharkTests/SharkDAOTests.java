package sharktests;

import com.landeros.customexceptions.SharkNotFound;
import com.landeros.databaseinteraction.SharkDAO;
import com.landeros.databaseinteraction.SharkDAOImplemented;
import com.landeros.entities.Shark;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class SharkDAOTests {
    SharkDAO sharkDAO = new SharkDAOImplemented();

    @Test
    void sharkCreateProfile() {
        Shark shark1 = new Shark(0, "Kevin", "O'Leary", "Millions, Inc.",
                "MrWonderful", "baldy1");
        Shark returnedShark = sharkDAO.createSharkProfile(shark1);
        Assert.assertTrue(returnedShark.getSharkId() != 0);
    }

    @Test
    void getAllSharks() {
        List<Shark> sharks = sharkDAO.getAllSharks();
        for (Shark s : sharks) {
            System.out.println(s);
        }
        Assert.assertTrue(sharks.size() >= 1);
    }

    @Test
    void getSharkByUsername() {
        Shark returnedShark = sharkDAO.getSharkByUsername("Kelso");
        Assert.assertEquals(returnedShark.getUsername(), "Kelso");
    }

    @Test(expectedExceptions = SharkNotFound.class, expectedExceptionsMessageRegExp = "Shark not found!")
    void getSharkByUsernameFail() {Shark shark = sharkDAO.getSharkByUsername("Bob");}
}
