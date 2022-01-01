package dev.java_investing_app.app.java.dev.java_investing_app.app;

import dev.java_investing_app.app.java.dev.java_investing_app.controllers.AppController;
import io.javalin.Javalin;

public class App {
    public static void main(String[] args) {
        // app variable to creates Javalin connection
        Javalin app = Javalin.create(config -> {
            config.enableCorsForAllOrigins();
            config.enableDevLogging();
        });

        // need to do dependency injection for DAO & service layer here
        // create appController variable
        AppController appController = new AppController();

        // routes

        // home route
        app.get("/", appController.hello);

        // start app connection
        app.start();
    }

}
