package org.example.namesearch.entity;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;

@Entity
@Getter
@Setter
@Table(name = "cnickname")
public class ClassNickname {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "id")
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cid", referencedColumnName = "id", nullable = false)
    private Class classs;

    @Column(name = "nickname", nullable = false, length = 500)
    private String nickname;
}
