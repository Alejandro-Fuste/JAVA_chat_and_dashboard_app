package com.investing_app.databaseinteraction;

import com.investing_app.entities.NewPitch;
import com.investing_app.entities.Pitch;

import java.util.List;

public interface PitchDAO {
    Pitch createPitch(Pitch pitch);

    List<Pitch> viewPitches();

    boolean makeOffer(int pitchId, double amount, double percentage);

    boolean acceptOffer(int pitchId);
}
