/**
 * 
 * Base64 encode / decode http://www.webtoolkit.info/
 * 
 */

var Export = {


	output : function(_url) {

		if (!Ext.fly('frmDummy')) {

			var frm = document.createElement('form');

			frm.id = 'frmDummy';
			frm.name = id;
			frm.className = 'x-hidden';
			document.body.appendChild(frm);
		}
		Ext.Ajax.request( {
			url : _url,
			method : 'POST',
			form : Ext.fly('frmDummy'),
			callback : function(o, s, r) {
			},
			isUpload : true,
			params : {}
		});
	}

}