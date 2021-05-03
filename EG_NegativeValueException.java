/**
 * Program Name:EG_NegativeValueException.java
 * Purpose:  Throws the exception when user inputs negative loan values! 
 * Coder: Eraj Gillani 0858887
 * Date: Apr. 5, 2020
 */

public class EG_NegativeValueException extends Exception
{
	EG_NegativeValueException()
	{
		super("Negative value exception triggered");
	}
}
