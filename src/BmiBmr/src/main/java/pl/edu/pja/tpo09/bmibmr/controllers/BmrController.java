package pl.edu.pja.tpo09.bmibmr.controllers;

import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import pl.edu.pja.tpo09.bmibmr.exceptions.InvalidGenderException;
import pl.edu.pja.tpo09.bmibmr.exceptions.NegativeParametersException;
import pl.edu.pja.tpo09.bmibmr.models.BmrDto;
import pl.edu.pja.tpo09.bmibmr.services.BmrService;

@RestController
@RequestMapping(
        path = "/api/v1/BMR/{gender}"
)
public class BmrController
{
    private final BmrService bmrService;

    public BmrController(BmrService bmrService)
    {
        this.bmrService = bmrService;
    }

    @GetMapping(
            produces = {
                    MediaType.APPLICATION_JSON_VALUE,
                    MediaType.APPLICATION_XML_VALUE
            })
    ResponseEntity<BmrDto> getBmrJsonXml(@PathVariable String gender, @RequestParam double weight, @RequestParam double height, @RequestParam int age)
    {
        try
        {
            return ResponseEntity.ok(bmrService.getBmrDto(gender, weight, height, age));
        } catch (NegativeParametersException exception)
        {
            return ResponseEntity.status(499)
                    .header("Reason", exception.getMessage())
                    .build();
        } catch (InvalidGenderException exception)
        {
            return ResponseEntity.badRequest()
                    .header("Reason", exception.getMessage())
                    .build();
        }
    }


    @GetMapping(produces = {
            MediaType.TEXT_PLAIN_VALUE
    })
    ResponseEntity<String> getBmrTextPlain(@PathVariable String gender, @RequestParam double weight, @RequestParam double height, @RequestParam int age)
    {
        try
        {
            return ResponseEntity.ok(bmrService.getBmrString(gender, weight, height, age));
        } catch (NegativeParametersException exception)
        {
            return ResponseEntity.status(499)
                    .header("Reason", exception.getMessage())
                    .build();
        } catch (InvalidGenderException exception)
        {
            return ResponseEntity.badRequest()
                    .header("Reason", exception.getMessage())
                    .build();
        }
    }
}