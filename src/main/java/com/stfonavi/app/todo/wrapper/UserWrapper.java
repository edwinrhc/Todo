package com.stfonavi.app.todo.wrapper;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class UserWrapper {

    private Integer id;
    private String name;
    private String email;
    private String contact_number;
    private String status;


}
