<%@page contentType="text/html; charset=UTF-8"
	pageEncoding="Windows-31J"%>
<%@taglib uri="/struts-tags" prefix="s"%>
<!DOCTYPE html>
<html>
<head>
	<link rel="shortcut icon" href="/img/favicon.ico" />
	<meta charset="utf-8">
	<meta name="viewport" content="width=device-width, initial-scale=1">
	<title>�w���v</title>
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
		<h1>�w���v</h1>
	</div><!-- /header -->
	<div class="ui-content" role="main">
		<div id="index-friend-request-list" class="ui-content">
	    	<ul data-role="listview" class="pin-list" data-filter="true" data-filter-placeholder="" data-filter-theme="a" data-inset="true">
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-home"></i></span>�z�[��</li>
				<li><p>�K�ꂽ���̂���v���W�F�N�g�̖��ǃ`���b�g�̒ʒm�A�t�����h�\���̒ʒm�A�t�����h���X�g�̊m�F���o���܂�</p></li>
				<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-th-large"></i></span>�v���W�F�N�g</li>
				<li>
					<h3><small>�v���W�F�N�g���X�g</small></h3>
					<p>��ʌ��J�A�܂��̓����o�[�ɏ������Ă���v���W�F�N�g�����X�g����Ă��܂��B���C�y�ɉ{�����ă`���b�g�ňӌ�������A�����ȂƎv���������Ɂu�����ˁI�v�����ĎQ�����Ă݂Ă��������B�ǂ̃v���W�F�N�g�ł������o�[�����Ȃ������}���܂��I</p>
					<h3><small>�}�C�v���W�F�N�g</small></h3>
					<p>������p�̔���J�ݒ�v���W�F�N�g�ł��B�g�����̗��K��������A�`���b�g�@�\�Ń����A�^�X�N�@�\��ToDo�Ǘ��Ȃǂ����R�ɂ��g�����������B���J�ݒ�ɕύX����Ƃ��͂悭�������ĉ������A�񐄏��ł��B</p></li>
				<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-search"></i></span>�T��</li>
				<li><p>����`�����ė~�����v���W�F�N�g����̃^�X�N�������ł��܂��B�����Ō����ł���^�X�N�݂͂Ȃ���̎Q����S�҂��ɂ��Ă��܂��I��������������^�X�N�������������ǐi�ߕ����悭�킩��Ȃ��Ȃǋ^�₪�������炨�C�y�Ƀ^�X�N�`���b�g�Ŏ��₵�Ă݂Ă�������</p></li>
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-check-square-o"></i></span>�^�X�N�ɂ���</li>
				<li>
					<h3><small><i class="fa fa-plus-circle"></i>����</small></h3>
					<p>�v���W�F�N�g�g�b�v��[Task]�^�u�ɂ���u�^�X�N�����́v�Ə����Ă���t�H�[���Ƀ^�X�N������͂���<i class="fa fa-plus-circle"></i>�{�^���������ƃ^�X�N���ǉ�����܂��B�l�Ŏg���ꍇ�͂��̂܂܃^�X�N�������ŉ^�p���Ă��\���܂��񂪁A������t�����胁���o�[�Ƌ��L�������ꍇ�̓^�X�N�ڍ׉�ʂ̐ݒ肩��ҏW�����܂��傤�B</p>
					<h3><small><i class="fa fa-check-square-o"></i>�`�F�b�N</small></h3>
					<p>���݂̓^�X�N�쐬�҂̂݃`�F�b�N�ł��܂��B�v���W�F�N�g�g�b�v��[Task]�^�u�������ĕ\�������^�X�N���̍��ɕ\������Ă���<i class="fa fa-square-o"></i>�l�p���^�b�v�����<i class="fa fa-check-square-o"></i>���̂悤�Ɂu�`�F�b�N�v�^�X�N�����ƂȂ�܂��B������x�����ƍēx��������ԂɂȂ�܂��B</p>
					<h3><small><i class="fa fa-info-circle"></i>�ڍ׉��</small></h3>
					<p>�v���W�F�N�g�g�b�v��[Task]�^�u�������ĕ\�������^�X�N�����^�b�v����Ƃ��ꂼ��̏ڍ׉�ʂֈړ����܂��B</p>
					<h3><small><i class="fa fa-tag"></i>�^�O</small></h3>
					<p>�ڍ׉�ʂ�[�^�O�ǉ�]�Ń^�X�N���C���[�W����L�[���[�h����͂�<i class="fa fa-plus-circle"></i>�������ƃ^�O��ǉ��ł��܂��B���͓r���ŉ��Ɋ����^�O��₪�o���ꍇ�͂Ȃ�ׂ����̒�����I������ƃ^�X�N�̃C���[�W���킩��₷���Ȃ�܂��B</p>
					<h3><small><i class="fa fa-cog"></i>�ݒ�</small></h3>
					<p>�^�X�N�̏ڍ׉�ʂŉE��̎��Ԃ���ݒ胁�j���[���o�������o���܂��B</p>
					<h3><small><i class="fa fa-pencil"></i>�ҏW</small></h3>
					<p>�^�X�N�쐬�҂̂݁A�^�C�g���A�T�v�A�S�[���A�����\�����ҏW�ł��܂��B</p>
					<h3><small><i class="fa fa-times-circle"></i>�폜</small></h3>
					<p>�^�X�N���폜���܂��B���݂͕����ł��Ȃ��̂ł悭�������̏�폜���Ă��������B</p>
					<h3><small><i class="fa fa-users"></i>���J/����J</small></h3>
					<p>�^�X�N����ʌ��J���čL���d�����˗����鎖���o���܂��B�ڍׂ́u�^�X�N���J�̃K�C�h���C���v�����Q�Ƃ��������B</p>
				</li>
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-check-square-o"></i></span>�^�X�N���J�̃K�C�h���C��</li>
				<li>
					<h3><small>�T�v</small></h3>
					<p>�^�X�N�����J�ݒ�ɂ����ꍇ�A�����̃��[�U�[�Ɏd�����˗����鎖���o���܂��B���ۂɃ��[�U�[�Ɏd�������Ē����ɂ͂������̔錍������܂��B�����ł͂��̔錍�����Љ�܂��B</p>
					<h3><small>1.�v���W�F�N�g�̌��J����������</small></h3>
					<p>�v���W�F�N�g�͔���J�ݒ�ł����ꂼ��̃^�X�N���ʂɌ��J���鎖�͏o���܂��B
					�������A����J�ݒ�ɂ���Ɓu�T���v����^�X�N���������Ă��郆�[�U�[�ɂ̓v���W�F�N�g�̊T�v�Ȃǂ̏�񂪌����܂���B
					����������A����W�Ȃǂ̍��x�ȃ^�X�N���˗��������ꍇ�ɂ̓v���W�F�N�g��񂪂���ƃ��[�U�[�ɂƂ��ē��e���`���₷���̂ŉ��傪�����邩������܂���B
					�˗��ɑ΂��ĉ��傪�����ꍇ�̓v���W�F�N�g�̌��J�ݒ�����������������B
					</p>
					<h3><small>2.�^�O��t����</small></h3>
					<p>�^�X�N�̃C���[�W�ɂ������^�O��t���鎖�Ō�������₷���Ȃ�܂��B�܂��d���������ŕK�v�ȃX�L���A�d���̃J�e�S���Ȃǂ�����ƃ��[�U�[�Ɏd���̓��e���`���₷���Ȃ�܂��B</p>
					<h3><small>3.�^�C�g���̏�����</small></h3>
					<p>���̃^�X�N�̓��e�𕪂���₷���\�������薼�����܂��傤�B
					�Ȃ�ׂ��S�p32�����ȓ��ŋ�̓I�ɂȂ�̎d���Ȃ̂��킩��悤�ȃL�[���[�h������܂��傤�B
					���e�́A5�v3�g���ӎ����đg�ݍ��킹�ď����܂��BWhen	���i�[���E�����j
					Where	�ǂ���
					Who	�N��
					Why	�Ȃ�
					What	����
					How	�ǂ̂悤�Ɂq��@�r
					How many	�����q���ʁr�B
					�Ⴆ�΁u�����̏��i�������͍쐬�v�u�����̃A���P�[�g�ɂ��񓚂��������v(WHAT&HOW)
					�u������Џ��̂P�O���ړ��́v(WHAT&HOWMANY&HOW)�ȂǓ`���悤�ɂ��܂��傤�B
					</p>
					<h3><small>4.�T�v�̏�����</small></h3>
					<p>5�v3�g���ӎ����ď����܂��傤�B�Ȃ����̎d�����K�v�ŉ����ǂ̂悤�ɂ������ė~�����̂��𖾊m�Ɉ˗�����ƃ��[�U�[�����債�₷���Ȃ�܂��B</p>
					<h3><small>5.�S�[���̏�����</small></h3>
					<p>����̎d���A�f�[�^�̌`���A���e���@�Ȃǂ���̓I�ɃS�[���������Đ��ʕ����Ȃ�Ȃ̂��킩��悤�ɂ��܂��傤�B
					�Ⴆ�΁uData�ɂ���No10�̃f�[�^���R�s�[����[ ]�̊Ԃɉ𓚂����L���̏�u�f�[�^���M�v���炲��o���������B�v
					�uHTML,CSS,javaScript���ꖇ�̃R�[�h�ɂ��āu�f�[�^���M�v���炲��o���������B�v
					</p>
					<h3><small>6.�����̐ݒ�</small></h3>
					<p>���J����Q�T�Ԓ��x�͗]�T�������Ċ�����ݒ肵�܂��傤�B�܂������������ƃ��[�U�[�������肵�Ă����̂��킩��܂���̂ŕK���ݒ肵�܂��傤�B</p>
					<h3><small>7.�⑫�̓`���b�g��</small></h3>
					<p>�T�v�ȂǂŐ���������Ȃ����̓`���b�g�ŕ⑫���܂��傤�B�֘A���ւ̃����NURL�Ȃǂ�Pin�����鎖�ŏ��������₷���Ȃ�܂��B</p>
				</li>
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
		            	<span class="nav-icon-text">�z�[��</span>
	            	</a>
	            </li>
	            <li class="navbar-button"><a href="/projectlist" data-ajax="false" data-theme="b"><i class="fa fa-th-large fa-nav-icon"></i><span class="nav-icon-text">�v���W�F�N�g</span></a></li>
				<li class="navbar-button"><a href="/task/" data-ajax="false" data-theme="b"><i class="fa fa-search fa-nav-icon"></i><span class="nav-icon-text">�T��</span></a></li>
 	        </ul>
	    </div><!-- /navbar -->
	</div><!-- /footer -->
	<div data-role="panel" data-position-fixed="true" data-display="push" data-theme="a" id="nav-panel-friend-list">
		<ul data-role="listview">
            <li data-icon="arrow-r"><a href="#" data-rel="close">����</a></li>
            <s:iterator value="fs">
            <li><span class="user-icon"><i class="fa fa-user"></i></span><s:property value="friend_name" /></li>
            </s:iterator>
		</ul>
	</div>
</body>
</html>