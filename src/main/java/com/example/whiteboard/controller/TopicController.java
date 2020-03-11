package com.example.whiteboard.controller;
import com.example.whiteboard.services.TopicService;
import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
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

    @GetMapping("/api/lessons/{lessonId}/topics")
    public List<Topic> findTopicsForLesson(
            @PathVariable("lessonId") String lessonId
    ) {
    	if(lessonId.equals("undefined")) {
    		return Collections.emptyList();
    	}
        return topicService.findTopicsForLesson(lessonId);
    }
    
    @PostMapping("/api/lessons/{lessonId}/topics")
    public Topic createTopic(
    		@PathVariable("lessonId") String lid,
            @RequestBody Topic newTopic) {
//    		newWidget.setTopicId(tid);
    	System.out.print(lid);
        return topicService.createTopic(lid, newTopic);
    }



}