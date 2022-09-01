package com.example.spring_security_demo.model;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.GenericGenerator;

import javax.persistence.*;
import java.util.UUID;

@Data
@Entity
@Table(name = "roles")
@AllArgsConstructor
@NoArgsConstructor
public class Role {
        @Id
//        @GeneratedValue(generator = "UUID")
//        @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
        @GeneratedValue(strategy = GenerationType.AUTO)
        @Column(name = "id")
        private long id;

        @Column
        private String name;


        public Role(String name) {
                this.name = name;
        }
}
