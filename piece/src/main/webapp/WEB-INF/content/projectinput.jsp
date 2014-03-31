<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>bit</title>
	<link rel="stylesheet" href="/css/main.css" />
	<link rel="stylesheet" href="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.css" />
<!--<link rel="shortcut icon" href="../favicon.ico"> -->
	<link rel="stylesheet" href="//code.jquery.com/ui/1.10.4/themes/smoothness/jquery-ui.css">
<!--<link rel="stylesheet" href="https://rawgithub.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.css">-->
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
<!--<script src="https://rawgithub.com/jquery/jquery-ui/1.10.4/ui/jquery.ui.datepicker.js"></script>
    <script id="mobile-datepicker" src="https://rawgithub.com/arschmitz/jquery-mobile-datepicker-wrapper/v0.1.1/jquery.mobile.datepicker.js">-->
	<script src="/js/main.js"></script>
</head>
<body>
<div data-role="page" id="projectinputpage" data-dom-cache="false">
	<div data-role="header">
		<div data-role="navbar">
			<ul>
				<li><a href="/" data-ajax="false" class="ui-btn-active ui-state-persist" data-icon="home">ホーム</a></li>
				<li><a href="/create" data-ajax="false" data-icon="plus">働く</a></li>
				<li><a href="/mypage" data-ajax="false" data-icon="user">マイページ</a></li>
			</ul>
		</div>
		<h1>bit</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<p style="color:red;"><s:property value="msg" /></p>
		<h4><s:property value="name" />さん</h4>
		<h4>プロジェクト登録</h4>
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
</body>
</html>