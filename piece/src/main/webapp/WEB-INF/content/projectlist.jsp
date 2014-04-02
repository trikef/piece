<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>�v���W�F�N�g���X�g</title>
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
<div data-role="page" id="projectlistpage">
	<div data-role="header" data-position="fixed">
		<h1>�v���W�F�N�g</h1>
		<a href="/projectinput" data-ajax="false" class="ui-btn ui-shadow ui-corner-all ui-icon-plus ui-btn-icon-notext ui-btn-inline ui-btn-right">Options</a>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
		    <s:iterator value="ps">
			<li><a data-ajax="false" href="/project/<s:property value="id"/>">
			<br /><h3 style="white-space: normal;"><s:property value="title"/></h3>
			<p><s:property value="description"/></p>
			<p><s:property value="goal"/></p>
			<p><strong><s:date name="target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</a></li>
			</s:iterator>
		</ul>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li><a href="/projectlist" data-ajax="false" data-icon="grid" data-theme="a">�v���W�F�N�g</a></li>
	            <li><a href="#" data-ajax="false" data-icon="star" data-theme="b">�^�X�N</a></li>
	            <li><a href="#" data-ajax="false" data-icon="star" data-theme="b">�}�C�y�[�W</a></li>
	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</body>
</html>