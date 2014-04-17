<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>ヘルプ</title>
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
		<h1>ヘルプ</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<div id="index-friend-request-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    		<li data-role="list-divider">ホーム</li>
				<li><p>訪れた事のあるプロジェクトの未読チャットの通知、フレンド申請の通知、フレンドリストの確認が出来ます</p></li>
				<li data-role="list-divider">プロジェクト</li>
				<li>
					<h3><small>プロジェクトリスト</small></h3>
					<p>一般公開、またはメンバーに所属しているプロジェクトがリストされています。お気軽に閲覧してチャットで意見したり、いいなと思った発言に「いいね！」をして参加してみてください。どのプロジェクトでもメンバーがあなたを歓迎します！</p>
					<h3><small>マイプロジェクト</small></h3>
					<p>自分専用の非公開設定プロジェクトです。使い方の練習をしたり、チャット機能でメモ、タスク機能でToDo管理などご自由にお使いください。公開設定に変更するときはよく検討して下さい、非推奨です。</p></li>
				<li data-role="list-divider">探す</li>
				<li><p>お手伝いして欲しいプロジェクトからのタスクが検索できます。ここで検索できるタスクはみなさんの参加を心待ちにしています！もし興味があるタスクが見つかったけど進め方がよくわからないなど疑問があったらお気軽にタスクチャットで質問してみてください</p></li>
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
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li class="navbar-button"><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li class="navbar-button"><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="a" id="nav-panel-friend-list">
		<ul data-role="listview">
            <li data-icon="arrow-r"><a href="#" data-rel="close">閉じる</a></li>
            <s:iterator value="fs">
            <li><span class="user-icon"><i class="fa fa-user"></i></span><s:property value="friend_name" /></li>
            </s:iterator>
		</ul>
	</div>
</body>
</html>