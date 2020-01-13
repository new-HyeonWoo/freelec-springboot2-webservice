package com.hyeon.book.springboot.web;

import com.hyeon.book.springboot.service.PostsService;
import com.hyeon.book.springboot.web.dto.PostsResponseDto;
import com.hyeon.book.springboot.web.dto.PostsSaveRequestDto;
import com.hyeon.book.springboot.web.dto.PostsUpdateRequestDto;
import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

@RequiredArgsConstructor
@RestController
public class PostsApiController {

    // 스프링에서 Bean을 주입받는 방식
    // - @Autowired
    // - setter
    // - 생성자
    // 이 중 가장 권장하는 방식은 생성자로 주입받는 방식이다.
    // 생성자 대신 롬복의 @RequiredArgsConstructor가 대신 생성해준다.
    private final PostsService postsService;

    @PostMapping("/api/v1/posts")
    public Long save(@RequestBody PostsSaveRequestDto requestDto) {
        return postsService.save(requestDto);
    }

    @PutMapping("/api/v1/posts/{id}")
    public Long update(@PathVariable Long id, @RequestBody PostsUpdateRequestDto requestDto){
        return postsService.update(id, requestDto);
    }

    @GetMapping("/api/v1/posts/{id}")
    public PostsResponseDto findById(@PathVariable Long id){
        return postsService.findById(id);
    }
}
