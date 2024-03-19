package co.edu.unbosque.solution.data.model;

/**
 * The type Sign up data.
 */
public record SignUpData(String email, String password,String usuario) {

    /**
     * Email string.
     *
     * @return the string
     */
    @Override
    public String email() {
        return email;
    }

    /**
     * Password string.
     *
     * @return the string
     */
    @Override
    public String password() {
        return password;
    }

    /**
     * Usuario string.
     *
     * @return the string
     */
    @Override
    public String usuario() {
        return usuario;
    }
}
