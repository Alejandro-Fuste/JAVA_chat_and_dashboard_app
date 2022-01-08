package com.investing_app.service;

import com.investing_app.customexceptions.IncorrectDataType;
import com.investing_app.customexceptions.NullValue;
import com.investing_app.customexceptions.TooManyChar;
import com.investing_app.customexceptions.UsernameOrPasswordIncorrect;
import com.investing_app.databaseinteraction.SharkDAO;
import com.investing_app.entities.Shark;

import java.util.List;
import java.util.Objects;
import java.util.regex.Pattern;

public class SharkServiceImplemented implements SharkService {

    SharkDAO sharkDAO;

    public SharkServiceImplemented (SharkDAO sharkDAO) {
        this.sharkDAO = sharkDAO;
    }

    @Override
    public Shark createSharkProfileService(Shark o) {
        Shark shark = this.sharkDAO.createSharkProfile(o);
        if ((o.getFirstName().length() > 20) || (o.getLastName().length() > 20) || (o.getBusinessName().length() > 30)
        || (o.getUsername().length() > 20) || (o.getPassword().length() > 30) || (o.getRole().length() > 10))
            throw new TooManyChar("You are exceeding the value length");
        if ((o.getFirstName().length() == 0) || (o.getLastName().length() == 0) || (o.getBusinessName().length() == 0)
                || (o.getUsername().length() == 0) || (o.getPassword().length() == 0) || (o.getRole().length() == 0))
            throw new NullValue("You must enter a value!");
        if (!Pattern.matches("^[a-zA-Z]*$", o.getFirstName()) ||
                !Pattern.matches("^[a-zA-Z]*$", o.getLastName()) ||
                !Pattern.matches("^[a-zA-Z]*$", o.getRole()))
            throw new IncorrectDataType("Input type not allowed");
        return shark;
    }


    @Override
    public Shark sharkLoginService(String username, String password) {
        Shark shark = this.sharkDAO.getSharkByUsername(username);
        if ((username.length() > 20) || (password.length() > 30))
            throw new TooManyChar("You are exceeding the value length");
        if ((username.length() == 0) || (password.length() == 0))
            throw new NullValue("You must enter a value!");
        if (!Objects.equals(shark.getUsername(), username) || (!Objects.equals(shark.getPassword(), password)))
            throw new UsernameOrPasswordIncorrect("Either your username or password or both are incorrect!");
        return shark;
    }
}
