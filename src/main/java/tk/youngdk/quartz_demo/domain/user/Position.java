package tk.youngdk.quartz_demo.domain.user;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
public class Position {

    @Id
    @GeneratedValue
    @Column(name = "position_seq")
    private Long id;
}
