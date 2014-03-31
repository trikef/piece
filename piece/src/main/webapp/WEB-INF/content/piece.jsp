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
<div data-role="page" id="projectlistpage">
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
		<h3><s:property value="name" />さん</h3>
		<s:if test="pips.size()==0">
			<ul data-role="listview" class="piece-list" >
			<li>
				<a href="/project/<s:property value="p.project_id" />">
				<p>プロジェクトに戻る</p>
				</a>
			</li>
		</s:if>
		<s:else>
			<ul data-role="listview" class="piece-list" >
			<s:iterator value="pips">
			<li>
				<a href="/piece/<s:property value="id" />">
				<p><strong>親タスク</strong></p>
				<p><s:property value="title"/></p>
				</a>
			</li>
			</s:iterator>
			</ul>
		</s:else>
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<br /><h3 style="white-space: normal;"><s:property value="p.title"/></h3>
			<p><strong>概要</strong></p><p><s:property value="p.description"/></p>
			<p><strong>ゴール</strong></p><p><s:property value="p.goal"/></p>
			<p><strong><s:date name="p.target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="p.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</li>
		</ul>
		<div data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>子タスク追加</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="p.project_id" />" />
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
							<a onClick="Piece.add(<s:property value="p.id" />)" class="ui-btn ui-corner-all">追加</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
		<h3>子タスクリスト</h3>
		<ul data-role="listview" class="piece-list" >
		<s:iterator value="pis">
		<li>
			<a href="/piece/<s:property value="id" />">
			<p><s:property value="title"/></p>
			</a>
		</li>
		</s:iterator>
		</ul>
	</div>
</div>
</body>
</html>