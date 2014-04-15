<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>メニュー</title>
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
		<h1>マイページ</h1>
		<a href="#nav-panel-friend-list" ><i class="fa fa-users"></i></a>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<s:if test="nfs.size()>0">
		<div id="index-friend-request-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    	<li data-role="list-divider">フレンド申請がきています</li>
			<s:iterator value="nfs">
			<li class="ui-li-unread" id="friend-<s:property value="id"/>">
				<p class="ui-li-name"><strong><s:property value="friend_name"/></strong></p>
				<button class="ui-btn ui-btn-inline ui-mini" onClick="User.friend.request(<s:property value="friend_user_id"/>,1,0,0,0,'#friend-<s:property value="id"/>');">許可</button>
				<button class="ui-btn ui-btn-inline ui-mini" onClick="User.friend.request(<s:property value="friend_user_id"/>,3,0,0,0,'#friend-<s:property value="id"/>');">ブロック</button>
			</li>
			</s:iterator>
			</ul>
		</div>
		</s:if>
		<div id="index-chat-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-inset="true">
	    	<li data-role="list-divider">未読</li>
			<s:iterator value="ncs">
			<li class="ui-li-unread">
				<s:if test="piece_id>0"><a data-ajax="false" href="/piece/<s:property value="piece_id"/>" ></s:if>
				<s:else><a data-ajax="false" href="/project/<s:property value="project_id"/>" ></s:else>
					<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
					<p class="ui-li-text"><s:property value="text"/></p>
					<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
					<p class="ui-li-subtitle"><s:property value="project_title"/></p>
				</a>
			</li>
			</s:iterator>
			</ul>
		</div>
	</div>
		<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li class="navbar-button">
	            	<a href="/" data-ajax="false" data-theme="b">
		            	<span class="nav-icon">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li class="navbar-button"><a href="/projectlist" data-ajax="false" data-theme="a"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li class="navbar-button"><a href="/task/" data-ajax="false" data-theme="a"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
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