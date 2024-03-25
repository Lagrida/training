package net.pluriel.exception;

import lombok.Data;

@Data
public class DataException extends RuntimeException {
    private  String errorCode;
    public DataException(String message , String errorCode){
        super(message);
        this.errorCode=errorCode;
    }

}
