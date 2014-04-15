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
<div data-role="page" id="taskindexpage">
		<div data-role="header">
			<h2>タスク検索</h2>
		</div><!-- /header -->
		<div data-role="content">
			<ul data-role="listview" data-theme="a">
				<li id="search-key-input">
					<ul data-role="listview" data-filter="true" data-filter-reveal="true" data-filter-placeholder="" data-inset="true">
				    <s:iterator value="ts">
					    <li><a href="/task/?ti=<s:property value="id" />"><i class="fa fa-tag"></i>&nbsp;&nbsp;<s:property value="name" /></a></li>
					</s:iterator>
					</ul>
				</li>
			</ul>
	        <ul data-role="listview" class="piece-list" >
			<s:if test="%{piwps.size()>0}">
			<s:set name="piece_lv" value="1"/>
			<s:iterator value="piwps">
			<li id="piece<s:property value="id" />" class="ui-li-piece-detail">
				<a data-ajax="false" href="/task/detail/<s:property value="id" />">
				<h2><s:property value="title"/></h2>
				<p><s:property value="description"/></p>
				<ul class="tag-list">
					<s:iterator status="s" value="tags_sa">
					<li class="ui-corner-all ui-shadow">
						<i class="fa fa-tag"></i>
						<span class="ui-tag-name"><h2><s:property value="tags_sa[#s.index]"/></h2></span>
					</li>
					</s:iterator>
				</ul>
				</a>
			</li>
			</s:iterator>
			</s:if>
			</ul>
		</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	        	<li>
	            	<a href="/" data-ajax="false" data-theme="a">
		            	<span class="nav-icon">
		            	<i class="fa fa-list-alt fa-nav-icon"></i>
		            	<s:if test="notify"><i class="fa fa-exclamation-circle fa-notify-icon"></i></s:if>
		            	</span>
		            	<span class="nav-icon-text">ホーム</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="a"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">プロジェクト</span></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">探す</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</div>
</body>
</html>