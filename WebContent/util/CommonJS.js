Ext.namespace('Ext.vms');

Ext.define('Ext.vms.CommonJS', 
{

		//弹出窗体
		createPopupWindow : function(_title) {

			// var win = new top.Ext.Window({

			// 		title:_title,
			// 		width:500,
			// 		height:400,
			// 		plain:true



			// });

			// win.show();
//, toolbar=no, menubar=no, scrollbars=no, resizable=no,location=yes, status=no, alwaysRaised=yes

			//window.open('popup/dispatch.html', 'test' ,	'height=600, width=800, top=50, left=200, location=no');
			window.showModalDialog('','window','status: no;location: no;');
			window.opener=null;
   			window.open("","_self");

		}


});
