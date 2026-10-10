package com.br.projeto_springai.infra.entity;

import com.br.projeto_springai.domain.User;
import com.br.projeto_springai.domain.types.UserId;
import jakarta.persistence.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.UUID;

@Entity
@Table(name = "users")
@Data
@AllArgsConstructor
@NoArgsConstructor
public class UserEntity {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private UUID userId;
    private String name;
    @Column(unique = true, nullable = false)
    private String email;
    private String password;

    public static UserEntity from(User user){
        return new UserEntity(
                user.getUserId().uuid(),
                user.getName(),
                user.getEmail(),
                user.getPassword()
        );
    }

    public User toDomain() {
        return new User(
                new UserId(this.userId),
                this.name,
                this.email,
                this.password
        );
    }
}
