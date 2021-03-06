package com.iinur.piece.model;

import java.text.ParseException;
import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.iinur.core.util.PermissionUtils;
import com.iinur.core.util.TimestampUtils;
import com.iinur.piece.data.PieceDao;
import com.iinur.piece.data.bean.GroupMember;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Project;

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
	
	public boolean update(int piece_id, String title,
			String description, String goal, String target_date) {
		boolean result = false;
		try {
			this.pdao.update(piece_id, title, description, goal, TimestampUtils.parseDate(target_date));
			result = true;
		} catch (ParseException e) {
			log.error(e.getMessage());
		}
		return result;
	}

	public void updateStatus(int piece_id, int status_id){
		this.pdao.updateStatus(piece_id, status_id);
	}
	
	public void updateDisplay(int piece_id, boolean display){
		this.pdao.updateDisplay(piece_id, display);
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
	
	public List<PieceWithPath> serach(String key){
		return this.pdao.search(key);
	}
	
	public List<PieceWithPath> searchFromTagId(int tag_id){
		return this.pdao.searchFromTagId(tag_id);
	}

	public List<PieceWithPath> searchFromTagName(String tag_name, int limit){
		return this.pdao.searchFromTagName(tag_name, limit);
	}

	/**
	 * 所属するプロジェクトで一般公開なら見えるようにする。
	 * 
	 * @param piece_id
	 * @param user_id
	 * @param action
	 * @return
	 */
	public boolean permission(int piece_id, int user_id, int action){
		Piece p = this.pdao.getSingle(piece_id);
		ProjectModel pjmodel = new ProjectModel();
		Project pj = pjmodel.getSingle(p.getProject_id());
		if(PermissionUtils.check(pj.getPermission(), PermissionUtils.OTHER, PermissionUtils.READ)){
			return true;
		}
		
		int permission = p.getPermission();
		String group = getGroup(piece_id, user_id);
		return PermissionUtils.check(permission, group, action);
	}

	public boolean permissionExecute(int piece_id, int user_id){
		return permission(piece_id, user_id, PermissionUtils.EXECUTE);
	}

	public String getGroup(int piece_id, int user_id){
		//TODO performance
		Piece p = this.pdao.getSingle(piece_id);
		ProjectModel prmodel = new ProjectModel();
		String prg = prmodel.getGroup(p.getProject_id(), user_id);

		if(!prg.equals(PermissionUtils.OTHER)){//check project group
			return prg;
		}

		if(p.getUser_id()==user_id){
			return PermissionUtils.OWNER;
		} else {
			GroupMemberModel gm = new GroupMemberModel();
			GroupMember g = gm.get(user_id, p.getProject_id(), piece_id);
			if(g != null){
				return PermissionUtils.GROUP;
			}
		}
		return PermissionUtils.OTHER;
	}

	public void updatePermission(int piece_id, String group, int action){
		if(group.equals(PermissionUtils.OTHER)){
			this.pdao.updatePermissionOther(piece_id, action);
		}
	}
}
