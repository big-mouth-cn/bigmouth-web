(function($) {
	'use strict';
	
	var blog = {
		init : function() {
			Menu.active(1);
			this.initEditor();
		},
		initEditor : function() {
			KindEditor.ready(function(K) {
				var editor = K.create('#content', {
					cssPath : [window.baseUrl + '/js/kindeditor/plugins/code/prettify.css'],
					uploadJson : window.baseUrl + '/manage/file!upload.shtml',
					allowFileManager : false,
					allowFlashUpload: false,
					allowMediaUpload: false,
					afterCreate : function() {
						var self = this;
						K.ctrl(document, 13, function() {
							self.sync();
							//document.forms['example'].submit();
						});
						K.ctrl(self.edit.doc, 13, function() {
							self.sync();
							//document.forms['example'].submit();
						});
					}
				});
			});
		}
	};
	
	$(function() {
		Menu.active(1);
		blog.init();
	});
	
})(jQuery);