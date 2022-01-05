package com.investing_app.service;

import com.investing_app.service.PitchService;
import com.investing_app.databaseinteraction.PitchDAO;
import com.investing_app.entities.Pitch;

import java.util.List;

public class PitchServiceImplemented implements PitchService {

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
