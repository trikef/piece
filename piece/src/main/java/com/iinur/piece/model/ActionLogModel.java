package com.iinur.piece.model;

import com.iinur.piece.data.ActionLogDao;
import com.iinur.piece.data.bean.Product;

public class ActionLogModel extends BaseModel{

	private ActionLogDao atdao = null;

	private static final int NONE_ID = 0;

	public static final String ACTION_NAME_NEW_PROJECT = "NEW PROJECT";
	public static final String ACTION_NAME_NEW_CHAT = "NEW CHAT";
	public static final String ACTION_NAME_NEW_PIECE = "NEW PIECE";
	public static final String ACTION_NAME_NEW_PRODUCT = "NEW PRODUCT";
	public static final String ACTION_NAME_NEW_PRODUCT_CHAT = "NEW PRODUCT CHAT";
	public static final String ACTION_NAME_NEW_TAG = "NEW TAG";
	public static final String ACTION_NAME_NEW_PIECE_TAG = "NEW PIECE TAG";
	
	public static final String ACTION_NAME_UPDATE_PROJECT = "UPDATE PROJECT";
	public static final String ACTION_NAME_UPDATE_PIECE = "UPDATE PIECE";
	
	public static final String ACTION_NAME_DEL_PROJECT = "DELETE PROJECT";
	public static final String ACTION_NAME_DEL_PIECE = "DELETE PIECE";
	public static final String ACTION_NAME_DEL_TAG = "DELETE TAG";
	public static final String ACTION_NAME_DEL_PIECE_TAG = "DELETE PIECE TAG";

	public static final String ACTION_NAME_COMP_PIECE = "COMPLETE PIECE";
	public static final String ACTION_NAME_INCOMP_PIECE = "INCOMPLETE PIECE";
	
	public static final String ACTION_NAME_PIN_CHAT = "PIN CHAT";
	
	public static final String ACTION_NAME_PUBLIC_PROJECT = "PUBLIC PROJECT";
	public static final String ACTION_NAME_PRIVATE_PROJECT = "PRIVATE PROJECT";
	
	public static final String ACTION_NAME_GOOD_CHAT_VALUE = "GOOD CHAT VALUE";
	public static final String ACTION_NAME_BAD_CHAT_VALUE = "BAD CHAT VALUE";

	public static final String ACTION_NAME_DEL_GOOD_CHAT_VALUE = "DEL GOOD CHAT VALUE";
	public static final String ACTION_NAME_DEL_BAD_CHAT_VALUE = "DEL BAD CHAT VALUE";

	public ActionLogModel() {
		this.atdao = new ActionLogDao();
	}

	public void registration(String url, String action_name, int user_id,
			int project_id, int piece_id, int product_id, int chat_id,
			int product_chat_id) {
		this.atdao.insert(url, action_name, user_id, project_id, piece_id,
				product_id, chat_id, product_chat_id, NONE_ID);
	}
	
	public void regiNewProject(String url, int user_id, int project_id){
		this.atdao.insert(url, ACTION_NAME_NEW_PROJECT, user_id, project_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiNewChat(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_NEW_CHAT, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
	
	public void regiNewPiece(String url, int user_id, int piece_id){
		int project_id = getProjectIdFromPieceId(piece_id);
		this.atdao.insert(url, ACTION_NAME_NEW_PIECE, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiNewProduct(String url, int user_id, int product_id){
		Product pd = getProduct(product_id);
		this.atdao.insert(url, ACTION_NAME_NEW_PRODUCT, user_id, pd.getProject_id(), pd.getPiece_id(), product_id, NONE_ID, NONE_ID, NONE_ID);
	}

	public void regiNewProductChat(String url, int user_id, int product_id, int product_chat_id){
		Product pd = getProduct(product_id);
		this.atdao.insert(url, ACTION_NAME_NEW_PRODUCT_CHAT, user_id, pd.getProject_id(), pd.getPiece_id(), product_id, NONE_ID, product_chat_id, NONE_ID);
	}

	public void regiNewTag(String url, int user_id, int tag_id){
		this.atdao.insert(url, ACTION_NAME_NEW_TAG, user_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID, tag_id);
	}

	public void regiNewPieceTag(String url, int user_id, int project_id, int piece_id, int tag_id){
		this.atdao.insert(url, ACTION_NAME_NEW_PIECE_TAG, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, tag_id);
	}

	public void regiUpdateProject(String url, int user_id, int project_id){
		this.atdao.insert(url, ACTION_NAME_UPDATE_PROJECT, user_id, project_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiUpdatePiece(String url, int user_id, int project_id, int piece_id){
		this.atdao.insert(url, ACTION_NAME_UPDATE_PIECE, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}

	public void regiDelProject(String url, int user_id, int project_id){
		this.atdao.insert(url, ACTION_NAME_DEL_PROJECT, user_id, project_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiDelPiece(String url, int user_id, int piece_id){
		int project_id = getProjectIdFromPieceId(piece_id);
		this.atdao.insert(url, ACTION_NAME_DEL_PIECE, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiDelTag(String url, int user_id, int tag_id){
		this.atdao.insert(url, ACTION_NAME_DEL_TAG, user_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID, tag_id);
	}

	public void regiDelPieceTag(String url, int user_id, int project_id, int piece_id, int tag_id){
		this.atdao.insert(url, ACTION_NAME_DEL_PIECE_TAG, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, tag_id);
	}
	
	public void regiCompPiece(String url, int user_id, int piece_id){
		int project_id = getProjectIdFromPieceId(piece_id);
		this.atdao.insert(url, ACTION_NAME_COMP_PIECE, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}

	public void regiIncompPiece(String url, int user_id, int piece_id){
		int project_id = getProjectIdFromPieceId(piece_id);
		this.atdao.insert(url, ACTION_NAME_INCOMP_PIECE, user_id, project_id, piece_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiPinChat(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_PIN_CHAT, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
	
	public void regiPublicProject(String url, int user_id, int project_id){
		this.atdao.insert(url, ACTION_NAME_PUBLIC_PROJECT, user_id, project_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiPrivateProject(String url, int user_id, int project_id){
		this.atdao.insert(url, ACTION_NAME_PRIVATE_PROJECT, user_id, project_id, NONE_ID, NONE_ID, NONE_ID, NONE_ID, NONE_ID);
	}
	
	public void regiGoodChatValue(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_GOOD_CHAT_VALUE, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
	
	public void regiBadChatValue(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_BAD_CHAT_VALUE, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
	
	public void regiDelGoodChatValue(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_DEL_GOOD_CHAT_VALUE, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
	
	public void regiDelBadChatValue(String url, int user_id, int project_id, int piece_id, int chat_id){
		this.atdao.insert(url, ACTION_NAME_DEL_BAD_CHAT_VALUE, user_id, project_id, piece_id, NONE_ID, chat_id, NONE_ID, NONE_ID);
	}
}
