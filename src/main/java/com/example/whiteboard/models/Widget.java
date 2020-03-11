package com.example.whiteboard.models;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.OneToMany;
import javax.persistence.Table;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;

@Entity
@Table(name="widgets")
 public class Widget {
	
	 @Id	
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
     private Integer id;
     
     private String text = "New Widget";
     private String type = "HEADING";
     
     @ManyToOne
     @JsonIgnore
     private Topic topic;
     
     private int size = 0;
     private String name = "";
     private int ordered = 0;
     private int width;
     private int height;
     private String cssClass;
     private String style;
     private String value;

     public int getSize() {
         return size;
     }

     public void setSize(int size) {
         this.size = size;
     }

     public Topic getTopic() {
         return topic;
     }

     public void setTopic(Topic tid) {
         this.topic = tid;
     }

     public String getType() {
         return type;
     }

     public void setType(String type) {
         this.type = type;
     }
     
     public int getOrdered() {
         return ordered;
     }

     public void setOrdered(int ordered) {
         this.ordered = ordered;
     }
     
     public String getName() {
         return name;
     }

     public void setName(String name) {
         this.name = name;
     }

     public Integer getId() {
         return id;
     }

     public void setId(Integer id) {
         this.id = id;
     }

     public String getText() {
         return text;
     }

     public void setText(String title) {
         this.text = title;
     }

     public Widget(Integer id, String title, String type) {
         this.id = id;
         this.text = title;
         this.type = type;
     }

     public Widget() {
     }
 }


//	WIDGET SHOWING

//package com.example.whiteboard.models;
//
// public class Widget {
//     private String id;
//     private String title;
//     private String type = "HEADING";
//     private String topicId;
//     private int size = 0;
//     private String widgetName = "";
//     private int ordered = 0;
//
//     public int getSize() {
//         return size;
//     }
//
//     public void setSize(int size) {
//         this.size = size;
//     }
//
//     public String getTopicId() {
//         return topicId;
//     }
//
//     public void setTopicId(String tid) {
//         this.topicId = tid;
//     }
//
//     public String getType() {
//         return type;
//     }
//
//     public void setType(String type) {
//         this.type = type;
//     }
//     
//     public int getOrdered() {
//         return ordered;
//     }
//
//     public void setOrdered(int ordered) {
//         this.ordered = ordered;
//     }
//     
//     public String getName() {
//         return widgetName;
//     }
//
//     public void setName(String name) {
//         this.widgetName = name;
//     }
//
//     public String getId() {
//         return id;
//     }
//
//     public void setId(String id) {
//         this.id = id;
//     }
//
//     public String getTitle() {
//         return title;
//     }
//
//     public void setTitle(String title) {
//         this.title = title;
//     }
//
//     public Widget(String id, String title, String type) {
//         this.id = id;
//         this.title = title;
//         this.type = type;
//     }
//
//     public Widget() {
//     }
// }