package dev.java_investing_app.servicelayer;

import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.customexceptions.BusinessNotFound;

import dev.java_investing_app.entities.Business;

import java.util.List;

public class BusinessServicesImp implements BusinessServices{
    BusinessDAO businessDAO;
    public BusinessServicesImp (BusinessDAO businessDAO){
        this.businessDAO = businessDAO;
    }

    @Override
    public Business getCreateBusinessService(Business business) {
        return this.businessDAO.createBusiness(business);
    }

    @Override
    public Business getBusinessByIdService(int id) {
        try {
            Business business = this.businessDAO.getBusinessById(id);
            return business;
        }
            catch(BusinessNotFound e) {
                throw new BusinessNotFound("Business not found");
            }
    }

    @Override
    public List<Business> getAllBusinessesService() {
        return this.businessDAO.getAllBusinesses();
    }
}
