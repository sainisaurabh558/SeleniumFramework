package com.qa.Helper.exceptions;

public class FileCustomException extends RuntimeException{
	
	public FileCustomException(String message)
	{
		super();
		System.out.println("file not found or path is incorrect");
		
	}

}
