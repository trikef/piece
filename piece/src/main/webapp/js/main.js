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
				.append("<li><a class='ui-btn ui-btn-icon-right ui-icon-carat-r' href='/piece/"+data.id+"'><p>"+data.title+"</p></a></li>"
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
					.append("<li class='ui-li-static ui-body-inherit ui-last-child'><p class='ui-li-name'><strong>"+data.name+"</strong></p><p class='ui-li-text'>"+data.text+"</p><p class='ui-li-date'><strong>"+data.created_at_str+"</strong></p>"
							+"<p class='ui-li-action'><a onClick='Chat.pin("+data.id+","+data.id+")' class='ui-btn ui-shadow ui-corner-all ui-icon-star ui-btn-icon-notext ui-btn-inline'>action</a></p></li>"
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
				}
			});
		}
	};