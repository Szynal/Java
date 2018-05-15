package GUI;

import java.awt.EventQueue;
import java.beans.PropertyVetoException;

import java.util.List;
import java.util.ArrayList;

import javax.swing.JFrame;

import JavaBeen.TeacherJournal;

import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;

import javax.swing.Action;
import java.awt.Toolkit;
import javax.swing.JLabel;
import java.awt.Font;
import javax.swing.SwingConstants;
import javax.swing.JButton;
import java.awt.event.ActionListener;

public class Window {

	/**
	 * Okno ziarenka (JFC/Swing)
	 */
	private JFrame beenFrame;

	private final Action action = new SwingAction();
	private List<TeacherJournal> teacherJournals = new ArrayList<TeacherJournal>();
	/*
	 * set x cord's Baund
	 */
	private int x = 180;

	/**
	 * Uruchomia aplikacjê.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Window window = new Window();
					window.beenFrame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public Window() {
		initialize();
	}

	/**
	 * Inicjalizacja zawartoœc okna ziarenka
	 */
	private void initialize() {

		beenFrame = new JFrame();

		beenFrame.setIconImage(
				Toolkit.getDefaultToolkit().getImage("C:\\Users\\PSzynal\\Documents\\Java\\Java(Lab5)\\img\\pwr.png"));

		beenFrame.setTitle("Lab 5. Ziarna Java'y.");
		beenFrame.setBounds(100, 100, 555, 400);
		beenFrame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		teacherJournals.add(new TeacherJournal());

		teacherJournals.get(0).setBounds(0, 54, 180, 267);

		teacherJournals.add(new TeacherJournal());
		teacherJournals.get(1).setBounds(180, 54, 180, 267);

		teacherJournals.add(new TeacherJournal());
		teacherJournals.get(2).setBounds(360, 54, 180, 267);

		beenFrame.getContentPane().setLayout(null);

		teacherJournals.get(0).setTest("Test 1");
		teacherJournals.get(0).setAverage(0);
		teacherJournals.get(0).setRate(0);
		beenFrame.getContentPane().add(teacherJournals.get(0));

		teacherJournals.get(1).setTest("Test 1");
		teacherJournals.get(1).setRate(0);
		teacherJournals.get(1).setAverage(0);
		beenFrame.getContentPane().add(teacherJournals.get(1));

		teacherJournals.get(2).setTest("Test 1");
		teacherJournals.get(2).setRate(0);
		teacherJournals.get(2).setAverage(0);
		beenFrame.getContentPane().add(teacherJournals.get(2));

		try {
			teacherJournals.get(2).setTitle("Student 3");

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		try {
			teacherJournals.get(0).setTitle("Student 1");

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}
		try {
			teacherJournals.get(1).setTitle("Student 2");

		} catch (PropertyVetoException e) {
			e.printStackTrace();
		}

		teacherJournals.get(0).addPropertyChangeListener(teacherJournals.get(1));
		teacherJournals.get(0).addPropertyChangeListener(teacherJournals.get(2));

		teacherJournals.get(1).addPropertyChangeListener(teacherJournals.get(0));
		teacherJournals.get(1).addPropertyChangeListener(teacherJournals.get(2));

		teacherJournals.get(2).addPropertyChangeListener(teacherJournals.get(0));
		teacherJournals.get(2).addPropertyChangeListener(teacherJournals.get(1));

		JLabel lblStudent = new JLabel("Prace student\u00F3w");
		lblStudent.setHorizontalAlignment(SwingConstants.CENTER);
		lblStudent.setFont(new Font("Times New Roman", Font.PLAIN, 17));
		lblStudent.setBounds(10, 11, 521, 32);
		beenFrame.getContentPane().add(lblStudent);

		JButton btnNewStudent = new JButton("Dodaj nowego studenta");
		btnNewStudent.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				teacherJournals.add(new TeacherJournal());
				teacherJournals.get(teacherJournals.size() - 1).setBounds(x * (teacherJournals.size() - 1), 54, 180,
						267);

				teacherJournals.get(teacherJournals.size() - 1).setTest("Test 1");
				teacherJournals.get(teacherJournals.size() - 1).setAverage(0);
				teacherJournals.get(teacherJournals.size() - 1).setRate(0);
				beenFrame.getContentPane().add(teacherJournals.get(teacherJournals.size() - 1));

				try {
					teacherJournals.get(0).setTitle("Student" + new Integer(teacherJournals.size() - 1).toString());
				} catch (PropertyVetoException e1) {
					e1.printStackTrace();
				}

				beenFrame.setBounds(100, 100, 555 + (x * (teacherJournals.size() - 3)), 400);
				btnNewStudent.setBounds(10, 329, 521 + (x * (teacherJournals.size() - 3)), 32);
				lblStudent.setBounds(10, 11, 521 + (x * (teacherJournals.size() - 3)), 32);
			}
		});
		btnNewStudent.setFont(new Font("Times New Roman", Font.BOLD, 15));
		btnNewStudent.setBounds(10, 329, 521, 32);
		beenFrame.getContentPane().add(btnNewStudent);

	}

	/**
	 * 
	 * @return actrion
	 */
	public Action getAction() {
		return action;
	}

	/**
	 * Ta klasa udostêpnia domyœlne implementacje interfejsu JFC. Wspiera JavaBeans
	 * 
	 * @author PSzynal
	 *
	 */
	private class SwingAction extends AbstractAction {

		private static final long serialVersionUID = 1L;

		/**
		 * Ustawia wartoœæ o okreœlonej wartoœæi.s
		 */
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}

		public void actionPerformed(ActionEvent e) {
		}
	}
}