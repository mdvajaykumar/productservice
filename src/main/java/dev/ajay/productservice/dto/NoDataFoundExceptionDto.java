package dev.ajay.productservice.dto;


import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

@Getter
@Setter
public class NoDataFoundExceptionDto {
    private HttpStatus errorCode;
    private String errorMessage;
    public NoDataFoundExceptionDto(HttpStatus errorCode, String errorMessage){
        this.errorCode =errorCode;
        this.errorMessage=errorMessage;
    }
}
