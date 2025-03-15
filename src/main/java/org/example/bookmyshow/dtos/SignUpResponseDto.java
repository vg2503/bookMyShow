package org.example.bookmyshow.dtos;


public class SignUpResponseDto extends BaseResponseDTO {
    private Long userId;

    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }
}
