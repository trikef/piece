<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
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
<div data-role="page" id="piecepage">
		<div data-role="header">
			<h2>タスク詳細</h2>
			<a data-rel="back" data-direction="reverse" data-icon="back" data-iconpos="notext">Back</a>
			<a href="#nav-panel-piece-info" data-icon="gear" data-iconpos="notext">Info</a>
		</div><!-- /header -->
		<div data-role="content">
			<ul data-role="listview" >
				<li>
					<p><small><s:iterator status="stat" value="piwp.piece_path">
						<s:if test="#stat.index==0">
						<a data-ajax="false" href="/project/<s:property value="piwp.project_id"/>">
							<s:property value="title"/>
						</a>>
						</s:if>
						<s:else>
						<a data-ajax="false" href="/piece/<s:property value="id"/>">
							<s:property value="title"/>
						</a>>
						</s:else>
					</s:iterator>
					</small></p>
				</li>
				<li>
					<br /><h1 style="white-space: normal;"><s:property value="piwp.title"/></h1>
					<p><strong>発行者</strong></p><p><s:property value="piwp.user_name"/></p>
					<p><strong>概要</strong></p><p><s:property escape="flase" value="piwp.description_link"/></p>
					<p><strong>ゴール</strong></p><p><s:property escape="flase" value="piwp.goal_link"/></p>
					<p><strong><s:date name="piwp.target_date" format="yyyy/MM/dd" /></strong></p>
					<p class="ui-li-aside"><strong><s:date name="piwp.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
				</li>
			</ul>
			<ul data-role="listview" data-split-icon=delete data-theme="a" data-split-theme="a">
				<li id="tag-name-input">
					<p><a onClick="Tag.add('piece',<s:property value="piwp.id"/>)" data-icon="false" class="tag-name-add-btn"><i class="fa fa-plus-circle"></i></a></p>
					<ul data-role="listview" data-filter="true" data-filter-reveal="true" data-filter-placeholder="タグ追加" data-inset="true">
				    <s:iterator value="ts">
					    <li><a onClick="Piece.add_tag(<s:property value="id"/>, <s:property value="piwp.id"/>)"><s:property value="name" /></a></li>
					</s:iterator>
					</ul>
				</li>
				<li data-role="list-divider">
					<i class="fa fa-tags"></i>タグ
					<ul class="tag-list">
						<s:iterator value="pts">
						<li id="pt<s:property value="piece_tag_id"/>" class="ui-corner-all ui-shadow">
							<i class="fa fa-tag"></i>
							<a class="ui-tag-name"><h2><s:property value="name"/></h2></a>
							<a class="ui-tag-del" onClick="Piece.del_tag(<s:property value="piece_tag_id"/>, <s:property value="id"/>, <s:property value="piwp.id"/>)"><i class="fa fa-times"></i></a>
						</li>
						</s:iterator>
					</ul>
				</li>
			</ul>
		</div>
	<div data-role="tabs">
	    <div data-role="navbar">
	        <ul>
	          <li><a class="ui-btn-active" href="#piece-chat" data-theme="a" data-ajax="false">Chat</a></li>
	          <li><a href="#piece-pin" data-theme="a" data-ajax="false">Pin</a></li>
	          <li><a href="#piece-task" data-theme="a" data-ajax="false">Sub</a></li>
	          <li><a href="#piece-data" data-theme="a" data-ajax="false">Data</a></li>
	        </ul>
	    </div>
		<div id="piece-chat" class="ui-content">
		    <div id="chat-collapsibleset" class="btn-min-space" data-role="collapsibleset" data-theme="a" data-content-theme="b">
			    <div data-role="collapsible">
			    <h2>チャット追加</h2>
			        <ul data-role="listview" data-theme="a" data-divider-theme="b">
			            <li>
							<div class="ui-field-contain">
								<textarea cols="40" rows="10" name="g" id="piece-text-input" placeholder="ここにメッセージ内容を入力" data-clear-btn="true"></textarea>
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
			<li class="ui-li-chat" id="chat-<s:property value="id"/>">
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
				            <li><a onClick="User.friend.request(<s:property value="user_id"/>,2,<s:property value="p.project_id"/>,<s:property value="p.id"/>,<s:property value="id"/>,'#popup-menu-<s:property value="id"/>');">友達申請</a></li>
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
	    <div id="piece-pin" class="ui-content">
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
		<s:set name="piece_path_before" value="piwp.piece_path"/>
		<s:set name="parent_id_before" value="piwp.parent_id"/>
		<div id="piece-task" class="ui-content">
			<div id="piece-name-input" class="btn-min-space">
				<p><a onClick="Piece.add(<s:property value="piwp.id" />)" data-icon="false" class="piece-name-add-btn"><i class="fa fa-plus-circle"></i></a></p>
		    	<input id="piece-title-input" type="text" data-clear-btn="true" name="piece-title-input" value="" placeholder="タスク名入力">
		    	<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="piwp.project_id" />" />
				<input type="hidden" name="pci" id="piece-pcid-input" value="<s:property value="piwp.id" />" />
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
			<s:if test="title!=piwp.title">
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
				<span class="ul-li-tags"><small><s:iterator status="s" value="tags_sa"><span class="ui-corner-all ui-shadow ui-tag-name-mini"><s:property value="tags_sa[#s.index]"/></span></s:iterator></small></span>
				</p>
				</a>
			</li>
			</s:iterator>
			</s:if>
			</ul>
		</div>
		<div id="piece-data" class="ui-content">
			<div id="data-collapsibleset" data-role="collapsibleset" data-theme="a" data-content-theme="b">
			    <div data-role="collapsible">
			    <h2>データ追加</h2>
			        <ul data-role="listview" data-theme="a" data-divider-theme="b">
			            <li>
							<input type="hidden" name="pi" id="product-pid-input" value="<s:property value="piwp.id" />" />
							<input type="hidden" name="ui" id="product-uid-input" value="<s:property value="uid" />" />
							<div class="ui-field-contain">
								<label for="product-data-input">データ
								</label>
								<textarea cols="40" rows="10" name="d" id="product-data-input" placeholder=""></textarea>
							</div>
							<div class="ui-field-contain">
								<label for="product-comment-input">コメント
								</label>
								<textarea cols="40" rows="10" name="d" id="product-comment-input" placeholder=""></textarea>
							</div>
							<div class="ui-field-contain">
								<a onClick="Product.add_text(1)" class="ui-btn ui-corner-all">追加</a>
								<!-- <a onClick="Product.add_text(2)" class="ui-btn ui-corner-all">下書き</a> -->
							</div>
			            </li>
			        </ul>
			    </div>
			</div>
			<ul data-role="listview" class="product-list ui-li-header" >
			<s:if test="%{ps.size()>0}">
			<s:iterator value="ps">
			<li>
				<a data-ajax="false" href="/product<s:property value="type_name" />/<s:property value="id" />">
					<p class="ui-li-name"><strong><s:property value="user_name"/></strong></p>
					<p class="ui-li-text">ID:<s:property value="name"/></p>
					<p class="ui-li-text-right"><s:property value="type_name"/></p>
					<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
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
	            	<a href="/" data-ajax="false" data-theme="b">
		            	<span class="nav-icon">
		            	<i class="fa fa-home fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b" class="ui-btn-active"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="false" data-position="right" data-display="push" data-theme="a" id="nav-panel-piece-info">
		<ul data-role="listview">
            <li data-icon="arrow-l"><a href="#" data-rel="close">閉じる</a></li>
            <s:if test="%{piwp.user_id==uid}">
            <li data-icon="edit"><a data-ajax="false" href="/pieceupdateinput/<s:property value="piwp.id"/>" data-rel="close">編集</a></li>
			<li data-icon="delete">
                <a href="#popupDialog" data-rel="popup" data-position-to="window" data-transition="pop">削除</a>
				<div data-role="popup" id="popupDialog" data-overlay-theme="b" data-theme="b" data-dismissible="false" style="max-width:400px;">
				    <div data-role="header" data-theme="a">
				    <h1>削除</h1>
				    </div>
				    <div role="main" class="ui-content">
				        <h3 class="ui-title">本当にこのタスクを削除しますか?</h3>
				        <a href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back">キャンセル</a>
				        <a onClick="Piece.display(<s:property value="piwp.id"/>,false)" href="#" class="ui-btn ui-corner-all ui-shadow ui-btn-inline ui-btn-b" data-rel="back" data-transition="flow">削除</a>
				    </div>
				</div>
			</li>
			</s:if>
			<s:if test="g!=null"><%--TOD permission group --%>
            <li>
				<select onChange="Piece.toggle_public(<s:property value="piwp.id"/>);" id="slider-flip-m" data-role="slider" data-mini="true">
					<s:if test="%{(piwp.permission-((piwp.permission/10)*10))&4==4}">
					    <option value="private">非公開</option>
					    <option value="public" selected="">公開</option>
				    </s:if>
				    <s:else>
				    	<option value="private" selected="">非公開</option>
					    <option value="public">公開</option>
				    </s:else>
				</select>
            </li>
            </s:if>
		</ul>
	</div>
</div>
</body>
</html>