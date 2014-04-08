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
		<h1><s:property value="p.title"/></h1>
		<a data-ajax="false" href="/piece/<s:property value="piwp.id" />" data-icon="back" data-iconpos="notext">Back</a>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<p class="ui-li-topicpath"><small><s:iterator  status="stat" value="piwp.piece_path">
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
			<a data-ajax="false" href="/piece/<s:property value="piwp.id"/>">
				<s:property value="piwp.title"/>
			</a>
			</small></p>
			<br /><p><strong>ID:</strong></p><h3 style="white-space: normal;"><s:property value="pt.name"/></h3>
			<p><strong>コメント</strong></p><p><s:property value="pt.comment"/></p>
			<p><strong>ユーザー</strong></p><p><s:property value="pt.user_name"/></p>
			<p class="ui-li-aside"><strong><s:date name="pt.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</li>
			<li>
				<pre id="pt<s:property value="pt.id"/>"><s:property value="pt.data"/></pre>
			</li>
		</ul>
		<div id="product-chat" class="ui-content">
		    <ul data-role="listview" class="productchat-list" >
			<s:iterator value="pcs">
			<li>
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
				<p class="ui-li-text"><s:property value="text"/></p>
				<p class="ui-li-text-right">評価:<s:property value="star"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
			</ul>
	    </div>
	    <div id="productchat-collapsibleset" data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>レビュー追加</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="product-pid-input" value="<s:property value="pt.id" />" />
						<input type="hidden" name="ui" id="product-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<textarea cols="40" rows="10" name="g" id="product-text-input" placeholder="ここにメッセージ内容を入力"></textarea>
						</div>
						<div class="ui-field-contain">
							<select name="star" id="product-star-input">
								<option value="5">★★★★★</option>
								<option value="4">★★★★☆</option>
								<option value="3">★★★☆☆</option>
								<option value="2">★★☆☆☆</option>
								<option value="1">★☆☆☆☆</option>
							</select>
						</div>
						<div class="ui-field-contain">
							<a href="#" onClick="ProductChat.add()" class="ui-btn ui-corner-all">送信</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i></a></li>

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