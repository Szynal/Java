package GUI;

import javax.swing.JPanel;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import java.awt.Font;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.lang.reflect.InvocationTargetException;
import java.lang.reflect.Method;
import java.lang.reflect.Modifier;
import java.util.Scanner;

import javax.swing.JScrollPane;
import javax.swing.JSpinner;
import javax.swing.ScrollPaneConstants;
import javax.swing.JButton;
import javax.swing.JRadioButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;

public class Program extends JPanel {
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

	private Class c1;
	private Class c2;
	private Object obj;
	private Method[] m1;
	private Method[] m2;

	// TSP salesman = new TSP();

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
		scrollPane.setBounds(15, 16, 430, 270);
		scrollPane.setBounds(138, 47, 330, 277);
		add(scrollPane);

		textArea = new JTextArea();
		textArea.setFont(new Font("Times New Roman", Font.PLAIN, 20));
		scrollPane.setViewportView(textArea);
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
					// salesman = new TSP();

					try {
						c1 = Class.forName("TSP.BandB");
						c2 = Class.forName("TSP.BruteForce");

						int classmodi1 = c1.getModifiers();
						int classmodi2 = c2.getModifiers();

						textArea.setText(Modifier.isPublic(classmodi2) + "\n");

						Class[] neighint1 = c1.getInterfaces();
						Class neighsuper1 = c1.getSuperclass();

						Class[] neighint = c2.getInterfaces();
						Class neighsuper = c2.getSuperclass();

						m1 = c1.getMethods();
						m2 = c2.getMethods();

						int funcno2 = 0, funcno1 = 0;
						int loadfun = 0, loadfun1 = 0;
						int disfun = 0, disfun1 = 0;
						int getgraf1 = 0;
						int tsp = 0, tsp1 = 0;

						for (int i = 0; i < m1.length; i++) {
							System.out.println(m1[i].getName() + "\n");
							if (m1[i].getName() == "TSP") {
								funcno1 = i;
							}
							if (m1[i].getName() == "loadFromFile") {
								loadfun1 = i;
							}
							if (m1[i].getName() == "display") {
								disfun1 = i;
							}
							if (m1[i].getName() == "getGraf") {
								getgraf1 = i;
							}

						}

						for (int i = 0; i < m2.length; i++) {
							System.out.println(m2[i].getName() + "\n");
							if (m2[i].getName() == "naive") {
								funcno2 = i;
							}
							if (m2[i].getName() == "loadFromFile") {
								loadfun = i;
							}
							if (m2[i].getName() == "display") {
								disfun = i;
							}

						}

						Object class1_obj = c1.newInstance();
						Object class2_obj = c2.newInstance();

						m1[loadfun1].invoke(class1_obj, (textFieldCityPath.getText() + ".txt"));
						m2[loadfun].invoke(class2_obj, (textFieldCityPath.getText() + ".txt"));

						if (rdbtnBruteForce.isSelected()) {

							textArea.setText("File: " + textFieldCityPath.getText() + "\n" + "Algorithm: "
									+ rdbtnBruteForce.getText() + "\n" + "Solution: ");
							StartTime = System.nanoTime();
							m2[funcno2].invoke(class2_obj, 0);
							EndTime = System.nanoTime();
							TimeOfOp = EndTime - StartTime;
							textArea.append((String) m2[disfun].invoke(class2_obj));
							textArea.append("\nCalculation time: ");
							textArea.append(String.valueOf(TimeOfOp));
							textArea.append(String.valueOf(" milliseconds"));

						}
						if (rdbtnBandB.isSelected()) {

							textArea.setText("File: " + textFieldCityPath.getText() + "\n" + "Algorithm: "
									+ rdbtnBruteForce.getText() + "\n" + "Solution: ");
							StartTime = System.nanoTime();
							m1[funcno1].invoke(class1_obj, m1[getgraf1].invoke(class1_obj));
							EndTime = System.nanoTime();
							TimeOfOp = EndTime - StartTime;
							textArea.append((String) m1[disfun1].invoke(class1_obj));
							textArea.append("\nCalculation time: ");
							textArea.append(String.valueOf(TimeOfOp));
							textArea.append(String.valueOf(" milliseconds"));
						}

						if (rdbtn.isSelected()) {
							textArea.setText("another algorithm...");
						}
					} catch (IllegalAccessException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (IllegalArgumentException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InvocationTargetException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					} catch (InstantiationException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
				}

				if (rdbtnRandomCity.isSelected()) {

					// salesman.generateCities((Integer) spinner.getValue());

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
						// salesman.naive(0);
						EndTime = System.nanoTime();
						TimeOfOp = EndTime - StartTime;
						// textArea.append(salesman.display());
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
						// salesman.TSP(salesman.getGraf());
						TimeOfOp = EndTime - StartTime;
						// textArea.append(salesman.display());
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