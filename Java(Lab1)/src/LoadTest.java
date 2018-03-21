
import java.io.BufferedReader;
import java.io.FileReader;
import java.util.ArrayList;
import java.util.List;
import javax.swing.JFileChooser;

/**
 * 
 * @author Pawel Szynal
 *
 */
public class LoadTest {

	private JFileChooser _FileChooser = new JFileChooser();
	private StringBuilder _StringBuilder = new StringBuilder();
	private Test _Test;
	private List<Question> _TestQuestions = new ArrayList<>();
	private List<Answer> _TestAnswers = new ArrayList<>();
	private Question _Question = new Question();
	private Answer _Answer = new Answer();

	String contentOfQuestionText = "";
	String contentOfAnswerText = "";

	private BufferedReader _BufferedReader = null;
	private String _Line = "";
	private String _CvsSpliter = ",";

	public void LoadExam() throws Exception {

		if (_FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the file
			java.io.File file = _FileChooser.getSelectedFile();
			// create a scanner from the file
			// Scanner input = new Scanner(file);
			// read text from file
			_BufferedReader = new BufferedReader(new FileReader(file));
			while ((_Line = _BufferedReader.readLine()) != null) {
				String[] quastion = _Line.split(_CvsSpliter);

				_Question.set_QuestionNumber(Integer.parseInt(quastion[0]));
				_Question.set_ContentOfQuestion(quastion[1]);
				contentOfQuestionText += quastion[0] + ": " + quastion[1] + "\n[" + quastion[2] + "] " + "["
						+ quastion[3] + "] " + "[" + quastion[4] + "] " + "[" + quastion[5] + "] \n\n";
				_Question.set_FirstAnswer(quastion[2]);
				_Question.set_SecondAnswer(quastion[3]);
				_Question.set_ThirdAnswe(quastion[4]);
				_Question.set_FourthAnswer(quastion[5]);
				_Question.set_GoodAnswer(Integer.parseInt(quastion[6]));
				_Question.set_PintsForQuestion(Integer.parseInt(quastion[7]));

				_TestQuestions.add(_Question);

			}
			// input.close();
		} else {

			_StringBuilder.append("No file was selected");
		}
	}

	public void LoadAnswer() throws Exception {

		if (_FileChooser.showOpenDialog(null) == JFileChooser.APPROVE_OPTION) {
			// get the file
			java.io.File file = _FileChooser.getSelectedFile();
			// create a scanner from the file
			// Scanner input = new Scanner(file);
			// read text from file
			_BufferedReader = new BufferedReader(new FileReader(file));
			while ((_Line = _BufferedReader.readLine()) != null) {

				String[] quastion = _Line.split(_CvsSpliter);
				_Answer.set_QuestionNumber(Integer.parseInt(quastion[0]));
				_Answer.set_Answer(Integer.parseInt(quastion[1]));
				_TestAnswers.add(_Answer);
				contentOfAnswerText += quastion[0] + " Odp: " + quastion[1] + "\n";

			}
			// input.close();
		} else {

			_StringBuilder.append("No file was selected");
		}

	}

	public Statistics LoadStatistic() {

		_Test = new Test(_TestQuestions);
		_Test.set_TestAnswers(_TestAnswers);
		Statistics marks = new Statistics(_Test);
		return marks;
	}
}
