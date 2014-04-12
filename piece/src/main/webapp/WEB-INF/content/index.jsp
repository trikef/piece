<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>メニュー</title>
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
<div data-role="page" id="indexpage" data-dom-cache="false">
	<div data-role="header">
		<h1>メニュー</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<a href="/projectlist" class="ui-btn ui-corner-all">プロジェクトリスト</a>
		<div id="index-chat-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    	<li data-role="list-divider">未読</li>
			<s:iterator value="ncs">
			<li class="ui-li-unread">
				<s:if test="piece_id>0"><a data-ajax="false" href="/piece/<s:property value="piece_id"/>" ></s:if>
				<s:else><a data-ajax="false" href="/project/<s:property value="project_id"/>" ></s:else>
					<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
					<p class="ui-li-text"><s:property value="text"/></p>
					<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
					<p class="ui-li-subtitle"><s:property value="project_title"/></p>
				</a>
			</li>
			</s:iterator>
			</ul>
		</div>
	</div>
		<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li>
	            	<a href="/" data-ajax="false" data-theme="b">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="a"><i class="fa fa-th-large fa-nav-icon"></i></a></li>

<!-- 
	            <li><a href="#" data-ajax="false" data-icon="bars" data-theme="b">タスク</a></li>
	            <li><a href="#" data-ajax="false" data-icon="user" data-theme="b">マイページ</a></li>
 -->
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</body>
</html>