package SofkaU.Challenge.entity;

import lombok.*;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.persistence.*;

@Entity
@Table(name="tbl_player")
@Data @AllArgsConstructor @NoArgsConstructor @Builder
public class Player {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long player_id;
    private String username;
}
