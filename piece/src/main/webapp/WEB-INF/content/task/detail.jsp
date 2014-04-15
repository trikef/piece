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
<div data-role="page" id="piecepage">
		<div data-role="header">
			<h2>タスク詳細</h2>
			<a data-rel="back" data-direction="reverse" data-icon="back" data-iconpos="notext">Back</a>
		</div><!-- /header -->
		<div data-role="content">
			<ul data-role="listview" >
				<li>
					<br /><h1 style="white-space: normal;"><s:property value="piwp.title"/></h1>
					<p><strong>発行者</strong></p><p><s:property value="piwp.user_name"/></p>
					<p><strong>概要</strong></p><p><s:property escape="flase" value="piwp.description_link"/></p>
					<p><strong>ゴール</strong></p><p><s:property escape="flase" value="piwp.goal_link"/></p>
					<p><strong><s:date name="piwp.target_date" format="yyyy/MM/dd" /></strong></p>
					<p class="ui-li-aside"><strong><s:date name="piwp.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
					<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="piwp.project_id" />" />
					<input type="hidden" name="pci" id="piece-pcid-input" value="<s:property value="piwp.id" />" />
					<input type="hidden" name="ui" id="piece-uid-input" value="<s:property value="uid" />" />
				</li>
			</ul>
			<ul data-role="listview" data-split-icon=delete data-theme="a" data-split-theme="a">
				<li data-role="list-divider">
					<i class="fa fa-tags"></i>タグ
					<ul class="tag-list">
						<s:iterator value="pts">
						<li id="pt<s:property value="piece_tag_id"/>" class="ui-corner-all ui-shadow">
							<i class="fa fa-tag"></i>
							<a class="ui-tag-name"><h2><s:property value="name"/></h2></a>
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
			<li>
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
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
								<a onClick="Product.add_text(1,'task')" class="ui-btn ui-corner-all">追加</a>
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
				<a data-ajax="false" href="/task/product<s:property value="type_name" />/<s:property value="id" />">
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
	            	<a href="/" data-ajax="false" data-theme="a">
		            	<span class="nav-icon">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="a"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</div>
</body>
</html>