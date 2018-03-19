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
import javax.swing.SpinnerNumberModel;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import java.awt.Font;

public class Frame {

	private JFrame frame;
	private JPanel mainPanel;

	private JButton btnStart;

	private JSpinner minListSizeSpinner;
	private JSpinner maxListSizeSpinner;
	private JSpinner minListValueSpinner;
	private JSpinner maxListValueSpinner;
	private JSpinner spinnerMinSeedValue;
	private JSpinner spinnerMaxSeedValue;
	private JSpinner spinnerNumberOfThreads;

	private JLabel lblNewLabel;
	private JLabel lblMaximumSizeOf;
	private JLabel lblMinListValue;
	private JLabel lblMaxListValue;
	private JLabel lblArraylist;
	private JLabel lblSeed;
	private JLabel lblMinimumSeedValue;
	private JLabel lblMaximumSeedValue;
	private JLabel lblNumberOfThreads;

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
		frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Pawel Szynal\\Documents\\Java\\Java(Lab3)\\img\\pwr.png"));
		frame.setTitle("Lab 3. S\u0142abe/mi\u0119kkie referencje i w\u0105tki");
		frame.getContentPane().setEnabled(false);
		frame.getContentPane().setLayout(new CardLayout(0, 0));

		mainPanel = new JPanel();

		frame.getContentPane().add(mainPanel, "name_7978325211185");
		mainPanel.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(242, 240, 106, 40);
		mainPanel.add(btnStart);

		minListSizeSpinner = new JSpinner();
		minListSizeSpinner
				.setModel(new SpinnerNumberModel(new Long(10000), new Long(100), new Long(1000000), new Long(1)));
		minListSizeSpinner.setBounds(193, 39, 84, 23);
		mainPanel.add(minListSizeSpinner);

		maxListSizeSpinner = new JSpinner();
		maxListSizeSpinner
				.setModel(new SpinnerNumberModel(new Long(1000000), new Long(100), new Long(2000000), new Long(1)));
		maxListSizeSpinner.setBounds(193, 73, 84, 23);
		mainPanel.add(maxListSizeSpinner);

		lblNewLabel = new JLabel("Minimum size of the list:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblNewLabel.setBounds(10, 39, 173, 23);
		mainPanel.add(lblNewLabel);

		lblMaximumSizeOf = new JLabel("Maximum size of the list:");
		lblMaximumSizeOf.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaximumSizeOf.setBounds(10, 73, 173, 23);
		mainPanel.add(lblMaximumSizeOf);

		minListValueSpinner = new JSpinner();
		minListValueSpinner.setModel(new SpinnerNumberModel(100, 1, 100000, 1));
		minListValueSpinner.setBounds(193, 127, 84, 23);
		mainPanel.add(minListValueSpinner);

		maxListValueSpinner = new JSpinner();
		maxListValueSpinner.setModel(new SpinnerNumberModel(1000, 1, 100000, 1));
		maxListValueSpinner.setBounds(193, 161, 84, 23);
		mainPanel.add(maxListValueSpinner);

		lblMinListValue = new JLabel("Minimum value");
		lblMinListValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinListValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinListValue.setBounds(10, 125, 173, 23);
		mainPanel.add(lblMinListValue);

		lblMaxListValue = new JLabel("Minimum value");
		lblMaxListValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxListValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaxListValue.setBounds(10, 159, 173, 23);
		mainPanel.add(lblMaxListValue);

		lblArraylist = new JLabel("ArrayList");
		lblArraylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArraylist.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblArraylist.setBounds(10, 5, 267, 23);
		mainPanel.add(lblArraylist);

		lblSeed = new JLabel("Seed");
		lblSeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeed.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblSeed.setBounds(316, 5, 267, 23);
		mainPanel.add(lblSeed);

		lblMinimumSeedValue = new JLabel("Minimum seed value:");
		lblMinimumSeedValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinimumSeedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMinimumSeedValue.setBounds(316, 37, 173, 23);
		mainPanel.add(lblMinimumSeedValue);

		lblMaximumSeedValue = new JLabel("Maximum seed value:");
		lblMaximumSeedValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaximumSeedValue.setFont(new Font("Tahoma", Font.PLAIN, 15));
		lblMaximumSeedValue.setBounds(316, 73, 173, 23);
		mainPanel.add(lblMaximumSeedValue);

		spinnerMinSeedValue = new JSpinner();
		spinnerMinSeedValue.setModel(new SpinnerNumberModel(2, 1, 1000, 1));
		spinnerMinSeedValue.setBounds(499, 39, 84, 23);
		mainPanel.add(spinnerMinSeedValue);

		spinnerMaxSeedValue = new JSpinner();
		spinnerMaxSeedValue.setModel(new SpinnerNumberModel(30, 1, 1000, 1));
		spinnerMaxSeedValue.setBounds(499, 74, 84, 23);
		mainPanel.add(spinnerMaxSeedValue);

		lblNumberOfThreads = new JLabel("Number of Threads");
		lblNumberOfThreads.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfThreads.setFont(new Font("Tahoma", Font.BOLD, 15));
		lblNumberOfThreads.setBounds(316, 127, 267, 23);
		mainPanel.add(lblNumberOfThreads);

		spinnerNumberOfThreads = new JSpinner();
		spinnerNumberOfThreads.setModel(new SpinnerNumberModel(5, 1, 10, 1));
		spinnerNumberOfThreads.setBounds(326, 162, 257, 23);
		mainPanel.add(spinnerNumberOfThreads);

		frame.setBounds(100, 100, 607, 348);
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
