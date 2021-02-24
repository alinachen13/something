import java.awt.Color;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Map;
import javax.swing.*;

public class LogIn extends JFrame { // INHERITANCE POG
	// fields
	private JPanel panel = new JPanel();
	private JLabel error = new JLabel("*Wrong name and/or password");
	private JLabel label1 = new JLabel("First Name:");
	private JLabel label2 = new JLabel("Last Name:");
	private JLabel label3 = new JLabel("Password:");
	private JTextField firstName = new JTextField(20);
	private JTextField lastName = new JTextField(20);
	private JPasswordField pwd = new JPasswordField(20);
	private JButton btn = new JButton("Enter");
	private Map accounts;

	// LogIn class constructor
	public LogIn(Map<String, String> accounts) { // takes in a hashmap as a parameter
		this.accounts = accounts;
		setTitle("BDST");
		setVisible(true);
		setSize(350, 400);
		setDefaultCloseOperation(EXIT_ON_CLOSE);

		panel.add(label1);
		panel.add(firstName);
		panel.add(label2);
		panel.add(lastName);
		panel.add(label3);
		panel.add(pwd);
		panel.add(btn);
		panel.add(error);
		error.setForeground(Color.RED);
		error.setVisible(false);
		add(panel);

		btn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String fName = firstName.getText();
				String lName = lastName.getText();
				String pass = pwd.getText();
				// System.out.println(fName + lName + pass);
				if (!checkAccount(fName, lName, pass)) {
					error.setVisible(true);
				}
			}

		});
	}

	public boolean checkAccount(String firstName, String lastName, String pwd) {
		if (accounts.containsKey(firstName + lastName)) {
			if (accounts.get(firstName + lastName).equals(pwd)) {
				return true;
			}
		}
		return false;
	}

}
