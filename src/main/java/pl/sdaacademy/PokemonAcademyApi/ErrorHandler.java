package pl.sdaacademy.PokemonAcademyApi;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import pl.sdaacademy.PokemonAcademyApi.pokemon_details.service.NoPokemonFoundException;

@ControllerAdvice
public class ErrorHandler {

    @ExceptionHandler(value = NoPokemonFoundException.class)
    public ResponseEntity<Object> noSuchElementException(NoPokemonFoundException e) {
        return new ResponseEntity<>(e.getMessage(), HttpStatus.NOT_FOUND);
    }
}
