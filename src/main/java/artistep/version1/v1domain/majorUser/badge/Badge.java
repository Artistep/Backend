package artistep.version1.v1domain.majorUser.badge;

import artistep.version1.v1domain.majorUser.user.User;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@NoArgsConstructor
@AllArgsConstructor
public class Badge {

    @Id @GeneratedValue
    private Long id;

    @JoinColumn(name = "user_id")
    @ManyToOne
    private User user;

    @Column
    private String description;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private String status;
}
