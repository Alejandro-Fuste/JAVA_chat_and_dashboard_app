package com.landeros.service;

import com.landeros.entities.Pitch;

import java.util.List;

public class PitchServiceImplemented implements PitchService{
    @Override
    public List<Pitch> viewPitchesService() {
        return null;
    }

    @Override
    public boolean makeOfferService(int pitchId, double amount, double percentage) {
        return false;
    }

    @Override
    public boolean acceptOfferService(int pitchId) {
        return false;
    }
}
