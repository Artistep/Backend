package artistep.version1.v1domain.majorComment.majorChatting.chattingRoomContent;


import artistep.version1.v1domain.majorComment.majorChatting.chattingRoom.ChattingRoom;
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
public class ChattingRoomContent {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long id;

    @JoinColumn(name = "chatting_room_id")
    @ManyToOne
    private ChattingRoom chattingRoom;

    @Column
    private String link;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private String status;
}
