package artistep.version1.domain.majorComment.commentComment;

import artistep.version1.domain.majorUser.avatar.Avatar;
import artistep.version1.domain.majorComment.comment.Comment;
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
public class CommentComment {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @JoinColumn(name = "avatar_id")
    @OneToOne
    private Avatar avatar;

    @JoinColumn(name = "comment_id")
    @OneToOne
    private Comment comment;

    @CreationTimestamp
    private LocalDateTime createdAt;

    @UpdateTimestamp
    private LocalDateTime updatedAt;

    @Column
    private int status;
}
