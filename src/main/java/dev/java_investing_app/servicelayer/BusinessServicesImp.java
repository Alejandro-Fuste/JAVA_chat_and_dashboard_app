package dev.java_investing_app.servicelayer;

import com.landeros.customexceptions.UsernameOrPasswordIncorrect;
import com.landeros.entities.Shark;
import dev.java_investing_app.DAO.BusinessDAO;
import dev.java_investing_app.customexceptions.BusinessNotFound;

import dev.java_investing_app.customexceptions.UsernameOrPasswordError;
import dev.java_investing_app.entities.Business;

import java.util.List;
import java.util.Objects;

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

    @Override
    public Business getBusinessLoginService(String username, String password) {
            Business business = this.businessDAO.getBusinessByUsername(username);
            if (!Objects.equals(business.getUsername(), username) || !Objects.equals(business.getPassword(), password))
                throw new UsernameOrPasswordError("Username or Password are incorrect");
            return business;
    }
}
