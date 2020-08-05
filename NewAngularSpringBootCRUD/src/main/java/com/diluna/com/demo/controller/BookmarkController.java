package com.diluna.com.demo.controller;

import java.util.List;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import com.diluna.com.demo.model.Bookmark;
import com.diluna.com.demo.service.BookmarkServiceImpl;


@CrossOrigin(origins = "http://localhost:4200")
@RestController
public class BookmarkController {
	private static final String JSON_URL="http://demo.dreamsquadgroup.com/test/index.json ";

	
	//private ParsingService parsingService;
	
	private BookmarkServiceImpl bookmarkService;

    public BookmarkController(BookmarkServiceImpl bookmarkService) {
        this.bookmarkService = bookmarkService;
    }

    
    @GetMapping("/bookmarks")
	public List<Bookmark> findAll(){
		return bookmarkService.findAll();
	}
    
    
    @GetMapping("/bookmarks/{bookmarkId}")
	public Bookmark getBookmark(@PathVariable int bookmarkId) {
		Bookmark bookmark=bookmarkService.findById(bookmarkId);
		
		if(bookmark==null) {
			throw new RuntimeException("Employeeid not found -"+bookmarkId);
		}
		return bookmark;
	}
    
	@PostMapping("/bookmarks")
	public Bookmark addBookmark(@RequestBody Bookmark bookmark) {
		
		bookmark.setId(0);
		
		bookmarkService.save(bookmark);
		return bookmark;
	}

	@PutMapping("/bookmarks/{bookmarkId}")
	//employee details comming as Json from Request body 
	public ResponseEntity<Bookmark> updateBookmark(@PathVariable int bookmarkId,@RequestBody Bookmark thebookmark) {
		Bookmark bookmark=bookmarkService.findById(bookmarkId);
		
		if(bookmark==null) {
			throw new RuntimeException("Employeeid not found -"+bookmarkId);
		}
		bookmark.setId(thebookmark.getId());
		bookmark.setName(thebookmark.getName());
		bookmark.setUrl(thebookmark.getUrl());
		
		final Bookmark updatedBookmark=bookmarkService.save(bookmark);
		return ResponseEntity.ok(updatedBookmark);
	}
	
	@DeleteMapping("/bookmarks/{bookmarkId}")
	public String deleteEmployee(@PathVariable int bookmarkId) {
		Bookmark bookmark=bookmarkService.findById(bookmarkId);
		
		if(bookmark==null) {
			throw new RuntimeException("Employeeid not found -"+bookmarkId);
		}
		 bookmarkService.deleteById(bookmarkId);
		 
		 return "Deleted Employee Id "+bookmarkId;
	}
    
    
}
