$(function() {
	var pres = $('pre');

	var Code = {
		load: function(pre) {
			var b = window.baseUrl;
			if (pre.hasClass('js')) {
				this.js(b + '/js/syntax/scripts/shBrushJScript.js');
			}
			if (pre.hasClass('xml')) {
				this.js(b + '/js/syntax/scripts/shBrushXml.js');
			}
			if (pre.hasClass('css')) {
				this.js(b + '/js/syntax/scripts/shBrushCss.js');
			}
			if (pre.hasClass('java')) {
				this.js(b + '/js/syntax/scripts/shBrushJava.js');
			}
			if (pre.hasClass('powershell')) {
				this.js(b + '/js/syntax/scripts/shBrushPowerShell.js');
			}
		},
		js: function(file) { this.loadjscssfile(file, 'js'); },
		css: function(file) { this.loadjscssfile(file, 'css'); },
		loadjscssfile : function(filename, filetype) {
			var fileref = null;
			if (filetype == "js") {
				fileref = document.createElement('script');
				fileref.setAttribute("type", "text/javascript");
				fileref.setAttribute("src", filename);
			} 
			else if (filetype == "css") {
				fileref = document.createElement('link');
				fileref.setAttribute("rel", "stylesheet");
				fileref.setAttribute("type", "text/css");
				fileref.setAttribute("href", filename);
			}
			if (typeof fileref != "undefined") {
				document.getElementsByTagName("head")[0].appendChild(fileref);
			}
		}
	};
	
	SyntaxHighlighter.all();

	pres.each(function() {
		var pre = $(this);
		Code.load(pre);
	});
	
});