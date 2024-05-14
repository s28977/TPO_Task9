package pl.edu.pja.tpo09.bmibmr.exceptions;

public class InvalidGenderException extends IllegalArgumentException
{
    public InvalidGenderException(String message)
    {
        super(message);
    }
}
