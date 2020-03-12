package com.example.whiteboard.services;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.TopicRepository;
import com.example.whiteboard.repositories.WidgetRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class TopicService {
    @Autowired
    TopicRepository topicRepository;
    
    @Autowired
    WidgetRepository widgetRepository;
    

    public Topic createTopic(String lid, Topic topic) {
    	topic.setLessonId(lid);
    	return topicRepository.save(topic);

    }
    public List<Topic> findTopicsForLesson(String lid) {
    	
        return topicRepository.findTopicsForLesson(lid);

    }
    public List<Topic> findAllTopics() {
        return (List<Topic>)topicRepository.findAll();
    }
    
    // TODO: implement findTopicById
    public Topic findTopicById(int tid) {
        return null;
    }

    // TODO: delete topic
    public void deleteTopic(int tid) {
    	topicRepository.deleteById(tid);
    }
    
    public Widget createWidgetForTopic(
            Integer tid,
            Widget newWidget) {
        Topic topic = topicRepository.findById(tid).get();
        newWidget.setTopic(topic);
        return widgetRepository.save(newWidget);
    }
    
    public void updateTopic(int tid, Topic newTopic) {
        Topic topic = topicRepository.findById(tid).get();
        topic.setTitle(newTopic.getTitle());
        topicRepository.save(topic);
    }

}