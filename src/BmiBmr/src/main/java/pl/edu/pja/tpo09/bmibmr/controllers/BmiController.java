package pl.edu.pja.tpo09.bmibmr.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import pl.edu.pja.tpo09.bmibmr.exceptions.NegativeParametersException;
import pl.edu.pja.tpo09.bmibmr.models.BmiDto;
import pl.edu.pja.tpo09.bmibmr.services.BmiService;

@RestController
@RequestMapping(
        path = "/api/v1/BMI"
)
public class BmiController
{
    private final BmiService bmiService;

    public BmiController(BmiService bmiService)
    {
        this.bmiService = bmiService;
    }

    @GetMapping(produces = {
            MediaType.APPLICATION_JSON_VALUE,
            MediaType.APPLICATION_XML_VALUE
    })
    ResponseEntity<BmiDto> getBmiJsonXml(@RequestParam double weight, @RequestParam double height)
    {
        try
        {
            return ResponseEntity.ok(bmiService.getBmiDto(weight, height));
        } catch (NegativeParametersException exception)
        {
            return ResponseEntity.badRequest()
                    .header("Reason", exception.getMessage())
                    .build();
        }
    }


    @GetMapping(produces = {
                MediaType.TEXT_PLAIN_VALUE
            })
    ResponseEntity<String> getBmiTextPlain(@RequestParam double weight, @RequestParam double height)
    {
        try
        {
            return ResponseEntity.ok(bmiService.getBmiString(weight, height));
        } catch (NegativeParametersException exception)
        {
            return ResponseEntity.badRequest()
                    .header("Reason", exception.getMessage())
                    .build();
        }
    }

}
