package com.investing_app.controllers;

import com.google.gson.Gson;
import com.investing_app.customexceptions.UsernameOrPasswordIncorrect;
import com.investing_app.entities.Shark;
import com.investing_app.service.SharkService;
import io.javalin.http.Handler;

import java.util.List;
import java.util.Map;

public class SharkController {
    SharkService sharkService;

    public SharkController(SharkService sharkService) {
        this.sharkService = sharkService;
    }

    public Handler createSharkProfile = ctx -> {
        Gson gson = new Gson();
        Shark newShark = gson.fromJson(ctx.body(), Shark.class);
        Shark createdShark = this.sharkService.createSharkProfileService(newShark);
        String createdSharkJson = gson.toJson(createdShark);
        ctx.result(createdSharkJson);
        ctx.status(201);
    };

    public Handler getAllSharks = ctx -> {
        List<Shark> sharks = this.sharkService.getAllSharksService();
        Gson gson = new Gson();
        String sharksJSONs = gson.toJson(sharks);
        ctx.result(sharksJSONs);
        ctx.status(200);
    };

    public Handler sharkLogin = ctx -> {
        Gson gson = new Gson();
        Map<String, String> credentials = gson.fromJson(ctx.body(), Map.class);
        try {
            Shark sharkLoggedIn = this.sharkService.sharkLoginService(credentials.get("username"), credentials.get("password"));
            String sharkLoggedInJson = gson.toJson(sharkLoggedIn);
            ctx.result(sharkLoggedInJson);
            ctx.status(200);
        }
        catch (UsernameOrPasswordIncorrect e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
        catch (Exception e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}
