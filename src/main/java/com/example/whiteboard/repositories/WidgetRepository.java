package com.example.whiteboard.repositories;
import java.util.List;

import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.CrudRepository;
import org.springframework.data.repository.query.Param;

import com.example.whiteboard.models.Widget;

public interface WidgetRepository extends CrudRepository<Widget, Integer> {

	@Query("SELECT widget FROM Widget widget WHERE widget.topicId=:tid")
	public List<Widget> findWidgetsForTopic(
			@Param("tid") String topicId);
	
	@Query("SELECT widget FROM Widget widget WHERE widget.id=:wid")
	public Widget findWidgetById(
			@Param("wid")Integer wid);
	
	@Query("SELECT widget FROM Widget widget")
	public List<Widget> findAllWidgets();
}
