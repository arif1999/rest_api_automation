package api.automation.base.util;

import groovyjarjarantlr.collections.List;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;

public class FileUtilities {
	private String filepath;
	private BufferedReader reader;
	FileUtilities(String filepath) throws FileNotFoundException{
		/*
		 * constructor to pick the file path 
		 */
		
		File file = new File(filepath);
		FileReader fr = new FileReader(file);
		reader = new BufferedReader(fr);
		this.filepath = filepath;
	}
	public java.util.List<String> getRequests(){
		/*
		 * fetch all request from file and create list of requests
		 */
		java.util.List<String> requests = new ArrayList();
		String line;
		try {
			while((line = reader.readLine()) != null){
			     //process the line
				requests.add(line);
			}
		} catch (IOException e) {
			e.printStackTrace();
		}
		return(requests);
	}
	
	public void closeReader() throws IOException{
		/*
		 * close the buffered reader
		 */
		reader.close();
	}

}
