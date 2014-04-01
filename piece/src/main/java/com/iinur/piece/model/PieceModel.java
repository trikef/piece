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
import com.iinur.piece.data.bean.PieceWithPath;

public class PieceModel {
	
	private static final Logger log = LoggerFactory
			.getLogger(PieceModel.class);

	private PieceDao pdao = null;
	
	public PieceModel(){
		this.pdao = new PieceDao();
	}

	public int registration(int project_id, int user_id, String title,
			String description, String goal, String target_date) {
		int result = 0;
		try {
			DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

			this.pdao.insert(project_id, user_id, title, description, goal, new Timestamp(
					df.parse(target_date).getTime()));
			result = this.pdao.getNewId();
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return result;
	}
	
	public Piece getSingle(int id){
		return this.pdao.getSingle(id);
	}
	
	public List<Piece> get(int project_id){
		return this.pdao.get(project_id);
	}
	
	public List<Piece> getChild(int project_id, int parent_id){
		return this.pdao.getChild(project_id, parent_id);
	}
	
	public List<Piece> getParent(int project_id, int child_id){
		return this.pdao.getParent(project_id, child_id);
	}
	
	public PieceWithPath getWithPath(int id){
		return this.pdao.getPieceWithPath(id);
	}
	
	public List<PieceWithPath> getListWithPath(int project_id, int parent_id){
		return this.pdao.getPieceWithPathList(project_id, parent_id);
	}
}
