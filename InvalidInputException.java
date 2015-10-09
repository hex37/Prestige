/* CS-112 FINAL PROJECT
   File Name:          	InvalidInputException
   Programmer:         	James Watkins
   Date Last Modified: 	May 19, 2012

   Problem Statement: Define custom Exception class to filter unacceptable
   input to class Item.
   
   Overall Plan:
   1. Define a constructors for class.
  
   Classes needed and Purpose (Input, Processing, Output)
   Exception - parent class
*/
public class InvalidInputException extends Exception
	{
		public InvalidInputException()
		{
			super("Invalid input detected.");
		}
		public InvalidInputException(String message)
		{
			super(message);
		}
	}