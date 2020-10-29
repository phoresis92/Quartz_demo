package tk.youngdk.quartz_demo.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import tk.youngdk.quartz_demo.domain.LangType;

import javax.persistence.*;
import java.io.Serializable;
import java.time.LocalDate;

@Entity
@ToString
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@Getter
public class UserInfo implements Serializable {

    @Id
//    @Column(name = "user_id")
    @OneToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id")
    User id;

    @Column(nullable = false)
    Integer companySeq;
    Integer hotelSeq;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "department_seq")
    Department department;

    @Column(nullable = false)
    String employeeCode;

    String userName;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "position_seq")
    Position position;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "duty_seq")
    Duty duty;

    String userExtensionCall;

    String userContact;

    String userEmail;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    Gender userGender;

    @Enumerated(EnumType.STRING)
    @Column(nullable = false)
    LangType userLang;

    LocalDate userBirth;

    @Column(nullable = false)
    @ColumnDefault("50")
    Byte userStatus;

    @Column(nullable = false)
    @ColumnDefault("0")
    Byte isWorking;

}
