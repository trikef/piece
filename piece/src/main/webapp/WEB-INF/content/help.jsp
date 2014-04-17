<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>�w���v</title>
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
		<h1>�w���v</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<div id="index-friend-request-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    		<li data-role="list-divider">�z�[��</li>
				<li><p>�K�ꂽ���̂���v���W�F�N�g�̖��ǃ`���b�g�̒ʒm�A�t�����h�\���̒ʒm�A�t�����h���X�g�̊m�F���o���܂�</p></li>
				<li data-role="list-divider">�v���W�F�N�g</li>
				<li>
					<h3><small>�v���W�F�N�g���X�g</small></h3>
					<p>��ʌ��J�A�܂��̓����o�[�ɏ������Ă���v���W�F�N�g�����X�g����Ă��܂��B���C�y�ɉ{�����ă`���b�g�ňӌ�������A�����ȂƎv���������Ɂu�����ˁI�v�����ĎQ�����Ă݂Ă��������B�ǂ̃v���W�F�N�g�ł������o�[�����Ȃ������}���܂��I</p>
					<h3><small>�}�C�v���W�F�N�g</small></h3>
					<p>������p�̔���J�ݒ�v���W�F�N�g�ł��B�g�����̗��K��������A�`���b�g�@�\�Ń����A�^�X�N�@�\��ToDo�Ǘ��Ȃǂ����R�ɂ��g�����������B���J�ݒ�ɕύX����Ƃ��͂悭�������ĉ������A�񐄏��ł��B</p></li>
				<li data-role="list-divider">�T��</li>
				<li><p>����`�����ė~�����v���W�F�N�g����̃^�X�N�������ł��܂��B�����Ō����ł���^�X�N�݂͂Ȃ���̎Q����S�҂��ɂ��Ă��܂��I��������������^�X�N�������������ǐi�ߕ����悭�킩��Ȃ��Ȃǋ^�₪�������炨�C�y�Ƀ^�X�N�`���b�g�Ŏ��₵�Ă݂Ă�������</p></li>
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
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="a" id="nav-panel-friend-list">
		<ul data-role="listview">
            <li data-icon="arrow-r"><a href="#" data-rel="close">����</a></li>
            <s:iterator value="fs">
            <li><span class="user-icon"><i class="fa fa-user"></i></span><s:property value="friend_name" /></li>
            </s:iterator>
		</ul>
	</div>
</body>
</html>