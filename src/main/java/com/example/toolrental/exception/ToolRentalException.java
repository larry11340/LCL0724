package com.example.toolrental.exception;

public class ToolRentalException extends Exception {
    private ErrorCodes errorCodes;

    public Object[] getParams() {
        return params;
    }

    public ErrorCodes getErrorCodes() {
        return errorCodes;
    }

    private Object[] params;

    public ToolRentalException(){
        super();
    }
    public ToolRentalException(ErrorCodes code){
        super(code.getMessage());
        this.errorCodes = code;
    }
    public ToolRentalException(ErrorCodes code, Object ... args){
        super(code.getMessage().formatted(args));
        this.params = args;
        this.errorCodes = code;
    }


}
