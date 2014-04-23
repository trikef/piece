<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
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
		<h1>お気に入り</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<div id="index-chat-list" class="ui-content">
	    	<ul data-role="listview" class="chat-list" data-filter="true" data-filter-placeholder="" data-filter-theme="a" data-inset="true">
	    	<li data-role="list-divider"><i class="fa fa-star"></i>メッセージ</li>
			<s:iterator value="fcs">
			<li>
					<p class="ui-li-name"><strong><s:property value="name"/></strong>
					<s:if test="piece_id>0"><a rel="external" data-ajax="false" href="/piece/<s:property value="piece_id"/>#chat-<s:property value="id"/>" ></s:if>
					<s:else><a rel="external" data-ajax="false" href="/project/<s:property value="project_id"/>#chat-<s:property value="id"/>" ></s:else>
					<i class="fa fa-share"></i></a>
					</p>
					<pre class="ui-li-text"><s:property escape="false" value="text_link"/></pre>
					<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
					<p class="ui-li-subtitle"><s:property value="project_title"/></p>
			</li>
			</s:iterator>
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
				<li class="navbar-button"><a href="#nav-panel-menu-list" data-ajax="false" data-theme="b"><i class="fa fa-bars fa-nav-icon"></i><span class="nav-icon-text">メニュー</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position="right" data-display="overlay" data-theme="a" id="nav-panel-menu-list">
		<ul data-role="listview">
            <li><a href="#" data-rel="close"><span class="menu-list-icon"><i class="fa fa-undo"></i></span>閉じる</a></li>
            <li><a href="/help" alt="ヘルプ"><span class="menu-list-icon"><i class="fa fa-question"></i></span>ヘルプ</a></li>
            <li><a href="/fav" alt="ヘルプ"><span class="menu-list-icon"><i class="fa fa-star"></i></span>お気に入り</a></li>
            <li data-role="collapsible" data-inset="false" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right">
		    	<h2><span class="menu-list-icon"><i class="fa fa-clock-o"></i></span>閲覧履歴</h2>
		        <ul data-role="listview">
		            <s:iterator value="hs">
		            <li>
		            	<a href="<s:property value="url" />" data-ajax="false">
		            		<s:property value="title" />
		            		<span class="ui-li-subtitle"><small><s:property value="url" />&nbsp;<s:date name="created_at" format="MM/dd HH:mm" /></small></span>
	            		</a>
	            	</li>
		            </s:iterator>
		        </ul>
		    </li>
            <li><a href="/profile" alt="プロフィール"><span class="menu-list-icon"><i class="fa fa-user"></i></span><s:property value="name" /></a></li>
            <li data-role="collapsible" data-inset="false" data-collapsed-icon="carat-d" data-expanded-icon="carat-u" data-iconpos="right">
		    	<h2><span class="menu-list-icon"><i class="fa fa-users"></i></span>フレンドリスト</h2>
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