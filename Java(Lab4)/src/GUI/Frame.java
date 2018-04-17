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

	private JFrame frmLabRefleksja;
	private JPanel mainPanel;

	private JButton btnStart;
	private JLabel lblTSP;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window.frmLabRefleksja.setVisible(true);
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
		frmLabRefleksja = new JFrame();
		frmLabRefleksja.setResizable(false);
		frmLabRefleksja.setAutoRequestFocus(false);
		frmLabRefleksja.setFont(new Font("Arial", Font.PLAIN, 18));
		frmLabRefleksja.setIconImage(Toolkit.getDefaultToolkit().getImage("C:\\Users\\PSzynal\\Documents\\Java\\Java(Lab4)\\img\\pwr.png"));
		frmLabRefleksja.setTitle("Lab 4. Refleksja i \u0142adowanie klas.");
		frmLabRefleksja.getContentPane().setEnabled(false);
		frmLabRefleksja.getContentPane().setLayout(new CardLayout(0, 0));

		mainPanel = new JPanel();

		frmLabRefleksja.getContentPane().add(mainPanel, "name_7978325211185");
		mainPanel.setLayout(null);

		btnStart = new JButton("Start");
		btnStart.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnStart.setBounds(10, 374, 475, 40);
		mainPanel.add(btnStart);

		lblTSP = new JLabel("Travelling salesman problem");
		lblTSP.setHorizontalAlignment(SwingConstants.CENTER);
		lblTSP.setFont(new Font("Tahoma", Font.BOLD, 18));
		lblTSP.setBounds(10, 5, 475, 40);
		mainPanel.add(lblTSP);

		frmLabRefleksja.setBounds(100, 100, 501, 454);
		frmLabRefleksja.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		btnStart.addActionListener(new ActionListener(	) {
			public void actionPerformed(ActionEvent e) {
				mainPanel.setVisible(false);
			//	Program program = new Program();
			//	frame.getContentPane().add(program);
			//	program.setVisible(true);
		
			}
		});

	}
}
