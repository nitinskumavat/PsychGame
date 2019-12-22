package com.psych.game.model;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.*;
import java.util.Set;

@Entity
@Table(name = "games")
public class Game extends Auditable{
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Getter
    @Setter
    private Long game_id;

    @OneToMany(fetch = FetchType.LAZY)
    @JoinColumn(name="id")
    private Set<Player> players;

    private Player leader;
}
