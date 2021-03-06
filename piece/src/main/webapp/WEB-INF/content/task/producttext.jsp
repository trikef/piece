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
<div data-role="page" id="piecepage">
	<div data-role="header">
		<h1><s:property value="p.title"/></h1>
		<a data-rel="back" data-direction="reverse" data-icon="back" data-iconpos="notext">Back</a>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<br /><p><strong>ID:</strong></p><h3 style="white-space: normal;"><s:property value="pt.name"/></h3>
			<p><strong>�R�����g</strong></p><p><s:property value="pt.comment"/></p>
			<p><strong>���[�U�[</strong></p><p><s:property value="pt.user_name"/></p>
			<p class="ui-li-aside"><strong><s:date name="pt.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</li>
			<li>
				<pre id="pt<s:property value="pt.id"/>"><s:property escape="false" value="pt.data_link"/></pre>
			</li>
		</ul>
		<div id="product-chat" class="ui-content">
		    <ul data-role="listview" class="productchat-list" >
			<s:iterator value="pcs">
			<li>
				<p class="ui-li-name"><strong><s:property value="name"/></strong></p>
				<p class="ui-li-text"><s:property value="text"/></p>
				<p class="ui-li-text-right">�]��:<s:property value="star"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</li>
			</s:iterator>
			</ul>
	    </div>
	    <div id="productchat-collapsibleset" data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>���r���[�ǉ�</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="product-pid-input" value="<s:property value="pt.id" />" />
						<input type="hidden" name="ui" id="product-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<textarea cols="40" rows="10" name="g" id="product-text-input" placeholder="�����Ƀ��b�Z�[�W���e�����"></textarea>
						</div>
						<div class="ui-field-contain">
							<select name="star" id="product-star-input">
								<option value="5">����������</option>
								<option value="4">����������</option>
								<option value="3">����������</option>
								<option value="2">����������</option>
								<option value="1">����������</option>
							</select>
						</div>
						<div class="ui-field-contain">
							<a href="#" onClick="ProductChat.add()" class="ui-btn ui-corner-all">���M</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
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
		            	<span class="nav-icon-text">�z�[��</span>
	            	</a>
	            </li>
	            <li><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">�v���W�F�N�g</span></a></li>
				<li><a href="/task/" data-ajax="false" data-theme="b" class="ui-btn-active"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">�T��</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</div>
</body>
</html>