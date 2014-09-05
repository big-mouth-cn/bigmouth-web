(function($) {
	
	'use strict';
	
	var photo = {
		init : function() {
			this.initUploadify();
			this.addEventListener();
			this.thumbnailReset();
		},
		
		addEventListener : function() {
			$('.photo').find('.delete').each(function() {
				$(this).click(function(e) {
					var primary = $(e.target).data('primary');
					Table.removeAsyn(primary, window.baseUrl + '/manage/photo!delete.shtml', function() {
						$('.photo[data-primary="' + primary + '"]').remove();
					});
				});
			});
		},
		
		initUploadify : function() {
			$('#btnSelect').uploadify({
				swf : 				window.baseUrl + '/js/uploadify/uploadify.swf?r=' + new Date().getTime(),
				formData :			{
					albumId : $('#albumId').val()
				},
				uploader : 			window.baseUrl + '/manage/photo!upload.shtml', //;jsessionid=' + jsessionid,
				cancelImg : 		window.baseUrl + '/js/uploadify/uploadify-cancel.png',
				fileObjName : 		'img',
				width :				82,
				height :			34,
				buttonText : 		'选择照片',
				auto : 				false,
				multi : 			true,
				fileSizeLimit : 	'20MB',
				fileTypeDesc : 		'图片文件',
				fileTypeExts : 		'*.jpg; *.jpeg; *.png; *.gif',
				queueID :			"upload-queue",
				onSelect : function(file) {
		        },
				onUploadSuccess:	function(file, data, response) {
					console.log(data);
				}
			});
			$('#btnSelect').addClass('btn btn-default');
			$('#btnStartUpload').click(function() {
				$('#btnSelect').uploadify('upload', '*');
			});
		}
	};
	
	$(function() {
		Menu.active(2);
		photo.init();
	});
	
})(jQuery);