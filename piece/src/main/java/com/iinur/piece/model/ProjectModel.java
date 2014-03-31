package com.iinur.piece.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.piece.data.ProjectDao;
import com.iinur.piece.data.bean.Project;

public class ProjectModel {

	private static final Logger log = LoggerFactory
			.getLogger(ProjectModel.class);

	public Project getSingle(int id){
		ProjectDao pdao = new ProjectDao();
		return pdao.getSingle(id);
	}
	
	public List<Project> get(int user_id){
		ProjectDao pdao = new ProjectDao();
		return pdao.get(user_id);
	}
	
	public boolean registration(int user_id, String title, String description,
			String goal, String target_date) {

		boolean result = true;
		ProjectDao pdao = new ProjectDao();
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");
			pdao.insert(user_id, title, description, goal, new Timestamp(
					df.parse(target_date).getTime()));
		} catch (ParseException e) {
			log.error(e.getMessage());
			result = false;
		}
		return result;
	}
}
