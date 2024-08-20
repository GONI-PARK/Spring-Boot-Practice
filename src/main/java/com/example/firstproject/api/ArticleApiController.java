package com.example.firstproject.api;


import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController // RestAPI용 컨트롤러! 데이터(JSON)를 반환
public class ArticleApiController {

    @Autowired // DI(외부에서 가져옴)
    private ArticleRepository articleRepository;

    // GET
    @GetMapping("/api/articles")
    public List<Article> index() {
        return articleRepository.findAll();
    }

    @GetMapping("/api/articles{id}")
    public Article index(@PathVariable Long id) {
        return articleRepository.findById(id).orElse(null);
    }


    // POST
    @PostMapping("/api/articles")
    public Article create(@RequestBody ArticleForm dto) {
        Article article = dto.toEntity();
        return articleRepository.save(article);
    }

    // PATCH
    @PatchMapping("/api/articles/{id}")
    public Article update(@PathVariable Long id,
                          @RequestBody ArticleForm dto) {
        // 1: 수정용 Entity 생성

        // 2: 대상 Entity 조회

        // 3: 잘못된 요청 처리(대상이 없거나, id가 다른 경우)

        // 4: 업데이트 및 정상 응답(200)
        return null;
    }

    // DELETE
}
