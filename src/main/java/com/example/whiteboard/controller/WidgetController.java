package com.example.whiteboard.controller;

import com.example.whiteboard.models.Widget;
import com.example.whiteboard.services.WidgetService;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@CrossOrigin(origins = "*")
public class WidgetController {

    @Autowired
    WidgetService service;

//    @GetMapping("/widgets/create")
//    public Widget createWidgetNotREST() {
//        Widget w1 = new Widget();
//        w1.setSize(45);
//        w1.setTitle("New Widget");
//        return service.createWidget(w1);
//    }

    @PostMapping("/api/topics/{topicId}/widgets")
    public Widget createWidget(
    		@PathVariable("topicId") String tid,
            @RequestBody Widget newWidget) {
    		newWidget.setTopicId(tid);
        return service.createWidget(newWidget);
    }
//
//    @GetMapping("/widgets/{widgetId}/delete")
//    public int deleteWidgetNotREST(
//            @PathVariable("widgetId") Integer wid) {
//        return service.deleteWidget(wid);
//    }

    @DeleteMapping("api/widgets/{wid}")
    public int deleteWidget(
            @PathVariable("wid") String wid) {
        return service.deleteWidget(wid);
    }

    @PutMapping("/api/widgets/{wid}")
    public int updateWidget(
            @PathVariable("wid") String wid,
            @RequestBody Widget updatedWidget) {
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
        return service.findWidgetsForTopic(topicId);
    }
}