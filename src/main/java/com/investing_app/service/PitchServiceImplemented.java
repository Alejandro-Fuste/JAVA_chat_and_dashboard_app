package com.landeros.service;

import com.landeros.databaseinteraction.PitchDAO;
import com.landeros.entities.Pitch;

import java.util.List;

public class PitchServiceImplemented implements PitchService{

    // declare pitch field
    PitchDAO pitchDAO;

    public PitchServiceImplemented (PitchDAO pitchDAO) {
        this.pitchDAO = pitchDAO;
    }

    @Override
    public List<Pitch> viewPitchesService() {
        return this.pitchDAO.viewPitches();
    }

    @Override
    public boolean makeOfferService(int pitchId, double amount, double percentage) {
        return this.pitchDAO.makeOffer(pitchId, amount, percentage);
    }

    @Override
    public boolean acceptOfferService(int pitchId) {
        return this.pitchDAO.acceptOffer(pitchId);
    }
}
