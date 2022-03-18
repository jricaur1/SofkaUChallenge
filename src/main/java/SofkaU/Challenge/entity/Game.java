package SofkaU.Challenge.entity;

import lombok.*;

import javax.persistence.*;
import java.util.Date;

@Entity
@Table(name = "tbl_game")
@Data @AllArgsConstructor
@NoArgsConstructor @Builder
public class Game {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long game_id;

    @Column(name="when_created")
    @Temporal(TemporalType.TIMESTAMP)
    private Date whencreated;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name="player_id")
    private Player player;
}
