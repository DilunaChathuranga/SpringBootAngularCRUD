package com.diluna.com.demo.service;

import java.util.List;

import com.diluna.com.demo.model.Bookmark;

public interface BookmarkService {

	public Iterable<Bookmark> saveAll(List<Bookmark> bookmark);
	
	public List<Bookmark> findAll();
	
	public Bookmark findById(int theId);
	
	public Bookmark save(Bookmark bookmark);
	
	public void deleteById(int theId);
}
