package de.mvs.service.entities;

import io.quarkus.hibernate.orm.panache.PanacheEntityBase;
import jakarta.persistence.*;
import jakarta.validation.constraints.NotNull;
import jakarta.validation.constraints.Size;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
public class Person extends PanacheEntityBase {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    Long id;

    @NotNull
    @Size(max = 20)
    @Column(length = 20)
    String salutation;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    String firstName;

    @NotNull
    @Size(max = 50)
    @Column(length = 50)
    String lastName;

    @NotNull
    @ManyToOne
    @JoinColumn(name = "category")
    Category category;

    @NotNull
    @Size(max = 20)
    @Column(length = 20)
    String phone;

    @NotNull
    @Size(max = 20)
    @Column(length = 20)
    String email;
}
