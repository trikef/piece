<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title><s:property value="title"/></title>
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
		<h1>����</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<a data-ajax="false" href="/project/<s:property value="pid"/>" class="ui-btn ui-corner-all">�v���W�F�N�g�ɖ߂�</a>
	</div>
		<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li><a href="/projectlist" data-ajax="false" data-icon="grid" data-theme="b">�v���W�F�N�g���X�g</a></li>
<!-- 
	            <li><a href="#" data-ajax="false" data-icon="bars" data-theme="b">�^�X�N</a></li>
	            <li><a href="#" data-ajax="false" data-icon="user" data-theme="b">�}�C�y�[�W</a></li>
 -->
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</body>
</html>