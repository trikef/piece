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
<div data-role="page" id="piecepage">
	<div data-role="header" data-position="fixed">
		<h1><s:property value="p.title"/></h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<p><small><s:iterator  status="stat" value="piwp.piece_path">
				<s:if test="#stat.index==0">
				<a data-ajax="false" href="/project/<s:property value="piwp.project_id"/>">
					<s:property value="title"/>
				</a>>
				</s:if>
				<s:else>
				<a data-ajax="false" href="/piece/<s:property value="id"/>">
					<s:property value="title"/>
				</a>>
				</s:else>
			</s:iterator>
			</small></p>
			<br /><h3 style="white-space: normal;"><s:property value="piwp.title"/></h3>
			<p><strong>概要</strong></p><p><s:property value="piwp.description"/></p>
			<p><strong>ゴール</strong></p><p><s:property value="piwp.goal"/></p>
			<p><strong><s:date name="piwp.target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="piwp.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</li>
		</ul>
		<ul data-role="listview" class="piece-list" >
			<li class="ui-li-header">タスク</li>
		<s:if test="%{piwps.size()>0}">
		<s:iterator value="piwps">
		<li>
			<p class="piece-topic-path"><small><s:iterator  status="stat" value="piece_path">
				<s:if test="#stat.index>0">
				<a data-ajax="false" href="/piece/<s:property value="id"/>">
					<s:property value="title"/>
				</a>>
				</s:if>
			</s:iterator>
			</small></p>
			<a data-ajax="false" href="/piece/<s:property value="id" />">
			<p><s:property value="title"/></p>
			</a>
		</li>
		</s:iterator>
		</s:if>
		</ul>
		<div data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>サブタスク追加</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="piwp.project_id" />" />
						<input type="hidden" name="ui" id="piece-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<label for="piece-title-input">タイトル
							</label>
							<input type="text" name="t" id="piece-title-input" placeholder="" />
						</div>
						<div class="ui-field-contain">
							<label for="piece-description-input">説明
							</label>
							<textarea cols="40" rows="10" name="d" id="piece-description-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
							<label for="piece-goal-input">終了条件
							</label>
							<textarea cols="40" rows="10" name="g" id="piece-goal-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
						    <label for="piece-targetdate-input">完了予定日</label>
				     		<input type="date" name="td" id="piece-targetdate-input" placeholder="yyyy/MM/dd">
				     	</div>
						<div class="ui-field-contain">
							<a onClick="Piece.add(<s:property value="piwp.id" />)" class="ui-btn ui-corner-all">追加</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
		<ul data-role="listview" class="product-list" >
			<li class="ui-li-header">データ</li>
		<s:if test="%{ps.size()>0}">
		<s:iterator value="ps">
		<li>
			<a data-ajax="false" href="/product<s:property value="type_name" />/<s:property value="id" />">
				<p class="ui-li-name"><strong><s:property value="user_name"/></strong></p>
				<p class="ui-li-text"><s:property value="name"/></p>
				<p class="ui-li-text-right"><s:property value="type_name"/></p>
				<p class="ui-li-date"><strong><s:date name="created_at" format="yyyy/MM/dd HH:mm" /></strong></p>
			</a>
		</li>
		</s:iterator>
		</s:if>
		</ul>
		<div data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>データ追加</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="product-pid-input" value="<s:property value="piwp.id" />" />
						<input type="hidden" name="ui" id="product-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<label for="product-data-input">データ
							</label>
							<textarea cols="40" rows="10" name="d" id="product-data-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
							<label for="product-comment-input">コメント
							</label>
							<textarea cols="40" rows="10" name="d" id="product-comment-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
							<a onClick="Product.add_text(1)" class="ui-btn ui-corner-all">追加</a>
							<a onClick="Product.add_text(2)" class="ui-btn ui-corner-all">下書き</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
	</div>
	<div data-role="footer" data-position="fixed">
	    <div data-role="navbar">
	        <ul>
	            <li><a href="/projectlist" data-ajax="false" data-icon="grid" data-theme="b">プロジェクトリスト</a></li>
<!-- 
	            <li><a href="#" data-ajax="false" data-icon="bars" data-theme="b">タスク</a></li>
	            <li><a href="#" data-ajax="false" data-icon="user" data-theme="b">マイページ</a></li>
 -->
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
</div>
</body>
</html>