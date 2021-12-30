package com.landeros.databaseinteraction;

import com.landeros.entities.Shark;

import java.sql.SQLException;
import java.util.List;

public class SharkDAOImplemented implements SharkDAO{

    @Override
    public Shark createSharkProfile(Shark shark) {
        try () {}
        catch (SQLException e) {
            e.printStackTrace();
            return null;
        }
    }

    @Override
    public List<Shark> getAllSharks() {
        return null;
    }
}
