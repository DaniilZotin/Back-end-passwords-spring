package angular.spring.test.exceptions.handler;



import angular.spring.test.exceptions.exceptions.UsersNotFoundException;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;
import org.springframework.web.context.request.WebRequest;

import java.time.LocalDateTime;
import java.util.Map;
import java.util.TreeMap;


@RestControllerAdvice
@Slf4j
public class RestResponseEntityExceptionHandler  {

    @ExceptionHandler(UsersNotFoundException.class)
    public ResponseEntity<Map<String, String>>  handleUserNotFoundException(UsersNotFoundException exception, WebRequest request) {
        Map<String, String> map =  new TreeMap<>();
        map.put("error", exception.getMessage());
        map.put("path", request.getDescription(false));
        map.put("status", "500");
        map.put( "timestamp", String.valueOf(LocalDateTime.now()));
        return new ResponseEntity<>(map,HttpStatus.INTERNAL_SERVER_ERROR);
    }


}