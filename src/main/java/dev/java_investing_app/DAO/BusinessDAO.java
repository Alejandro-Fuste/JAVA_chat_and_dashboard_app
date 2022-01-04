package dev.java_investing_app.DAO;

import dev.java_investing_app.entities.Business;

import java.util.List;

public interface BusinessDAO {

    Business createBusiness(Business business);

    Business getBusinessById(int id);

    List<Business> getAllBusinesses();

//    Business businessLogin(String username, String password);

    Business getBusinessByUsername(String username);
}
