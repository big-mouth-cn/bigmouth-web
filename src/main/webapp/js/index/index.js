(function($) {
	'use strict';
	
	$(function() {
		Menu.active(0);
		
		var attr = Cookie.read();
		if (attr && attr.name) {
			$('#name').html(attr.name + '，');
		}
	});
	
})(jQuery);