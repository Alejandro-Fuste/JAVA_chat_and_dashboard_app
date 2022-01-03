package com.landeros.controllers;

import com.google.gson.Gson;
import com.landeros.customexceptions.UsernameOrPasswordIncorrect;
import com.landeros.entities.Shark;
import com.landeros.service.SharkService;
import io.javalin.http.Handler;

import java.util.List;

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
        String username = gson.toJson(ctx.body(), String.class);
        String password = gson.toJson(ctx.body(), String.class);
        try {
            Shark sharkLoggedIn = this.sharkService.sharkLoginService(username, password);
            String sharkLoggedInJson = gson.toJson(sharkLoggedIn);
            ctx.result(sharkLoggedInJson);
            ctx.status(200);
        }
        catch (UsernameOrPasswordIncorrect e) {
            ctx.result(e.getMessage());
            ctx.status(404);
        }
    };
}
