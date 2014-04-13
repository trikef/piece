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
<div data-role="page" id="projectinputpage" data-dom-cache="false">
	<div data-role="header">
		<h1>プロジェクト登録</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<p style="color:red;"><s:property value="msg" /></p>
		<form class="ui-mini" action="/projectregi" method="post">
			<input type="hidden" name="uid" value="<s:property value="uid" />" />
			<div class="ui-field-contain">
			    <label for="title-input">タイトル</label>
	     		<input type="text" name="title" id="title-input" value="<s:property value="title" />" placeholder="プロジェクトを表す簡潔な名前を記入してください">
	     	</div>
	     	<div class="ui-field-contain">
				<label for="description-input">説明
				</label>
				<textarea cols="40" rows="10" name="description" id="description-input" placeholder=""><s:property value="description" /></textarea>
			</div>
	     	<div class="ui-field-contain">
			    <label for="goal-input">ゴール</label>
	     		<input type="text" name="goal" id="goal-input" value="<s:property value="goal" />" placeholder="このプロジェクトが目指すゴールを明確に記入してください">
	     	</div>
	     	<div class="ui-field-contain">
			    <label for="targetdate-input">完了予定日</label>
	     		<input type="date" name="target_date" id="targetdate-input" value="<s:property value="target_date" />" placeholder="yyyy/MM/dd">
	     	</div>
			<div class="ui-field-contain">
				<input type="submit" id="submit-1" value="登録">
			</div>
		</form>
	</div>
		<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	        	<li>
	            	<a href="/" data-ajax="false" data-theme="a">
		            	<span class="nav-icon">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
		            	<s:if test="ncs.size()>0"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="a"><i class="fa fa-tasks fa-nav-icon"></i></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</body>
</html>