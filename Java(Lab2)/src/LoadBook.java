import java.io.BufferedReader;
import java.io.FileReader;
import javax.swing.JFileChooser;

/**
 * 
 * @author Pawel Szynal 226026
 *
 */
public class LoadBook {

	private JFileChooser _FileChooser = new JFileChooser();
	private StringBuilder _StringBuilder = new StringBuilder();

	private BufferedReader _BufferedReader = null;
	private String _Line = "";
	private String _CvsSpliter = ",";
	private Book newBook = new Book();

	public void LoadExam() throws Exception {

		if (_FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the file
			java.io.File file = _FileChooser.getSelectedFile();
			// create a scanner from the file
			// Scanner input = new Scanner(file);
			// read text from file
			_BufferedReader = new BufferedReader(new FileReader(file));
			while ((_Line = _BufferedReader.readLine()) != null) {
				String[] book = _Line.split(_CvsSpliter);
				newBook.setTitle(book[0]);
				newBook.set_Author(book[1]);
				newBook.set_Price(Float.parseFloat(book[2]));

			}
			// input.close();
		} else {

			_StringBuilder.append("No file was selected");
		}
	}

}
