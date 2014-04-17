package com.iinur.piece.action;

import java.util.List;

import org.apache.struts2.convention.annotation.Action;
import org.apache.struts2.convention.annotation.Result;

import com.iinur.core.util.PermissionUtils;
import com.iinur.piece.data.bean.Chat;
import com.iinur.piece.data.bean.GroupMember;
import com.iinur.piece.data.bean.Piece;
import com.iinur.piece.data.bean.PieceWithPath;
import com.iinur.piece.data.bean.Product;
import com.iinur.piece.data.bean.Tag;
import com.iinur.piece.model.ChatModel;
import com.iinur.piece.model.GroupMemberModel;
import com.iinur.piece.model.PieceModel;
import com.iinur.piece.model.PieceTagModel;
import com.iinur.piece.model.ProductModel;
import com.iinur.piece.model.TagModel;

@Action(value="/piece/{id:.+}",
results={@Result(name="success", location="piece.jsp"),
		@Result(name="forbidden", type="httpheader", params={"status", "403", "errorMessage", "Forbidden"})
})
public class PieceAction extends BaseAction {

	public Piece p;
	public PieceWithPath piwp;
	public int id;
	public List<PieceWithPath> piwps;
	public List<Product> ps;
	
	public List<Chat> cs;
	public List<Chat> cps;
	
	public List<Tag> ts;
	public List<Tag> pts;

	public GroupMember g;

	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}
		PieceModel pmodel = new PieceModel();
		this.p = pmodel.getSingle(id);
		this.piwp = pmodel.getWithPath(id);
		this.piwps = pmodel.getListWithPath(this.p.getProject_id(), id);
		
		ProductModel pdmodel = new ProductModel();
		this.ps = pdmodel.getList(id);

		ChatModel cmodel = new ChatModel();
		this.cs = cmodel.getList(p.getProject_id(),id);
		this.cps = cmodel.getPinList(p.getProject_id(),id);
		
		TagModel tmodel = new TagModel();
		this.ts = tmodel.getTagsWithSelectedPiece(id);

		PieceTagModel ptmodel = new PieceTagModel();
		this.pts = ptmodel.getTags(id);

		GroupMemberModel gmodel = new GroupMemberModel();
		this.g = gmodel.get(uid, piwp.getProject_id(), 0);//TODO check piece_id

		if(!pmodel.permission(id, uid, PermissionUtils.READ)){
			return FORBIDDEN;
		}

		this.acsmodel.regiPiece(this.servletPath, id, this.uid);//log
	
		return SUCCESS;
	}
}
