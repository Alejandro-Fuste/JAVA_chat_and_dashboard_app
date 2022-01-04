package com.landeros.controllers;

import com.google.gson.Gson;
import com.landeros.entities.Offer;
import com.landeros.entities.Pitch;
import com.landeros.service.PitchService;

import java.util.List;
import java.util.Map;

import io.javalin.http.Handler;

public class PitchController {

    PitchService pitchService;

    public PitchController(PitchService pitchService) {
        this.pitchService = pitchService;
    }

    public Handler viewPitches = ctx -> {
        List<Pitch> pitches = this.pitchService.viewPitchesService();
        Gson gson = new Gson();
        String pitchesJSONs = gson.toJson(pitches);
        ctx.result(pitchesJSONs);
        ctx.status(200);
    };

    public Handler makeOffer = ctx -> {
        Gson gson = new Gson();
        Offer offerMade = gson.fromJson(ctx.body(), Offer.class);
        boolean offer = this.pitchService.makeOfferService(offerMade.getPitchId(),
                offerMade.getAmount(), offerMade.getPercentage());
        ctx.result(String.valueOf(offer));
        ctx.status(200);
    };

    public Handler acceptOffer = ctx -> {
        int pitchId = Integer.parseInt(ctx.pathParam("pitchId"));
        boolean offerAccepted = this.pitchService.acceptOfferService(pitchId);
        ctx.result(String.valueOf(offerAccepted));
        ctx.status(200);
    };
}
