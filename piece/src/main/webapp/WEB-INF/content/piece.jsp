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
				<li><a href="/" data-ajax="false" class="ui-btn-active ui-state-persist" data-icon="home">�z�[��</a></li>
				<li><a href="/create" data-ajax="false" data-icon="plus">����</a></li>
				<li><a href="/mypage" data-ajax="false" data-icon="user">�}�C�y�[�W</a></li>
			</ul>
		</div>
		<h1>bit</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<h3><s:property value="name" />����</h3>
		<s:if test="pips.size()==0">
			<ul data-role="listview" class="piece-list" >
			<li>
				<a href="/project/<s:property value="p.project_id" />">
				<p>�v���W�F�N�g�ɖ߂�</p>
				</a>
			</li>
		</s:if>
		<s:else>
			<ul data-role="listview" class="piece-list" >
			<s:iterator value="pips">
			<li>
				<a href="/piece/<s:property value="id" />">
				<p><strong>�e�^�X�N</strong></p>
				<p><s:property value="title"/></p>
				</a>
			</li>
			</s:iterator>
			</ul>
		</s:else>
		<ul data-role="listview"  data-count-theme="b" data-inset="true">
			<li>
			<br /><h3 style="white-space: normal;"><s:property value="p.title"/></h3>
			<p><strong>�T�v</strong></p><p><s:property value="p.description"/></p>
			<p><strong>�S�[��</strong></p><p><s:property value="p.goal"/></p>
			<p><strong><s:date name="p.target_date" format="yyyy/MM/dd" /></strong></p>
			<p class="ui-li-aside"><strong><s:date name="p.created_at" format="yyyy/MM/dd hh:mm" /></strong></p>
			</li>
		</ul>
		<div data-role="collapsibleset" data-theme="a" data-content-theme="b">
		    <div data-role="collapsible">
		    <h2>�q�^�X�N�ǉ�</h2>
		        <ul data-role="listview" data-theme="a" data-divider-theme="b">
		            <li>
						<input type="hidden" name="pi" id="piece-pid-input" value="<s:property value="p.project_id" />" />
						<input type="hidden" name="ui" id="piece-uid-input" value="<s:property value="uid" />" />
						<div class="ui-field-contain">
							<label for="piece-title-input">�^�C�g��
							</label>
							<input type="text" name="t" id="piece-title-input" placeholder="" />
						</div>
						<div class="ui-field-contain">
							<label for="piece-description-input">����
							</label>
							<textarea cols="40" rows="10" name="d" id="piece-description-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
							<label for="piece-goal-input">�I������
							</label>
							<textarea cols="40" rows="10" name="g" id="piece-goal-input" placeholder=""></textarea>
						</div>
						<div class="ui-field-contain">
						    <label for="piece-targetdate-input">�����\���</label>
				     		<input type="date" name="td" id="piece-targetdate-input" placeholder="yyyy/MM/dd">
				     	</div>
						<div class="ui-field-contain">
							<a onClick="Piece.add(<s:property value="p.id" />)" class="ui-btn ui-corner-all">�ǉ�</a>
						</div>
		            </li>
		        </ul>
		    </div>
		</div>
		<h3>�q�^�X�N���X�g</h3>
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