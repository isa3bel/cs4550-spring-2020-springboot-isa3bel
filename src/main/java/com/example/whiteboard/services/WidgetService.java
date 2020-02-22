package com.example.whiteboard.services;

import com.example.whiteboard.models.Widget;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

import org.springframework.stereotype.Service;

@Service
public class WidgetService {
	List<Widget> widgetList = new ArrayList<Widget>();

//	 {
//	 Widget w2 = new Widget("234", "WB", "PARAGRAPH");
//	
//	 w2.setTopicId("111");
//	
//	 widgetList.add(w2);
//	 }
	public Widget createWidget(Widget newWidget) {
		widgetList.add(newWidget);
		System.out.println("created widget's id: " + newWidget.getId());
		return newWidget;
	}

	public Widget findWidgetById(String wid) {
		System.out.print(wid + " find widget by id");
		for (Widget w : widgetList) {
			if (w.getId().equals(wid)) {
				System.out.print(w + " widget");
				return w;
			}
		}
		return null;
	}

	public List<Widget> findAllWidgets() {
		return widgetList;
	}

	public List<Widget> findWidgetsForTopic(String topicId) {
		List<Widget> results = new ArrayList<Widget>();
		for (Widget w : widgetList) {
			if (w.getTopicId().equals(topicId)) {
				System.out.print(w + " widget from topic");
				results.add(w);
			}
		}
		return results;
	}

	public int deleteWidget(String wid) {
		widgetList = widgetList.stream().filter(w -> !w.getId().equals(wid))
				.collect(Collectors.toList());
		return 1;
	}

	public int updateWidget(String wid, Widget updatedWidget) {
		for (int i = 0; i < widgetList.size(); i++) {
			if (widgetList.get(i).getId().equals(wid)) {
				widgetList.set(i, updatedWidget);
				return 1;
			}
		}
		return 0;
	}
}