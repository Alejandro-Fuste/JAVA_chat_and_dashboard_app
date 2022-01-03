package com.landeros.app;

import com.landeros.controllers.SharkController;
import com.landeros.databaseinteraction.SharkDAO;
import com.landeros.databaseinteraction.SharkDAOImplemented;
import com.landeros.service.SharkService;
import com.landeros.service.SharkServiceImplemented;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        Javalin app = Javalin.create(config -> {
            config.enableDevLogging();
            config.enableCorsForAllOrigins();
        });

        SharkDAO sharkDAO = new SharkDAOImplemented();
        SharkService sharkService = new SharkServiceImplemented(sharkDAO);
        SharkController sharkController = new SharkController(sharkService);

        app.post("/shark", sharkController.createSharkProfile);

        app.get("/sharks", sharkController.getAllSharks);

        app.post("/shark/login", sharkController.sharkLogin);


        app.start();
    }
}
