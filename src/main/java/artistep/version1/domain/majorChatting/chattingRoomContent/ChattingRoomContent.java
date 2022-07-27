package artistep.version1.domain.majorChatting.chattingRoomContent;


import artistep.version1.domain.majorChatting.chattingRoom.ChattingRoom;
import artistep.version1.domain.majorChatting.chattingRoomFile.ChattingRoomFile;
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
    private Long id;

    @JoinColumn(name = "chatting_room_id")
    @OneToOne
    private ChattingRoom chattingRoom;

    @JoinColumn(name = "chatting_room_file_id")
    @OneToOne
    private ChattingRoomFile chattingRoomFile;

    @Column
    private String link;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private int status;
}
