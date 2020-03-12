package com.example.whiteboard.services;

import com.example.whiteboard.models.Topic;
import com.example.whiteboard.models.Widget;
import com.example.whiteboard.repositories.TopicRepository;
import com.example.whiteboard.repositories.WidgetRepository;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class WidgetService {
	List<Widget> widgetList = new ArrayList<Widget>();
	
	@Autowired
	TopicRepository topicRepository;
	
	@Autowired
	WidgetRepository widgetRepository;

//	 {
//	 Widget w2 = new Widget("234", "WB", "PARAGRAPH");
//	
//	 w2.setTopicId("111");
//	
//	 widgetList.add(w2);
//	 }
	
	public Widget createWidget(Integer tid, Widget newWidget) {
		//widgetList.add(newWidget);
		System.out.println("created widget's id: " + newWidget.getId());
		Topic topic = topicRepository.findById(tid).get();
		newWidget.setTopic(topic);
		return widgetRepository.save(newWidget);
	}

	public Widget findWidgetById(Integer wid) {
		return widgetRepository.findWidgetById(wid);
		//return widgetRepository.findById(wid).get();
	}

	public List<Widget> findAllWidgets() {
		return widgetRepository.findAllWidgets();
	}

	public List<Widget> findWidgetsForTopic(Integer topicId) {
		return widgetRepository.findWidgetsForTopic(topicId);
	}

	public int deleteWidget(Integer wid) {
		widgetRepository.deleteById(wid);
		return 1;
	}

	public int updateWidget(Integer widgetId, Widget updatedWidget) {
        Widget oldWidget = widgetRepository.findWidgetById(widgetId);
        System.out.println(updatedWidget.getTitle());
        System.out.println(updatedWidget.getName() + " name");
        oldWidget.setTitle(updatedWidget.getTitle());
        oldWidget.setSize(updatedWidget.getSize());
        oldWidget.setOrdered(updatedWidget.getOrdered());
        oldWidget.setName(updatedWidget.getName());
        oldWidget.setType(updatedWidget.getType());
        widgetRepository.save(oldWidget);
        return 1;
    }
}
