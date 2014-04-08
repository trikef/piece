package com.iinur.piece.model;

import com.iinur.piece.data.bean.Product;


public class BaseModel {

	public int getProjectIdFromPieceId(int piece_id){
		PieceModel pcmodel = new PieceModel();
		return pcmodel.getSingle(piece_id).getProject_id();
	}
	
	public int getProjectIdFromProductId(int product_id){
		return getProduct(product_id).getProject_id();
	}
	
	public Product getProduct(int product_id){
		ProductModel pdmodel = new ProductModel();
		return pdmodel.get(product_id);
	}
}
