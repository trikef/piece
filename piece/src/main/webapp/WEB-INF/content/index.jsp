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
	<div data-role="header" data-position="fixed">
		<h1>メニュー</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<h4><s:property value="name" />さん</h4>
		<a href="/projectlist" class="ui-btn ui-corner-all">プロジェクトリスト</a>
		<a href="/projectinput" class="ui-btn ui-corner-all">プロジェクト追加</a>
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
</body>
</html>