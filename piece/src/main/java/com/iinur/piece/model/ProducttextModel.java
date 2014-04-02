package com.iinur.piece.model;

import com.iinur.piece.data.ProductTextDao;
import com.iinur.piece.data.bean.Product;
import com.iinur.piece.data.bean.ProductText;

public class ProducttextModel {

	//INSERT INTO product_type (id,name) VALUES (1,'text');
	private ProductTextDao ptdao = null;
	private ProductModel pmodel = null;

	public ProducttextModel(){
		this.ptdao = new ProductTextDao();
		this.pmodel = new ProductModel();
	}

	public void registration(int product_id, String data, String comment){
		this.ptdao.insert(product_id, data, comment);
	}

	private static String NULL_VALUE = "";

	public ProductText registrationAll(int piece_id, int user_id, int status, String data, String comment){
		this.pmodel.registration(piece_id, user_id, NULL_VALUE, status);
		Product p = this.pmodel.getNew(piece_id, user_id);
		registration(p.getId(), data, comment);
		ProductText pt = get(p.getId());
		this.pmodel.update(pt.getId(), pt.getPiece_id(), String.valueOf(pt.getText_id()), pt.getStatus());
		return get(p.getId());
	}

	public ProductText get(int product_id){
		return this.ptdao.getWithProductInfo(product_id);
	}
}
