package com.investing_app.databaseinteraction;

import com.investing_app.entities.Shark;

public interface SharkDAO {
    Shark createSharkProfile(Shark o);

    Shark getSharkByUsername(String username);
}
