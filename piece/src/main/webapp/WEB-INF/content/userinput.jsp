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
	<script src="http://code.jquery.com/jquery-1.9.1.min.js"></script>
	<script src="http://code.jquery.com/ui/1.10.4/jquery-ui.js"></script>
	<script src="http://code.jquery.com/mobile/1.4.2/jquery.mobile-1.4.2.min.js"></script>
	<script src="/js/main.js"></script>
</head>
<body>
<div data-role="page" id="userinputpage" data-dom-cache="false">
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
		<h4>ユーザー登録</h4>
		<form class="ui-mini" action="/userregi" method="post">
			<div class="ui-field-contain">
			    <label for="name-input">名前</label>
	     		<input type="text" name="name" id="name-input" value="" placeholder="半角英数字,スペース無し">
	     	</div>
			<div class="ui-field-contain">
				<input type="submit" id="submit-1" value="登録">
			</div>
		</form>
	</div>
</body>
</html>