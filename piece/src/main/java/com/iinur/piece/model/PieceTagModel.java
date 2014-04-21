package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.PieceTagDao;
import com.iinur.piece.data.bean.PieceTag;
import com.iinur.piece.data.bean.Tag;

public class PieceTagModel {

	private PieceTagDao ptdao = null;
	
	public PieceTagModel(){
		this.ptdao = new PieceTagDao();
	}
	
	public void registration(int user_id, int piece_id, int tag_id){
		this.ptdao.insert(user_id, piece_id, tag_id);
	}
	
	public void delete(int id){
		this.ptdao.delete(id);
	}
	
	public Tag getTag(int id){
		return this.ptdao.getTag(id);
	}

	public Tag getTag(int piece_id, int tag_id){
		return this.ptdao.getTagFromTagId(piece_id, tag_id);
	}

	public List<Tag> getTags(int piece_id){
		return this.ptdao.getTags(piece_id);
	}
	
	public List<Tag> getAllTagsWithPieceCount(){
		return this.ptdao.getAllTagsWithPieceCount();
	}
	
	public PieceTag getNew(int user_id, int piece_id, int tag_id){
		return this.ptdao.getNew(user_id, piece_id, tag_id);
	}
	
	public Tag getNewTag(int user_id, int piece_id, int tag_id){
		return this.ptdao.getNewTag(user_id, piece_id, tag_id);
	}
	
	public Tag getTagFromName(String name){
		return this.ptdao.getTagFromName(name);
	}
}
