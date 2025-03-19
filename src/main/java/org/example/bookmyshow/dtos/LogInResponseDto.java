package org.example.bookmyshow.dtos;

import org.example.bookmyshow.models.User;

public class LogInResponseDto extends BaseResponseDTO{
    private User user;

    public User getUser() {
        return user;
    }

    public void setUser(User user) {
        this.user = user;
    }
}
