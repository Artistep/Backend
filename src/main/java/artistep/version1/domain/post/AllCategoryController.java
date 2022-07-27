package artistep.version1.domain.post;

import artistep.version1.domain.post.feedbackDomain.FeedbackDomainRepository;
import artistep.version1.domain.post.feedbackDomain.QFeedBackDomain;
import artistep.version1.domain.post.freeTalkingDomain.QFreeTalkingDomain;
import artistep.version1.domain.post.informationDomain.QInformationDomain;
import artistep.version1.domain.post.postResponseDto.PostResponseDto;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/all-category")
@Api(tags = {"3페이지"})
@RequiredArgsConstructor
public class AllCategoryController {

    private final FeedbackDomainRepository feedbackDomainRepository;

    @GetMapping
    @ApiOperation(value = "모든 카테고리의 게시글을 조회합니다.", notes = "AccessToken 을 이용하여 Get 요청합니다.")
    public ResponseEntity<PostResponseDto.previewPostForm> loadAllCategory() {

//        PostResponseDto.previewPostForm responseForm = PostResponseDto.previewPostForm.builder()
//                .previewFreeTalking()
//                .previewInformation()
//                .previewFeedBack()
//                .build();
//
//
//
//        QFeedBackDomain qFeedBackDomain;
//        QInformationDomain qInformationDomain;
//        QFreeTalkingDomain qFreeTalkingDomain;

        return new ResponseEntity<PostResponseDto.previewPostForm>(HttpStatus.OK);
    }
}
