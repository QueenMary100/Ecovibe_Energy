package com.example.biogas.controller;

import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class UssdController {

    @PostMapping("/ussd")
    public String handleUssd(
            @RequestParam String text,
            @RequestParam String phoneNumber) {

        String response = "";
        String mainMenu = "CON Welcome to Biogas Utility:\n" +
                "1. Register\n" +
                "2. Check Credit Balance\n" +
                "3. Submit Materials\n" +
                "4. Pay Bills";

        // Handle USSD logic based on user input
        if (text == null || text.isEmpty()) {
            // Main Menu
            response = mainMenu;
        } else if (text.equals("1")) {
            // Registration process
            response = "CON Enter your phone number to register:";
        } else if (text.equals("2")) {
            // Check credit balance (mocked)
            response = "END Your credit balance is 120 points.";
        } else if (text.equals("3")) {
            // Submit materials - material selection
            response = "CON Choose material type:\n" +
                    "1. Food Waste\n" +
                    "2. Plant Waste";
        } else if (text.startsWith("3*1") || text.startsWith("3*2")) {
            // Ask for material quantity after material type is chosen
            response = "CON Enter quantity:";
        } else if (text.startsWith("3*1*") || text.startsWith("3*2*")) {
            // Ask for pickup location after quantity is entered
            response = "CON Choose pickup/drop-off point:\n" +
                    "1. Location A\n" +
                    "2. Location B";
        } else if (text.equals("4")) {
            // Pay bills - ask for bill type
            response = "CON Choose bill type:\n" +
                    "1. Electricity\n" +
                    "2. Water";
        } else if (text.startsWith("4*")) {
            // Ask for account number after bill type is selected
            response = "CON Enter account number:";
        } else {
            // Default error message
            response = "END Invalid choice, please try again.";
        }

        return response;
    }
}
