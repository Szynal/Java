package GUI;

import java.awt.EventQueue;

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
import javax.swing.JSeparator;
import javax.swing.JTextArea;
import javax.swing.JList;
import javax.swing.JTextPane;
import javax.swing.JTextField;
import javax.swing.JScrollBar;
import javax.swing.JScrollPane;
import javax.swing.JFormattedTextField;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Form {

	private JFrame frmLabSabemikkie;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
					window.frmLabSabemikkie.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
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
		frmLabSabemikkie = new JFrame();
		frmLabSabemikkie.setTitle("Lab 3. S\u0142abe/mi\u0119kkie referencje i w\u0105tki");
		frmLabSabemikkie.setBounds(100, 100, 758, 434);
		frmLabSabemikkie.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmLabSabemikkie.getContentPane().setLayout(null);

		JLabel _lblSeed = new JLabel("Seed");
		_lblSeed.setHorizontalAlignment(SwingConstants.CENTER);
		_lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		_lblSeed.setBounds(15, 46, 118, 20);
		frmLabSabemikkie.getContentPane().add(_lblSeed);

		try {
			_seedSpinermodel = new SpinnerNumberModel(_initSeedValue, _minSeedValue, _maxSeedValue, _stepSeed);
			_spinnerSeed = new JSpinner(_seedSpinermodel);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Illegal seed argument", "Error", JOptionPane.ERROR_MESSAGE);
		}

		_spinnerSeed.setBounds(148, 43, 118, 26);
		frmLabSabemikkie.getContentPane().add(_spinnerSeed);

		JButton btnNewButton = new JButton("START");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				ThreadManager manager = new ThreadManager(5);
			}
		});
		btnNewButton.setBounds(183, 221, 115, 29);
		frmLabSabemikkie.getContentPane().add(btnNewButton);
	}

	public int Get_spinnerSeed() {
		return _spinnerSeed.getComponentCount();
	}
}
