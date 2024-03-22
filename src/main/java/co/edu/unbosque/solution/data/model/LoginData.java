package co.edu.unbosque.solution.data.model;

/**
 * The type Login data.
 */
public record LoginData(String email, String password) {
    /**
     * Gets email.
     *
     * @return the email
     */
    public String getEmail() {
        return email;
    }

    /**
     * Gets password.
     *
     * @return the password
     */
    public String getPassword() {
        return password;
    }
}