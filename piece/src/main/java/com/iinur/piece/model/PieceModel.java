package com.iinur.piece.model;

import java.sql.Timestamp;
import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.piece.data.PieceDao;
import com.iinur.piece.data.bean.Piece;

public class PieceModel {
	
	private static final Logger log = LoggerFactory
			.getLogger(PieceModel.class);

	public int registration(int project_id, int user_id, String title,
			String description, String goal, String target_date) {
		int result = 0;
		PieceDao pdao = new PieceDao();
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			pdao.insert(project_id, user_id, title, description, goal, new Timestamp(
					df.parse(target_date).getTime()));
			result = pdao.getNewId();
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return result;
	}
	
	public Piece getSingle(int id){
		PieceDao pdao = new PieceDao();
		return pdao.getSingle(id);
	}
	
	public List<Piece> get(int project_id){
		PieceDao pdao = new PieceDao();
		return pdao.get(project_id);
	}
	
	public List<Piece> getChild(int project_id, int parent_id){
		PieceDao pdao = new PieceDao();
		return pdao.getChild(project_id, parent_id);
	}
	
	public List<Piece> getParent(int project_id, int child_id){
		PieceDao pdao = new PieceDao();
		return pdao.getParent(project_id, child_id);
	}
}
