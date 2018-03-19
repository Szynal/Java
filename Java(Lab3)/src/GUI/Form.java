package GUI;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;

import javax.swing.SwingConstants;

import Threads.ThreadManager;

import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Toolkit;
import java.awt.Color;

public class Form {

	private JFrame frame;

	private int _minSeedValue = 0;
	private int _maxSeedValue = 1000;
	private int _stepSeed = 1;
	private int _initSeedValue = 1;

	private SpinnerModel _seedSpinermodel;
	private JSpinner _spinnerSeed;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {

		ThreadManager manager = new ThreadManager(2);
		/*
		 * EventQueue.invokeLater(new Runnable() { public void run() { try { Form window
		 * = new Form(); window.frame.setVisible(true); } catch (Exception e) {
		 * e.printStackTrace(); } } });
		 */
	}

	/**
	 * Create the application.
	 */
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Pawel Szynal\\Documents\\Java\\Java(Lab3)\\img\\pwr.png"));

		frame.setTitle("Lab 3. S\u0142abe/mi\u0119kkie referencje i w\u0105tki");
		frame.setBounds(100, 100, 881, 527);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel _lblSeed = new JLabel("Seed");
		_lblSeed.setHorizontalAlignment(SwingConstants.CENTER);
		_lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 22));
		_lblSeed.setBounds(15, 84, 118, 37);
		frame.getContentPane().add(_lblSeed);

		try {
			_seedSpinermodel = new SpinnerNumberModel(_initSeedValue, _minSeedValue, _maxSeedValue, _stepSeed);
			_spinnerSeed = new JSpinner(_seedSpinermodel);
			_spinnerSeed.setFont(new Font("Tahoma", Font.PLAIN, 22));
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Illegal seed argument", "Error", JOptionPane.ERROR_MESSAGE);
		}

		_spinnerSeed.setBounds(148, 87, 118, 38);
		frame.getContentPane().add(_spinnerSeed);

		JButton btnNewButton = new JButton("START");
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});
		btnNewButton.setBounds(19, 418, 398, 37);
		frame.getContentPane().add(btnNewButton);

		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setToolTipText("");
		scrollPane.setBounds(432, 84, 412, 371);
		frame.getContentPane().add(scrollPane);

		JTextPane textPane = new JTextPane();
		textPane.setFont(new Font("Tahoma", Font.PLAIN, 24));
		textPane.setForeground(new Color(0, 0, 0));
		scrollPane.setViewportView(textPane);
	}

	public int Get_spinnerSeed() {
		return _spinnerSeed.getComponentCount();
	}
}
