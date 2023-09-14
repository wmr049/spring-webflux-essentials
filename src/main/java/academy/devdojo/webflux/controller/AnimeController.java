package academy.devdojo.webflux.controller;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.service.AnimeService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("animes")
@Slf4j
public class AnimeController {
    private final AnimeService animeService;

    public AnimeController(AnimeService animeService) {
        this.animeService = animeService;
    }

    @GetMapping
    public Flux<Anime> listAll() {
        return animeService.findAll();
    }

//    public Mono<Anime> findByName(String name) {
//        return animeService.findByName(name);
//    }
//
//    public Mono<Anime> saveAll(Anime anime) {
//        return animeService.saveAll(anime);
//    }
//
//    public Mono<Void> deleteAll() {
//        return animeService.deleteAll();
//    }
//
//    public Mono<Anime> update(Anime anime) {
//        return animeService.update(anime);
//    }

    @GetMapping(path = "{id}")
    public Mono<Anime> findById(@PathVariable int id) {
        return animeService.findById(id);
    }


}
