package sait.mms.managers;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;

public class MovieManagementSystem {

	public void displayMenu() {
		System.out.println("Movie Management system");
		System.out.println("1. Add New Movie and Save");
		System.out.println("2. Generate List of Movies Released in a Year");
		System.out.println("3. Generate List of Random Movies");
		System.out.println("4. Exit");
		System.out.print("Enter an option: ");
	}

	public void addMovie(ArrayList<Movie> movieList, String filename) throws IOException {

		String duration, title, year, line;
		String[] lineArray;
		File file = new File(filename).getAbsoluteFile();
		Scanner scanner = new Scanner(file);
		Scanner inFile = scanner.useDelimiter(",");

		while (inFile.hasNext()) {
			line = inFile.nextLine();
			lineArray = line.split(",");
			duration = lineArray[0];
			title = lineArray[1];
			year = lineArray[2];
			Movie movie = new Movie(Integer.parseInt(duration), title, Integer.parseInt(year));
			movieList.add(movie);
		}

		scanner.close();
		inFile.close();
	}

	public int generateMovieListInYear(ArrayList<Movie> movieList, int year) {

		int totalDuration = 0;
		for (int i = 0; i < movieList.size(); i++) {
			if (movieList.get(i).getYear() == year) {
				System.out.println(movieList.get(i));
				totalDuration += movieList.get(i).getDuration();
			}
		}
		return totalDuration;

	}

	public int generateRandomMovieList(ArrayList<Movie> movieList, int numberRandom) {
		Collections.shuffle(movieList);
		int totalDuration = 0;
		for (int i = 0; i < numberRandom; i++) {
			System.out.println(movieList.get(i).toString());
			totalDuration += movieList.get(i).getDuration();
		}
		return totalDuration;
	}

	public void loadMovieList(ArrayList<Movie> movieList, String filename) throws IOException {
		FileWriter fw = new FileWriter(filename);
		PrintWriter writer = new PrintWriter(fw);
		writer.print("");
		for (int i = 0; i < movieList.size(); i++) {
			writer.println(movieList.get(i).toStringUpdate());
		}
		writer.close();
	}

}
