package org.example.namesearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "bnickname")
public class BuildingNickname {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "bid", referencedColumnName = "id", nullable = false)
    private Building building;

    @Column(name = "nickname", nullable = false, length = 500)
    private String nickname;

}
