package tk.youngdk.quartz_demo.controller;

import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.*;
import tk.youngdk.quartz_demo.dto.response.exception.BaseExceptionResponseDto;

@Slf4j
@RestControllerAdvice(basePackages = "tk.youngdk.quartz_demo.controller.*")
public class GlobalExceptionHandlerController {

    @ExceptionHandler(MethodArgumentNotValidException.class)
    @ResponseStatus(HttpStatus.BAD_REQUEST)
    public ResponseEntity<BaseExceptionResponseDto> bindExceptionHandler(MethodArgumentNotValidException e) {
        log.error(e.getMessage());

        System.out.println("e = " + e);

        BaseExceptionResponseDto baseExceptionResponseDto = new BaseExceptionResponseDto();
        baseExceptionResponseDto.setMessage(e.getMessage());

        ResponseEntity responseEntity = new ResponseEntity(baseExceptionResponseDto, HttpStatus.BAD_REQUEST);

        return responseEntity;

    }

}
