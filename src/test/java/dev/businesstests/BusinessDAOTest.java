package dev.businesstests;

import com.investing_app.entities.Business;
import com.investing_app.dao.BusinessDAO;
import com.investing_app.dao.BusinessDAOImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BusinessDAOTest {

    BusinessDAO businessDAO = new BusinessDAOImp();

    @Test
    void testCreateBusiness() {
        Business newBusiness = new Business(0, "Tim", "Tebow", "QB Training In", "Usernames4", "Passwords", "business");
        Business returnedBusiness = businessDAO.createBusiness(newBusiness);
        Assert.assertTrue(returnedBusiness.getBusinessNumber() != 0);
    }

    @Test
    void selectBusinessById() {
        Business business = businessDAO.getBusinessById(1);
        Assert.assertEquals(business.getBusinessNumber(), 1);
    }

    @Test
    void getAllBusinesses() {
        List<Business> businesses = businessDAO.getAllBusinesses();
        Assert.assertTrue(businesses.size() >= 2);
        for (Business b : businesses) {
            System.out.println(b);
            System.out.println();
        }
    }

    @Test
    void testGetBusinessByUserName() {
        Business newBusiness = businessDAO.getBusinessByUsername("Wayne100");
        System.out.println("new business is " + newBusiness);
        Assert.assertEquals(newBusiness.getUsername(), "Wayne100");
    }
}
