package org.example.namesearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "facility")
public class Facility {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bid", referencedColumnName = "id", nullable = false)
    private Building building;

    @Column(name = "type", nullable = false, length = 500)
    private String type;
}
