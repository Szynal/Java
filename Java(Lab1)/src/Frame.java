import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JTextArea;
import javax.swing.JTextField;

/**
 * 
 * @author Pawel Szynal
 *
 */
public class Frame {

	private JFrame _Frame;
	LoadTest test = new LoadTest();
	Statistics stats;
	private JTextField statisticTextField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window._Frame.setVisible(true);
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
		_Frame = new JFrame();
		_Frame.setTitle("Lab 1. W\u0142asna biblioteka i javadoc.");
		_Frame.setBounds(100, 100, 721, 464);
		_Frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_Frame.getContentPane().setLayout(null);

		JLabel lblNewLabel = new JLabel("Wczytaj test z pliku");
		lblNewLabel.setHorizontalAlignment(SwingConstants.CENTER);
		lblNewLabel.setBounds(10, 55, 531, 23);
		_Frame.getContentPane().add(lblNewLabel);

		JTextArea textTest = new JTextArea();
		textTest.setBounds(10, 119, 534, 156);
		_Frame.getContentPane().add(textTest);

		statisticTextField = new JTextField();
		statisticTextField.setBounds(554, 85, 109, 329);
		_Frame.getContentPane().add(statisticTextField);
		statisticTextField.setColumns(10);

		JButton btnGetFile = new JButton("Get File");
		btnGetFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					test.LoadExam();
					textTest.setText(test.contentOfQuestionText);
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnGetFile.setBounds(10, 85, 534, 23);
		_Frame.getContentPane().add(btnGetFile);

		JTextArea answerArea = new JTextArea();
		answerArea.setBounds(10, 349, 534, 65);
		_Frame.getContentPane().add(answerArea);

		JButton btnSetAnswerFile = new JButton("GEt File");
		btnSetAnswerFile.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					test.LoadAnswer();
					answerArea.setText(test.contentOfAnswerText);
					stats = test.LoadStatistic();
					statisticTextField.setText("Wynik: " + stats.Get_Score() + "/" + stats.get_MaxScore());
				} catch (Exception e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		});
		btnSetAnswerFile.setBounds(10, 320, 534, 23);
		_Frame.getContentPane().add(btnSetAnswerFile);

		JLabel lblWybierzPlikW = new JLabel("Wybierz plik z odpowiedziami");
		lblWybierzPlikW.setHorizontalAlignment(SwingConstants.CENTER);
		lblWybierzPlikW.setBounds(10, 286, 534, 23);
		_Frame.getContentPane().add(lblWybierzPlikW);

		JLabel lblWynik = new JLabel("Wynik");
		lblWynik.setHorizontalAlignment(SwingConstants.CENTER);
		lblWynik.setBounds(554, 55, 109, 23);
		_Frame.getContentPane().add(lblWynik);

	}
}
