package com.diluna.com.demo.repo;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.diluna.com.demo.model.Bookmark;

@Repository
public interface BookmarkRepo extends JpaRepository<Bookmark, Integer> {

}
