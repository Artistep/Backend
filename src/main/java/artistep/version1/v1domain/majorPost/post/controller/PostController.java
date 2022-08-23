package artistep.version1.v1domain.majorPost.post.controller;


import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto;
import artistep.version1.v1domain.majorPost.post.dto.PostResponseDto.AllCategoryPostsPreviewForm;
import artistep.version1.v1domain.majorPost.post.repository.PostRepository;
import io.swagger.annotations.Api;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
@RequiredArgsConstructor
@Api("게시글 컨트롤러")
@RequestMapping("/post")
public class PostController {

    private final PostRepository postRepository;

//    public ResponseEntity<AllCategoryPostsPreviewForm> AllCategoryPostPreviewKDH(@Valid @RequestHeader String Authorization) {
//
//
//    }
}
