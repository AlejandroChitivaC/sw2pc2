package co.edu.unbosque.solution.data.model;

public record SignUpData(String email, String password,String usuario) {

    @Override
    public String email() {
        return email;
    }

    @Override
    public String password() {
        return password;
    }

    @Override
    public String usuario() {
        return usuario;
    }
}
