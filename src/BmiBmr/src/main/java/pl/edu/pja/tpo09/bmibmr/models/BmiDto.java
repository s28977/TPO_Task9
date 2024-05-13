package pl.edu.pja.tpo09.bmibmr.models;

public class BmiDto
{
    private double weight;
    private double height;
    private int bmi;
    private String type;

    public BmiDto(double weight, double height, int bmi, String type)
    {
        this.weight = weight;
        this.height = height;
        this.bmi = bmi;
        this.type = type;
    }

    public double getWeight()
    {
        return weight;
    }

    public void setWeight(double weight)
    {
        this.weight = weight;
    }

    public double getHeight()
    {
        return height;
    }

    public void setHeight(double height)
    {
        this.height = height;
    }

    public int getBmi()
    {
        return bmi;
    }

    public void setBmi(int bmi)
    {
        this.bmi = bmi;
    }

    public String getType()
    {
        return type;
    }

    public void setType(String type)
    {
        this.type = type;
    }
}
