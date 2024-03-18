package co.edu.unbosque.solution.data.entities;

public class ResponseBase<T> {

    private boolean isValid;
    private String message;
    //Esto es un generic type
    private T dataSingle;

    public boolean isValid() {
        return isValid;
    }

    public void setValid(boolean valid) {
        isValid = valid;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getDataSingle() {
        return dataSingle;
    }

    public void setDataSingle(T dataSingle) {
        this.dataSingle = dataSingle;
    }
}

