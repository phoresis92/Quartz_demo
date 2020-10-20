package tk.youngdk.quartz_demo.repository.gcp;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import tk.youngdk.quartz_demo.domain.Member;
import tk.youngdk.quartz_demo.repository.MemberRepository;

import java.util.List;

public interface GcpMemberRepository extends MemberRepository {
}
