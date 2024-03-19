package co.edu.unbosque.solution.data.entities;

/**
 * The type Response base.
 *
 * @param <T> the type parameter
 */
public class ResponseBase<T> {

    private boolean isValid;
    private String message;
    //Esto es un generic type
    private T dataSingle;

    /**
     * Is valid boolean.
     *
     * @return the boolean
     */
    public boolean isValid() {
        return isValid;
    }

    /**
     * Sets valid.
     *
     * @param valid the valid
     */
    public void setValid(boolean valid) {
        isValid = valid;
    }

    /**
     * Gets message.
     *
     * @return the message
     */
    public String getMessage() {
        return message;
    }

    /**
     * Sets message.
     *
     * @param message the message
     */
    public void setMessage(String message) {
        this.message = message;
    }

    /**
     * Gets data single.
     *
     * @return the data single
     */
    public T getDataSingle() {
        return dataSingle;
    }

    /**
     * Sets data single.
     *
     * @param dataSingle the data single
     */
    public void setDataSingle(T dataSingle) {
        this.dataSingle = dataSingle;
    }
}

