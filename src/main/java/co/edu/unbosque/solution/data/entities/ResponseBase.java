package co.edu.unbosque.solution.data.entities;

import lombok.Getter;
import lombok.Setter;

/**
 * The type Response base.
 *
 * @param <T> the type parameter
 */
public class ResponseBase<T> {

    @Getter
    @Setter
    private boolean isValid;
    /**
     * -- GETTER --
     * Gets message.
     *
     * @return the message
     */
    @Getter
    @Setter
    private String message;
    //Esto es un generic type
    @Getter
    @Setter
    private T dataSingle;

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

