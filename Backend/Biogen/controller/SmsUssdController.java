@Autowired
AfricasTalkingService africasTalkingService;

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

    if (text == null || text.isEmpty()) {
        response = mainMenu;
    } else if (text.equals("1")) {
        response = "CON Enter your phone number to register:";
        africasTalkingService.sendSms(phoneNumber, "Welcome to Biogas Utility! You are now registered.");
    } else if (text.equals("2")) {
        response = "END Your credit balance is 120 points.";
    } else if (text.equals("3")) {
        response = "CON Choose material type:\n1. Food Waste\n2. Plant Waste";
    } else {
        response = "END Invalid choice, please try again.";
    }

    return response;
}
