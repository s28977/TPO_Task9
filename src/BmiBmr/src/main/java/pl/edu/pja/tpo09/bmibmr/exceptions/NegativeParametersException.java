package pl.edu.pja.tpo09.bmibmr.exceptions;

public class NegativeParametersException extends IllegalArgumentException
{
    public NegativeParametersException(String message)
    {
        super(message);
    }
}