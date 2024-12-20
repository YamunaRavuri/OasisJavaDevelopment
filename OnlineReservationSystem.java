import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.util.HashMap;
import java.util.Map;

public class OnlineReservationSystem {
    private static Map<String, String> users = new HashMap<>(); 
    private static Map<String, String> reservations = new HashMap<>(); 
    private static String currentUser;

    public static void main(String[] args) {
        
        users.put("admin", "password");
        users.put("user", "12345");

        
        SwingUtilities.invokeLater(OnlineReservationSystem::showLoginForm);
    }

    private static void showLoginForm() {
        JFrame loginFrame = new JFrame("Login Form");
        loginFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        loginFrame.setSize(400, 200);
        loginFrame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblUsername = new JLabel("Username:");
        JTextField txtUsername = new JTextField();

        JLabel lblPassword = new JLabel("Password:");
        JPasswordField txtPassword = new JPasswordField();

        JButton btnLogin = new JButton("Login");
        JLabel lblMessage = new JLabel("", SwingConstants.CENTER);

        btnLogin.addActionListener(e -> {
            String username = txtUsername.getText();
            String password = new String(txtPassword.getPassword());

            if (users.containsKey(username) && users.get(username).equals(password)) {
                currentUser = username;
                loginFrame.dispose();
                showMainMenu();
            } else {
                lblMessage.setText("Invalid Username or Password!");
                lblMessage.setForeground(Color.RED);
            }
        });

        loginFrame.add(lblUsername);
        loginFrame.add(txtUsername);
        loginFrame.add(lblPassword);
        loginFrame.add(txtPassword);
        loginFrame.add(btnLogin);
        loginFrame.add(lblMessage);

        loginFrame.setLocationRelativeTo(null);
        loginFrame.setVisible(true);
    }

    private static void showMainMenu() {
        JFrame mainMenuFrame = new JFrame("Main Menu");
        mainMenuFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        mainMenuFrame.setSize(400, 300);
        mainMenuFrame.setLayout(new GridLayout(3, 1, 10, 10));

        JButton btnReservation = new JButton("Reservation System");
        JButton btnCancellation = new JButton("Cancellation Form");
        JButton btnLogout = new JButton("Logout");

        btnReservation.addActionListener(e -> {
            mainMenuFrame.dispose();
            showReservationForm();
        });

        btnCancellation.addActionListener(e -> {
            mainMenuFrame.dispose();
            showCancellationForm();
        });

        btnLogout.addActionListener(e -> {
            mainMenuFrame.dispose();
            currentUser = null;
            showLoginForm();
        });

        mainMenuFrame.add(btnReservation);
        mainMenuFrame.add(btnCancellation);
        mainMenuFrame.add(btnLogout);

        mainMenuFrame.setLocationRelativeTo(null);
        mainMenuFrame.setVisible(true);
    }

    private static void showReservationForm() {
        JFrame reservationFrame = new JFrame("Reservation System");
        reservationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        reservationFrame.setSize(400, 300);
        reservationFrame.setLayout(new GridLayout(6, 2, 10, 10));

        JLabel lblPNR = new JLabel("PNR Number:");
        JTextField txtPNR = new JTextField();

        JLabel lblTrainNumber = new JLabel("Train Number:");
        JTextField txtTrainNumber = new JTextField();

        JLabel lblTrainName = new JLabel("Train Name:");
        JTextField txtTrainName = new JTextField();

        JLabel lblDate = new JLabel("Date of Journey:");
        JTextField txtDate = new JTextField();

        JButton btnReserve = new JButton("Reserve");
        JButton btnBack = new JButton("Back");
        JLabel lblMessage = new JLabel("", SwingConstants.CENTER);

        btnReserve.addActionListener(e -> {
            String pnr = txtPNR.getText();
            String trainNumber = txtTrainNumber.getText();
            String trainName = txtTrainName.getText();
            String date = txtDate.getText();

            if (pnr.isEmpty() || trainNumber.isEmpty() || trainName.isEmpty() || date.isEmpty()) {
                lblMessage.setText("All fields are required!");
                lblMessage.setForeground(Color.RED);
            } else {
                reservations.put(pnr, "Train: " + trainNumber + ", " + trainName + ", Date: " + date);
                lblMessage.setText("Reservation Successful!");
                lblMessage.setForeground(Color.GREEN);
            }
        });

        btnBack.addActionListener(e -> {
            reservationFrame.dispose();
            showMainMenu();
        });

        reservationFrame.add(lblPNR);
        reservationFrame.add(txtPNR);
        reservationFrame.add(lblTrainNumber);
        reservationFrame.add(txtTrainNumber);
        reservationFrame.add(lblTrainName);
        reservationFrame.add(txtTrainName);
        reservationFrame.add(lblDate);
        reservationFrame.add(txtDate);
        reservationFrame.add(btnReserve);
        reservationFrame.add(btnBack);
        reservationFrame.add(lblMessage);

        reservationFrame.setLocationRelativeTo(null);
        reservationFrame.setVisible(true);
    }

    private static void showCancellationForm() {
        JFrame cancellationFrame = new JFrame("Cancellation Form");
        cancellationFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        cancellationFrame.setSize(400, 200);
        cancellationFrame.setLayout(new GridLayout(3, 2, 10, 10));

        JLabel lblPNR = new JLabel("PNR Number:");
        JTextField txtPNR = new JTextField();

        JButton btnCancel = new JButton("Cancel");
        JButton btnBack = new JButton("Back");
        JLabel lblMessage = new JLabel("", SwingConstants.CENTER);

        btnCancel.addActionListener(e -> {
            String pnr = txtPNR.getText();

            if (reservations.containsKey(pnr)) {
                reservations.remove(pnr);
                lblMessage.setText("Cancellation Successful!");
                lblMessage.setForeground(Color.GREEN);
            } else {
                lblMessage.setText("PNR not found!");
                lblMessage.setForeground(Color.RED);
            }
        });

        btnBack.addActionListener(e -> {
            cancellationFrame.dispose();
            showMainMenu();
        });

        cancellationFrame.add(lblPNR);
        cancellationFrame.add(txtPNR);
        cancellationFrame.add(btnCancel);
        cancellationFrame.add(btnBack);
        cancellationFrame.add(lblMessage);

        cancellationFrame.setLocationRelativeTo(null);
        cancellationFrame.setVisible(true);
    }
}
