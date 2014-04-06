package com.iinur.piece.model;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.util.PermissionUtils;
import com.iinur.core.util.TimestampUtils;
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
			this.pdao.insert(project_id, user_id, title, description, goal, TimestampUtils.parseDate(target_date));
			result = this.pdao.getNewId();
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return result;
	}
	
	public void update(int piece_id, String title,
			String description, String goal, String target_date) {
		try {
			this.pdao.update(piece_id, title, description, goal, TimestampUtils.parseDate(target_date));
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
	}

	public void updateStatus(int piece_id, int status_id){
		this.pdao.updateStatus(piece_id, status_id);
	}
	
	public Piece getSingle(int id){
		return this.pdao.getSingle(id);
	}
	
	public List<Piece> get(int project_id){
		return this.pdao.get(project_id);
	}
	
	public List<PieceWithPath> getChild(int project_id, int parent_id){
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
	
	public boolean permissionExecute(int piece_id, int user_id){
		Piece p = this.pdao.getSingle(piece_id);
		int permission = p.getPermission();
		String group = getGroup(piece_id, user_id);
		return PermissionUtils.check(permission, group, PermissionUtils.EXECUTE);
	}

	public String getGroup(int piece_id, int user_id){
		//TODO performance
		Piece p = this.pdao.getSingle(piece_id);
		if(p.getUser_id()==user_id){
			return PermissionUtils.OWNER;
		}
		return PermissionUtils.OTHER;
	}
}
