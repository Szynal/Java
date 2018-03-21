/**
 * 
 * @author Pawel Szynal
 *
 */
public class Question {
	/**
	 * Numer pytania
	 */
	private int _QuestionNumber;
	/**
	 * Tresc pytania
	 */
	private String _ContentOfQuestion;
	/**
	 * Pierwsza mozliwa odpowiedz
	 */
	private String _FirstAnswer;
	/**
	 * druga mozliwa odpowiedz
	 */
	private String _SecondAnswer;
	/**
	 * Trzecia mozliwa odpowiedz
	 */
	private String _ThirdAnswer;
	/**
	 * Czwarta mozliwa odpowiedz
	 */
	private String _FourthAnswer;
	/**
	 * Poprawna odpowiedz tego pytania
	 */
	private int _GoodAnswer;
	/**
	 * Punktacja za to pytanie
	 */
	private int _PintsForQuestion;

	/**
	 * Konstruktor
	 */
	public Question() {
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Numer pytania
	 */
	public int get_QuestionNumber() {
		return _QuestionNumber;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param questionNumber
	 *            Numer pytania
	 */
	public void set_QuestionNumber(int questionNumber) {
		this._QuestionNumber = questionNumber;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Tresc pytania
	 */
	public String get_ContentOfQuestion() {
		return _ContentOfQuestion;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param contentOfQuestion
	 *            Tresc pytania
	 */
	public void set_ContentOfQuestion(String contentOfQuestion) {
		this._ContentOfQuestion = contentOfQuestion;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Trzecia mozliwa odpowiedz
	 */
	public String get_ThirdAnswe() {
		return _ThirdAnswer;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param thirdAnswe
	 *            Trzecia mozliwa odpowiedz
	 */
	public void set_ThirdAnswe(String thirdAnswe) {
		this._ThirdAnswer = thirdAnswe;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return druga mozliwa odpowiedz
	 */
	public String get_SecondAnswer() {
		return _SecondAnswer;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param secondAnswer
	 *            druga mozliwa odpowiedz
	 */
	public void set_SecondAnswer(String secondAnswer) {
		this._SecondAnswer = secondAnswer;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Poprawna odpowiedz tego pytania
	 */
	public String get_FirstAnswer() {
		return _FirstAnswer;
	}

	/**
	 * Akceosr Set
	 * 
	 * @param firstAnswer
	 *            Poprawna odpowiedz tego pytania
	 */
	public void set_FirstAnswer(String firstAnswer) {
		this._FirstAnswer = firstAnswer;
	}

	/**
	 * Akceosr Get
	 * 
	 * @return Czwarta mozliwa odpowiedz
	 */
	public String get_FourthAnswer() {
		return _FourthAnswer;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param fourthAnswer
	 *            Czwarta mozliwa odpowiedz
	 */
	public void set_FourthAnswer(String fourthAnswer) {
		this._FourthAnswer = fourthAnswer;
	}

	/**
	 * Akcesor Get
	 * 
	 * @return Poprawna odpowiedz tego pytania
	 */
	public int get_GoodAnswer() {
		return _GoodAnswer;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param goodAnswer
	 *            Poprawna odpowiedz tego pytania
	 */
	public void set_GoodAnswer(int goodAnswer) {
		this._GoodAnswer = goodAnswer;
	}

	/**
	 * Akceosr Get
	 * 
	 * @return Punktacja za to pytanie
	 */
	public int get_PintsForQuestion() {
		return _PintsForQuestion;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param pintsForQuestion
	 *            Punktacja za to pytanie
	 */
	public void set_PintsForQuestion(int pintsForQuestion) {
		this._PintsForQuestion = pintsForQuestion;
	}

}
