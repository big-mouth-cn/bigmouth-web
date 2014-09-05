(function($) {
	
	'use strict';
	
	var settings = {};
	
	var commentContainer = $('#comment-container'),
		commentTotal = $('.commentTotal span'),
		parentId = null;
	
	var editor = $('#content');
	var len = 0;
	
	$.comment = {
		TargetType : { BLOG : 'BLOG', PHOTO : 'PHOTO' },
		defaults : {
			targetId : '',
			target : ''
		},
		init : function(options) {
			settings = $.extend($.comment.defaults, options);
			this.addEventListener();
			this.initSession();
			this.initEditor();
		},
		
		initSession: function() {
			var exist = false;
			var name = '', email = '', headUrl = '';
			// Getting session from Cookie
			var cookie = Cookie.read();
			if (cookie && cookie.name && cookie.headUrl) {
				exist = true;
				name = cookie.name;
				email = cookie.email;
				headUrl = cookie.headUrl;
			}
			// Getting session from Session
			else if (nickname && avatar) {
				exist = true;
				name = nickname;
				email = '';
				headUrl = avatar;
				$.comment.writtenCookie(name, email, headUrl);
			}
			else {
				$('#btnSubmitComment').hide();
				$('#btnSubmitComment').after('<span>发表评论前请先登录，您可以使用 </span>');
				$('#welcome').remove();
			}
			if (exist) {
				$('#name').val(name);
				$('#email').val(email);
				$('#headUrl').attr('src', headUrl);
				$('#qqLoginBtn').remove();
				$('#welcome .remind').text(DateUtils.getRemind());
				$('#welcome .name').text(name);
			}
		},
		
		initEditor : function() {
			KindEditor.ready(function(K) {
				editor = K.create('#content', {
					cssPath : [window.baseUrl + '/js/kindeditor/plugins/code/prettify.css'],
					items : ['emoticons'],
					afterCreate : function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
						});
					},
					afterChange : function() {
						len = this.count('text');
					}
				});
			});
		},
		
		addEventListener : function() {
			$('#btnSubmitComment').click(function(e) {
				e.preventDefault();
				$.comment.append();
			});
		},
		
		load : function() {
			var url = window.baseUrl + '/c.shtml';
			var param = {
				targetId : settings.targetId,
				target : settings.target
			};
			var success = function(json) {
				if (Response.ok(json)) {
					$.comment.renderList(json.Data);
				}
				else {
				}
			};
			Ajax.get(url, param, success);
		},
		
		append : function() {
			if (len == 0) {
				editor.focus();
				return;
			}
			var url = window.baseUrl + '/c!append.shtml';
			var name = Tags.val('#name');
			var email = Tags.val('#email');
			var headUrl = $('#headUrl').attr('src');
			var param = {
				targetId : settings.targetId,
				target : settings.target,
				name : name,
				content : editor.html(),
				email : email,
				headUrl : headUrl,
				parentId : parentId
			};
			var success = function(json) {
				if (Response.ok(json)) {
					$.comment.writtenCookie(name, email, headUrl);
					$.comment.reset();
					$.comment.removeEmptyElement();
					$.comment.renderCommentItem(json.Data);
				}
				else {
					Alert.error(json.Message);
				}
			};
			Ajax.post(url, param, success);
		},
		
		writtenCookie : function(name, email, headUrl) {
			var obj = 
			{
				name : name,
				email : email,
				headUrl : headUrl
			};
			Cookie.write(obj);
		},
		
		reset: function() {
			editor.html('');
		},
		
		getCommentTotalValue : function() {
			var val = commentTotal.text();
			return parseInt(val);
		},
		
		renderCommentTotal : function(value) {
			commentTotal.text(value);
		},
		
		renderList : function(data) {
			if (CollectionUtils.isEmpty(data)) {
				commentTotal.text(0);
				commentContainer.append($('<div class="empty text-center">Oh~ho, 还没有任何人进行评论……赶快抢个沙发吧。</div>'));
				return;
			}
			var len = data.length;
			
			for (var i = 0; i < len; i++) {
				$.comment.renderCommentItem(data[i]);
			}
		},
		
		renderCommentItem : function(comment) {
			$.comment.renderCommentULIfNotExists();
			
			var li = $('<li class="media">');
			li.attr('data-primary', comment.id);
			
			var head = $('<a class="pull-left" href="#"><img class="media-object thumbnail" src="' + comment.headUrl + '"></a>');
			var body = $('<div class="media-body">');
			var name = $('<h4 class="media-heading">');
			name.html(comment.name + '&nbsp;');
			var time = $('<small>');
			time.text(comment.createTime);
			var content = $('<p>');
			content.html(comment.content);
			
			li.append(head);
			li.append(body);
			body.append(name);
			name.append(time);
			body.append(content);
			
			$('#comments').append(li);
			li.fadeIn();
			
			var total = $.comment.getCommentTotalValue();
			$.comment.renderCommentTotal(total+1);
		},
		
		renderCommentULIfNotExists : function() {
			var ul = $('#comments').first();
			if (ul.length == 0) {
				commentContainer.append($('<ul id="comments" class="media-list">'));
			}
		},
		
		removeEmptyElement : function() {
			commentContainer.find('.empty').remove();
		}
	};
	
})(jQuery);