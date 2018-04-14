package com.kevin.tabbookmark.controller;

import com.kevin.tabbookmark.model.Bookmark;
import com.kevin.tabbookmark.service.BookmarkService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BookmarkRestController {

    @Autowired
    private BookmarkService bookmarkService;

    /*---Add new bookmark---*/
    @PostMapping("/bookmark")
    public ResponseEntity<?> save(@RequestBody Bookmark bookmark) {
        long id = bookmarkService.save(bookmark);
        return ResponseEntity.ok().body("New Book has been saved with ID:" + id);
    }

    /*---Get a bookmark by id---*/
    @GetMapping("/bookmark/{id}")
    public ResponseEntity<Bookmark> get(@PathVariable("id") int id) {
        Bookmark bookmark = bookmarkService.get(id);
        return ResponseEntity.ok().body(bookmark);
    }

    /*---get all bookmarks---*/
    @GetMapping("/bookmark")
    public ResponseEntity<List<Bookmark>> list() {
        List<Bookmark> bookmarks = bookmarkService.list();
        return ResponseEntity.ok().body(bookmarks);
    }

    /*---Update a bookmark by id---*/
    @PutMapping("/bookmark/{id}")
    public ResponseEntity<?> update(@PathVariable("id") int id, @RequestBody Bookmark bookmark) {
        bookmarkService.update(id, bookmark);
        return ResponseEntity.ok().body("Bookmark has been updated successfully.");
    }

    /*---Delete a bookmark by id---*/
    @DeleteMapping("/book/{id}")
    public ResponseEntity<?> delete(@PathVariable("id") int id) {
        bookmarkService.delete(id);
        return ResponseEntity.ok().body("Bookmark has been deleted successfully.");
    }
}