package com.landeros.app;

import com.landeros.controllers.PitchController;
import com.landeros.controllers.SharkController;
import com.landeros.databaseinteraction.PitchDAO;
import com.landeros.databaseinteraction.PitchDAOImplemented;
import com.landeros.databaseinteraction.SharkDAO;
import com.landeros.databaseinteraction.SharkDAOImplemented;
import com.landeros.service.PitchService;
import com.landeros.service.PitchServiceImplemented;
import com.landeros.service.SharkService;
import com.landeros.service.SharkServiceImplemented;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        // Shark
        SharkDAO sharkDAO = new SharkDAOImplemented();
        SharkService sharkService = new SharkServiceImplemented(sharkDAO);
        SharkController sharkController = new SharkController(sharkService);

        // Pitch
        PitchDAO pitchDAO = new PitchDAOImplemented();
        PitchService pitchService = new PitchServiceImplemented(pitchDAO);
        PitchController pitchController = new PitchController(pitchService);

        // Shark
        app.post("/shark", sharkController.createSharkProfile);

        app.get("/sharks", sharkController.getAllSharks);

        app.post("/shark/login", sharkController.sharkLogin);

        //Pitch
        app.get("/pitches", pitchController.viewPitches);

        app.patch("/offer", pitchController.makeOffer);

        app.patch("/accept/{pitchId}", pitchController.acceptOffer);


        app.start();
    }
}
