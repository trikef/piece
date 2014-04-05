package com.iinur.piece.model;

import java.util.List;

import com.iinur.piece.data.ProductChatDao;
import com.iinur.piece.data.bean.ProductChat;

public class ProductChatModel {

	private ProductChatDao cdao = null;
	
	public ProductChatModel(){
		this.cdao = new ProductChatDao();
	}

	public void registration(int product_id, int user_id, String text, int star){
		this.cdao.insert(product_id, user_id, text, star);
	}
	
	public void updatePriority(int id, int priority){
		this.cdao.updatePriority(id, priority);
	}
	
	public void updateText(int id, String text){
		this.cdao.updateText(id, text);
	}
	
	public ProductChat get(int id){
		return this.cdao.get(id);
	}

	public ProductChat getNew(int product_id, int user_id){
		return this.cdao.getNew(product_id, user_id);
	}
	
	public List<ProductChat> getList(int product_id){
		return this.cdao.getList(product_id);
	}
}
