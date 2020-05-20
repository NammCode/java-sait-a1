package sait.mms.problemdomain;

/**
 * Represent a movie, which take from text file
 * @author Nam Khanh Nguyen
 * @version 1.0
 * @since 2020-0511
 */
public class Movie {

	/**
	 * This is the movie's duration
	 */
	private int duration;
	
	/**
	 * This is the movie's title
	 */
	private String title;
	
	/**
	 * This is the movie's year publisher
	 */
	private int year;
	
	
	/**
	 * This is the movie's constructor which takes in all of the respective info
	 * @param duration is the Movie's duration
	 * @param title is the Movie's title
	 * @param year is the Movie's year publisher
	 */
	public Movie(int duration, String title, int year) {
		this.duration = duration;
		this.title = title;
		this.year = year;
	}

	/**
	 * The getDuration method returns a Movie object's duration.
	 * @return The value in duration field
	 */
	public int getDuration() {
		return duration;
	}
	
	/**
	 * The setDuration method stores a value in the duration field.
	 * @param duration The value to store in duration.
	 */
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	/**
	 * The getTitle method returns a Movie object's title.
	 * @return The value in title field
	 */
	public String getTitle() {
		return title;
	}
	
	/**
	 * The setTitle method stores a value in the title field.
	 * @param title The value to store in title.
	 */
	public void setTitle(String title) {
		this.title = title;
	}
	
	/**
	 * The getYear method returns a Movie object's year.
	 * @return The value in year field
	 */
	public int getYear() {
		return year;
	}
	
	/**
	 * The setYear method stores a value in the year field.
	 * @param year The value to store in year.
	 */
	public void setYear(int year) {
		this.year = year;
	}

	/**
	 * The toString method return content of movie 
	 * In format for display in movie list
	 * @return the formated String
	 */
	@Override
	public String toString() {
		return String.format("%-12d %-6d %-30s", duration, year, title);
	}
	
	/**
	 * The formatToFile method return content of movie
	 * This method format the customer info into desired ...
	 * @return the formated String
	 */
	public String formatToFile() {
		return duration + "," + title + "," + year;
	}
	
}
