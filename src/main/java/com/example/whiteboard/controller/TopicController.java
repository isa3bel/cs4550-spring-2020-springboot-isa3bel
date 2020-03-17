package com.example.whiteboard.controller;
import com.example.whiteboard.services.TopicService;
import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.Collections;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class TopicController {

    @Autowired
    TopicService topicService;

    @GetMapping("/api/topics")
    public List<Topic> findAllTopics() {
        return topicService.findAllTopics();
    }
    
    @GetMapping("/api/topics/{topicId}")
    public void findTopicById(@PathVariable("topicId") Integer topicId) {
    	topicService.findTopicById(topicId);
    }

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") String lessonId
    ) {
    	if(lessonId.equals("undefined")) {
    		return Collections.emptyList();
    	}
        return topicService.findTopicsForLesson(lessonId);
    }
    
    @PutMapping("/api/topics/{topicId}") 
    public void updateTopic(@PathVariable("topicId") String topicId, @RequestBody Topic updatedTopic){
    	topicService.updateTopic(Integer.parseInt(topicId), updatedTopic);
    	
    }
    
    @PostMapping("/api/lessons/{lessonId}/topics")
    public Topic createTopic(
    		@PathVariable("lessonId") String lid,
            @RequestBody Topic newTopic) {
//    		newWidget.setTopicId(tid);
    	System.out.print(lid);
        return topicService.createTopic(lid, newTopic);
    }
    
    @DeleteMapping("api/topics/{topicId}")
    public void deleteTopic(@PathVariable("topicId") String topicId) {
    	System.out.print("hit delete topic");
    	topicService.deleteTopic(Integer.parseInt(topicId));
    }

}