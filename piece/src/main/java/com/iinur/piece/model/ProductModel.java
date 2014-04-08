package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.ProductDao;
import com.iinur.piece.data.bean.Product;

public class ProductModel {

	private ProductDao pdao = null;

	public ProductModel(){
		this.pdao = new ProductDao();
	}
	
	public void registration(int piece_id, int user_id, String name, int status){
		this.pdao.insert(piece_id, user_id, name, status);
	}

	public void update(int product_id, int piece_id, String name, int status){
		this.pdao.update(product_id, piece_id, name, status);
	}

	public Product get(int product_id){
		return this.pdao.get(product_id);
	}
	
	public Product getNew(int piece_id, int user_id){
		return this.pdao.getNew(piece_id, user_id);
	}

	public List<Product> getList(int piece_id){
		return this.pdao.getList(piece_id);
	}
}
