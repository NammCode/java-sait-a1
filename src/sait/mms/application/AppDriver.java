package sait.mms.application;

import java.io.IOException;

import sait.mms.managers.MovieManagementSystem;

/**
 * This program display the menu for user figure out the movie list User have 3
 * options 1/ Add New movie to the list
 * 
 * @author Nam Khanh Nguyen
 * @version 1.0, May 11, 2020
 */
public class AppDriver {
	
	public static void main(String[] args) throws IOException {
		MovieManagementSystem movieManagement = new MovieManagementSystem();
		movieManagement.displayMenu();
		
	}
	
}
