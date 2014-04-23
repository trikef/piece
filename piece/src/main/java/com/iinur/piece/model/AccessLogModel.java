package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.AccessLogDao;
import com.iinur.piece.data.bean.AccessLog;
import com.iinur.piece.data.bean.Product;

public class AccessLogModel extends BaseModel{

	private AccessLogDao adao = null;
	
	private static final int NONE_ID = 0;
	
	public AccessLogModel(){
		this.adao = new AccessLogDao();
	}
	
	public void registration(String url, int project_id, int piece_id, int product_id, int user_id){
		adao.insert(url, project_id, piece_id, product_id, user_id);
	}
	
	public void regiUrl(String url, int user_id){
		adao.insert(url, NONE_ID, NONE_ID, NONE_ID, user_id);
	}

	public void regiProject(String url, int project_id, int user_id){
		adao.insert(url, project_id, NONE_ID, NONE_ID, user_id);
	}

	public void regiPiece(String url, int piece_id, int user_id){
		int project_id = getProjectIdFromPieceId(piece_id);
		registration(url, project_id, piece_id, NONE_ID, user_id);
	}
	
	public void regiProduct(String url, int product_id, int user_id){
		Product pd = getProduct(product_id);
		registration(url, pd.getProject_id(), pd.getPiece_id(), product_id, user_id);
	}
	
	public List<AccessLog> getListFromUserId(int user_id, int limit){
		return this.adao.getListFromUserId(user_id, limit);
	}
}
