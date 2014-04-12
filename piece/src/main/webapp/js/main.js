var Main = {
	loading : function(display){
		if(display=="show"){
			$.mobile.loading( "show", {
	            text: "",
	            textVisible: false,
	            theme: $.mobile.loader.prototype.options.theme,
	            textonly: false,
	            html: ""
	    });
		} else if(display=="hide"){
			$.mobile.loading( "hide" );
		}
	}	
};
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
		Main.loading("show");
		return defer.promise().done(function(data) {
			if(data.id>0){
				//TODO display?
			}
			Main.loading("hide");
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
		Main.loading("show");
		return defer.promise().done(function(data) {
			if(data.id>0){
				$('.piece-list')
				.prepend("<li id='piece"+data.id+"' class='ui-li-piece ui-first-child'><span class='ui-li-piece-check' id='check"+data.id+"'><a onclick='Piece.check("+data.id+",0)' class='ui-link'><i class='fa fa-square-o'></i></a></span><a data-ajax='false' href='/piece/"+data.id+"' class='ui-btn ui-btn-icon-right ui-icon-carat-r'><p class='ul-li-piece-title'>"+data.title+"</p></a></li>");
				$( "#piece-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
			}
			Main.loading("hide");
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
		Main.loading("show");
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
			Main.loading("hide");
		});
	},
	display: function(piece_id,display){
		var defer = $.Deferred();
		$.ajax({
			url : "/api/piecedisplay",
			data : {
				i : piece_id,
				d : display
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		Main.loading("show");
		return defer.promise().done(function(data) {
			if(data.id>0){
				if(data.project_id>0){
					location.href="/project/"+data.project_id;
				}else{
					location.href="/projectlist";
				}
			}
			Main.loading("hide");
		});
	},
	add_tag : function(tag_id,piece_id) {
		var defer = $.Deferred();
		$.ajax({
			url : "/api/piecetagregi",
			data : {
				ti : tag_id,
				pci : piece_id
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		Main.loading("show");
		return defer.promise().done(function(data) {
			if(data.id>0){
				 $('.tag-list')
				.append(
				 "<li id='pt"+data.piece_tag_id+"' class='ui-li-has-alt ui-last-child'>"
				 +"<a class='ui-btn ui-mini'><h2>"+data.name+"</h2></a>"
				 +"<a onclick='Piece.del_tag("+data.piece_tag_id+", "+data.id+", "+piece_id+")' class='ui-btn ui-mini ui-btn-icon-notext ui-icon-delete ui-btn-a' title='delete'></a></li>"
				);
			}
			$("a.ui-input-clear").trigger("click");
			Main.loading("hide");
		});
	},
	add_tag_none_html : function(tag_id,piece_id) {
		var defer = $.Deferred();
		$.ajax({
			url : "/api/piecetagregi",
			data : {
				ti : tag_id,
				pci : piece_id
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		Main.loading("show");
		return defer.promise().done(function(data) {
			Main.loading("hide");
		});
	},
	del_tag : function(piece_tag_id,tag_id,piece_id) {
		var defer = $.Deferred();
		$.ajax({
			url : "/api/piecetagdel",
			data : {
				i : piece_tag_id,
				ti : tag_id,
				pci : piece_id
			},
			dataType : 'json',
			success : defer.resolve,
			error : defer.reject
		});
		Main.loading("show");
		return defer.promise().done(function(data) {
			if(data){
				$("#pt"+piece_tag_id).empty();
				/*
				 $('.piece-list')
				.append("<li id='piece"+data.id+"' class='ui-li-piece ui-first-child'><span class='ui-li-piece-check' id='check"+data.id+"'><a onclick='Piece.check("+data.id+",0)' class='ui-link'><i class='fa fa-square-o'></i></a></span><a data-ajax='false' href='/piece/"+data.id+"' class='ui-btn ui-btn-icon-right ui-icon-carat-r'><p class='ul-li-piece-title'>"+data.title+"</p></a></li>");
				$( "#piece-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
				*/
			}
			Main.loading("hide");
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
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.product-list')
					.append("<li><a data-ajax='false' class='ui-btn ui-btn-icon-right ui-icon-carat-r' href='/producttext/"+data.id+"'><p>"+data.name+"</p></a></li>"
							);
					$( "#data-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
				}
				Main.loading("hide");
			});
		}
	};
var Chat = {
		add : function() {
			var defer = $.Deferred();
			var pid = $("#piece-pid-input").val();
			var pcid = $("#piece-pcid-input").val();
			var uid = $("#piece-uid-input").val();
			var text = $("#piece-text-input").val();
			$.ajax({
				url : "/api/chatregi",
				data : {
					pri : pid,
					pci : pcid,
					u : uid,
					t : text
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.chat-list')
					.prepend("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p>"
							+"<p class='ui-li-action'><span id='pin"+data.id+"'><a onclick='Chat.pin("+data.id+","+data.id+")' class='ui-link'>"
							+"<i class='fa fa-thumb-tack'></i></a></span>"
							+"<a onclick=\"Chat.count("+data.id+","+data.user_id+",1,0,'#good"+data.id+"')\" class='ui-link'><i class='fa fa-thumbs-o-up'></i>(<span id='good"+data.id+"'>0</span>)</a>"
							+"<a onclick=\"Chat.count("+data.id+","+data.user_id+",0,1,'#bad"+data.id+"')\" class='ui-link'><i class='fa fa-thumbs-o-down'></i>(<span id='bad"+data.id+"'>0</span>)</a></p>"
					);
					$( "#chat-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
				}
				Main.loading("hide");
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
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.pin-list')
					.append("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p></li>"
							);
					$("#pin"+id).html("<i class='fa fa-thumb-tack'></i>");
				}
				Main.loading("hide");
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
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.regi){
					if (good > 0) {
						$(hid).text(data.good);
					} else if (bad > 0) {
						$(hid).text(data.bad);
					}
				}
				Main.loading("hide");
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
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					$('.productchat-list')
					.append("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p>"
							+"</li>"
							);
					$( "#productchat-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
				}
				Main.loading("hide");
			});
		}
};
var Tag = {
		add : function(target,id) {
			var defer = $.Deferred();
			var name = $("#tag-name-input form input").val()||$("#tag-name-input").val();
			var description = $("#tag-des-input").val();
			$.ajax({
				url : "/api/tagregi",
				data : {
					n : name,
					des : description
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					if(target=="piece"){
						Piece.add_tag(data.id, id);
					}
					//$( "#tag-input-collapsibleset" ).children( ":last" ).collapsible( "collapse" );
					//$('#tid-input-menu').append("<li data-option-index='0' data-icon='false' class='ui-first-child' role='option' aria-selected='false'><a href='#' tabindex='-1' class='ui-btn ui-checkbox-off ui-btn-icon-right'>"+data.name+"</a></li>");
				}
				Main.loading("hide");
			});
		},
		display: function(tag_id,display){
			var defer = $.Deferred();
			$.ajax({
				url : "/api/tagdisplay",
				data : {
					i : tag_id,
					d : display
				},
				dataType : 'json',
				success : defer.resolve,
				error : defer.reject
			});
			Main.loading("show");
			return defer.promise().done(function(data) {
				if(data.id>0){
					lcation.reload();
				}
				Main.loading("hide");
			});
		}
};