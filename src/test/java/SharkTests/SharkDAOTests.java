package sharktests;

import com.investing_app.databaseinteraction.SharkDAO;
import com.investing_app.databaseinteraction.SharkDAOImplemented;
import com.investing_app.entities.Shark;
import org.testng.Assert;
import org.testng.annotations.Test;


public class SharkDAOTests {
    SharkDAO sharkDAO = new SharkDAOImplemented();

    @Test
    void sharkCreateProfile() {
        Shark shark1 = new Shark(0, "Ashton", "Kutcher", "Rich, Inc.",
                "Kelso", "70sShow", "Shark");
        Shark returnedShark = sharkDAO.createSharkProfile(shark1);
        Assert.assertTrue(returnedShark.getSharkId() != 0);
    }


    @Test
    void getSharkByUsername() {
        Shark returnedShark = sharkDAO.getSharkByUsername("Kelso");
        Assert.assertEquals(returnedShark.getUsername(), "Kelso");
    }
}
