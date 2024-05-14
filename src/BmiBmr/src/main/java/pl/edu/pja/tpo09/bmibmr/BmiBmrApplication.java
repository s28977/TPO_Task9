package pl.edu.pja.tpo09.bmibmr;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class BmiBmrApplication
{

    public static void main(String[] args)
    {
        SpringApplication.run(BmiBmrApplication.class, args);
    }
    /*
    questions:
    1. Can I have a BmiDTO without regular DTO class (is it logical)?
    2. Should we consider other exceptions, e.g. age=njknvsjkldv?
    3. What is reason header? Should we define our own header called Reason?
    4. 499 status code text is Client Closed Request, not Invalid Data ?
     */
}
