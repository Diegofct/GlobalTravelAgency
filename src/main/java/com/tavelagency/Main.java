package com.tavelagency;

import java.util.Scanner;

import Plane.infrastructure.in.PlaneController;

public class Main {
    public static void main(String[] args) {
        // MainMenu menuPrincipal = new MainMenu();
        // menuPrincipal.Start();
        Scanner scanner = new Scanner(System.in);
        PlaneController planeController = new PlaneController(scanner);
        planeController.run();
    }
}