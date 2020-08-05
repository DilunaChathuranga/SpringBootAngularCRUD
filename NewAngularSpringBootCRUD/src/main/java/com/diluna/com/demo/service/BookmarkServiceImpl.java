package com.diluna.com.demo.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.diluna.com.demo.model.Bookmark;
import com.diluna.com.demo.repo.BookmarkRepo;



@Service
public class BookmarkServiceImpl implements BookmarkService {

	private BookmarkRepo bookmarkRepo;
	
	@Autowired
	public BookmarkServiceImpl(BookmarkRepo bookmarkRepo) {
		this.bookmarkRepo=bookmarkRepo;
	}
	/*
	public Iterable<Bookmark> list(){
		return bookmarkRepo.findAll();
	}
	
	public Optional<Bookmark> findById(int theID){
		return bookmarkRepo.findById(theID);
	}
	
	public Bookmark save(Bookmark bookmark) {
		return bookmarkRepo.save(bookmark);
	}
	*/
	
	//this is to save all bookmarks to db
	public Iterable<Bookmark> saveAll(List<Bookmark> bookmark){
		return bookmarkRepo.saveAll(bookmark);
	}
	
	//create a bookmark
	@Override
	public Bookmark save(Bookmark bookmark) {
		//delegate calls to jpa repository interface
		return bookmarkRepo.save(bookmark);
	}

	
	//return all bookmark in json
	@Override
	public List<Bookmark> findAll() {
		//return employeeRepository.findAll();
		return bookmarkRepo.findAll();
	}

	//get bookmark by ID
	@Override
	public Bookmark findById(int theId) {
		Optional<Bookmark> result = bookmarkRepo.findById(theId);
		Bookmark bookmark=null;
		
		if(result.isPresent()) {
			bookmark=result.get();
		}
		else {
			throw new RuntimeException("Didn't find employee id "+theId);
		}
			
			return bookmark;
		}
	

	@Override
	public void deleteById(int theId) {
		bookmarkRepo.deleteById(theId);

	}



	

	

}
