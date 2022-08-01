package artistep.version1.v1domain.majorUser.user;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import javax.persistence.*;
import java.time.LocalDateTime;

@Entity
@Builder
@Data
@NoArgsConstructor
@AllArgsConstructor
public class User {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column
    private String nickname;

    @Column
    private String bio;

    @Column
    private String picture;

    @Column
    private String username;

    @Column
    private String email;

    @Column
    private String phoneNumber;

    @Column
    private LocalDateTime birth;

    @Enumerated(EnumType.STRING)
    private Genre genre;

    @Column
    private String belong;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private String status;
}
