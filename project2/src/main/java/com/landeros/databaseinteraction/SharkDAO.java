package com.landeros.databaseinteraction;

import com.landeros.entities.Shark;

import java.util.List;

public interface SharkDAO {
    Shark createSharkProfile(Shark o);

    List<Shark> getAllSharks();
}
