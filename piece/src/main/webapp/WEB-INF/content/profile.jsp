<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>���j���[</title>
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
		<h1><s:property value="name" /></h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<div id="index-chat-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    	<li data-theme="b" data-role="list-divider">�X�e�[�^�X</li>
			<li data-theme="b">
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�o���l</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>���[�_�[�V�b�v</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�s����</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�D��S</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�����</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�ӔC��</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�R�~����</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�����\��</strong></p>
					<p class="ui-li-text">---</p>
				</span>
				<span class="profile-parameter">
					<p class="ui-li-name"><strong>�V�X�e����</strong></p>
					<p class="ui-li-text">---</p>
				</span>
			</li>
			</ul>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li class="navbar-button">
	            	<a href="/" data-ajax="false" data-theme="b" class="ui-btn-active">
		            	<span class="nav-icon">
		            	<i class="fa fa-home fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">�z�[��</span>
	            	</a>
	            </li>
	            <li class="navbar-button"><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">�v���W�F�N�g</span></a></li>
				<li class="navbar-button"><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">�T��</span></a></li>
				<li class="navbar-button"><a href="#nav-panel-menu-list" data-ajax="false" data-theme="b"><i class="fa fa-bars fa-nav-icon"></i><span class="nav-icon-text">���j���[</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position="right" data-display="overlay" data-theme="a" id="nav-panel-menu-list">
		<ul data-role="listview">
            <li><a href="#" data-rel="close"><span class="menu-list-icon"><i class="fa fa-undo"></i></span>����</a></li>
            <li><a href="/profile" alt="�v���t�B�[��"><span class="menu-list-icon"><i class="fa fa-user"></i></span><s:property value="name" /></a></li>
            <li><a href="/help" alt="�w���v"><span class="menu-list-icon"><i class="fa fa-question"></i></span>�w���v</a></li>
            <li data-role="collapsible" data-inset="false" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right">
		    	<h2><span class="menu-list-icon"><i class="fa fa-users"></i></span>�t�����h���X�g</h2>
		        <ul data-role="listview">
		            <s:iterator value="fs">
		            <li><span class="user-icon"><i class="fa fa-user"></i></span><s:property value="friend_name" /></li>
		            </s:iterator>
		        </ul>
		    </li>
		</ul>
	</div>
</div>
</body>
</html>