package tk.youngdk.quartz_demo.domain;

import tk.youngdk.quartz_demo.domain.user.User;

import javax.persistence.*;

@Entity
public class Hotel {

    @Id
    @GeneratedValue
    @Column(name = "hotel_seq")
    Long id;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "reg_user_id")
    User regUserId;

}
