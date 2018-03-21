/**
 * Klasa pomocnicza. Oblicza wynik testu
 * 
 * @author Pawel Szynal
 *
 */
public class Statistics {

	/**
	 * Egzamin
	 */
	private Test _Exam;
	/**
	 * Maksymalna pula punktow do otrzymania
	 */
	private int _MaxScore = 0;
	/**
	 * Wynik z testu
	 */
	private int _Score = 0;

	/**
	 * Kostruktor obliczajacy wynik z testu
	 * 
	 * @param exam
	 *            Test
	 */
	public Statistics(Test exam) {
		this.set_Exam(exam);

		for (int i = 0; i < exam.get_TestQuestions().size(); i++) {
			_MaxScore += exam.get_TestQuestions().get(i).get_PintsForQuestion();
			//
			if (exam.get_TestQuestions().get(i).get_GoodAnswer() == exam.get_TestAnswers().get(i).get_Answer()) {
				_Score += exam.get_TestQuestions().get(i).get_PintsForQuestion();
			}
		}
	}

	/**
	 * AKcesor GEt
	 * 
	 * @return test
	 */
	public Test get_Exam() {
		return _Exam;
	}

	/**
	 * Akcesor Set
	 * 
	 * @param exam
	 *            test
	 */
	public void set_Exam(Test exam) {
		this._Exam = exam;
	}

	/**
	 * Akcesor GEt
	 * 
	 * @return Maksymalna pula punktow do otrzymania
	 */
	public int get_MaxScore() {
		return _MaxScore;
	}

	/**
	 * Akcesor GEt
	 * 
	 * @return Wynik z testu
	 */
	public int Get_Score() {
		return _Score;
	}

}
