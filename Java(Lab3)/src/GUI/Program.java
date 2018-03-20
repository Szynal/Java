package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import java.awt.Font;
import javax.swing.JScrollPane;
import javax.swing.ScrollPaneConstants;

public class Program extends JPanel {

	private static final long serialVersionUID = 1L;
	public JScrollPane scrollPane;
	public static JTextArea textArea;

	/**
	 * Create the panel.
	 */
	public Program() {
		setLayout(null);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(15, 16, 770, 343);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);

	}
}
