package com.investing_app.databaseinteraction;

import com.investing_app.entities.Shark;

import java.util.List;

public interface SharkDAO {
    Shark createSharkProfile(Shark o);

    List<Shark> getAllSharks();

    Shark getSharkByUsername(String username);
}
