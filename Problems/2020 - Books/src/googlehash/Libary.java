package googlehash;

import java.util.ArrayList;

public class Libary {
	private int id;
	private ArrayList<Book> books;
	private ArrayList<Book> booksSent;
	private int signUpDays;
	private int scansPerDay;
	private boolean isSigned;
	private int dayStartedSingingUp;
	private boolean isSingingUp;
	private boolean isUsed;

	public void setDayStartedSingingUp(int dayStartedSingingUp) {
		this.dayStartedSingingUp = dayStartedSingingUp;
	}

	public boolean isSingingUp() {
		return isSingingUp;
	}

	public void setSingingUp(boolean isSingingUp) {
		this.isSingingUp = isSingingUp;
	}

	public void setSigned(boolean isSigned) {
		this.isSigned = isSigned;
	}

	public Libary(int id, int signUpDays, int scansPerDay) {
		this.id = id;
		this.signUpDays = signUpDays;
		this.scansPerDay = scansPerDay;
		books = new ArrayList<>();
		isSigned = false;
		booksSent = new ArrayList<>();
		isUsed = false;
	}

	public boolean isSigned() {
		return isSigned;
	}

	public void startSignup(int day) {

	}

	public void update(int day) {

		if (isSingingUp) {
			if (day - dayStartedSingingUp == signUpDays) {
				isSigned = true;
				isSingingUp = false;
			}
		}
		if (isSigned) {
			for (int i = 0; i < scansPerDay && !books.isEmpty(); i++) {
				isUsed = true;
				booksSent.add(books.get(0));
				books.remove(0);
				Main.pushed.ad
			}
		}
	}

	public boolean isUsed() {
		return isUsed;
	}

	public void setUsed(boolean isUsed) {
		this.isUsed = isUsed;
	}

	public int getDayStartedSingingUp() {
		return dayStartedSingingUp;
	}

	public ArrayList<Book> getBooksSent() {
		return booksSent;
	}

	public void setBooksSent(ArrayList<Book> booksSent) {
		this.booksSent = booksSent;
	}

	public void addBook(Book book) {
		books.add(book);
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public ArrayList<Book> getBooks() {
		return books;
	}

	public int numBooks() {
		return books.size();
	}

	public void setBooks(ArrayList<Book> books) {
		this.books = books;
	}

	public int getSignUpDays() {
		return signUpDays;
	}

	public void setSignUpDays(int signUpDays) {
		this.signUpDays = signUpDays;
	}

	public int getScansPerDay() {
		return scansPerDay;
	}

	public void setScansPerDay(int scansPerDay) {
		this.scansPerDay = scansPerDay;
	}

	public double getRatio() {
		return (double) scansPerDay / getScoreWorth();
	}

	public int getDupe() {
		for(Book b : books) {
			if(Main.pushed)
		}
		return 0;
	}

	public int getScoreWorth() {
		int runsFor = (Main.maxDay - Main.currentDay) - signUpDays;
		int possibleScans = runsFor * scansPerDay;
		int worth = 0;
		for (int i = 0; i < possibleScans && i < books.size(); i++) {
			worth += books.get(i).getScore();
		}

		return worth;
	}
}
