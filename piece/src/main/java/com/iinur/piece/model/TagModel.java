package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.TagDao;
import com.iinur.piece.data.bean.Tag;

public class TagModel {

	private TagDao tdao = null;

	public TagModel(){
		this.tdao = new TagDao();
	}

	public void registration(int user_id, String name, String description){
		this.tdao.insert(user_id, name, description);
	}
	
	public List<Tag> getAll(){
		return this.tdao.getAll();
	}
	
	public Tag get(int id){
		return this.tdao.get(id);
	}
	
	public Tag getNew(int user_id){
		return this.tdao.getNew(user_id);
	}
	
	public List<Tag> getTagsWithSelectedPiece(int piece_id){
		return this.tdao.getTagsWithSelectedPiece(piece_id);
	}
	
	public static boolean DISPLAY_ON = true;
	public static boolean DISPLAY_OFF = false;
	
	public void updateDisplay(int id, boolean display){
		tdao.updateDisplay(id, display);
	}
}
