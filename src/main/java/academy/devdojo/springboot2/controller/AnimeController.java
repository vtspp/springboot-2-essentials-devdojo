package academy.devdojo.springboot2.controller;

import academy.devdojo.springboot2.domain.Anime;
import academy.devdojo.springboot2.service.AnimeService;
import academy.devdojo.springboot2.util.DateUtil;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDateTime;
import java.util.List;

@RestController
@Log4j2
@RequestMapping("animes")
public class AnimeController {

    @Autowired
    private DateUtil dateUtil;
    @Autowired
    private AnimeService animeService;

    @GetMapping
    public ResponseEntity<List<Anime>> list(){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity(animeService.listAll(), HttpStatus.OK);
    }

    @GetMapping("/{id}")
    public ResponseEntity<Anime> findById(@PathVariable Long id){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity(animeService.findById(id), HttpStatus.OK);
    }

    @PostMapping
    public ResponseEntity<Anime> save(@RequestBody Anime anime){
        log.info(dateUtil.formatLocalDateTimeToDatabaseStyle(LocalDateTime.now()));
        return new ResponseEntity(animeService.save(anime), HttpStatus.CREATED);
    }
}
