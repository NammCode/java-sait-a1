package sait.mms.application;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Scanner;

import sait.mms.managers.MovieManagementSystem;
import sait.mms.problemdomain.Movie;

public class AppDriver {

	public static final String FILE_MOVIE = "res\\movies.txt";

	public static void main(String[] args) throws IOException {

		Scanner input = new Scanner(System.in);
		Scanner inputNumber = new Scanner(System.in);
		Scanner inputUser = new Scanner(System.in);
		boolean quit = false;

		MovieManagementSystem movieManagement = new MovieManagementSystem();
		ArrayList<Movie> movieList = new ArrayList<Movie>();
		movieManagement.addMovie(movieList, FILE_MOVIE);
		Movie movie = new Movie();

		do {
			movieManagement.displayMenu();
			String userOptions = inputUser.nextLine();
			switch (userOptions) {
			case "1":
				String title;
				int duration, year;

				System.out.print("Enter duration: ");
				duration = inputNumber.nextInt();
				while (duration == 0) {
					System.out.println("Duration should not be 0, please enter again: ");
					duration = inputNumber.nextInt();
				}

				System.out.print("Enter movie title: ");
				title = input.nextLine();
				while (title.trim().equals("")) {
					System.out.println("Title should not be empty, please enter again: ");
					title = input.nextLine();
				}

				System.out.print("Enter year: ");
				year = inputNumber.nextInt();
				while (year == 0) {
					System.out.println("Year should not be 0, please enter again: ");
					year =inputNumber.nextInt();
				}

				movie = new Movie(duration, title, year);
				movieList.add(movie);
				movieManagement.loadMovieList(movieList, FILE_MOVIE);
				System.out.println("Saving movies...");
				System.out.println("Added movie to the data file.\n");
				break;

			case "2":
				int yearFilm, totalDuration;
				System.out.print("Enter in year: ");
				yearFilm = inputNumber.nextInt();
				System.out.println("Movie List");
				System.out.printf("%-12s %-6s %-30s\n", "Duration", "Year", "Title");
				totalDuration = movieManagement.generateMovieListInYear(movieList, yearFilm);
				System.out.println("Total duration: " + totalDuration + " minutes\n");
				break;

			case "3":
				int numberRandom;
				System.out.print("Enter number of movies: ");
				numberRandom = inputNumber.nextInt();
				System.out.println();
				System.out.println("Movie List");
				System.out.printf("%13s %7s %20s\n", "Duration", "Year", "Title");
				totalDuration = movieManagement.generateRandomMovieList(movieList, numberRandom);
				System.out.println("Total duration: " + totalDuration + " minutes\n");
				break;

			case "4":
				quit = true;
				movieManagement.loadMovieList(movieList, FILE_MOVIE);
				System.out.println("Saving movies list...");
				System.out.println("Have a good night!");
				break;

			default:
				System.out.println("Invalid option\n");
				break;
			}
		} while (!quit);
		input.close();
		inputNumber.close();
		inputUser.close();
	}
}
