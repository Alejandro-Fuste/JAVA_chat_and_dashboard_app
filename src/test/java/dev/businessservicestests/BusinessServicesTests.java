package dev.businessservicestests;

import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.customexceptions.BusinessNotFound;
import dev.java_investing_app.customexceptions.UsernameOrPasswordError;
import dev.java_investing_app.entities.Business;
import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.DAO.BusinessDAOImp;
import dev.java_investing_app.servicelayer.BusinessServices;
import dev.java_investing_app.servicelayer.BusinessServicesImp;
import org.testng.annotations.Test;

public class BusinessServicesTests {

    static BusinessDAO businessDAO = new BusinessDAOImp();
    static BusinessServices businessServices = new BusinessServicesImp(businessDAO);

    @Test(expectedExceptions = BusinessNotFound.class, expectedExceptionsMessageRegExp = "Business not found")
    void badIdForBusiness(){
        Business anotherBusiness = businessServices.getBusinessByIdService(2345);
    }
    @Test(expectedExceptions = UsernameOrPasswordError.class, expectedExceptionsMessageRegExp = "Username or Password are incorrect")
    void badLogin(){
        Business newBusiness = businessServices.getBusinessLoginService("Lex", "Luther");
    }
}
