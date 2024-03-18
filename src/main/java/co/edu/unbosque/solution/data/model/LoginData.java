package co.edu.unbosque.solution.data.model;
public record LoginData(String email, String password) {
    public String getEmail() {
        return email;
    }
    public String getPassword() {
        return password;
    }
}