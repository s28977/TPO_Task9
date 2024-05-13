package pl.edu.pja.tpo09.bmibmr.services;

import org.springframework.stereotype.Service;
import pl.edu.pja.tpo09.bmibmr.models.BmiDto;

@Service
public class BmiService
{
    public BmiService()
    {
    }

    public BmiDto getBmiDto(double weight, double height)
    {
        double bmi = calculateBmi(weight, height);
        String type = getType(bmi);
        return new BmiDto(weight, height, (int) bmi, type);
    }

    private String getType(double bmi)
    {
        if (bmi < 16)
            return "Underweight (severe thinness)";
        if (bmi < 17)
            return "Underweight (Moderate thinness)";
        if (bmi < 18.5)
            return "Underweight (Mild thinness)";
        if (bmi < 25)
            return "Normal";
        if (bmi < 30)
            return "Overweight (Pre-obese)";
        if (bmi < 35)
            return "Obese (Class I)";
        if (bmi < 40)
            return "Obese (Class II)";
        return "Obese (Class III)";
    }

    private double calculateBmi(double weight, double height)
    {
        return (weight / height);
    }
}
