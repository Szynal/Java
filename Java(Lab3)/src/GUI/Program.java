package GUI;

import javax.swing.JPanel;
import javax.swing.JTextField;

public class Program extends JPanel {
	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	private JTextField textField;

	/**
	 * Create the panel.
	 */
	public Program() {
		setLayout(null);

		textField = new JTextField();
		textField.setBounds(91, 53, 266, 205);
		add(textField);
		textField.setColumns(10);

	}

}
