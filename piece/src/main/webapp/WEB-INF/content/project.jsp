<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><s:property value="p.title"/></title>
	<link rel="stylesheet" href="/css/main.css" />
	<link rel="stylesheet" href="/css/font-awesome.min.css">
<!-- 	<link rel="stylesheet" href="/css/jquery-ui.css"> -->
	<link rel="stylesheet" href="/css/jquery.mobile-1.4.2.css" />
<!--<link rel="shortcut icon" href="../favicon.ico"> -->
	<script src="/js/jquery-1.11.0.js"></script>
<!-- 	<script src="/js/jquery-ui-1.10.2.custom.js"></script> -->
	<script src="/js/jquery.mobile-1.4.2.js"></script>
	<script src="/js/main.js"></script>
</head>
<body>
<div data-role="page" id="projectpage">
	<div data-role="tabs">
		<div data-role="header">
			<h1><s:property value="p.title"/></h1>
			<a href="#nav-panel-project-info" data-icon="info" data-iconpos="notext">Info</a>
		</div><!-- /header -->
	    <div data-role="navbar">
	        <ul>
	          <li><a class="ui-btn-active" href="#project-chat" data-theme="a" data-ajax="false">Chat</a></li>
	          <li><a href="#project-pin" data-theme="a" data-ajax="false">Pin</a></li>
	          <li><a href="#project-task" data-theme="a" data-ajax="false">Task</a></li>
	        </ul>
	    </div>
	    <div id="project-chat" class="ui-content">
		    <div id="chat-collapsibleset" class="btn-min-space" data-role="collapsibleset" data-theme="a" data-content-theme="b">
			    <div data-role="collapsible">
			    <h2>チャット追加</h2>
			        <ul data-role="listview" data-theme="a" data-divider-theme="b">
			            <li>
							<div class="ui-field-contain">
								<textarea cols="40" rows="10" name="g" id="piece-text-input" placeholder="ここにメッセージ内容を入力"></textarea>
							</div>
							<div class="ui-field-contain">
								<a href="#" onClick="Chat.add()" class="ui-btn ui-corner-all">送信</a>
							</div>
			            </li>
			        </ul>
			    </div>
			</div>
		    <ul data-role="listview" class="chat-list" >
			<s:iterator value="cs">
			<li class="ui-li-chat">
				<div class="ui-li-chat-header">
					<p class="ui-li-no">NO:<s:property value="id"/></p>
					<s:if test="user_id==uid">
					<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
					</s:if>
					<s:else>
					<p class="ui-li-name"><strong><a href="#popup-menu-<s:property value="id"/>" data-rel="popup"><s:property value="name"/></a></strong></p>
					<div data-role="popup" id="popup-menu-<s:property value="id"/>" data-theme="b">
				        <ul data-role="listview" data-inset="true" style="min-width:210px;">
				            <li data-role="list-divider"><s:property value="name"/>さんへのアクション</li>
				            <s:if test="friend_status_id!=1">
				            <li><a onClick="User.friend.request(<s:property value="user_id"/>,2,<s:property value="p.id"/>,0,<s:property value="id"/>,'#popup-menu-<s:property value="id"/>');">友達申請</a></li>
				            </s:if>
	<%-- TODO block action
					            <s:if test="friend_status_id!=3">
					            <li><a onClick="User.friend.request(<s:property value="user_id"/>,3,<s:property value="p.id"/>,0,<s:property value="id"/>);">ブロック</a></li>
					            </s:if>
					            <li><a href="#">メッセージ</a></li>
	--%>
				        </ul>
					</div>
					</s:else>
				</div>
				<pre class="ui-li-text"><s:property escape="false" value="text_link"/></pre>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
				<p class="ui-li-action">
					<s:if test="%{priority>0}">
					<span id="pin<s:property value="id" />" class="on">
					<a onClick="Chat.pin(<s:property value="id"/>,0)">
						<i class="fa fa-thumb-tack"></i>
					</a>
					</span>
					</s:if>
					<s:else>
					<span id="pin<s:property value="id" />" class="off">
					<a onClick="Chat.pin(<s:property value="id"/>,<s:property value="id"/>)">
						<i class="fa fa-thumb-tack"></i>
					</a>
					</span>
					</s:else>
					<a onClick="Chat.count(<s:property value="id" />,'<s:property value="uid" />',1,0,'#good<s:property value="id"/>')" class=""><i class="fa fa-thumbs-o-up"></i><span id="good<s:property value="id"/>"><s:property value="good"/></span></a>
					<a onClick="Chat.count(<s:property value="id" />,'<s:property value="uid" />',0,1,'#bad<s:property value="id"/>')" class=""><i class="fa fa-thumbs-o-down"></i><span id="bad<s:property value="id"/>"><s:property value="bad"/></span></a>
				</p>
			</li>
			</s:iterator>
			</ul>
	    </div>
	    <div id="project-pin" class="ui-content">
	    	<ul data-role="listview" class="pin-list" >
			<s:iterator value="cps">
			<li id="pin_chat_<s:property value="id"/>">
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
				<pre class="ui-li-text"><s:property escape="false" value="text_link"/></pre>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
			</ul>
		</div>
		<s:set name="piece_path_before" value="null"/>
		<s:set name="parent_id_before"/>
	    <div id="project-task" class="ui-content">
	    	<div id="piece-name-input" class="btn-min-space">
				<p><a onClick="Piece.add(0)" data-icon="false" class="piece-name-add-btn"><i class="fa fa-plus-circle"></i></a></p>
		    	<input id="piece-title-input" type="text" data-clear-btn="true" name="piece-title-input" value="" placeholder="タスク名入力">
		    	<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="p.id" />" />
				<input type="hidden" name="pci" id="piece-pcid-input" value="0" />
				<input type="hidden" name="ui" id="piece-uid-input" value="<s:property value="uid" />" />
				<input type="hidden" id="piece-description-input" />
				<input type="hidden" id="piece-goal-input" />
				<input type="hidden" id="piece-targetdate-input" />
			</div>
	        <ul data-role="listview" class="piece-list" >
			<s:if test="%{piwps.size()>0}">
			<s:set name="piece_lv" value="1"/>
			<s:iterator value="piwps">
	 		<s:if test="%{#piece_path_before!=null&&#parent_id_before!=null&&parent_id!=#parent_id_before}">
				<s:iterator status="stat" value="piece_path">
				<s:if test="#stat.index>0">
				<s:set name="piece_lv" value="#stat.index+1"/>
				<s:if test="#piece_path_before.size()-1<#stat.index||piece_path.get(#stat.index).getTitle()!=#piece_path_before.get(#stat.index).getTitle()">
				<li class="ui-li-piece">
					<span style="padding-left:<s:property value="%{(#stat.index-1)*20}"/>px;" class="ui-li-piece-collapse" id="parent<s:property value="id" />">
					<a onClick=""><i class="fa fa-chevron-down"></i></a>
					</span>
					<a style="padding-left:<s:property value="%{#stat.index*20}"/>px;" data-ajax="false" href="/piece/<s:property value="id" />">
					<p class="ul-li-piece-title"><s:property value="title"/>
					</p>
					</a>
				</li>
				</s:if>
				</s:if>
				</s:iterator>
			</s:if>
			<s:elseif test="%{#piece_path_before==null}">
				<s:iterator status="stat" value="piece_path">
				<s:if test="#stat.index>0">
				<s:set name="piece_lv" value="#stat.index+1"/>
				<li class="ui-li-piece">
					<span style="padding-left:<s:property value="%{(#stat.index-1)*20}"/>px;" class="ui-li-piece-collapse" id="parent<s:property value="id" />">
					<a onClick=""><i class="fa fa-chevron-down"></i></a>
					</span>
					<a style="padding-left:<s:property value="%{#stat.index*20}"/>px;" data-ajax="false" href="/piece/<s:property value="id" />">
					<p class="ul-li-piece-title"><s:property value="title"/>
					</p>
					</a>
				</li>
				</s:if>
				</s:iterator>
			</s:elseif>
			<s:set name="piece_path_before" value="piece_path"/>
			<s:set name="parent_id_before" value="parent_id"/>
			<li id="piece<s:property value="id" />" class="ui-li-piece <s:if test="%{status_id==0}">ui-li-piece-o</s:if>">
				<s:if test="%{user_id==uid}">
					<span class="ui-li-piece-check" id="check<s:property value="id" />">
					<s:if test="%{status_id==0}"><a onClick="Piece.check(<s:property value="id"/>,1)"><i class="fa fa-check-square"></i></a></s:if>
					<s:else><a onClick="Piece.check(<s:property value="id"/>,0)"><i class="fa fa-square-o"></i></a></s:else>
					</span>
				</s:if>
				<a style="padding-left:<s:property value="%{#piece_lv*20}"/>px;" data-ajax="false" href="/piece/<s:property value="id" />">
				<p class="ul-li-piece-title"><s:property value="title"/>
				<span class="ul-li-tags"><small><s:iterator status="s" value="tags_sa"><s:property value="tags_sa[#s.index]"/>&nbsp;&nbsp;</s:iterator></small></span>
				</p>
				</a>
			</li>
			</s:iterator>
			</s:if>
			</ul>
		</div>
	    
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	        	<li>
	            	<a href="/" data-ajax="false" data-theme="a">
		            	<span class="nav-icon">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="a"><i class="fa fa-tasks fa-nav-icon"></i></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="a" id="nav-panel-project-info">
		<ul data-role="listview">
            <li data-icon="arrow-r"><a href="#" data-rel="close">閉じる</a></li>
            <s:if test="%{p.user_id==uid}">
            <li data-icon="edit"><a data-ajax="false" href="/projectupdateinput/<s:property value="p.id"/>" data-rel="close">編集</a></li>
            </s:if>
            <s:if test="p.user_id!=uid&&g!=null">
            <li data-icon="delete">
            	<a data-ajax="false" href="/groupout?pri=<s:property value="p.id"/>&pci=0">メンバーを抜ける</a>
            </li>
            </s:if>
            <s:if test="g!=null && fs.size()>0">
			<li data-icon="user">
				<a href="#popup-menu-group" data-rel="popup">メンバー追加</a>
				<div data-role="popup" id="popup-menu-group" data-theme="b">
			        <ul data-role="listview" data-inset="true" style="min-width:210px;">
			            <li data-role="list-divider">フレンドリスト</li>
			            <s:iterator value="fs">
			            <li id="friend-<s:property value="friend_user_id" />">
			            	<a onClick="Group.add(<s:property value="friend_user_id" />,<s:property value="p.id"/>,0,'#friend-<s:property value="friend_user_id" />');">
			            	<span class="user-icon">
			            		<i class="fa fa-user"></i>
			            	</span>
			            	<s:property value="friend_name" />
			            	</a>
			            </li>
			            </s:iterator>
			        </ul>
				</div>
			</li>
			</s:if>
			<li>
			<br /><h3 style="white-space: normal;"><s:property value="p.title"/></h3>
			<p><strong>メンバー</strong></p>
			<p>
				<s:iterator value="gs">
				<s:property value="name"/>,
				</s:iterator>
			</p>
			<p><strong>概要</strong></p><p><s:property escape="flase" value="p.description_link"/></p>
			<p><strong>ゴール</strong></p><p><s:property escape="flase" value="p.goal_link"/></p>
			<p><strong>リリース予定日</strong></p><p><strong><s:date name="p.target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="p.created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			<s:if test="%{p.user_id==uid}">
			<select onChange="Project.toggle_public(<s:property value="p.id"/>);" id="slider-flip-m" data-role="slider" data-mini="true">
				<s:if test="%{(p.permission-((p.permission/10)*10))&4==4}">
				    <option value="private">非公開</option>
				    <option value="public" selected="">公開</option>
			    </s:if>
			    <s:else>
			    	<option value="private" selected="">非公開</option>
				    <option value="public">公開</option>
			    </s:else>
			</select>
			</s:if>
			</li>
<%--
			<li data-icon="delete">
                <a href="#popupDialog" data-rel="popup" data-position-to="window" data-transition="pop">削除</a>
				<div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
				    <div data-role="header" data-theme="a">
				    <h1>削除</h1>
				    </div>
				    <div role="main" class="ui-content">
				        <h3 class="ui-title">本当にこのプロジェクトを削除しますか?</h3>
				        <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">キャンセル</a>
				        <a onClick="Project.display(<s:property value="p.id"/>,false)" href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back" data-transition="flow">削除</a>
				    </div>
				</div>
			</li>
 --%>
		</ul>
	</div>
</div>
</body>
</html>