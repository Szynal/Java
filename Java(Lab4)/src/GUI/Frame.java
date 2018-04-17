package GUI;

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.CardLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import javax.swing.JSpinner;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import java.awt.Font;
import javax.swing.JRadioButton;
import javax.swing.JTextField;

public class Frame {

	private JFrame frame;
	private JPanel mainPanel;

	private JButton btnStart;
	private JLabel lblTSP;
	private JTextField textFieldCityPath;
	private JRadioButton rdbtnRandomCity;
	private JRadioButton rdbtnCityFromFile;
	private JSpinner spinner;
	private JLabel lblNumberOfCities;
	private JLabel lblFilePath;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Frame() {
		initialize();

	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setResizable(false);
		frame.setAutoRequestFocus(false);
		frame.setFont(new Font("Arial", Font.PLAIN, 18));
		frame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\PSzynal\\Documents\\Java\\Java(Lab4)\\img\\pwr.png"));
		frame.setTitle("Lab 4. Refleksja i \u0142adowanie klas.");
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		mainPanel = new JPanel();

		frame.getContentPane().add(mainPanel, "name_7978325211185");
		mainPanel.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(10, 299, 475, 40);
		mainPanel.add(btnStart);

		lblTSP = new JLabel("Travelling salesman problem");
		lblTSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTSP.setBounds(10, 5, 475, 40);
		mainPanel.add(lblTSP);

		rdbtnRandomCity = new JRadioButton("Generate a random city");
		rdbtnRandomCity.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnRandomCity.isSelected()) {
					rdbtnCityFromFile.setSelected(false);
					spinner.setEnabled(true);
					textFieldCityPath.setEnabled(false);

				}
				if (rdbtnRandomCity.isSelected() == false) {
					spinner.setEnabled(false);
				}
			}
		});
		rdbtnRandomCity.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnRandomCity.setBounds(29, 64, 178, 30);
		mainPanel.add(rdbtnRandomCity);

		rdbtnCityFromFile = new JRadioButton("Load city from file");
		rdbtnCityFromFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				if (rdbtnCityFromFile.isSelected()) {
					rdbtnCityFromFile.setSelected(false);
					textFieldCityPath.setEnabled(true);

				}
				if (rdbtnCityFromFile.isSelected() == false) {
					rdbtnCityFromFile.setSelected(true);
					rdbtnRandomCity.setSelected(false);
					spinner.setEnabled(false);
				}
			}
		});
		rdbtnCityFromFile.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		rdbtnCityFromFile.setBounds(29, 163, 178, 30);
		mainPanel.add(rdbtnCityFromFile);

		textFieldCityPath = new JTextField();
		textFieldCityPath.setEnabled(false);
		textFieldCityPath.setBounds(119, 200, 328, 20);
		mainPanel.add(textFieldCityPath);
		textFieldCityPath.setColumns(10);

		spinner = new JSpinner();
		spinner.setEnabled(false);
		spinner.setBounds(163, 102, 284, 20);
		mainPanel.add(spinner);

		lblNumberOfCities = new JLabel("Number of cities");
		lblNumberOfCities.setHorizontalAlignment(SwingConstants.RIGHT);
		lblNumberOfCities.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblNumberOfCities.setBounds(39, 101, 114, 21);
		mainPanel.add(lblNumberOfCities);

		lblFilePath = new JLabel("FIle path");
		lblFilePath.setHorizontalAlignment(SwingConstants.RIGHT);
		lblFilePath.setFont(new Font("Times New Roman", Font.PLAIN, 15));
		lblFilePath.setBounds(29, 200, 80, 21);
		mainPanel.add(lblFilePath);

		frame.setBounds(100, 100, 501, 386);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				Program program = new Program();
				frame.getContentPane().add(program);
				program.setVisible(true);

			}
		});

	}
}
