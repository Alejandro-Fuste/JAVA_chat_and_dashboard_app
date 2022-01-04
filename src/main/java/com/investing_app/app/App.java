package com.investing_app.app;

import com.investing_app.controllers.PitchController;
import com.investing_app.controllers.SharkController;
import com.investing_app.databaseinteraction.PitchDAO;
import com.investing_app.databaseinteraction.PitchDAOImplemented;
import com.investing_app.databaseinteraction.SharkDAO;
import com.investing_app.databaseinteraction.SharkDAOImplemented;
import com.investing_app.service.PitchService;
import com.investing_app.service.PitchServiceImplemented;
import com.investing_app.service.SharkService;
import com.investing_app.service.SharkServiceImplemented;
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

        app.post("/shark/login", sharkController.sharkLogin);

        //Pitch
        app.get("/pitches", pitchController.viewPitches);

        app.patch("/offer", pitchController.makeOffer);

        app.patch("/accept/{pitchId}", pitchController.acceptOffer);


        app.start();
    }
}
