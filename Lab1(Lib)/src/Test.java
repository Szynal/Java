import java.util.ArrayList;
import java.util.List;

/**
 * 
 * @author Pawel Szynal
 */
public class Test {

	/**
	 * Baza pytan
	 */
	private List<Question> _TestQuestions = new ArrayList<>();
	/**
	 * Rozwiazany test
	 */
	private List<Answer> _TestAnswers = new ArrayList<>();

	/**
	 * Wynik testu
	 */

	/**
	 * Konstruktor klasy Test
	 * 
	 * @param testQuestions
	 *            Baza pytan
	 */
	Test(List<Question> testQuestions) {
		this.set_TestQuestions(testQuestions);
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Baza pytan
	 */
	public List<Question> get_TestQuestions() {
		return _TestQuestions;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param testQuestions
	 *            Baza pytan
	 */
	public void set_TestQuestions(List<Question> testQuestions) {
		this._TestQuestions = testQuestions;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Rozwiazany test
	 */
	public List<Answer> get_TestAnswers() {
		return _TestAnswers;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param testAnswers
	 *            Rozwiazany test
	 * 
	 */
	public void set_TestAnswers(List<Answer> testAnswers) {
		this._TestAnswers = testAnswers;
	}

}
