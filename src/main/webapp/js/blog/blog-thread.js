(function($) {
	'use strict';
	
	var blog = {
		init : function() {
			$.comment.init({
				targetId : Tags.val('#id'),
				target : $.comment.TargetType.BLOG
			});
			$.comment.load();
		}
	};
	
	$(function() {
		Menu.active(1);
		blog.init();
	});
	
})(jQuery);