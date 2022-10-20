package com.example.spring_security_demo.model;

import lombok.*;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

@Data
@Entity
@Builder
@ToString
@Table( name = "users")
@AllArgsConstructor
@NoArgsConstructor
public class User {

    @Id
//    @GeneratedValue(generator = "UUID")
//    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private String surname;


    @Column(nullable = false)
    private String email;

    @Column(nullable = false)
    private String password;

    @Column
    private LocalDateTime created;

    @Column
    private LocalDateTime updated;

    @ManyToMany( fetch = FetchType.EAGER)
    @JoinTable(name = "users_roles",
            joinColumns = {@JoinColumn(name = "user_id")},
            inverseJoinColumns = {@JoinColumn(name = "roles_id")})
    private List<Role> roles = new ArrayList<>();


    @PrePersist
    protected void onCreate() {
        this.created = LocalDateTime.now();
        this.updated = this.created;
    }

    @PreUpdate
    protected void onUpdate() {
        this.updated = LocalDateTime.now();
    }


}
