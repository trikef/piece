package com.iinur.piece.model;

import com.iinur.piece.data.UserinfoDao;
import com.iinur.piece.data.bean.Userinfo;

public class UserinfoModel {

	public boolean registration(String name){
		boolean flag = false;
		UserinfoDao udao = new UserinfoDao();
		Userinfo u = udao.get(name);
		if(u == null){
			udao.insert(name);
			flag = true;
		}
		return flag;
	}
	
	public Userinfo get(String name){
		UserinfoDao udao = new UserinfoDao();
		return udao.get(name);
	}
}
