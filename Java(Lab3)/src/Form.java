import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.SpinnerModel;
import javax.swing.SpinnerNumberModel;
import javax.swing.JSpinner;
import javax.swing.JButton;

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
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Form window = new Form();
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
	public Form() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 758, 434);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frame.getContentPane().setLayout(null);

		JLabel _lblSeed = new JLabel("Seed");
		_lblSeed.setHorizontalAlignment(SwingConstants.CENTER);
		_lblSeed.setFont(new Font("Tahoma", Font.PLAIN, 16));
		_lblSeed.setBounds(15, 46, 118, 20);
		frame.getContentPane().add(_lblSeed);

		try {
			_seedSpinermodel = new SpinnerNumberModel(_initSeedValue, _minSeedValue, _maxSeedValue, _stepSeed);
			_spinnerSeed = new JSpinner(_seedSpinermodel);
		} catch (IllegalArgumentException e) {
			JOptionPane.showMessageDialog(null, "Illegal seed argument", "Error", JOptionPane.ERROR_MESSAGE);
		}

		_spinnerSeed.setBounds(148, 43, 118, 26);
		frame.getContentPane().add(_spinnerSeed);

		JButton btnNewButton = new JButton("New button");
		btnNewButton.setBounds(25, 82, 115, 29);
		frame.getContentPane().add(btnNewButton);
	}

	public int Get_spinnerSeed() {
		return _spinnerSeed.getComponentCount();
	}
}
