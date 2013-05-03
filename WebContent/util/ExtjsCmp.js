/**
 * 
 * Base64 encode / decode http://www.webtoolkit.info/
 * 
 */

var ExtjsCmp = {

	createDsByDomainCode : function(_code) {
		var ds = Ext.create('Si.util.ComboxJsonStore', {});
		ds.proxy.url = '../services/billService/findAllDomain?type=' + _code;
		return ds;
	},
	createDsByUrl : function(_url) {
		var ds = Ext.create('Si.util.ComboxJsonStore', {});
		ds.proxy.url = _url;
		return ds;
	},
	createDsCountry : function() {
		var ds = Ext.create('Si.util.ComboxJsonStore', {});
		ds.proxy.url = "../services/selectitems/country";
		return ds;
	},

	createStore : function(_url) {

		var store = Ext.create('Ext.data.Store', {
			proxy : {
				type : 'ajax',
				url : _url,
				reader : {
					type : 'json',
					root : 'root'
				}
			},
			fields : [ {
				name : 'id',
				name : 'text'
			} ]
		});
		return store;
	},
	createCombo : function(_url) {
		var store = Ext.create('Ext.data.Store', {
			proxy : {
				type : 'ajax',
				url : _url,
				reader : {
					type : 'json',
					root : 'root'
				}
			},
			fields : [ {
				name : 'id',
				name : 'text'
			} ]
		});

		var combo = Ext.create('Ext.form.field.ComboBox', {
			fieldLabel : '',
			displayField : 'text',
			valueField : 'id',
			width : 100,
			labelWidth : 130,
			store : store,
			queryMode : 'remote',
			typeAhead : true,
		});
		return combo;
	},

	createTree : function(_url) {

		var store2 = Ext.create('Ext.data.TreeStore', {
			proxy : {
				type : 'ajax',
				url : _url
			},
			fields : [ 'id', 'text' ]
		// 跟旧版本extjs一样，节点的id和显示文本
		});

		var asyncTree2 = Ext.create("Ext.tree.Panel", {
			title : '用车单位',
			collapsible : true,
			singleExpand : true,
			rootVisible : false,
			listeners : {
				click : function(n) {
					// id=n.attributes.id;//节点id
					// alert(id);
					// tcontent=n.text;//节点名称
				},
			},
			root : {
				id : -1,
				text : "Root node",
				expanded : true

			},
			store : store2,
		});
		return asyncTree2;
	},
	createBasicWin : function() {
		var win = Ext.create('Ext.Window', {
			width : 450,
			height : 120,
			// closable : false,
			bodyStyle : "padding:15px",

			layout : "fit",
			lableWidth : 45,
			// x:500,
			// y:300,
			plain : true,
			// 指示标题头的位置,分别为 top,bottom,left,right,默认为top
			headerPosition : 'top',
			title : '',
			items : [ {
				xtype : 'textfield',
				// value :
				// '您已经拥有此条码的商品！您可以点击确认或取消继续修改商品，或者点击“使用多条码功能保存”按钮保存成重复条码的商品。',
				fieldLabel : '报关单号',
				// width:90,
				anchor : '80%',
				height : 50,
				// padding:'5px',
				id : 'pre_entry_id'
			} ],
			buttons : [ {
				text : "确定",
				handler : function() {
					win.hide();
				}
			}, {
				text : "取消",
				handler : function() {
					win.hide();
				}
			} ]
		});
		return win;
	}
}