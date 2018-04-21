package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.PrintWriter;
import java.io.StringWriter;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

import TSP.TSP;

public class Program extends JPanel {

	private static final long serialVersionUID = 1L;
	public JScrollPane scrollPane;
	public static JTextArea textArea;

	private JButton btnStart;
	private JRadioButton rdbtnBruteForce;
	private JRadioButton rdbtnBandB;
	private JRadioButton rdbtn;

	Scanner scanner = new Scanner(System.in);
	double StartTime;
	double EndTime;
	double TimeOfOp;

	TSP salesman = new TSP();

	/**
	 * Create the panel.
	 */
	public Program(JTextField textFieldCityPath, JRadioButton rdbtnRandomCity, JRadioButton rdbtnCityFromFile,
			JSpinner spinner) {
		setLayout(null);

		JLabel label = new JLabel("Travelling salesman problem");
		label.setHorizontalAlignment(SwingConstants.CENTER);
		label.setFont(new Font("Tahoma", Font.BOLD, 18));
		label.setBounds(138, 11, 330, 33);
		add(label);

		scrollPane = new JScrollPane();
		scrollPane.setHorizontalScrollBarPolicy(ScrollPaneConstants.HORIZONTAL_SCROLLBAR_NEVER);
		scrollPane.setVerticalScrollBarPolicy(ScrollPaneConstants.VERTICAL_SCROLLBAR_ALWAYS);
		scrollPane.setBounds(138, 47, 330, 277);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setBounds(138, 47, 330, 277);
		add(textArea);
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 15));

		btnStart = new JButton("START");
		btnStart.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnStart.setBounds(10, 291, 113, 33);
		add(btnStart);

		rdbtnBruteForce = new JRadioButton("Brute Force");
		rdbtnBruteForce.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnBruteForce.setBounds(15, 81, 109, 23);
		add(rdbtnBruteForce);

		rdbtnBandB = new JRadioButton("B&B");
		rdbtnBandB.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtnBandB.setBounds(15, 131, 109, 23);
		add(rdbtnBandB);

		rdbtn = new JRadioButton("");
		rdbtn.setFont(new Font("Times New Roman", Font.PLAIN, 14));
		rdbtn.setBounds(15, 180, 109, 23);
		add(rdbtn);

		rdbtnBruteForce.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBruteForce.isSelected()) {
					rdbtnBandB.setSelected(false);
					rdbtn.setSelected(false);
				}
			}
		});

		rdbtnBandB.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtnBandB.isSelected()) {
					rdbtnBruteForce.setSelected(false);
					rdbtn.setSelected(false);
				}
			}
		});

		rdbtn.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if (rdbtn.isSelected()) {
					rdbtnBruteForce.setSelected(false);
					rdbtnBandB.setSelected(false);
				}
			}
		});

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				if (rdbtnCityFromFile.isSelected()) {
					salesman = new TSP();
					try {
						salesman.loadFromFile(textFieldCityPath.getText() + ".txt");
					} catch (IOException e) {
						e.printStackTrace();
						StringWriter errors = new StringWriter();
						e.printStackTrace(new PrintWriter(errors));
						textArea.setText(errors.toString());
					}

					if (rdbtnBruteForce.isSelected()) {

						textArea.setText("File: " + textFieldCityPath.getText() + "\n" + "Algorithm: "
								+ rdbtnBruteForce.getText() + "\n" + "Solution: ");
						StartTime = System.nanoTime();
						salesman.naive(0);
						EndTime = System.nanoTime();
						TimeOfOp = EndTime - StartTime;
						textArea.append(salesman.display());
						textArea.append("\nCalculation time: ");
						textArea.append(String.valueOf(TimeOfOp));
						textArea.append(String.valueOf(" milliseconds"));

					}
					if (rdbtnBandB.isSelected()) {
						textArea.setText("File: " + textFieldCityPath.getText() + "\n" + "Algorithm: "
								+ rdbtnBandB.getText() + "\n" + "Solution: ");
						StartTime = System.nanoTime();
						salesman.TSP(salesman.getGraf());
						TimeOfOp = EndTime - StartTime;
						textArea.append(salesman.display());
						textArea.append("\nCalculation time: ");
						textArea.append(String.valueOf(TimeOfOp));
						textArea.append(String.valueOf(" milliseconds"));
					}

					if (rdbtn.isSelected()) {
						textArea.setText("another algorithm...");
					}
				}

				if (rdbtnRandomCity.isSelected()) {

					salesman.generateCities((Integer) spinner.getValue());

					/*
					 * for (int i = 0; i < ((Integer) spinner.getValue()); i++) { for (int j = 0; j
					 * < ((Integer) spinner.getValue()); j++) textArea.append(salesman.graf[i][j] +
					 * " "); textArea.append("\n"); }
					 */
					if (rdbtnBruteForce.isSelected()) {
						textArea.setText("");
						textArea.append("Algorithm: ");
						textArea.append(rdbtnBruteForce.getText());
						textArea.append("\n");
						textArea.append("Solution: ");
						StartTime = System.nanoTime();
						salesman.naive(0);
						EndTime = System.nanoTime();
						TimeOfOp = EndTime - StartTime;
						textArea.append(salesman.display());
						textArea.append("\nCalculation time: ");
						textArea.append(String.valueOf(TimeOfOp));
						textArea.append(String.valueOf(" milliseconds"));

					}
					if (rdbtnBandB.isSelected()) {
						textArea.setText("");
						textArea.append("Algorithm: ");
						textArea.append(rdbtnBandB.getText());
						textArea.append("\n");
						textArea.append("Solution: ");
						StartTime = System.nanoTime();
						salesman.TSP(salesman.getGraf());
						TimeOfOp = EndTime - StartTime;
						textArea.append(salesman.display());
						textArea.append("\nCalculation time: ");
						textArea.append(String.valueOf(TimeOfOp));
						textArea.append(String.valueOf(" milliseconds"));
					}

					if (rdbtn.isSelected()) {
						textArea.setText("another algorithm...");
					}

				}
			}
		});

	}
}
