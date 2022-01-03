package com.landeros.service;

import com.landeros.customexceptions.SharkNotFound;
import com.landeros.customexceptions.UsernameOrPasswordIncorrect;
import com.landeros.databaseinteraction.SharkDAO;
import com.landeros.entities.Shark;

import java.util.List;
import java.util.Objects;

public class SharkServiceImplemented implements SharkService {

    SharkDAO sharkDAO;

    public SharkServiceImplemented (SharkDAO sharkDAO) {
        this.sharkDAO = sharkDAO;
    }

    @Override
    public Shark createSharkProfileService(Shark o) {
        return this.sharkDAO.createSharkProfile(o);
    }

    @Override
    public List<Shark> getAllSharksService() {
        return this.sharkDAO.getAllSharks();
    }


    @Override
    public Shark sharkLoginService(String username, String password) {
        Shark shark = this.sharkDAO.getSharkByUsername(username);
        if (!Objects.equals(shark.getUsername(), username))
            throw new UsernameOrPasswordIncorrect("Either your username or password or both are incorrect!");
        return shark;

    }
}
