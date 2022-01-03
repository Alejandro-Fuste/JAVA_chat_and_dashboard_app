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
    void testCreateBusiness(){
        Business newBusiness = new Business(0,"first", "last", "bizName", "UN", "PW");
        Business returnedBusiness = businessDAO.createBusiness(newBusiness);
        Assert.assertTrue(returnedBusiness.getBusinessNumber() != 0);
    }
    @Test
    void selectBusinessById(){
        Business business = businessDAO.getBusinessById(1);
        Assert.assertEquals(business.getBusinessNumber(), 1);
    }
    @Test
    void getAllBusinesses(){
        List<Business> businesses = businessDAO.getAllBusinesses();
        Assert.assertTrue(businesses.size() >= 2);
        for (Business b : businesses){
            System.out.println(b);
            System.out.println();
        }
    }
}
