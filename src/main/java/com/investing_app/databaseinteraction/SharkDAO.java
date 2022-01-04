package com.investing_app.databaseinteraction;

import com.investing_app.entities.Shark;

import java.util.List;

public interface SharkDAO {
    Shark createSharkProfile(Shark o);

    Shark getSharkByUsername(String username);
}
