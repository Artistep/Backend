package artistep.version1.domain.post.postResponseDto;

import artistep.version1.domain.post.feedbackDomain.FeedBackDomain;
import artistep.version1.domain.post.freeTalkingDomain.FreeTalkingDomain;
import artistep.version1.domain.post.informationDomain.InformationDomain;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.ArrayList;

@NoArgsConstructor
public class PostResponseDto {

    @Data
    @Builder
    public static class previewPostForm {
        ArrayList<FreeTalkingDomain> previewFreeTalking = new ArrayList<>();
        ArrayList<InformationDomain> previewInformation = new ArrayList<>();
        ArrayList<FeedBackDomain> previewFeedBack = new ArrayList<>();
    }
}
