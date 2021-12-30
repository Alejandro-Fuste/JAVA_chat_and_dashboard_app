package SharkTests;

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
        Shark shark1 = new Shark(0, "Ashton", "Kutcher", "Ashy, Inc",
                "Kelso", "70sShow");
        Shark returnedShark = sharkDAO.sharkCreateProfile(shark1);
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
}