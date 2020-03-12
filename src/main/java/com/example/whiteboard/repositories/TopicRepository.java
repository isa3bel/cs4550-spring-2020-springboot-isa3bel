package com.example.whiteboard.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;

public interface TopicRepository extends CrudRepository<Topic, Integer> {
	
	@Query("SELECT topic FROM Topic topic WHERE topic.lessonId=:lid")
	public List<Topic> findTopicsForLesson(
			@Param("lid") String lessonId);
	
	@Query("SELECT topic FROM Topic topic WHERE topic.id=:lid")
	public Widget findTopicById(
			@Param("lid")Integer lid);
	
	@Query("SELECT topic FROM Topic topic")
	public List<Topic> findAllTopics();


}
