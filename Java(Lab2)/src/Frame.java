import java.awt.EventQueue;
import java.awt.Color;
import java.awt.event.ActionListener;
import java.io.File;
import java.io.FileInputStream;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.awt.event.ActionEvent;

import javax.swing.JFrame;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.Timer;
import javax.xml.parsers.DocumentBuilder;
import javax.xml.parsers.DocumentBuilderFactory;

import org.w3c.dom.Document;
import org.w3c.dom.Element;
import org.w3c.dom.Node;
import org.w3c.dom.NodeList;

import javax.swing.JComboBox;
import javax.swing.DefaultComboBoxModel;
import javax.swing.ImageIcon;

import java.util.ArrayList;
import java.util.Enumeration;
import java.util.List;
import java.util.Locale;
import java.util.Properties;
import java.util.ResourceBundle;
import java.awt.Toolkit;
import java.awt.Font;
import javax.swing.JTextPane;
import javax.swing.JScrollPane;

/**
 * APLIKACJA
 * 
 * @author Pawel Szynal 226026
 */
public class Frame {

	private JFrame _frame;
	// JText
	private JTextField _textAuthor;
	private JTextField _textReleaseDate;
	private JTextField _textPrice;
	private JTextField _textTitle;
	private JTextField _textPicturePath;
	// JLabel
	private JLabel _labelLanguage;
	private JLabel _labelBookName;
	private JLabel _labelAuthor;
	private JLabel _labelData;
	private JLabel _labelPrice;
	private JLabel _labelPicturePath;
	private JLabel _labelPicture;
	private JLabel _lblPicture;
	private JLabel _labelIcon;
	private JLabel _labelConfirmation;
	// JButton
	private JButton _btbRemoveBook;
	private JButton _btnAddNewBook;
	private JButton _btnSelectBook;
	private JButton _btnSubmit;
	private JButton _btnGetAllBooksTitle;
	// JComboBox
	private JComboBox<Object> _comboBox;
	// ImageIcon
	private ImageIcon _imageIcon;
	private ImageIcon _pictureIcon;

	private JScrollPane _scrollPane;
	private JTextPane _scrollText;

	public List<Book> _Books = new ArrayList<>();

	public String localeLanguage = "en";
	public String localeCountry = "US";
	public ResourceBundle resourceBundle;
	public Locale locale;

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Frame window = new Frame();
					window._frame.setVisible(true);
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
		_frame = new JFrame();
		_frame.setIconImage(Toolkit.getDefaultToolkit()
				.getImage("C:\\Users\\Pawel Szynal\\eclipse-workspace\\Java(Lab2)\\img\\pwr.png"));
		_frame.setResizable(false);
		_frame.setTitle("Lab 2. Okienka, internacjonalizacja, zasoby.");
		_frame.setBounds(100, 100, 749, 575);
		_frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		_frame.getContentPane().setLayout(null);

		_labelLanguage = new JLabel("Select Language");
		_labelLanguage.setHorizontalAlignment(SwingConstants.CENTER);
		_labelLanguage.setBounds(15, 11, 137, 20);
		_frame.getContentPane().add(_labelLanguage);

		_labelBookName = new JLabel("Title");
		_labelBookName.setHorizontalAlignment(SwingConstants.CENTER);
		_labelBookName.setBounds(15, 86, 137, 20);
		_frame.getContentPane().add(_labelBookName);

		_labelAuthor = new JLabel("Author");
		_labelAuthor.setHorizontalAlignment(SwingConstants.CENTER);
		_labelAuthor.setBounds(15, 154, 147, 20);
		_frame.getContentPane().add(_labelAuthor);

		_labelData = new JLabel("Publishing date");
		_labelData.setHorizontalAlignment(SwingConstants.CENTER);
		_labelData.setBounds(15, 222, 147, 20);
		_frame.getContentPane().add(_labelData);

		_labelPrice = new JLabel("Price");
		_labelPrice.setHorizontalAlignment(SwingConstants.CENTER);
		_labelPrice.setBounds(15, 290, 147, 20);
		_frame.getContentPane().add(_labelPrice);

		_labelPicturePath = new JLabel("Picture path");
		_labelPicturePath.setToolTipText("Sciezka dostpu do zdj\u0119cia");
		_labelPicturePath.setHorizontalAlignment(SwingConstants.CENTER);
		_labelPicturePath.setBounds(15, 355, 147, 20);
		_frame.getContentPane().add(_labelPicturePath);

		_labelPicture = new JLabel("Picture");
		_labelPicture.setHorizontalAlignment(SwingConstants.CENTER);
		_labelPicture.setBounds(205, 55, 287, 20);
		_frame.getContentPane().add(_labelPicture);

		_lblPicture = new JLabel("");
		_lblPicture.setBackground(new Color(128, 128, 128));
		_lblPicture.setBounds(205, 86, 287, 406);
		_frame.getContentPane().add(_lblPicture);

		_labelIcon = new JLabel("");
		_imageIcon = new ImageIcon(this.getClass().getResource("/us.png"));
		_labelIcon.setIcon(_imageIcon);
		_labelIcon.setBounds(162, 11, 37, 20);
		_frame.getContentPane().add(_labelIcon);

		_labelConfirmation = new JLabel("");
		_labelConfirmation.setFont(new Font("Tahoma", Font.PLAIN, 14));
		_labelConfirmation.setBounds(15, 11, 582, 29);
		_frame.getContentPane().add(_labelConfirmation);

		_textAuthor = new JTextField();
		_textAuthor.setBounds(15, 185, 146, 26);
		_frame.getContentPane().add(_textAuthor);
		_textAuthor.setColumns(10);

		_textReleaseDate = new JTextField();
		_textReleaseDate.setColumns(10);
		_textReleaseDate.setBounds(16, 253, 146, 26);
		_frame.getContentPane().add(_textReleaseDate);

		_textPrice = new JTextField();
		_textPrice.setColumns(10);
		_textPrice.setBounds(16, 318, 146, 26);
		_frame.getContentPane().add(_textPrice);

		_textTitle = new JTextField();
		_textTitle.setColumns(10);
		_textTitle.setBounds(15, 117, 146, 26);
		_frame.getContentPane().add(_textTitle);

		_textPicturePath = new JTextField();
		_textPicturePath.setColumns(10);
		_textPicturePath.setBounds(15, 395, 147, 26);
		_frame.getContentPane().add(_textPicturePath);

		_scrollPane = new JScrollPane();
		_scrollPane.setToolTipText("");
		_scrollPane.setBounds(502, 86, 227, 406);
		_frame.getContentPane().add(_scrollPane);

		_scrollText = new JTextPane();
		_scrollPane.setViewportView(_scrollText);

		_btbRemoveBook = new JButton("Remove book");
		_btbRemoveBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

			}
		});

		_btnAddNewBook = new JButton("Add book");
		_btnAddNewBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {

				try {
					XMLDocument creator = new XMLDocument();

					locale = new Locale(localeLanguage, localeCountry);
					resourceBundle = ResourceBundle.getBundle("Bundle", locale);

					if (creator.CheckIfFileExists() == false) {

						creator.CreateNewXmlFIle();
					}

					creator.AddDataToXml(creator.get_Document(), creator.get_RotElement(), _textTitle.getText(),
							_textAuthor.getText(), _textReleaseDate.getText(), _textPrice.getText(),
							_textPicturePath.getText());

					_labelConfirmation.setText(resourceBundle.getString("Add.textAddNewBook.text"));
					TimerUI();

				} catch (Exception e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}

			}
		});
		_btnAddNewBook.setBounds(15, 503, 147, 29);
		_frame.getContentPane().add(_btnAddNewBook);
		_btbRemoveBook.setBounds(188, 503, 147, 29);
		_frame.getContentPane().add(_btbRemoveBook);

		_btnSelectBook = new JButton("Select book");
		_btnSelectBook.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ReadPropertiesXmlFile(_textTitle.getText());

			}
		});
		_btnSelectBook.setBounds(345, 503, 147, 29);
		_frame.getContentPane().add(_btnSelectBook);

		_comboBox = new JComboBox<Object>();
		_comboBox.setModel(
				new DefaultComboBoxModel<Object>(new String[] { "English", "German", "French", "Japanese", "Polish" }));
		_comboBox.setBounds(205, 8, 180, 26);
		_frame.getContentPane().add(_comboBox);

		_btnSubmit = new JButton("Submit");
		_btnSubmit.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				ChangeNationality();
			}
		});

		_btnSubmit.setBounds(389, 7, 180, 29);
		_frame.getContentPane().add(_btnSubmit);

		_btnGetAllBooksTitle = new JButton("Get books titles ");
		_btnGetAllBooksTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				_scrollText.setText(null);
				ReadTitlesFromXmlFile();
			}
		});
		_btnGetAllBooksTitle.setBounds(502, 503, 227, 29);
		_frame.getContentPane().add(_btnGetAllBooksTitle);
	}

	/**
	 * Ustawia text label'om w zale�no�ci od ustawie� narodowych
	 * 
	 * @param resourceBundle
	 *            Pakiet zasob�w zawierajy obiekty specyficzne dla ustawie�
	 *            narodowych.
	 */
	private void SetUI(ResourceBundle resourceBundle) {

		// Set JLabels
		_labelLanguage.setText(resourceBundle.getString("Add.labelLanguage.text"));
		_labelBookName.setText(resourceBundle.getString("Add.labelBookName.text"));
		_labelAuthor.setText(resourceBundle.getString("Add.labelAuthor.text"));
		_labelData.setText(resourceBundle.getString("Add.labelData.text"));
		_labelPrice.setText(resourceBundle.getString("Add.labelPrice.text"));
		_labelPicturePath.setText(resourceBundle.getString("Add.labelPicturePath.text"));
		_labelPicture.setText(resourceBundle.getString("Add.labelPicture.text"));
		// Set JButtons
		_btbRemoveBook.setText(resourceBundle.getString("Add.btbRemoveBook.text"));
		_btnAddNewBook.setText(resourceBundle.getString("Add.btnAddNewBook.text"));
		_btnSelectBook.setText(resourceBundle.getString("Add.btnSelectBook.text"));
		_btnSubmit.setText(resourceBundle.getString("Add.btnSubmit.text"));
		_btnGetAllBooksTitle.setText(resourceBundle.getString("Add.btnGetAllBooksTitle.text"));
		// SetImageIcon
		_imageIcon = new ImageIcon(this.getClass().getResource(resourceBundle.getString("Add.imageIcon.text")));
		_labelIcon.setIcon(_imageIcon);
	}

	/**
	 * Licznik kt�ry po 5 sekundach wy��cza test komunikatu oraz usatawua textboxom
	 * warto�� null
	 */
	protected void TimerUI() {

		Timer t = new Timer(5000, new ActionListener() {

			@Override
			public void actionPerformed(ActionEvent e) {
				_labelConfirmation.setText(null);
				_textAuthor.setText(null);
				_textPicturePath.setText(null);
				_textPrice.setText(null);
				_textReleaseDate.setText(null);
				_textTitle.setText(null);
				_lblPicture.setIcon(null);
			}
		});
		t.setRepeats(false);
		t.start();
	}

	/**
	 * Zmienia ustawienia odpowiedzialne za lokazliacj� bierz�cego u�ytkownika
	 * (USTAWIENIA NARODOWE)
	 */
	private void ChangeNationality() {

		switch (String.valueOf(_comboBox.getSelectedItem())) {
		case "English": {
			localeLanguage = "en";
			localeCountry = "US";
			locale = new Locale(localeLanguage, localeCountry);
			resourceBundle = ResourceBundle.getBundle("Bundle", locale);
			SetUI(resourceBundle);
			break;
		}
		case "German": {
			localeLanguage = "de";
			localeCountry = "DE";
			locale = new Locale(localeLanguage, localeCountry);
			resourceBundle = ResourceBundle.getBundle("Bundle", locale);
			SetUI(resourceBundle);
			break;
		}
		case "French": {
			localeLanguage = "fr";
			localeCountry = "FR";
			locale = new Locale(localeLanguage, localeCountry);
			resourceBundle = ResourceBundle.getBundle("Bundle", locale);
			SetUI(resourceBundle);
			break;
		}
		case "Japanese": {
			localeLanguage = "ja";
			localeCountry = "JA";
			locale = new Locale(localeLanguage, localeCountry);
			resourceBundle = ResourceBundle.getBundle("Bundle", locale);
			SetUI(resourceBundle);
			break;
		}
		case "Polish": {
			localeLanguage = "pl";
			localeCountry = "PL";
			locale = new Locale(localeLanguage, localeCountry);
			resourceBundle = ResourceBundle.getBundle("Bundle", locale);
			SetUI(resourceBundle);
			break;
		}

		default:
			break;
		}

	}

	/**
	 * Wypisuje wszystkie tytu�y znajduj�ce si� w pliku xml.
	 */
	public void ReadTitlesFromXmlFile() {

		try {
			File file = new File("C:\\Users\\Pawel Szynal\\eclipse-workspace\\Java(Lab2)\\xml\\Books.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			System.out.println("Element g��wny: " + document.getDocumentElement().getNodeName());

			NodeList nodeList = document.getElementsByTagName("Book");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);

				if (node.getNodeType() == Node.ELEMENT_NODE) {

					Element element = (Element) node;

					// NodeList fstNmElmntLst = author.getElementsByTagName("Book");
					_scrollText.setText(
							_scrollText.getText() + "\n" + (i + 1) + ": " + element.getAttribute("Title") + "\n");
				}

			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

	/**
	 * Wypisuje wszystkie atrybuty ksi�zki
	 * 
	 * @param title
	 *            Wyszukiwany tytu� ksi��ki
	 */
	public void ReadPropertiesXmlFile(String title) {

		try {
			File file = new File("C:\\Users\\Pawel Szynal\\eclipse-workspace\\Java(Lab2)\\xml\\Books.xml");
			DocumentBuilderFactory documentBuilderFactory = DocumentBuilderFactory.newInstance();
			DocumentBuilder builder = documentBuilderFactory.newDocumentBuilder();
			Document document = builder.parse(file);
			document.getDocumentElement().normalize();

			System.out.println("Element g��wny: " + document.getDocumentElement().getNodeName());

			NodeList nodeList = document.getElementsByTagName("Book");

			for (int i = 0; i < nodeList.getLength(); i++) {

				Node node = nodeList.item(i);

				Element element = (Element) node;

				if (node.getNodeType() == Node.ELEMENT_NODE && element.getAttribute("Title").equals(title)) {

					// NodeList fstNmElmntLst = author.getElementsByTagName("Book");
					_textTitle.setText(element.getAttribute("Title"));
					_textAuthor.setText(element.getAttribute("Author"));
					_textPrice.setText(element.getAttribute("Price"));
					_textReleaseDate.setText(element.getAttribute("PublishingDate"));
					_textPicturePath.setText(element.getAttribute("Picture"));

					_pictureIcon = new ImageIcon(element.getAttribute("Picture"));
					_lblPicture.setIcon(_pictureIcon);

				}
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
	}

}
