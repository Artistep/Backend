package artistep.version1.v1domain.majorChatting.chattingRoom;

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
public class ChattingRoom {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "created_room_user_id")
    @ManyToOne
    private User created_room_user_id;

    @JoinColumn(name = "invited_room_user_id")
    @ManyToOne
    private User invited_room_user_id;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private String status;
}
