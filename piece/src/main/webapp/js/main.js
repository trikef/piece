var Project = {
	toggle_public : function(project_id){
		var defer = $.Deferred();
		$.ajax({
			url : "/api/projecttogglepublic",
			data : {
				i : project_id
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		return defer.promise().done(function(data) {
			if(data.id>0){
				//TODO display?
			}
		});
	}	
};
var Piece = {
	add : function(parent_id) {
		var defer = $.Deferred();
		var pid = $("#piece-pid-input").val();
		var uid = $("#piece-uid-input").val();
		var title = $("#piece-title-input").val();
		var des = $("#piece-description-input").val();
		var goal = $("#piece-goal-input").val();
		var targetdate = $("#piece-targetdate-input").val();
		$.ajax({
			url : "/pieceregi",
			data : {
				pai : parent_id,
				pi : pid,
				uid : uid,
				t : title,
				d : des,
				g : goal,
				td : targetdate
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		return defer.promise().done(function(data) {
			if(data.id>0){
				$('.piece-list')
//				.append("<li><a data-ajax='false' class='ui-btn ui-btn-icon-right ui-icon-carat-r' href='/piece/"+data.id+"'><p>"+data.title+"</p></a></li>"
//						);
				.append("<li id='piece"+data.id+"' class='ui-li-piece ui-first-child'><span class='ui-li-piece-check' id='check"+data.id+"'><a onclick='Piece.check("+data.id+",0)' class='ui-link'><i class='fa fa-square-o'></i></a></span><a data-ajax='false' href='/piece/"+data.id+"' class='ui-btn ui-btn-icon-right ui-icon-carat-r'><p class='ul-li-piece-title'>"+data.title+"</p></a></li>");
			}
		});
	},
	check: function(piece_id,status_id){
		var defer = $.Deferred();
		$.ajax({
			url : "/api/piececheck",
			data : {
				i : piece_id,
				s : status_id
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		return defer.promise().done(function(data) {
			if(data.id>0){
				var i_none = "fa-square-o";
				var i_check = "fa-check-square";
				var icon=i_none;
				var re_status=0;
				if(data.status_id==0){
					icon=i_check;
					re_status=1;
					$("#piece"+data.id).addClass("ui-li-piece-o");
				} else {
					$("#piece"+data.id).removeClass("ui-li-piece-o");
				}
				$('#check'+piece_id)
				.html("<a onClick='Piece.check("+data.id+","+re_status+")'><i class='fa "+icon+"'></i></a>"
						);
			}
		});
	}
};
var Product = {
		add_text : function(status_id) {
			var defer = $.Deferred();
			var pid = $("#product-pid-input").val();
			var uid = $("#product-uid-input").val();
			var data = $("#product-data-input").val();
			var comment = $("#product-comment-input").val();
			$.ajax({
				url : "/api/producttextregi",
				data : {
					pi : pid,
					ui : uid,
					d : data,
					c : comment
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.product-list')
					.append("<li><a data-ajax='false' class='ui-btn ui-btn-icon-right ui-icon-carat-r' href='/producttext/"+data.id+"'><p>"+data.name+"</p></a></li>"
							);
				}
			});
		}
	};
var Chat = {
		add : function() {
			var defer = $.Deferred();
			var pid = $("#piece-pid-input").val();
			var uid = $("#piece-uid-input").val();
			var text = $("#piece-text-input").val();
			$.ajax({
				url : "/api/chatregi",
				data : {
					p : pid,
					u : uid,
					t : text
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.chat-list')
					.prepend("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p>"
							+"<p class='ui-li-text-right'><a onClick='Chat.pin("+data.id+","+data.id+")'><i class='fa fa-thumb-tack'></i></a><i class='fa fa-thumbs-o-down'></i><i class='fa fa-thumbs-o-up'></i></p>"
					);
				}
			});
		},
		pin : function(id,priority) {
			var defer = $.Deferred();
			$.ajax({
				url : "/api/chatpinregi",
				data : {
					i : id,
					p : priority
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.pin-list')
					.append("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p></li>"
							);
					$("#pin"+id).html("<i class='fa fa-thumb-tack'></i>");
				}
			});
		},
		count : function(cid, uid, good, bad, hid) {
			var defer = $.Deferred();
			$.ajax({
				url : "/api/chatvalue",
				data : {
					i : cid,
					u : uid,
					g : good,
					b : bad
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			return defer.promise().done(function(data) {
				if(data.regi){
					if (good > 0) {
						$(hid).text(data.good);
					} else if (bad > 0) {
						$(hid).text(data.bad);
					}
				}
			});
		}
	};
var ProductChat = {
		add : function() {
			var defer = $.Deferred();
			var pid = $("#product-pid-input").val();
			var uid = $("#product-uid-input").val();
			var text = $("#product-text-input").val();
			var star = $("#product-star-input").val();
			$.ajax({
				url : "/api/productchatregi",
				data : {
					p : pid,
					u : uid,
					t : text,
					s : star
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.productchat-list')
					.append("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p>"
							+"</li>"
							);
				}
			});
		}
}
