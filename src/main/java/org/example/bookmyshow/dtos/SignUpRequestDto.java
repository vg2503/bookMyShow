package org.example.bookmyshow.dtos;

public class SignUpRequestDto {
    private Long userId;
    private String name;
    private String email;

    public void setPassword(String password) {
        this.password = password;
    }

    private String password;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return email;
    }
}
