(function() {
	
	'use strict';
	
	var MAX_WIDTH = 250, MAX_HEIGHT = 160;
	
	var web = {
		init : function() {
			this.thumbnailResetSize();
		},
		
		thumbnailResetSize : function() {
			$('.photo img').each(function() {
				var w = $(this).data('width');
				var h = $(this).data('height');
				
				var wd = 0;
				var wh = 0;
				if (w > MAX_WIDTH) { // 宽大于高
					wd = ((MAX_WIDTH-w) / 2);
				}
				if (h > MAX_HEIGHT) {
					wh = -((h - MAX_HEIGHT) / 2);
				}
				$(this).css('margin', wh + 'px ' + wd + 'px');
			});
		}
	};
	
	$(function() {
		web.init();
	});
	
})(jQuery);