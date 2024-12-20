import java.util.*;

class OnlineExamination {
    private static Scanner scanner = new Scanner(System.in);
    private static String username = "user";
    private static String password = "password";
    private static boolean isLoggedIn = false;

    private static void login() {
        System.out.println("\n--- Login ---");
        System.out.print("Enter Username: ");
        String enteredUsername = scanner.nextLine();
        System.out.print("Enter Password: ");
        String enteredPassword = scanner.nextLine();

        if (enteredUsername.equals(username) && enteredPassword.equals(password)) {
            isLoggedIn = true;
            System.out.println("Login Successful!");
        } else {
            System.out.println("Invalid Username or Password. Try Again.");
        }
    }

    private static void updateProfile() {
        if (!isLoggedIn) {
            System.out.println("You need to login first.");
            return;
        }

        System.out.println("\n--- Update Profile ---");
        System.out.print("Enter New Username: ");
        username = scanner.nextLine();
        System.out.print("Enter New Password: ");
        password = scanner.nextLine();
        System.out.println("Profile Updated Successfully!");
    }

    private static void takeExam() {
        if (!isLoggedIn) {
            System.out.println("You need to login first.");
            return;
        }

        System.out.println("\n--- Exam Started ---");
        String[] questions = {
                "Q1: What is the capital of France?\n1) Berlin\n2) Madrid\n3) Paris\n4) Rome",
                "Q2: Which planet is known as the Red Planet?\n1) Earth\n2) Mars\n3) Jupiter\n4) Saturn",
                "Q3: Who wrote 'Hamlet'?\n1) Charles Dickens\n2) Mark Twain\n3) William Shakespeare\n4) Leo Tolstoy"
        };

        int[] answers = { 3, 2, 3 };
        int score = 0;
        int timer = 30; // seconds

        for (int i = 0; i < questions.length; i++) {
            System.out.println(questions[i]);
            System.out.print("Your Answer (1-4): ");

            long startTime = System.currentTimeMillis();
            int userAnswer = scanner.nextInt();
            long endTime = System.currentTimeMillis();

            if ((endTime - startTime) / 1000 > timer) {
                System.out.println("Time's up! Moving to the next question.");
                continue;
            }

            if (userAnswer == answers[i]) {
                score++;
            }
        }

        System.out.println("\n--- Exam Finished ---");
        System.out.println("Your Score: " + score + "/" + questions.length);
    }

    private static void logout() {
        if (!isLoggedIn) {
            System.out.println("You are not logged in.");
            return;
        }

        isLoggedIn = false;
        System.out.println("Logged out successfully.");
    }

    public static void main(String[] args) {
        while (true) {
            System.out.println("\n--- Online Examination System ---");
            System.out.println("1. Login");
            System.out.println("2. Update Profile and Password");
            System.out.println("3. Take Exam");
            System.out.println("4. Logout");
            System.out.println("5. Exit");
            System.out.print("Choose an option: ");

            int choice = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            switch (choice) {
                case 1:
                    login();
                    break;
                case 2:
                    updateProfile();
                    break;
                case 3:
                    takeExam();
                    break;
                case 4:
                    logout();
                    break;
                case 5:
                    System.out.println("Exiting... Goodbye!");
                    return;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}
