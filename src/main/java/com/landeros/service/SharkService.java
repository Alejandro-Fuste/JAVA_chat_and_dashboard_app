package com.landeros.service;

import com.landeros.entities.Shark;

import java.util.List;

public interface SharkService {
    Shark createSharkProfileService(Shark o);

    List<Shark> getAllSharksService();

    Shark sharkLoginService(String username, String password);
}
