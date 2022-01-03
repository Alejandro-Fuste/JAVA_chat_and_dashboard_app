package com.landeros.databaseinteraction;

import com.landeros.entities.Pitch;

import java.util.List;

public interface PitchDAO {
    List<Pitch> viewPitches();

    boolean makeOffer(int pitchId, double amount, double percentage);

    boolean acceptOffer(int pitchId);
}
