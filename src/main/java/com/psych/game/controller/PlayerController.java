package com.psych.game.controller;

import com.psych.game.model.Player;
import com.psych.game.repository.PlayerRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import javax.validation.Valid;
import java.util.List;

@RestController
@RequestMapping("/api")
public class PlayerController {
    @Autowired
    private PlayerRepository playerRepository;

    @GetMapping("/players")
    public List<Player> getAllPlayer(){
        return playerRepository.findAll();
    }

    @PostMapping("/players")
    public Player createPlayer(@Valid @RequestBody Player player){
        return playerRepository.save(player);
    }

    @GetMapping("/players/{id}")
    public Player getPlayerById(@PathVariable(value = "id") Long id)throws  Exception{
        return playerRepository.findById(id).orElseThrow(() -> new Exception("Player don't Exist"));
    }

    @PutMapping("/players/{id}")
    public Player updatePlayer(@PathVariable(value = "id") Long id, @Valid @RequestBody Player player) throws Exception {
        Player p = playerRepository.findById(id).orElseThrow(() -> new Exception("something went wrong"));
        p.setName(player.getName());
        return playerRepository.save(p);
    }

    @DeleteMapping("/players/{id}")
    public ResponseEntity<?> deletePlayer(@PathVariable(value = "id") Long id) throws Exception {
        Player p = playerRepository.findById(id).orElseThrow(() -> new Exception("something went wrong"));
        playerRepository.delete(p);
        return ResponseEntity.ok().build();
    }
}
