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
<div data-role="page" id="taskindexpage">
	<div data-role="header">
		<h2>タスク検索</h2>
	</div><!-- /header -->
	<div data-role="content">
<%--
		<a href="/task/tag?ti=<s:property value="t1.id" />" class="ui-btn"><s:property value="t1.name" />:<s:property value="t1.num" /></a>
		<a href="/task/tag?ti=<s:property value="t2.id" />" class="ui-btn"><s:property value="t2.name" />:<s:property value="t2.num" /></a>
 --%>
		<s:if test="%{pstp.size()>0}">
 		<ul data-role="listview" class="piece-list" >
			<s:set name="piece_lv" value="1"/>
    		<li data-role="list-divider"><span class="menu-list-icon">新着おすすめタスク</li>
			<s:iterator value="pstp">
			<li id="piece<s:property value="id" />" class="ui-li-piece-top">
				<a data-ajax="false" href="/task/detail/<s:property value="id" />">
				<div class="ul-li-piece-title">
					<h2><s:property value="title"/></h2>
					<span class="ul-li-tags"><small><s:iterator status="s" value="tags_sa"><span class="ui-corner-all ui-shadow ui-tag-name-mini"><s:property value="tags_sa[#s.index]"/></span></s:iterator></small></span>
				</div>
				</a>
			</li>
			</s:iterator>
		</ul>
		</s:if>
		<form class="ui-filterable">
		    <input id="search-key-input" data-type="search" placeholder="タグ名から検索">
		</form>
		<ul data-role="listview" data-filter="true" data-input="#search-key-input">
		    <s:iterator value="ts">
			    <li>
			    	<a href="/task/tag?ti=<s:property value="id" />">
			    		<i class="fa fa-tag"></i>&nbsp;&nbsp;<s:property value="name" />
			    		<span class="ui-li-count"><s:property value="num" /></span>
			    	</a>
			    </li>
			</s:iterator>
		</ul>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	        	<li>
	            	<a href="/" data-ajax="false" data-theme="b">
		            	<span class="nav-icon">
		            	<i class="fa fa-home fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="b" class="ui-btn-active"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</div>
</body>
</html>