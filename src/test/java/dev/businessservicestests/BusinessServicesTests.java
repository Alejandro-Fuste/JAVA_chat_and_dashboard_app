package dev.businessservicestests;


import com.investing_app.customexceptions.*;
import com.investing_app.dao.BusinessDAO;
import com.investing_app.entities.Business;
import com.investing_app.dao.BusinessDAOImp;
import com.investing_app.service.BusinessServices;
import com.investing_app.service.BusinessServicesImp;
import org.mockito.Mockito;
import org.testng.Assert;
import org.testng.annotations.BeforeClass;
import org.testng.annotations.Test;
import java.util.List;

public class BusinessServicesTests {

    static BusinessDAO businessDAO = new BusinessDAOImp();
    static BusinessServices businessServices = new BusinessServicesImp(businessDAO);

    static Business businessProfile;
    static Business businessProfile2;
    static Business tooLongRole;
    static Business tooLongRole2;
    static Business tooLongBusinessName;
    static Business tooLongBusinessName1;
    static Business withoutAName;
    static Business withoutAName2;
    static Business shortUsername;
    static Business shortUsername2;
    static Business longUserName;
    static Business longUserName2;
    static Business nonLetters;
    static Business nonLetters2;
    static List<Business> newList;


    @BeforeClass
    public void businessSetup() {
        businessDAO = Mockito.mock(BusinessDAO.class);
        businessServices = new BusinessServicesImp(businessDAO);
        businessProfile = new Business(0, "Tim", "Tebow", "Football Inc", "FBWizard", "Winnings", "business");
        businessProfile2 = new Business(1, "Tim", "Tebow", "Football Inc", "Socceris", "Winnings", "business");
        tooLongRole = new Business(0, "Ned", "Flanders", "Hello World Boxes", "Neddyiss", "Flanders", "businessbusiness");
        tooLongRole2 = new Business(1, "Ned", "Flanders", "Hello World Boxes", "Neddyiss", "Flanders", "businessbusiness");
        tooLongBusinessName = new Business(0, "Ned", "Flanders", "Hello World Boxes For all of the kinds of kids in the world and the extraordinary too!", "Neddy", "Flanders", "businessbusiness");
        tooLongBusinessName1 = new Business(1, "Ned", "Flanders", "Hello World Boxes For all of the kinds of kids in the world and the extraordinary too!", "Neddy", "Flanders", "businessbusiness");
        withoutAName = new Business(0, "Jim", "Jones", "", "MyUserNamer", "MyPWforme", "business");
        withoutAName2 = new Business(1, "Jim", "Jones", "", "MyUserNamer", "MyPWforme", "business");
        shortUsername = new Business(0, "Tiny", "Tim", "Legots B", "R", "MyNewPAssword", "business");
        shortUsername2 = new Business(1, "Tiny", "Tim", "Legots B", "R", "MyNewPAssword", "business");
        longUserName = new Business(0, "Mr", "Potter", "Pottersville", "IOwnAllAndIDoNotCareAboutItAtAllNoWayNoHowHaHaHa", "IAmOldAndMean", "business");
        longUserName2 = new Business(2, "Mr", "Potter", "Pottersville", "IOwnAllAndIDoNotCareAboutItAtAllNoWayNoHowHaHaHa", "IAmOldAndMean", "business");
        nonLetters = new Business(0, "Ti'ny1", "Tim", "PoorMan", "FeedMeSomeTurkey", "ScroogeIsNice", "business");
        nonLetters2 = new Business(1, "Ti'ny1", "Tim", "PoorMan", "FeedMeSomeTurkey", "ScroogeIsNice", "business");
    }

    @Test(expectedExceptions = UsernameOrPasswordError.class)
    public void loginCredentialsIncorrect(){
        Mockito.when(businessDAO.getBusinessByUsername("Wayne")).thenThrow(new UsernameOrPasswordError("Username or Password are incorrect"));
        businessServices.getBusinessLoginService("Wayne", "ImNotBatman");
    }

    @Test(expectedExceptions = UsernameOrPasswordError.class)
    public void businessLoginUsernameFailure(){
        Mockito.when(businessDAO.getBusinessByUsername(businessProfile2.getUsername())).thenReturn(businessProfile);
        businessServices.getBusinessLoginService(businessProfile2.getUsername(), businessProfile2.getPassword());
    }

    @Test(expectedExceptions = UsernameOrPasswordError.class)
    public void businessLoginPasswordFailure(){
        Mockito.when(businessDAO.getBusinessByUsername("Banner1")).thenThrow(new UsernameOrPasswordError("Username or Password are incorrect"));
        businessServices.getBusinessLoginService("Banner1", "ImNotHulk");
    }
    @Test(expectedExceptions = TooLong.class)
    public void createRoleTooLong(){
        Mockito.when(businessDAO.createBusiness(tooLongRole)).thenReturn(tooLongRole2);
        businessServices.getCreateBusinessService(tooLongRole);
    }
    @Test(expectedExceptions = TooLong.class)
    public void createBusinessNameTooLong(){
        Mockito.when(businessDAO.createBusiness(tooLongBusinessName)).thenReturn(tooLongBusinessName1);
        businessServices.getCreateBusinessService(tooLongBusinessName);
    }

    @Test(expectedExceptions = NoValueException.class)
    public void createBusinessWithNoName(){
        Mockito.when(businessDAO.createBusiness(withoutAName)).thenReturn(withoutAName2);
        businessServices.getCreateBusinessService(withoutAName);
    }

    @Test(expectedExceptions = NotEnoughChars.class)
    public void shortUserNameCreate(){
        Mockito.when(businessDAO.createBusiness(shortUsername)).thenReturn(shortUsername2);
        businessServices.getCreateBusinessService(shortUsername);
    }

    @Test(expectedExceptions = TooLong.class)
    public void longUserNameCreate(){
        Mockito.when(businessDAO.createBusiness(longUserName)).thenReturn(longUserName2);
        businessServices.getCreateBusinessService(longUserName);
    }

    @Test(expectedExceptions = OnlyLetters.class)
    public void nonLettersUsedInCreate(){
        Mockito.when(businessDAO.createBusiness(nonLetters)).thenReturn(nonLetters2);
        businessServices.getCreateBusinessService(nonLetters);
    }

    // Testing for unique username
    @Test(expectedExceptions = UsernameAlreadyExists.class)
    public void createBusinessProfileUniqueUsername() {
        Mockito.when(businessDAO.createBusiness(businessProfile))
                .thenThrow(new UsernameAlreadyExists("That username is already taken! Please try again."));
        businessServices.getCreateBusinessService(businessProfile);
    }

    // -------------------------  Stubbing Tests Below -----------------------------------------

    @Test
    public void businessByIdMockito(){
        Mockito.when(businessDAO.getBusinessById(businessProfile.getBusinessNumber())).thenReturn(businessProfile2);
        Business result = businessServices.getBusinessByIdService(businessProfile.getBusinessNumber());
        Assert.assertEquals(result, businessProfile2);
    }

    @Test
    public void viewAllBusinessesMockito(){
        Mockito.when(businessDAO.getAllBusinesses()).thenReturn(newList);
        List<Business> result = businessServices.getAllBusinessesService();
        Assert.assertEquals(result, newList);
    }

    @Test
    public void createBusinessMockito(){
        Mockito.when(businessDAO.createBusiness(businessProfile)).thenReturn(businessProfile2);
        Business creation = businessServices.getCreateBusinessService(businessProfile);
        Assert.assertEquals(creation, businessProfile2);
    }
}
