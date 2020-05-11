package sait.mms.problemdomain;

public class Movie {

	private int duration;
	private String title;
	private int year;
	
	public Movie() {
	}
	
	public Movie(int duration, String title, int year) {
		this.duration = duration;
		this.title = title;
		this.year = year;
	}

	public int getDuration() {
		return duration;
	}
	
	public void setDuration(int duration) {
		this.duration = duration;
	}
	
	public String getTitle() {
		return title;
	}
	
	public void setTitle(String title) {
		this.title = title;
	}
	
	public int getYear() {
		return year;
	}
	
	public void setYear(int year) {
		this.year = year;
	}

	@Override
	public String toString() {
		return String.format("%-12d %-6d %-30s", duration, year, title);
	}
	
	public String toStringUpdate() {
		return duration + "," + title + "," + year;
	}
	
	
}
