package com.example.demo.library.users;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;

@Data
@AllArgsConstructor
@Builder
public class UserError implements UserResponse{
    private int status;
    private String message;

}
