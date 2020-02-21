package googlehash;

import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;

public class Main {
	public static int maxDay;
	public static Book[] books;
	public static Libary[] libaries;
	public static boolean canSignUp = true;
	public static int currentDay = 0;
	public static ArrayList<Libary> libsUsed;
	public static Book[] pushed;

	public static void main(String[] args) throws IOException {
		System.out.println("start..");

		libsUsed = new ArrayList<>();

//		ArrayList<String> lines = Parser.getLines("resources/a_example.txt");
		ArrayList<String> lines = Parser.getLines("resources/b_read_on.txt");
//		ArrayList<String> lines = Parser.getLines("resources/c_incunabula.txt");
//		ArrayList<String> lines = Parser.getLines("resources/d_tough_choices.txt");
//		ArrayList<String> lines = Parser
//				.getLines("resources/e_so_many_books.txt");
//		ArrayList<String> lines = Parser
//				.getLines("resources/f_libraries_of_the_world.txt");

		int lineNumber = 0;
		int[] line = numArray(lines.get(lineNumber).split(" "));
		books = new Book[line[0]];
		libaries = new Libary[line[1]];
		maxDay = line[2];

		lineNumber++;
		line = numArray(lines.get(lineNumber).split(" "));

		for (int i = 0; i < books.length; i++) {
			books[i] = new Book(i, line[i]);
		}

		for (int i = 0; i < libaries.length; i++) {// for every libary
			lineNumber++;
			line = numArray(lines.get(lineNumber).split(" "));
			libaries[i] = new Libary(i, line[1], line[2]);

			lineNumber++;
			line = numArray(lines.get(lineNumber).split(" "));
			for (int j = 0; j < line.length; j++) {
				libaries[i].addBook(books[line[j]]);
			}
		}

		System.out.println("end parser!\nStart calculation!");

		ArrayList<Libary> libariesAL = new ArrayList<Libary>(
				Arrays.asList(libaries));

		libariesAL.sort(Comparator.comparing(Libary::getScoreWorth));
		Collections.reverse(libariesAL);

		for (Libary l : libariesAL) {
			l.getBooks().sort(Comparator.comparing(Book::getScore));
			Collections.reverse(l.getBooks());
		}

		for (currentDay = 0; currentDay < maxDay; currentDay++) {
			if (canSignUp) {
				int z = 0;
				while (z < libariesAL.size() && (libariesAL.get(z).isSigned()
						|| libariesAL.get(z).isSingingUp())) {
					z++;
				}
				if (z < libariesAL.size()) {
					libariesAL.get(z).setSingingUp(true);
				}

			}
			for (Libary l : libariesAL) {
				l.update(currentDay);
				if (l.isUsed()) {

					if (!libsUsed.contains(l)) {
						libsUsed.add(l);
					}
				}
			}
		}

//		FileWriter fw = new FileWriter("src/outputzoo.txt");
//		int serversUsed = 0;
//		for (int j = 0; j < servers.length; j++) {
//			if (servers[j].getVideos().size() > 0) {
//				serversUsed++;
//			}
//		}
//		fw.write(String.valueOf(serversUsed));
//		for (int j = 0; j < servers.length; j++) {
//			if (servers[j].getVideos().size() > 0) {
//				fw.write("\n" + servers[j].toString());
//			}
//		}
//		fw.close();
//		System.out.println("done");

		FileWriter fw = new FileWriter("resources/outputb.txt");
		int libariesUsed = libsUsed.size();
		fw.write(String.valueOf(libariesUsed + "\n"));

		for (Libary l : libsUsed) {

			fw.write(String.valueOf(l.getId()) + " "
					+ String.valueOf(l.getBooksSent().size()) + "\n");
			for (int i = 0; i < l.getBooksSent().size(); i++) {
				if (i == 0) {
					fw.write(String.valueOf(l.getBooksSent().get(i).getId()));
				} else {
					fw.write(" "
							+ String.valueOf(l.getBooksSent().get(i).getId()));
				}
			}
			fw.write("\n");
		}
		fw.close();

		System.out.println("done!!!!");

	}

	public static int[] numArray(String[] array) {
		return Arrays.stream(array).mapToInt(Integer::valueOf).toArray();
	}

}
