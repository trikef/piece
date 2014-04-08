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
	<div data-role="header" data-position="fixed">
		<h1><s:property value="p.title"/></h1>
		<a href="#nav-panel" data-icon="gear" data-iconpos="notext">Menu</a>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<br /><h3 style="white-space: normal;"><s:property value="p.title"/></h3>
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
		</ul>
	<div data-role="tabs">
	    <div data-role="navbar">
	        <ul>
	          <li><a class="ui-btn-active" href="#project-chat" data-theme="a" data-ajax="false">チャット</a></li>
	          <li><a href="#project-pin" data-theme="a" data-ajax="false">ピン</a></li>
	          <li><a href="#project-task" data-theme="a" data-ajax="false">タスク</a></li>
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
			<li>
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
				<p class="ui-li-text"><s:property escape="false" value="text_link"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
				<p class="ui-li-action">
					<s:if test="%{priority>0}"><i class="fa fa-thumb-tack"></i></s:if>
					<s:else>
					<span id="pin<s:property value="id" />">
					<a onClick="Chat.pin(<s:property value="id"/>,<s:property value="id"/>)">
						<i class="fa fa-thumb-tack"></i>
					</a>
					</span>
					</s:else>
					<a onClick="Chat.count(<s:property value="id" />,'<s:property value="uid" />',1,0,'#good<s:property value="id"/>')" class=""><i class="fa fa-thumbs-o-up"></i>(<span id="good<s:property value="id"/>"><s:property value="good"/></span>)</a>
					<a onClick="Chat.count(<s:property value="id" />,'<s:property value="uid" />',0,1,'#bad<s:property value="id"/>')" class=""><i class="fa fa-thumbs-o-down"></i>(<span id="bad<s:property value="id"/>"><s:property value="bad"/></span>)</a>
				</p>
			</li>
			</s:iterator>
			</ul>
	    </div>
	    <div id="project-pin" class="ui-content">
	    	<ul data-role="listview" class="pin-list" >
			<s:iterator value="cps">
			<li>
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
				<p class="ui-li-text"><s:property escape="false" value="text_link"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
			</ul>
		</div>
	    <div id="project-task" class="ui-content">
	    	<div id="piece-collapsibleset" class="btn-min-space" data-role="collapsibleset" data-theme="a" data-content-theme="b">
			    <div data-role="collapsible">
			    <h2>タスク追加</h2>
			        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="p.id" />" />
						<input type="hidden" name="pci" id="piece-pcid-input" value="0" />
						<input type="hidden" name="ui" id="piece-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<label for="piece-title-input">タイトル
							</label>
							<input type="text" name="t" id="piece-title-input" placeholder="" />
						</div>
						<div class="ui-field-contain">
							<label for="piece-description-input">説明
							</label>
							<textarea cols="40" rows="10" name="d" id="piece-description-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
							<label for="piece-goal-input">終了条件
							</label>
							<textarea cols="40" rows="10" name="g" id="piece-goal-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
						    <label for="piece-targetdate-input">完了予定日</label>
				     		<input type="date" name="td" id="piece-targetdate-input" placeholder="yyyy/MM/dd">
				     	</div>
						<div class="ui-field-contain">
							<a href="#" onClick="Piece.add(0)" class="ui-btn ui-corner-all">追加</a>
						</div>
		            </li>
		        </ul>
			    </div>
			</div>
	        <ul data-role="listview" class="piece-list" >
			<s:iterator value="pis">
			<li id="piece<s:property value="id" />" class="ui-li-piece <s:if test="%{status_id==0}">ui-li-piece-o</s:if>">
				<s:if test="%{child_count>0}">
				<a data-ajax="false" href="/piece/<s:property value="id" />">
				<p class="ul-li-piece-title"><s:property value="title"/></p>
				<span class="ui-li-count ul-li-count-left"><s:property value="child_count" /></span>
				</a>
				</s:if>
				<s:else>
					<s:if test="%{user_id==uid}">
					<span class="ui-li-piece-check" id="check<s:property value="id" />">
					<s:if test="%{status_id==0}"><a onClick="Piece.check(<s:property value="id"/>,1)"><i class="fa fa-check-square"></i></a></s:if>
					<s:else><a onClick="Piece.check(<s:property value="id"/>,0)"><i class="fa fa-square-o"></i></a></s:else>
					</span>
					</s:if>
					<a data-ajax="false" href="/piece/<s:property value="id" />">
					<p class="ul-li-piece-title"><s:property value="title"/></p>
					</a>
				</s:else>
			</li>
			</s:iterator>
			</ul>
	    </div>
	</div>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li><a href="/projectlist" data-ajax="false" data-icon="grid" data-theme="b">プロジェクトリスト</a></li>
<!-- 
	            <li><a href="#" data-ajax="false" data-icon="bars" data-theme="b">タスク</a></li>
	            <li><a href="#" data-ajax="false" data-icon="user" data-theme="b">マイページ</a></li>
 -->
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="b" id="nav-panel">
        <ul data-role="listview">
            <li data-icon="arrow-r"><a href="#" data-rel="close">閉じる</a></li>
            <s:if test="%{p.user_id==uid}">
            <li data-icon="edit"><a data-ajax="false" href="/projectupdateinput/<s:property value="p.id"/>" data-rel="close">編集</a></li>
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
 			</s:if>
		</ul>
	</div>
</div>
</body>
</html>