import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

public class Registration extends JFrame implements ActionListener {
    private JTextField idField, nameField, emailField, dobField, phoneField;
    private JTextArea addressArea;
    private JButton submitButton, resetButton;
    private UserDao userDao;

    public Registration() {
        userDao = new UserDao();

        // Set up the frame
        setTitle("User Registration Form");
        getContentPane().setBackground(new Color(109, 164, 170));
        setSize(750, 300);
        setLocation(350, 250);
        setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        setLayout(new GridLayout(8, 2));

        // Create form components
        JLabel idLabel = new JLabel("ID:");
        idField = new JTextField();
        idLabel.setBounds(40,20,100,30);
        idLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        idLabel.setBackground(Color.BLACK);
        idField.setEditable(false); // ID is auto-generated

        JLabel nameLabel = new JLabel("Name:");
        nameField = new JTextField();
        nameLabel.setBounds(40,20,100,30);
        nameLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        nameLabel.setBackground(Color.BLACK);


        JLabel emailLabel = new JLabel("Email:");
        emailField = new JTextField();
        emailLabel.setBounds(40,20,100,30);
        emailLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        emailLabel.setBackground(Color.BLACK);


        JLabel dobLabel = new JLabel("Date of Birth (dd/mm/yyyy):");
        dobField = new JTextField();
        dobLabel.setBounds(40,20,100,30);
        dobLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        dobLabel.setBackground(Color.BLACK);


        JLabel phoneLabel = new JLabel("Phone Number:");
        phoneField = new JTextField();
        phoneLabel.setBounds(40,20,100,30);
        phoneLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        phoneLabel.setBackground(Color.BLACK);


        JLabel addressLabel = new JLabel("Address:");
        addressArea = new JTextArea();
        addressLabel.setBounds(40,20,100,30);
        addressLabel.setFont(new Font("Tahoma",Font.BOLD,15));
        addressLabel.setBackground(Color.BLACK);
        addressArea.setRows(2);
        addressArea.setLineWrap(true);
        addressArea.setWrapStyleWord(true);

        submitButton = new JButton("Submit");
        submitButton.setBounds(40, 140, 120, 30);
        submitButton.setFont(new Font("serif",Font.BOLD,15));
        submitButton.setBackground(Color.BLACK);
        submitButton.setForeground(Color.WHITE);

        resetButton = new JButton("Reset");
        resetButton.setBounds(40, 140, 120, 30);
        resetButton.setFont(new Font("serif",Font.BOLD,15));
        resetButton.setBackground(Color.BLACK);
        resetButton.setForeground(Color.WHITE);

        // Add action listeners
        submitButton.addActionListener(this);
        resetButton.addActionListener(this);

        // Add components to the frame
        add(idLabel);
        add(idField);

        add(nameLabel);
        add(nameField);

        add(emailLabel);
        add(emailField);

        add(dobLabel);
        add(dobField);

        add(phoneLabel);
        add(phoneField);

        add(addressLabel);
        add(new JScrollPane(addressArea));

        add(submitButton);
        add(resetButton);

        setVisible(true);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if (e.getSource() == submitButton) {
            // Retrieve form data
            String name = nameField.getText();
            String email = emailField.getText();
            String dobString = dobField.getText();
            String phone = phoneField.getText();
            String address = addressArea.getText();

            // Basic validation
            if (name.isEmpty() || email.isEmpty() || dobString.isEmpty()) {
                JOptionPane.showMessageDialog(this, "Please fill in all required fields.");
                return;
            }

            // Parse Date of Birth
            Date dob;
            try {
                SimpleDateFormat sdf = new SimpleDateFormat("dd/MM/yyyy");
                dob = sdf.parse(dobString);
            } catch (ParseException ex) {
                JOptionPane.showMessageDialog(this, "Invalid Date of Birth format. Use dd/MM/yyyy.");
                return;
            }

            // Create User object
            User newUser = new User(0, name, email, dob, phone, address);

            // Create user in database
            userDao.createUser(newUser);
            JOptionPane.showMessageDialog(this, "User registered successfully!");

            // Reset the form
            resetForm();
        } else if (e.getSource() == resetButton) {
            resetForm();
        }
    }

    private void resetForm() {
        nameField.setText("");
        emailField.setText("");
        dobField.setText("");
        phoneField.setText("");
        addressArea.setText("");
    }

    public static void main(String[] args) {
        SwingUtilities.invokeLater(Registration::new);
    }
}
