package com.dell.lockedme.application;

import java.util.Scanner;
import java.io.File;
import java.io.FileNotFoundException;


import com.dell.lockedme.model.FileOperations;

public class Login {
	


	public static void welcomeScreen() {
		
		System.out.println("---------------------------------------------");
		System.out.println("*					*");
		System.out.println("*   Welcome To LockedMe.com		            *");
		System.out.println("*                Jaya Mudunuri	            *");
		System.out.println("*					*");
		System.out.println("----------------------------------------------");
		
		
	}
	public static void exitScreen() {
		// TODO Auto-generated method stub
		System.out.println("---------------------------------------------");
		System.out.println("*					*");
		System.out.println("*   Thanks for Visiting LockedMe.com		*");
		System.out.println("*					*");
		System.out.println("----------------------------------------------");
		
	}
	
	public static void optionsMenu(){
		System.out.println("Please select any of the below choices");
		System.out.println("1. List all file names in ascending order");
		System.out.println("2. Add / Delete / Search a file");
		System.out.println("3. Exit the application");
		Scanner sc = new Scanner(System.in);
		
		int input = sc.nextInt();
		
		boolean flag = true;
		
		while(flag) {
			switch(input) {
			case 1 : 
				flag = FileOperations.ListAllFiles();	
				exitScreen();
				break;
			case 2 :
				System.out.println("Please select any choice from the below list");
				System.out.println("1. Add file ");
				System.out.println("2. Delete file");
				System.out.println("3. Search file");
				input = sc.nextInt();
				switch(input) {
				case 1 : 
					flag = FileOperations.addFileName();
					exitScreen();
					break;
				case 2 :
					flag = FileOperations.deleteFileName();	
					exitScreen();
					break;
				case 3 :
					flag = FileOperations.searchFileName();
					exitScreen();
					break;
				default :
					System.out.println("Please select valid choice from the below list");
					System.out.println("1. Add file ");
					System.out.println("2. Delete file");
					System.out.println("3. Search file");
					input = sc.nextInt();
					break;
				}									
				break;
			case 3 :
				flag = false;
				exitScreen();
				break;
			default :
				System.out.println("Please select valid choice from the below list");
				System.out.println("1. List all file names in ascending order");
				System.out.println("2. Add / Delete / Search a file");
				System.out.println("3. Exit the Application");
				input = sc.nextInt();
				flag = true;
			}		
		}
		sc.close();		
	}	

		
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		
		welcomeScreen();
		optionsMenu();

	}

}
