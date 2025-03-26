// Author:      Bradley Bush
// Date:        19 March 2025
// Activity:    Class Exercise 3: Exception Handling
// File:        InvalidGradeException.java
// Description: Step 1: Define a Custom Exception - Create an exception
//              for invalid grades.

package assignments.classexercise3.exception;

public class InvalidGradeException extends RuntimeException
{
	public InvalidGradeException(String message)
	{
		super(message);
	}
}
