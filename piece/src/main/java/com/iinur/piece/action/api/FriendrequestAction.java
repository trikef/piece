package com.iinur.piece.action.api;

import org.apache.struts2.convention.annotation.ParentPackage;
import org.apache.struts2.convention.annotation.Result;
import org.apache.struts2.convention.annotation.Results;

import com.iinur.piece.action.BaseAction;
import com.iinur.piece.data.FriendDao;
import com.iinur.piece.data.bean.Friend;
import com.iinur.piece.model.FriendModel;

@ParentPackage("json-default")

@Results({
@Result(name="success" , type="json" ,
     params={"root","f", "ignoreHierarchy","false"}),
})
public class FriendrequestAction extends BaseAction {

	public Friend f = null;
	
	public int fi;//friend_user_id
	public int pri;//project_id
	public int pci;//piece_id
	public int ci;//chat_id
	
	public int si;//status_id
	
	public String execute(){
		String result = before();
		if(result.equals(INPUT)){
			return INPUT;
		}

		if(si>0 && fi>0 && uid!=fi){
			FriendModel fmodel = new FriendModel();
			f = fmodel.get(uid, fi);
			Friend rf = fmodel.get(fi, uid);//reverse friend
			
			switch (si) {
			case FriendDao.STATUS_REQUEST:
				if(f==null && rf==null){//new request
					fmodel.registration(uid, fi, si);
					f = fmodel.get(uid, fi);
					this.atlmodel.regiRequestFriend(servletPath, uid, pri, pci, ci, fi);
				} else if(f==null && rf != null){
					if(rf.getStatus_id() == FriendDao.STATUS_BLOCK){//throw
						f = new Friend();
						f.setFriend_status_id(rf.getStatus_id());
						
					} else if(rf.getStatus_id() == FriendDao.STATUS_REQUEST
							|| rf.getStatus_id() == FriendDao.STATUS_PERMISSION
							){//permission
						fmodel.registration(uid, fi, FriendDao.STATUS_PERMISSION);
						fmodel.updateStatusId(fi, uid, FriendDao.STATUS_PERMISSION);//reverse friend
						f = fmodel.get(uid, fi);
						this.atlmodel.regiPermissionFriend(servletPath, uid, fi);
					}
					
				} else if(f!=null && rf!=null){
					if(rf.getStatus_id() == FriendDao.STATUS_BLOCK){//throw
						fmodel.updateStatusId(uid, fi, FriendDao.STATUS_REQUEST);
						f = fmodel.get(uid, fi);
						f.setFriend_status_id(rf.getStatus_id());
						
					} else if(rf.getStatus_id() == FriendDao.STATUS_REQUEST
							|| rf.getStatus_id() == FriendDao.STATUS_PERMISSION
							){//permission
						fmodel.updateStatusId(uid, fi, FriendDao.STATUS_PERMISSION);
						fmodel.updateStatusId(fi, uid, FriendDao.STATUS_PERMISSION);//reverse friend
						f = fmodel.get(uid, fi);
						rf = fmodel.get(fi,uid);
						f.setFriend_status_id(rf.getStatus_id());
						this.atlmodel.regiPermissionFriend(servletPath, uid, fi);
					}
				} else if(f.getStatus_id()!=FriendDao.STATUS_REQUEST){
					fmodel.updateStatusId(uid, fi, FriendDao.STATUS_REQUEST);
					f = fmodel.get(uid, fi);
					this.atlmodel.regiRequestFriend(servletPath, uid, pri, pci, ci, fi);
				}
				
				break;

			case FriendDao.STATUS_PERMISSION:
				if(f==null && rf==null){//new request
					fmodel.registration(uid, fi, FriendDao.STATUS_REQUEST);//new request
					f = fmodel.get(uid, fi);
					this.atlmodel.regiRequestFriend(servletPath, uid, pri, pci, ci, fi);
				} else if(f==null && rf != null){
					if(rf.getStatus_id() == FriendDao.STATUS_BLOCK){//throw
						f = new Friend();
						f.setFriend_status_id(rf.getStatus_id());
						
					} else if(rf.getStatus_id() == FriendDao.STATUS_REQUEST
							|| rf.getStatus_id() == FriendDao.STATUS_PERMISSION
							){//permission
						fmodel.registration(uid, fi, FriendDao.STATUS_PERMISSION);
						fmodel.updateStatusId(fi, uid, FriendDao.STATUS_PERMISSION);//reverse friend
						f = fmodel.get(uid, fi);
						this.atlmodel.regiPermissionFriend(servletPath, uid, fi);
					}
				} else if(f!=null && rf!=null){
					if(rf.getStatus_id() == FriendDao.STATUS_BLOCK){//throw
						fmodel.updateStatusId(uid, fi, FriendDao.STATUS_REQUEST);
						f = fmodel.get(uid, fi);
						f.setFriend_status_id(rf.getStatus_id());
						
					} else if(rf.getStatus_id() == FriendDao.STATUS_REQUEST
							|| rf.getStatus_id() == FriendDao.STATUS_PERMISSION
							){//permission
						fmodel.updateStatusId(uid, fi, FriendDao.STATUS_PERMISSION);
						fmodel.updateStatusId(fi, uid, FriendDao.STATUS_PERMISSION);//reverse friend
						f = fmodel.get(uid, fi);
						rf = fmodel.get(fi,uid);
						f.setFriend_status_id(rf.getStatus_id());
						this.atlmodel.regiPermissionFriend(servletPath, uid, fi);
					}
				} else if(f.getStatus_id()!=FriendDao.STATUS_REQUEST){
					fmodel.updateStatusId(uid, fi, FriendDao.STATUS_REQUEST);//update request
					f = fmodel.get(uid, fi);
					this.atlmodel.regiRequestFriend(servletPath, uid, pri, pci, ci, fi);
				}
				break;

			case FriendDao.STATUS_BLOCK:
				if(f==null){
					fmodel.registration(uid, fi, FriendDao.STATUS_BLOCK);
				} else {
					fmodel.updateStatusId(uid, fi, FriendDao.STATUS_BLOCK);
				}
				f = fmodel.get(uid, fi);
				this.atlmodel.regiBlockFriend(servletPath, uid, fi);
				break;

			default:
				break;
			}
		}
		return SUCCESS;
	}
}
