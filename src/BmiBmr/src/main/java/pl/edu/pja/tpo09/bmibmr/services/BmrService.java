package pl.edu.pja.tpo09.bmibmr.services;

import org.springframework.stereotype.Service;
import pl.edu.pja.tpo09.bmibmr.models.BmrDto;
import pl.edu.pja.tpo09.bmibmr.exceptions.NegativeParametersException;
import pl.edu.pja.tpo09.bmibmr.exceptions.InvalidGenderException;


@Service
public class BmrService
{
    public BmrService()
    {
    }

    public String getBmrString(String gender, double weight, double height, int age) throws NegativeParametersException, InvalidGenderException
    {
        int bmr = (int) calculateBmr(gender, weight, height, age);
        return String.valueOf(bmr);
    }

    public BmrDto getBmrDto(String gender, double weight, double height, int age) throws NegativeParametersException, InvalidGenderException
    {
        double bmr = calculateBmr(gender, weight, height, age);
        return new BmrDto(gender, weight, height, age, (int) bmr);
    }

    private double calculateBmr(String gender, double weight, double height, int age) throws NegativeParametersException, InvalidGenderException
    {
        if (weight <= 0 || height <= 0 || age <= 0)
        {
            throw new NegativeParametersException("invalid data, weight, height and age parameters must be positive numbers.");
        }
        return switch (gender)
        {
            case "man" -> (13.397 * weight + 4.799 * height - 5.677 * age + 88.362);
            case "woman" -> (9.247 * weight + 3.098 * height - 4.330 * age + 447.593);
            default -> throw new InvalidGenderException("invalid gender data");
        };
    }
}
