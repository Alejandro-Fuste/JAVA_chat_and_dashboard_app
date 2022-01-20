package com.investing_app.service;

import com.investing_app.customexceptions.*;
import com.investing_app.dao.BusinessDAO;
import com.investing_app.entities.Business;
import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;


public class BusinessServicesImp implements BusinessServices {
    BusinessDAO businessDAO;
    public BusinessServicesImp(BusinessDAO businessDAO) {
        this.businessDAO = businessDAO;
    }

    @Override
    public Business getCreateBusinessService(Business business) {
        List<Business> businesses = this.businessDAO.getAllBusinesses();
        try {
            for (Business _business : businesses) {
                if (Objects.equals(_business.getUsername(), business.getUsername()))
                    throw new UsernameAlreadyExists("That username is already taken! Please try again.");
            }
            if (business.getRole().length() > 10 || business.getLastName().length() > 20 || business.getFirstName().length() > 20 || business.getUsername().length() > 30 || business.getPassword().length() > 30 || business.getBusinessName().length() > 30) {
                throw new TooLong("Your input is too many characters");
            } else if (business.getRole().length() == 0 || business.getUsername().length() == 0 || business.getPassword().length() == 0 || business.getFirstName().length() == 0 || business.getLastName().length() == 0 || business.getBusinessName().length() == 0) {
                throw new NoValueException("Cannot leave boxes empty");
            } else if (business.getBusinessName().length() <= 2 || business.getUsername().length() < 2 || business.getPassword().length() < 2 || business.getRole().length() < 5) {
                throw new NotEnoughChars("Need to fill out the minimum amount of characters");
            } else if (!Pattern.matches("^[a-zA-Z]*$", business.getFirstName())) {
                throw new OnlyLetters("Can only use letters in this field");
            } else if (!Pattern.matches("^[a-zA-Z]*$", business.getLastName())) {
                throw new OnlyLetters("Can only use letters in this field");
            }
            else {
                return this.businessDAO.createBusiness(business);
            }
        } catch (CreateBusinessException e) {
            throw new CreateBusinessException("Unable to create profile");
        }
    }

    @Override
    public Business getBusinessByIdService(int id) {
        try {
            return this.businessDAO.getBusinessById(id);
        } catch (BusinessNotFound e) {
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