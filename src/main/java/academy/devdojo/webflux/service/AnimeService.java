package academy.devdojo.webflux.service;

import academy.devdojo.webflux.domain.Anime;
import academy.devdojo.webflux.repository.AnimeRepository;
import org.springframework.stereotype.Service;
import org.springframework.web.server.ResponseStatusException;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import static org.springframework.http.HttpStatus.NOT_FOUND;

@Service
public class AnimeService {

    private final AnimeRepository animeRepository;

    public AnimeService(AnimeRepository animeRepository) {
        this.animeRepository = animeRepository;
    }

    public Flux<Anime> findAll() {
        return animeRepository.findAll();
    }

    public Mono<Anime> findByName(String name) {
        return animeRepository.findByName(name);
    }

//    public Mono<Void> deleteAll() {
//        return animeRepository.deleteAll();
//    }
//
//    public Mono<Anime> update(Anime anime) {
//        return animeRepository.saveAll(anime);
//    }
//
//    public Mono<Anime> saveAll(Anime anime) {
//        return animeRepository.saveAll(anime);
//    }

    public Mono<Anime> findById(int id) {
        return animeRepository.findById(id)
                .switchIfEmpty(monoResponseStatusNotFoundException());
    }

    public <T> Mono<T> monoResponseStatusNotFoundException() {
        return Mono.error(new ResponseStatusException(NOT_FOUND, "Anime not found"));
    }
}
