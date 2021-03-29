package com.dell.lockedme.model;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.charset.StandardCharsets;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.Paths;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;



public class FileOperations {
	
	public static boolean addFileName() {
		System.out.println("Please enter file name to add: \n");
		Scanner sc = new Scanner(System.in);
		try {
		      FileWriter myWriter = new FileWriter(Constants.fileName,true);
		      myWriter.write("\n"+sc.nextLine());
		      myWriter.close();
		      sc.close();
		      System.out.println("Successfully wrote to the file.");
		    } catch (IOException e) {
		      System.out.println("An error occurred.");
		    }
		return false;
	}
	public static boolean deleteFileName() {
		System.out.println("Please enter file name to delte: \n");
		Scanner sc = new Scanner(System.in);
		
		try {
			Path path = Paths.get(Constants.fileName);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path), charset);
			String deleteFileName = sc.nextLine();
			if(content.contains(deleteFileName)) {
			
			content = content.replaceAll(deleteFileName, "");
			Files.write(path, content.getBytes(charset));
			System.out.println("File name '"+deleteFileName +"' deleted successfully \n");
			} else {
				System.out.println("\n File name not found \n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println("An error occurred.");
		}
		sc.close();
		return false;
	}

	public static boolean searchFileName() {
		System.out.println("Please enter file name to Search : \n");
		Scanner sc = new Scanner(System.in);
		
		try {
			Path path = Paths.get(Constants.fileName);
			Charset charset = StandardCharsets.UTF_8;

			String content = new String(Files.readAllBytes(path), charset);
			String deleteFileName = sc.nextLine();
			if(content.contains(deleteFileName)) {			
			//content = content.replaceAll(deleteFileName, "");
			//Files.write(path, content.getBytes(charset));
			System.out.println("File name '"+deleteFileName +"' found successfully \n");
			} else {
				System.out.println("\n File name not found \n");
			}
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			 System.out.println("An error occurred.");
		}
		sc.close();
		return false;
	}
	public static boolean ListAllFiles() {
		// TODO Auto-generated method stub
		System.out.println("List of file names in ascending order: \n");
		
		try {		
			FileReader fr = new FileReader(Constants.fileName);
			BufferedReader reader = new BufferedReader(fr);
			ArrayList<String> str = new ArrayList<>();
			String line = "";
			while((line=reader.readLine())!=null){
				str.add(line);
			}
			Collections.sort(str);
			for(String s:str)
			System.out.println(s);
		} catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured while reading the file");
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("An error occured while reading the file");
		}
		return false;
	}
}
