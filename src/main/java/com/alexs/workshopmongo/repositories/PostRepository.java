package com.alexs.workshopmongo.repositories;

import java.util.Date;
import java.util.List;

import org.springframework.data.mongodb.repository.MongoRepository;
import org.springframework.data.mongodb.repository.Query;
import org.springframework.stereotype.Repository;

import com.alexs.workshopmongo.domain.Post;

@Repository
public interface PostRepository extends MongoRepository<Post, String>{
	List<Post> findAll();
	
	List<Post> findByTitleContaining(String str);
	
	@Query("{ 'title': { $regex: ?0, $options: 'i' } }")
	List<Post> searchTitle(String str);
	
	
	@Query("{ $and:[{'date':{$gte: ?1}} ,{'date':{$lte: ?2}} ,{$or: [{'title': { $regex: ?0, $options: 'i' }}, {'body': { $regex: ?0, $options: 'i' }},{'comments.text': { $regex: ?0, $options: 'i' }}]}]}")
	List<Post> fullSearch(String str, Date minDate, Date maxDate);
	
}
