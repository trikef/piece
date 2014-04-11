package com.iinur.piece.data.bean;

import java.sql.Array;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PieceWithPath extends Piece {

	private int parent_id;
	private Array path;
	private Array path_title;
	private int lv;
	private int child_count;
	private Array tags;
	public int getParent_id() {
		return parent_id;
	}
	public void setParent_id(int parent_id) {
		this.parent_id = parent_id;
	}

	public Array getPath() throws SQLException {
		return path;
	}
	public void setPath(Array path) {
		this.path = path;
	}
	public Array getPath_title() {
		return path_title;
	}
	public String[] getPath_title_array() throws SQLException {
		Object o = path_title.getArray();
		//System.out.println("**************"+o.getClass().getCanonicalName());
		String[] array = (String[])o;
		//return path_title;
		return array;
	}
	public List<PiecePath> getPiece_path() throws SQLException {
		String[] titleArray = (String[])path_title.getArray();
		Integer[] pathArray = (Integer[])path.getArray();
		List<PiecePath> list = new ArrayList<PiecePath>();
		for (int i=0; i < pathArray.length; i++) {
			PiecePath pp = new PiecePath();
			pp.setId(pathArray[i].intValue());
			pp.setTitle(titleArray[i]);
			list.add(pp);
		}
		return list;
	}

	public void setPath_title(Array path_title) {
		this.path_title = path_title;
	}
	public int getLv() {
		return lv;
	}
	public void setLv(int lv) {
		this.lv = lv;
	}
	public int getChild_count() {
		return child_count;
	}
	public void setChild_count(int child_count) {
		this.child_count = child_count;
	}

	public Array getTags() {
		return tags;
	}

	public String[] getTags_sa() throws SQLException {
		String[] ts = (String[])tags.getArray();
		return ts;
	}
	public void setTags(Array tags) {
		this.tags = tags;
	}
	
}