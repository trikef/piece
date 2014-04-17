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
<div data-role="page" id="userinputpage" data-dom-cache="false">
	<div data-role="header">
		<h1 class="ui-title">
			<img class="ui-title-icon" src="/img/tomos_icon.png" alt="Tomos">
			���O�C��/�o�^
		</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<h4>���O�C��/�o�^</h4>
		<form class="ui-mini" action="/userregi" method="post">
			<div class="ui-field-contain">
			    <label for="name-input">���O</label>
	     		<input type="text" name="name" id="name-input" value="" placeholder="���p�p����,�X�y�[�X����">
	     	</div>
			<div class="ui-field-contain">
				<input type="submit" id="submit-1" value="���O�C��/�o�^">
			</div>
		</form>
	</div>
<%--
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	        	<li>
	            	<a href="/" data-ajax="false" data-theme="b">
		            	<span class="nav-icon">
		            	<i class="fa fa-home fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">�z�[��</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">�v���W�F�N�g</span></a></li>

<!-- 
	            <li><a href="#" data-ajax="false" data-icon="bars" data-theme="b">�^�X�N</a></li>
	            <li><a href="#" data-ajax="false" data-icon="user" data-theme="b">�}�C�y�[�W</a></li>
 -->
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
 --%>
</div>
</body>
</html>