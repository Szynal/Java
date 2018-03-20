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

	public JSpinner MinListSizeSpinner;
	public JSpinner MaxListSizeSpinner;
	public JSpinner MinListValueSpinner;
	public JSpinner MaxListValueSpinner;
	public JSpinner MinSeedValueSpinner;
	public JSpinner MaxSeedValueSpinner;
	public JSpinner NumberOfThreadsSpinner;

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
		frame.setResizable(false);
		frame.setAutoRequestFocus(false);
		frame.setFont(new Font("Arial", Font.PLAIN, 18));
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
		btnStart.setBounds(10, 334, 752, 40);
		mainPanel.add(btnStart);

		MinListSizeSpinner = new JSpinner();
		MinListSizeSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MinListSizeSpinner
				.setModel(new SpinnerNumberModel(new Long(10000), new Long(100), new Long(1000000), new Long(1)));
		MinListSizeSpinner.setBounds(232, 54, 105, 30);
		mainPanel.add(MinListSizeSpinner);

		MaxListSizeSpinner = new JSpinner();
		MaxListSizeSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MaxListSizeSpinner
				.setModel(new SpinnerNumberModel(new Long(1000000), new Long(100), new Long(2000000), new Long(1)));
		MaxListSizeSpinner.setBounds(232, 97, 105, 30);
		mainPanel.add(MaxListSizeSpinner);

		lblNewLabel = new JLabel("Minimum size of the list:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblNewLabel.setBounds(10, 44, 225, 30);
		mainPanel.add(lblNewLabel);

		lblMaximumSizeOf = new JLabel("Maximum size of the list:");
		lblMaximumSizeOf.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaximumSizeOf.setBounds(10, 96, 225, 30);
		mainPanel.add(lblMaximumSizeOf);

		MinListValueSpinner = new JSpinner();
		MinListValueSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MinListValueSpinner.setModel(new SpinnerNumberModel(100, 1, 100000, 1));
		MinListValueSpinner.setBounds(232, 143, 105, 30);
		mainPanel.add(MinListValueSpinner);

		MaxListValueSpinner = new JSpinner();
		MaxListValueSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MaxListValueSpinner.setModel(new SpinnerNumberModel(1000, 1, 100000, 1));
		MaxListValueSpinner.setBounds(232, 189, 105, 30);
		mainPanel.add(MaxListValueSpinner);

		lblMinListValue = new JLabel("Minimum value");
		lblMinListValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMinListValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMinListValue.setBounds(10, 142, 225, 30);
		mainPanel.add(lblMinListValue);

		lblMaxListValue = new JLabel("Minimum value");
		lblMaxListValue.setHorizontalAlignment(SwingConstants.CENTER);
		lblMaxListValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaxListValue.setBounds(10, 189, 225, 30);
		mainPanel.add(lblMaxListValue);

		lblArraylist = new JLabel("ArrayList");
		lblArraylist.setHorizontalAlignment(SwingConstants.CENTER);
		lblArraylist.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblArraylist.setBounds(10, 5, 309, 40);
		mainPanel.add(lblArraylist);

		lblSeed = new JLabel("Seed");
		lblSeed.setHorizontalAlignment(SwingConstants.CENTER);
		lblSeed.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblSeed.setBounds(460, 5, 302, 40);
		mainPanel.add(lblSeed);

		lblMinimumSeedValue = new JLabel("Minimum seed value:");
		lblMinimumSeedValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMinimumSeedValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMinimumSeedValue.setBounds(444, 53, 225, 30);
		mainPanel.add(lblMinimumSeedValue);

		lblMaximumSeedValue = new JLabel("Maximum seed value:");
		lblMaximumSeedValue.setHorizontalAlignment(SwingConstants.RIGHT);
		lblMaximumSeedValue.setFont(new Font("Tahoma", Font.PLAIN, 18));
		lblMaximumSeedValue.setBounds(444, 96, 225, 30);
		mainPanel.add(lblMaximumSeedValue);

		MinSeedValueSpinner = new JSpinner();
		MinSeedValueSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MinSeedValueSpinner.setModel(new SpinnerNumberModel(2, 1, 1000, 1));
		MinSeedValueSpinner.setBounds(678, 54, 84, 30);
		mainPanel.add(MinSeedValueSpinner);

		MaxSeedValueSpinner = new JSpinner();
		MaxSeedValueSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		MaxSeedValueSpinner.setModel(new SpinnerNumberModel(30, 1, 1000, 1));
		MaxSeedValueSpinner.setBounds(678, 97, 84, 30);
		mainPanel.add(MaxSeedValueSpinner);

		lblNumberOfThreads = new JLabel("Number of Threads");
		lblNumberOfThreads.setHorizontalAlignment(SwingConstants.CENTER);
		lblNumberOfThreads.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblNumberOfThreads.setBounds(460, 147, 302, 40);
		mainPanel.add(lblNumberOfThreads);

		NumberOfThreadsSpinner = new JSpinner();
		NumberOfThreadsSpinner.setFont(new Font("Tahoma", Font.PLAIN, 18));
		NumberOfThreadsSpinner.setModel(new SpinnerNumberModel(5, 1, 10, 1));
		NumberOfThreadsSpinner.setBounds(460, 203, 302, 40);
		mainPanel.add(NumberOfThreadsSpinner);

		frame.setBounds(100, 100, 799, 446);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnStart.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
				Program program = new Program();
				frame.getContentPane().add(program);
				program.setVisible(true);
			//	frame.add(program.middlePanel);
			////	frame.pack();
			//	frame.setLocationRelativeTo(null);
			//	frame.setVisible(true);
			}
		});

	}
}
