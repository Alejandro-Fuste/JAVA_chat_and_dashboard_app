package com.investing_app.databaseinteraction;

import com.investing_app.entities.Business;

import java.util.List;

public interface BusinessDAO {

    Business createBusiness(Business business);

    Business getBusinessById(int id);

    List<Business> getAllBusinesses();

    Business getBusinessByUsername(String username);
}
