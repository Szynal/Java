/**
 * 
 * @author Pawel Szynal
 *
 */
public class Answer {
	/**
	 * numer pytania
	 */
	private int _QuestionNumber;
	/**
	 * odpowiedz na pyanie z testu
	 */
	private int _Answer;

	public Answer() {
		// TODO Auto-generated constructor stub
	}

	public int get_QuestionNumber() {
		return _QuestionNumber;
	}

	public void set_QuestionNumber(int questionNumber) {
		this._QuestionNumber = questionNumber;
	}

	public int get_Answer() {
		return _Answer;
	}

	public void set_Answer(int answer) {
		this._Answer = answer;
	}

}
