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
	    	<ul data-role="listview" class="pin-list" data-filter="true" data-filter-placeholder="" data-filter-theme="a" data-inset="true">
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-home"></i></span>ホーム</li>
				<li><p>訪れた事のあるプロジェクトの未読チャットの通知、フレンド申請の通知、フレンドリストの確認が出来ます</p></li>
				<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-th-large"></i></span>プロジェクト</li>
				<li>
					<h3><small>プロジェクトリスト</small></h3>
					<p>一般公開、またはメンバーに所属しているプロジェクトがリストされています。お気軽に閲覧してチャットで意見したり、いいなと思った発言に「いいね！」をして参加してみてください。どのプロジェクトでもメンバーがあなたを歓迎します！</p>
					<h3><small>マイプロジェクト</small></h3>
					<p>自分専用の非公開設定プロジェクトです。使い方の練習をしたり、チャット機能でメモ、タスク機能でToDo管理などご自由にお使いください。公開設定に変更するときはよく検討して下さい、非推奨です。</p></li>
				<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-search"></i></span>探す</li>
				<li><p>お手伝いして欲しいプロジェクトからのタスクが検索できます。ここで検索できるタスクはみなさんの参加を心待ちにしています！もし興味があるタスクが見つかったけど進め方がよくわからないなど疑問があったらお気軽にタスクチャットで質問してみてください</p></li>
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-check-square-o"></i></span>タスクについて</li>
				<li>
					<h3><small><i class="fa fa-plus-circle"></i>作り方</small></h3>
					<p>プロジェクトトップで[Task]タブにある「タスク名入力」と書いてあるフォームにタスク名を入力して<i class="fa fa-plus-circle"></i>ボタンを押すとタスクが追加されます。個人で使う場合はこのままタスク名だけで運用しても構いませんが、期限を付けたりメンバーと共有したい場合はタスク詳細画面の設定から編集をしましょう。</p>
					<h3><small><i class="fa fa-check-square-o"></i>チェック</small></h3>
					<p>現在はタスク作成者のみチェックできます。プロジェクトトップの[Task]タブを押して表示されるタスク名の左に表示されている<i class="fa fa-square-o"></i>四角をタップすると<i class="fa fa-check-square-o"></i>このように「チェック」タスク完了となります。もう一度押すと再度未完了状態になります。</p>
					<h3><small><i class="fa fa-info-circle"></i>詳細画面</small></h3>
					<p>プロジェクトトップの[Task]タブを押して表示されるタスク名をタップするとそれぞれの詳細画面へ移動します。</p>
					<h3><small><i class="fa fa-tag"></i>タグ</small></h3>
					<p>詳細画面の[タグ追加]でタスクをイメージするキーワードを入力し<i class="fa fa-plus-circle"></i>を押すとタグを追加できます。入力途中で下に既存タグ候補が出た場合はなるべく候補の中から選択するとタスクのイメージがわかりやすくなります。</p>
					<h3><small><i class="fa fa-cog"></i>設定</small></h3>
					<p>タスクの詳細画面で右上の歯車から設定メニューを出す事が出来ます。</p>
					<h3><small><i class="fa fa-pencil"></i>編集</small></h3>
					<p>タスク作成者のみ、タイトル、概要、ゴール、完了予定日を編集できます。</p>
					<h3><small><i class="fa fa-times-circle"></i>削除</small></h3>
					<p>タスクを削除します。現在は復元できないのでよくご検討の上削除してください。</p>
					<h3><small><i class="fa fa-users"></i>公開/非公開</small></h3>
					<p>タスクを一般公開して広く仕事を依頼する事が出来ます。詳細は「タスク公開のガイドライン」をご参照ください。</p>
				</li>
	    		<li data-role="list-divider"><span class="menu-list-icon"><i class="fa fa-check-square-o"></i></span>タスク公開のガイドライン</li>
				<li>
					<h3><small>概要</small></h3>
					<p>タスクを公開設定にした場合、多くのユーザーに仕事を依頼する事が出来ます。実際にユーザーに仕事をして頂くにはいくつかの秘訣があります。ここではその秘訣をご紹介します。</p>
					<h3><small>1.プロジェクトの公開を検討する</small></h3>
					<p>プロジェクトは非公開設定でもそれぞれのタスクを個別に公開する事は出来ます。
					しかし、非公開設定にすると「探す」からタスクを検索してくるユーザーにはプロジェクトの概要などの情報が見えません。
					競合調査や、企画募集などの高度なタスクを依頼したい場合にはプロジェクト情報があるとユーザーにとって内容が伝わりやすいので応募が増えるかもしれません。
					依頼に対して応募が無い場合はプロジェクトの公開設定をご検討ください。
					</p>
					<h3><small>2.タグを付ける</small></h3>
					<p>タスクのイメージにあったタグを付ける事で検索されやすくなります。また仕事をする上で必要なスキル、仕事のカテゴリなどを入れるとユーザーに仕事の内容が伝わりやすくなります。</p>
					<h3><small>3.タイトルの書き方</small></h3>
					<p>そのタスクの内容を分かりやすく表現した題名をつけましょう。
					なるべく全角32文字以内で具体的になんの仕事なのかわかるようなキーワードをいれましょう。
					内容は、5Ｗ3Ｈを意識して組み合わせて書きます。When	いつ（納期・期限）
					Where	どこで
					Who	誰が
					Why	なぜ
					What	何を
					How	どのように〈手法〉
					How many	いくつ〈分量〉。
					例えば「○○の商品説明文章作成」「○○のアンケートにご回答ください」(WHAT&HOW)
					「競合会社情報の１０項目入力」(WHAT&HOWMANY&HOW)など伝わるようにしましょう。
					</p>
					<h3><small>4.概要の書き方</small></h3>
					<p>5Ｗ3Ｈを意識して書きましょう。なぜこの仕事が必要で何をどのようにいくつして欲しいのかを明確に依頼するとユーザーが応募しやすくなります。</p>
					<h3><small>5.ゴールの書き方</small></h3>
					<p>応募の仕方、データの形式、投稿方法などを具体的にゴールだけ見て成果物がなんなのかわかるようにしましょう。
					例えば「DataにあるNo10のデータをコピーして[ ]の間に解答をご記入の上「データ送信」からご提出ください。」
					「HTML,CSS,javaScriptを一枚のコードにして「データ送信」からご提出ください。」
					</p>
					<h3><small>6.期限の設定</small></h3>
					<p>公開から２週間程度は余裕を持って期限を設定しましょう。また期限が無いとユーザーがいつ着手していいのかわかりませんので必ず設定しましょう。</p>
					<h3><small>7.補足はチャットで</small></h3>
					<p>概要などで説明しきれない情報はチャットで補足しましょう。関連情報へのリンクURLなどはPinをする事で情報を見つけやすくなります。</p>
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