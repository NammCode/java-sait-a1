package sait.mms.managers;

import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

import sait.mms.problemdomain.Movie;

/**
 * 
 * @author Nam Khanh Nguyen
 * @version 1.0, May 11, 2020
 */
public class MovieManagementSystem {

	// Constants
	public static final String FILE_PATH = "res\\movies.txt";

	// Scanner
	Scanner keyboard;

	/**
	 * This arrayList stores all of the movies info
	 */
	private ArrayList<Movie> movies;

	/**
	 *  This constructor create a new Scanner keyboard and new Arraylist movie
	 *  After that, it call method loadMovieList()
	 * @throws FileNotFoundException
	 */
	public MovieManagementSystem() throws FileNotFoundException {
		keyboard = new Scanner(System.in);
		movies = new ArrayList<>();
		loadMovieList();
	}

	/**
	 * This method read the text file and add the movie and its content into arraylist movies
	 * @throws FileNotFoundException
	 */
	private void loadMovieList() throws FileNotFoundException {
		File file = new File(FILE_PATH).getAbsoluteFile();
		Scanner inFile = new Scanner(file);
		while (inFile.hasNext()) {
			String curLine = inFile.nextLine();
			String[] splittedLine = curLine.split(",");
			Movie tmpMove = new Movie(Integer.parseInt(splittedLine[0]), splittedLine[1],
					Integer.parseInt(splittedLine[2]));
			movies.add(tmpMove);
		}
		inFile.close();
	}

	/**
	 * Display the menu
	 * 
	 * @throws IOException
	 */
	public void displayMenu() throws IOException {
		int option = -1;
		while (option != 4) {
			System.out.println("Movie Management System");
			System.out.println("1     Add New Movie and Save");
			System.out.println("2     Generate List of Movies Released in a Year");
			System.out.println("3     Generate List of Random Movies");
			System.out.println("4     Exit");
			System.out.print("Enter an option: ");
			option = keyboard.nextInt();
			switch (option) {
			case 1:
				addMovie();
				break;

			case 2:
				generateMovieListInYear();
				break;

			case 3:
				generateRandomMovieList();
				break;

			case 4:
				saveChanges();
				break;

			default:
				System.out.println("Invalid option\n");
				break;
			}
		}
	}

	/**
	 * This method for user to add a movie into arrayList
	 * @throws IOException
	 */
	public void addMovie() throws IOException {
		System.out.print("Enter duration: ");
		int duration = keyboard.nextInt();
		keyboard.nextLine();
		while (duration == 0) {
			System.out.println("Duration should not be 0, please enter again: ");
			duration = keyboard.nextInt();
		}

		System.out.print("Enter movie title: ");
		String title = keyboard.nextLine();
		while (title.trim().equals("")) {
			System.out.println("Title should not be empty, please enter again: ");
			title = keyboard.nextLine();
		}

		System.out.print("Enter year: ");
		int year = keyboard.nextInt();
		while (year == 0) {
			System.out.println("Year should not be 0, please enter again: ");
			year = keyboard.nextInt();
		}

		movies.add(new Movie(duration, title, year));
		System.out.println("Saving movies...");
		System.out.println("Added movie to the data file.\n");
	}

	/**
	 * This method for user input year, and display this list of movie in this year
	 */
	public void generateMovieListInYear() {
		int year, totalDuration = 0;
		System.out.print("Enter in year: ");
		year = keyboard.nextInt();
		System.out.println("\nMovie List");
		System.out.printf("%-12s %-6s %-30s\n", "Duration", "Year", "Title");
		for (int i = 0; i < movies.size(); i++) {
			if (movies.get(i).getYear() == year) {
				System.out.println(movies.get(i));
				totalDuration += movies.get(i).getDuration();
			}
		}
		System.out.println("Total duration: " + totalDuration + " minutes\n");
	}

	/**
	 * This method for user input number of movies, and display the number of random movie
	 */
	public void generateRandomMovieList() {
		int totalDuration = 0;
		System.out.print("Enter number of movies: ");
		int numberRandom = keyboard.nextInt();
		System.out.println("\nMovie List");
		System.out.printf("%-12s %-6s %-30s\n", "Duration", "Year", "Title");
		Collections.shuffle(movies);

		for (int i = 0; i < numberRandom; i++) {
			System.out.println(movies.get(i).toString());
			totalDuration += movies.get(i).getDuration();
		}
		System.out.println("Total duration: " + totalDuration + " minutes\n");
	}

	/**
	 * This method to saves change from arrayList movies into text file
	 * @throws IOException
	 */
	public void saveChanges() throws IOException {
		FileWriter fw = new FileWriter(FILE_PATH);
		PrintWriter outputFile = new PrintWriter(fw);
		outputFile.print("");
		for (int i = 0; i < movies.size(); i++) {
			outputFile.println(movies.get(i).formatToFile());
		}
		outputFile.close();
		System.out.println("Saving movies list...");
		System.out.println("Have a good night!");
	}

}
