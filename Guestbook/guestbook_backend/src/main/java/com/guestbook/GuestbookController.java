package com.guestbook;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import java.util.List;

/**
 * Created by skyereh on 28.02.17.
 */
@Controller
@RequestMapping("/guestbook")
@CrossOrigin(origins = "*")

public class GuestbookController {

    @Autowired
    private GuestbookRepository repository;

    @RequestMapping(value = "/",
        method = RequestMethod.GET,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> getEntries(){
        // Daten laden.
        List<GuestbookEntry> entries = repository.findAll();

        // Daten zurückgeben
        return  ResponseEntity.ok(entries);
    }
    @RequestMapping(value = "/",
    method = RequestMethod.POST,
    consumes = MediaType.APPLICATION_JSON_VALUE,
    produces = MediaType.APPLICATION_JSON_VALUE)
    public ResponseEntity<?> create (@RequestBody GuestbookEntry entry){
        // Speichern
        entry = repository.save(entry);

        // Zurückgeben
        return ResponseEntity.ok(entry);
    }

}
