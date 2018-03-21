/**
 * 
 * @author Pawel Szynal 226026
 *
 */
public class Book {
	/**
	 * Tytu³
	 */
	private String _title;
	/**
	 * Autor
	 */
	private String _author;
	/**
	 * Data publikacji ksi¹¿ki
	 */
	private String _releaseDate;
	/**
	 * Cena
	 */
	private float _price;
	/**
	 * Scie¿ka dostêpu do zdjêcia ok³adki ksi¹¿ki
	 */
	private String _picturePatch;

	public String getTitle() {
		return _title;
	}

	public void setTitle(String title) {
		this._title = title;
	}

	public String get_Author() {
		return _author;
	}

	public void set_Author(String author) {
		this._author = author;
	}

	public String get_ReleaseDate() {
		return _releaseDate;
	}

	public void set_ReleaseDate(String releaseDate) {
		this._releaseDate = releaseDate;
	}

	public float get_Price() {
		return _price;
	}

	public void set_Price(float price) {
		this._price = price;
	}

	public String get_PicturePatch() {
		return _picturePatch;
	}

	public void set_PicturePatch(String picturePatch) {
		this._picturePatch = picturePatch;
	}

}
