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
<div data-role="page" id="projectlistpage">
	<div data-role="header" data-position="fixed">
		<h1><s:property value="p.title"/></h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<br /><h3 style="white-space: normal;"><s:property value="p.title"/></h3>
			<p><strong>概要</strong></p><p><s:property value="p.description"/></p>
			<p><strong>ゴール</strong></p><p><s:property value="p.goal"/></p>
			<p><strong>リリース予定日</strong></p><p><strong><s:date name="p.target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="p.created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
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
		    <div class="btn-min-space" data-role="collapsibleset" data-theme="a" data-content-theme="b">
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
				<p class="ui-li-text"><s:property value="text"/></p>
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
				<p class="ui-li-text"><s:property value="text"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
			</ul>
		</div>
	    <div id="project-task" class="ui-content">
	    	<div class="btn-min-space" data-role="collapsibleset" data-theme="a" data-content-theme="b">
			    <div data-role="collapsible">
			    <h2>タスク追加</h2>
			        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="p.id" />" />
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
			<li>
				<a data-ajax="false" href="/piece/<s:property value="id" />">
				<p><s:property value="title"/></p>
				</a>
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
</div>
</body>
</html>