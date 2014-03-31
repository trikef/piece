package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.PiecenetDao;
import com.iinur.piece.data.bean.Piecenet;

public class PiecenetModel {

	public List<Piecenet> getChild(int parent_id){
		PiecenetDao pdao = new PiecenetDao();
		return pdao.getChild(parent_id);
	}

	public void registration(int project_id, int parent_id, int child_id){
		PiecenetDao pdao = new PiecenetDao();
		pdao.insert(project_id, parent_id, child_id);
	}
}
