package tk.youngdk.quartz_demo.domain.user;

import lombok.AccessLevel;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.ToString;
import org.hibernate.annotations.ColumnDefault;
import org.springframework.data.domain.Persistable;
import tk.youngdk.quartz_demo.domain.BaseTimeEntity;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Getter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
@ToString(callSuper = true)
public class User extends BaseTimeEntity implements Persistable<String> {

    @Id
    @Column(name = "user_id")
    String id;

    @Enumerated(EnumType.STRING)
    UserType userType;

    @Column(nullable = false)
    @ColumnDefault("50")
    Byte status;

    @Column(nullable = false)
    Byte agreeUse;
    LocalDateTime agreeUseDate;

    @Column(nullable = false)
    Byte agreeSave;
    LocalDateTime agreeSaveDate;

    @Column(nullable = false)
    Byte agreeCamera;
    LocalDateTime agreeCameraDate;

    @Override
    public boolean isNew() {
        return super.getRegDate() == null;
    }

}
