package com.landeros.service;

import com.landeros.entities.Pitch;

import java.util.List;

public interface PitchService {
    List<Pitch> viewPitchesService();

    boolean makeOfferService(int pitchId, double amount, double percentage);

    boolean acceptOfferService(int pitchId);
}
