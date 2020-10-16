package tk.youngdk.quartz_demo.domain;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString
public class Member {

    public Member(String userName) {
        this.userName = userName;
    }

    @Id
    @GeneratedValue
    @Column(name = "member_id")
    private Long id;

    private String userName;

}
