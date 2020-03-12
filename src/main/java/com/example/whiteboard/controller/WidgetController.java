package com.example.whiteboard.controller;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;
import com.mysql.cj.xdevapi.Collection;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;
    
    List<Widget> w = new ArrayList<Widget>();
    
    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
    		@PathVariable("topicId") Integer tid,
            @RequestBody Widget newWidget) {
        return service.createWidget(tid, newWidget);
    }


    @DeleteMapping("api/widgets/{wid}")
    public int deleteWidget(
            @PathVariable("wid") Integer wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
            @PathVariable("wid") Integer wid,
            @RequestBody Widget updatedWidget) {
    	System.out.print(updatedWidget + " updated widget");
        return service.updateWidget(wid, updatedWidget);
    }

    @GetMapping("/api/widgets/{widgetId}")
    public Widget findWidgetById(
            @PathVariable("widgetId") Integer wid) {
        return service.findWidgetById(wid);
    }

    @GetMapping("/widgets")
    public List<Widget> findAllWidgets() {
        return service.findAllWidgets();
    }

    @GetMapping("api/topics/{topicId}/widgets")
    public List<Widget> findWidgetsForTopic(
            @PathVariable("topicId") String topicId) {
    	if ((topicId.equals("undefined"))) {
    		return w;
    	} else {
    		System.out.print(topicId);
    		return service.findWidgetsForTopic(Integer.parseInt(topicId));
    	}
        
    }
}
