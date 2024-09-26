package com.stfonavi.app.todo.POJO;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.DynamicInsert;
import org.hibernate.annotations.DynamicUpdate;

import javax.persistence.*;
import javax.validation.constraints.Email;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.Size;
import java.io.Serial;
import java.io.Serializable;
import java.util.ArrayList;

@NamedQuery(name="User.findByEmailId", query="select u from  User u where u.email=:email")


@NoArgsConstructor
@Data
@Entity
@DynamicUpdate
@DynamicInsert
@Table(name="user")
public class User implements Serializable {

    @Serial
    private static final long serialVersionUID = 3034371874894730975L;

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Integer id;

    @NotEmpty(message = "Name is required")
    @Column(name="name")
    private String name;

    @NotEmpty(message = "Phone is required")
    @Column(name="contactNumber")
    private String contactNumber;

    @NotEmpty(message = "Email is required")
    @Email(message = "Invalid email format")
    @Column(name="email")
    private String email;

    @NotEmpty(message = "Password is required")
    @Size(min = 6, message = "Password must be at least 6 characters long")
    @Column(name="password")
    private String password;

    @Column(name="status")
    private String status;

    @Column(name="role")
    private String role;


}
