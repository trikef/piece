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
<!-- 	<link rel="stylesheet" href="/css/jquery-ui.css"> -->
	<link rel="stylesheet" href="/css/jquery.mobile-1.4.2.css" />
<!--<link rel="shortcut icon" href="../favicon.ico"> -->
	<script src="/js/jquery-1.11.0.js"></script>
<!-- 	<script src="/js/jquery-ui-1.10.2.custom.js"></script> -->
	<script src="/js/jquery.mobile-1.4.2.js"></script>
	<script src="/js/main.js"></script>
</head>
<body>
<div data-role="page" id="projectinputpage" data-dom-cache="false">
	<div data-role="header" data-position="fixed">
		<h1>�v���W�F�N�g�ҏW</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<p style="color:red;"><s:property value="msg" /></p>
		<form class="ui-mini" action="/projectupdate" method="post">
			<input type="hidden" name="uid" value="<s:property value="uid" />" />
			<input type="hidden" name="pid" value="<s:property value="p.id" />" />
			<div class="ui-field-contain">
			    <label for="title-input">�^�C�g��</label>
	     		<input type="text" name="title" id="title-input" value="<s:property value="p.title" />" placeholder="�v���W�F�N�g��\���Ȍ��Ȗ��O���L�����Ă�������">
	     	</div>
	     	<div class="ui-field-contain">
				<label for="description-input">����
				</label>
				<textarea cols="40" rows="10" name="description" id="description-input" placeholder=""><s:property value="p.description" /></textarea>
			</div>
	     	<div class="ui-field-contain">
			    <label for="goal-input">�S�[��</label>
	     		<input type="text" name="goal" id="goal-input" value="<s:property value="p.goal" />" placeholder="���̃v���W�F�N�g���ڎw���S�[���𖾊m�ɋL�����Ă�������">
	     	</div>
	     	<div class="ui-field-contain">
			    <label for="targetdate-input">�����\���</label>
	     		<input type="date" name="target_date" id="targetdate-input" value="<s:date name="p.target_date" format="yyyy/MM/dd" />" placeholder="yyyy/MM/dd">
	     	</div>
			<div class="ui-field-contain">
				<input type="submit" id="submit-1" value="�o�^">
			</div>
		</form>
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