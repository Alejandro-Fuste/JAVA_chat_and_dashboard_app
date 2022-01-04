package dev.businesstests;

import dev.java_investing_app.entities.Business;
import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.DAO.BusinessDAOImp;
import org.testng.Assert;
import org.testng.annotations.Test;

import java.util.List;

public class BusinessDAOTest {

    BusinessDAO businessDAO = new BusinessDAOImp();

    @Test
    void testCreateBusiness() {
        Business newBusiness = new Business(0, "first", "last", "bizName", "UN", "PW");
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


    // ------------------  Unused Method --------------------------------
//    @Test
//    void testBusinessLogin(){
//        Business business = businessDAO.businessLogin("Wayne100", "ImBatman");
////        Assert.assertTrue(business.getBusinessName() == "Wayne Enterprises");
//        Assert.assertSame(business.getFirstName(), "Wayne", "These names do not match");
//    }
