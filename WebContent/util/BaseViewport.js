Ext.namespace('Ext.Cmp.Common');
Ext
		.define(
				'util.BaseViewport',
				{
					extend : 'Ext.container.Viewport',
					// -------------------------var URL
					getUrl : '', // var:get one object
					newUrl : '', // var:add new object
					editUrl : '',// var:edit one object,most same with newUrl
					delUrl : '',// var:del one object
					searchUrl : '',// var:search objects
					
					gridTitle:'数据列表',
					// loadUrl : '',

					// -------------------------fn ref object

					beforeAddWin : null,// fn ref object:add the added field
					// before show new object win
					beforeEditWin : null,// fn ref object:add the edited
					// field before show edit object win
					beforeInfoWin : null,// fn ref object:add the detail

					afterRenderTable : null,
					// field before show object details
					// win
					getSearchField : null, // fn ref object:add the searchable
					
					callBackFn:null,
					// field before show search win

					// -------------------------ext window object, can access by
					// others

					searchWin : null,
					addWin : null,
					editWin : null,
					infoWin : null,
					// -------------------------others
					gridStore : null,
					searchGrid : null,
					searchFieldUrl : null,
					selectedGridId : [],
					modelStr : '',
					// initLoad : fasle,
					layout : {
						type : 'border'
					},

					initUrl : function(_newUrl, _editUrl, _delUrl, _searchUrl,
							_getUrl) {
						this.newUrl = _newUrl;
						this.editUrl = _editUrl;
						this.delUrl = _delUrl;
						this.searchUrl = _searchUrl;
						this.getUrl = _getUrl;
					},
					initCommonUrl : function(_model) {
						var urlPath = '../services/common/';
						var urlParam = '?model=' + _model;
						// this.modelStr=_model;
						this.searchUrl = urlPath + 'load' + urlParam;
						this.newUrl = urlPath + 'save' + urlParam;
						this.editUrl = urlPath + 'update' + urlParam;
						this.delUrl = urlPath + 'del' + urlParam;
						this.getUrl = '../services/common/get' + urlParam;
						this.searchFieldUrl = urlPath + 'getSearchField'
								+ urlParam;
					},

					initSimpleCommonUrl : function(_model) {
						var urlPath = '../services/simplecommon/';
						var commonUrl = '../services/common/';
						var urlParam = '?model=' + _model;

						// this.modelStr=_model;
						this.searchUrl = urlPath + 'load' + urlParam;
						this.newUrl = urlPath + 'save' + urlParam;
						this.editUrl = urlPath + 'update' + urlParam;
						this.delUrl = urlPath + 'del' + urlParam;
						this.getUrl = '../services/simplecommon/get' + urlParam;
						this.searchFieldUrl = commonUrl + 'getSearchField'
								+ urlParam;
					},
					// get params from url like ?a=1&b=2 ,a,b is key
					getUrlVars : function() {
						var vars = {};
						window.location.href.replace(/[?&]+([^=&]+)=([^&]*)/gi,
								function(m, key, value) {
									vars[key] = value;
								});
						return vars;
					},
					// create dynamic table with http url,and param
					createLocalGrid : function(_url, _param) {

						if (!_param) {

							_param = '';
						}
						// var grid=null;

						var obj = Ext.decode(response.responseText);

						if (this.afterRenderTable != null) {
							var o = new Object();
							this.afterRenderTable.call(o, obj);//
						}

						var columns = obj.columns;
						// var data = obj.root;
						var fields = [];

						Ext.each(columns, function(column) {

							if (column.dataIndex == 'deleteFlag') {
								column.renderer = function(value, metaData,
										record, row, col, store, gridView) {
									// if
									// (record.data.status
									// % 2
									// ===
									// 0) {
									// metaData.style
									// =
									// 'background:#ff7755;';
									// }
									return value == 0 ? "有效" : "无效";
								};
							}
							fields.push(column.dataIndex);

						});

						var store = Ext.create('Ext.data.Store', {
							fields : fields,
							pageSize : 10,
							autoLoad : true,
							proxy : {
								type : 'ajax',
								extraParams : {
									conStr : _param
								},

								url : _url,
								reader : {
									type : 'json',
									root : 'root'
								}
							}
						});

						var grid = Ext.create('Ext.grid.Panel', {
							title : '数据列表',
							store : store,
							columns : columns,
							autoScroll : true,
							forceFit : true,
							selModel : Ext.create(
									'Ext.selection.CheckboxModel', {
										checkOnly : true,
										listeners : {
											select : function(model, record,
													index) {
											},
											deselect : function(model, record,
													index) {
											}
										}
									}),
							dockedItems : [ {
								xtype : 'pagingtoolbar',
								store : store,
								dock : 'bottom',
								emptyMsg : '没有数据',
								displayInfo : true,
								displayMsg : '当前显示{0}-{1}条记录 / 共{2}条记录 ',
								beforePageText : '第',
								afterPageText : '页/共{0}页'
							} ]
						});

						grid.addListener('itemdblclick', recordFn, this);
						function recordFn(grid, record, e) {
							infoWin = Ext.create('Ext.Window', {
								title : '详细信息',
								layout : 'fit',
								itemId : 'baseInfoWindow',
								height : 320,
								width : 480
							});

						}
						return grid;

					},
					createGrid : function(_url, _param, _parent) {
var me=this;
						if (!_param || _param == null) {

							_param = '';
						}
						// var grid=null;
						Ext.Ajax
								.request({
									url : _url,
									timeout : 600000,
									method : 'GET',
									async : true,
									headers : {
										"Content-Type" : "application/json; charset=utf-8"
									},
									params : {
										conStr : _param
									},
									scope : this,
									success : function(response, opts) {

										var obj = Ext
												.decode(response.responseText);

									

										var columns = obj.columns;
										// var data = obj.root;
										var fields = [];

										Ext
												.each(
														columns,
														function(column) {

															if (column.dataIndex == 'deleteFlag') {
																column.renderer = function(
																		value,
																		metaData,
																		record,
																		row,
																		col,
																		store,
																		gridView) {
																	// if
																	// (record.data.status
																	// % 2
																	// ===
																	// 0) {
																	// metaData.style
																	// =
																	// 'background:#ff7755;';
																	// }
																	return value == 0 ? "有效"
																			: "无效";
																};
															}
															fields
																	.push(column.dataIndex);

														});

										var store = Ext.create(
												'Ext.data.Store', {
													fields : fields,
													pageSize : 10,
													autoLoad : true,
													proxy : {
														type : 'ajax',
														extraParams : {
															conStr : _param
														},

														url : _url,
														reader : {
															type : 'json',
															root : 'root'
														}
													}
												});

										var grid = Ext
												.create(
														'Ext.grid.Panel',
														{
															title :me.gridTitle,
															store : store,
															columns : columns,
															flex:1,
															autoScroll : true,
															forceFit : true,
															selModel : Ext
																	.create(
																			'Ext.selection.CheckboxModel',
																			{
																				checkOnly : true,
																				listeners : {
																					select : function(
																							model,
																							record,
																							index) {
																					},
																					deselect : function(
																							model,
																							record,
																							index) {
																					}
																				}
																			}),
															dockedItems : [ {
																xtype : 'pagingtoolbar',
																store : store,
																dock : 'bottom',
																emptyMsg : '没有数据',
																displayInfo : true,
																displayMsg : '当前显示{0}-{1}条记录 / 共{2}条记录 ',
																beforePageText : '第',
																afterPageText : '页/共{0}页'
															} ]
														});

										grid.addListener('itemdblclick',
												recordFn, this);
										function recordFn(grid, record, e) {
											infoWin = Ext
													.create(
															'Ext.Window',
															{
																title : '详细信息',
																layout : 'fit',
																itemId : 'baseInfoWindow',
																height : 320,
																width : 480
															});

										}

										if (_parent) {

//											_parent.add(grid);
											
											if (me.afterRenderTable != null) {
												var o = new Object();
												me.afterRenderTable.call(o, grid);//
											}
//											_parent.show();
										}
										return grid;

									},
									failure : function(responseObject) {
										Ext.Msg.alert("",
												"\u64cd\u4f5c\u5931\u8d25");
										return false;
									}

								});

					},
					search : function() {
						var me = this;

						me.createSearchForm();
						var gridPanel = me.getComponent('dataPanel').getComponent('gridPanel');
						if (gridPanel.getComponent('dataGrid')) {
							gridPanel.remove('dataGrid');
						}
						// dataPanel.removeAll();
						// var form = this.up('form').getForm();
						var form = null;
						var flag = 0;
						var conStr = '{}';
						// 有查询窗口
						if (me.searchWin != null
								&& me.searchWin.getComponent('searchForm')) {
							form = me.searchWin.getComponent('searchForm')
									.getForm();
							var fv = form.getValues();
							conStr = Ext.JSON.encode(fv);
						} else {
							flag = 1;
						}

						if ((form && form.isValid()) || flag == 1) {

							Ext.Ajax
									.request({
										url : me.searchUrl,
										timeout : 600000,
										method : 'GET',
										headers : {
											"Content-Type" : "application/json; charset=utf-8"
										},
										params : {
											conStr : conStr
										},
										scope : this,
										success : function(response, opts) {

											var obj = Ext
													.decode(response.responseText);
											me
													.getComponent(
															'operatePanel')
													.getComponent('operateNote')
													.setValue(
															me
																	.getComponent(
																			'operatePanel')
																	.getComponent(
																			'operateNote')
																	.getValue()
																	+ obj.message);
											var columns = obj.columns;
											// var data = obj.root;
											var fields = [];

											Ext
													.each(
															columns,
															function(column) {

																// if(column.renderer){
																// //
																// alert(1111);
																// column.renderer
																// =function(value,metaData,record,row,col,store,gridView){return
																// value==0?'有效':'无效';};
																//										
																// }
																if (column.dataIndex == 'deleteFlag') {
																	column.renderer = function(
																			value,
																			metaData,
																			record,
																			row,
																			col,
																			store,
																			gridView) {
																		// if
																		// (record.data.status
																		// % 2
																		// ===
																		// 0) {
																		// metaData.style
																		// =
																		// 'background:#ff7755;';
																		// }
																		return value == 0 ? "有效"
																				: "无效";
																	};
																}
																fields
																		.push(column.dataIndex);

															});
											selectedIndex = [];

											deSelect = function(model, record,
													index) {

												id = record.get('id');
												if (Ext.Array.contains(
														me.selectedGridId, id)) {

													Ext.Array.remove(
															me.selectedGridId,
															id);

													Ext.Array.remove(
															selectedIndex,
															record);

													// selectedIndex.push(index);
												}
												if (parent.Ext
														.getCmp("paramshf")) {

													if (Ext.Array.contains(
															childWinParams, id)) {
														Ext.Array
																.remove(
																		me.selectedGridId,
																		id);
														Ext.Array.remove(
																childWinParams,
																id);
														Ext.Array
																.remove(
																		childWinParamsName,
																		record
																				.get('name'));
													}

													parent.Ext
															.getCmp("paramshf")
															.setValue(
																	childWinParams
																			.toString());
													if (parent.Ext
															.getCmp("paramsNamehf")) {
														parent.Ext
																.getCmp(
																		"paramsNamehf")
																.setValue(
																		childWinParamsName
																				.toString());
													}
												}

											};
											me.gridStore = Ext
													.create(
															'Ext.data.Store',
															{
																fields : fields,
																pageSize : 10,
																autoLoad : true,
																listeners : {
																	beforeload : function(
																			store,
																			e,
																			eOpts) {

																		// Ext.apply(store.proxy.extraParams,
																		// me.getQueryParameters());
																		me.searchGrid
																				.getSelectionModel()
																				.removeListener(
																						'deselect',
																						deSelect);

																		for ( var i = 0; i < selectedIndex.length; i++) {
																			me.searchGrid
																					.getSelectionModel()
																					.select(
																							selectedIndex[i],
																							true);

																		}
																		// 保持check状态

																	},
																	load : function(
																			store,
																			records,
																			succ,
																			eOpts) {
																		me.searchGrid
																				.getSelectionModel()
																				.removeListener(
																						'deselect',
																						deSelect);
																		for ( var i = 0; i < selectedIndex.length; i++) {
																			me.searchGrid
																					.getSelectionModel()
																					.select(
																							selectedIndex[i],
																							true);

																		}
																		me.searchGrid
																				.getSelectionModel()
																				.addListener(
																						'deselect',
																						deSelect);
																	}

																},
																proxy : {
																	type : 'ajax',
																	extraParams : {
																		conStr : Ext.JSON
																				.encode(fv)
																	},

																	url : me.searchUrl,
																	reader : {
																		type : 'json',
																		root : 'root'
																	}
																}
															});
											var childWinParams = [];
											var childWinParamsName = [];
											searchGrid = Ext
													.create(
															'Ext.grid.Panel',
															{
																title : me.gridTitle,
																itemId : 'dataGrid',
																flex : 1,
																store : me.gridStore,
																columns : columns,
																autoScroll : true,
																forceFit : true,
																selModel : Ext
																		.create(
																				'Ext.selection.CheckboxModel',
																				{
																					checkOnly : true,
																					listeners : {
																						select : function(
																								model,
																								record,
																								index) {
																							id = record
																									.get('id');
																							if (!Ext.Array
																									.contains(
																											me.selectedGridId,
																											id)) {
																								me.selectedGridId
																										.push(id);
																								selectedIndex
																										.push(record);
																							}
																							if (parent.Ext
																									.getCmp("paramshf")) {
																								if (!Ext.Array
																										.contains(
																												childWinParams,
																												id)) {
																									childWinParams
																											.push(id);
																									childWinParamsName
																											.push(record
																													.get('name'));
																									// me.selectedGridId.push(id);
																								}
																								// alert(id);
																								// alert(childWinParams.toString());

																								// parent.Ext.getCmp("paramshf").setValue('test');

																								parent.Ext
																										.getCmp(
																												"paramshf")
																										.setValue(
																												childWinParams
																														.toString());

																								if (parent.Ext
																										.getCmp("paramsNamehf")) {
																									parent.Ext
																											.getCmp(
																													"paramsNamehf")
																											.setValue(
																													childWinParamsName
																															.toString());
																								}
																							}
																							// parent.Ext.getCmp("operateNote").setValue(parent.Ext.getCmp("operateNote").getValue()+"\n"+"选择角色");

																							// if(parent.document.getElementById('childWinParams')){
																							// parent.document.getElementById('childWinParams').value=childWinParams.toString();
																							// }
																						},
																						deselect : deSelect
																					}
																				}),
																dockedItems : [ {
																	xtype : 'pagingtoolbar',
																	store : me.gridStore,
																	dock : 'bottom',
																	emptyMsg : '没有数据',
																	displayInfo : true,
																	displayMsg : '当前显示{0}-{1}条记录 / 共{2}条记录 ',
																	beforePageText : '第',
																	afterPageText : '页/共{0}页'
																} ]
															});

											searchGrid.addListener(
													'itemdblclick', recordFn,
													this);
											function recordFn(searchGrid,
													record, e) {
												infoWin = Ext
														.create(
																'Ext.Window',
																{
																	title : '详细信息',
																	layout : 'fit',
																	itemId : 'baseInfoWindow',
																	height : 320,
																	width : 480
																});

												editWin = me.createWin(record
														.get('id'));

											}
											me.searchGrid = searchGrid;
											gridPanel.add(searchGrid);
											gridPanel.doLayout();
										},
										failure : function(responseObject) {
											Ext.Msg.alert("",
													"\u64cd\u4f5c\u5931\u8d25");
											return false;
										}

									});

						}

					},

					createSearchForm : function() {
						var me = this;
						var form = Ext.create('Ext.form.Panel', {
							title : '',
							layout : 'hbox',
							itemId : 'baseSearchForm',
							border : false,
							bodyPadding : 5,
							align : 'center',
							defaultType : 'textfield',
				
						});
						if (me.searchFieldUrl != null) {

							Ext.Ajax
									.request({
										url : me.searchFieldUrl,
										success : function(responseObject) {
											var obj = Ext
													.decode(responseObject.responseText);
											var columns = obj.columns;
											var fields = [];

											// var form = me.searchWin
											// .getComponent('searchForm');
											Ext
													.each(
															columns,
															function(column) {
																if (column.searchable) {

																	form
																			.add(Ext
																					.create(
																							Ext.form.field.Text,
																							{
																								fieldLabel : column.text,
																								labelWidth:60,
																								name : column.dataIndex,
																								align : 'center',
																								width:150,	

																							}));
																}

															});
											// me.searchWin
											// .show();

											me
													.getComponent('dataPanel')
													.getComponent('searchPanel')
													.add(form);
											me
													.getComponent('dataPanel')
													.getComponent('searchPanel')
													.doLayout();
											// me
											// .getComponent('dataPanel')
											// .getComponent('searchPanel')
											// .setVisible(true);

										},
										failure : function(responseObject) {
											Ext.Msg.alert("",
													"\u64cd\u4f5c\u5931\u8d25");
											return false;
										}
									});
						} else {

							// var form = searchWin.getComponent('searchForm');
							form.add(Ext.create(Ext.form.field.Text, {
								fieldLabel : '名称',
								name : 'name',
								anchor : '90%',
								align : 'center'

							}));

							me.getComponent('dataPanel').getComponent(
									'searchPanel').add(form);
							me.getComponent('dataPanel').getComponent(
									'searchPanel').doLayout();
							// me.getComponent('dataPanel').getComponent(
							// 'searchPanel').setVisible(true);

							// me.searchWin
							// .show();

						}

					},
					createWin : function(_id,_url) {
						var me = this;
						var url;
						var winTitle;
						if (_id) {
							url = this.editUrl;
							winTitle = "修改";
						} else {
							url = this.newUrl;
							winTitle = "新增";
						}
if(_url){
	
	url=_url;
}


						var win = new Ext.Window(
								{
									title : winTitle,
									layout : 'fit',
									itemId : 'baseWindow',
									height : 394,
									width : 520,
									maximizable : true,
									items : {
										xtype : 'form',
										itemId : 'editForm',
										border : false,
										bodyPadding : 5,
										padding : "0px 0px 0px 5px",
										layout : 'anchor',
										align : 'center',
										dockedItems : [ {
											xtype : 'toolbar',
											dock : 'bottom',
											layout : {
												pack : 'end',
												type : 'hbox'
											},
											items : [
													{
														xtype : 'button',
														text : '保存',
														align : 'center',
														handler : function() {

															var form = this.up(
																	'form')
																	.getForm();
															if (form.isValid()) {
																var fv = form
																		.getValues();
																Ext.Ajax
																		.request({
																			url : url,
																			params : Ext.JSON
																					.encode(fv),
																			method : 'POST',
																			headers : {
																				"Content-Type" : "application/json; charset=utf-8"
																			},
																			success : function(
																					response,
																					opts) {

																				var obj = Ext
																						.decode(response.responseText);
																				Ext.Msg
																						.alert(
																								'提示',
																								obj.message);
																				if (me.gridStore) {
																					me.gridStore
																							.load();

																				}

																				win
																						.destroy();
																			},
																			failure : function(
																					form,
																					action) {
																				Ext.Msg
																						.alert(
																								'提示',
																								'保存失败');
																				return false;
																			}
																		});
															}
														}
													},
													{
														xtype : 'button',
														text : '重置',
														align : 'center',
														handler : function() {
															this.up('form')
																	.getForm()
																	.reset();
														}
													}, {
														xtype : 'button',
														text : '关闭',
														align : 'center',
														handler : function() {
															win.close();
														}
													} ]
										} ]
									}
								});

						if (_id) {

							if (this.beforeEditWin != null) {
								var obj = new Object();
								this.beforeEditWin.call(obj, win);//
							}
						} else {

							if (this.beforeAddWin != null) {
								var obj = new Object();
								this.beforeAddWin.call(obj, win);//
							}
						}

						if (_id) {
							var form = win.getComponent('editForm').getForm();
							form.load({
								waitMsg : '正在加载数据请稍后', // 提示信息
								waitTitle : '提示', // 标题
								url : me.getUrl, // 请求的url地址
								params : {
									id : _id
								},
								method : 'GET', // 请求方式
								success : function(form, action) { // 加载成功的处理函数
									win.show();

								},
								failure : function(form, action) { // 加载失败的处理函数
									Ext.Msg.alert('提示', '加载失败');
								}
							});

						}

						return win;

					},

					initComponent : function() {
						var me = this;
						Ext
								.applyIf(
										me,
										{
											items : [
													{
														xtype : 'toolbar',
														height : 30,
														itemId : 'actionToolbar',
														region : 'north',
														layout : {
															padding : '',
															type : 'hbox'
														},
														items : [
																{
																	xtype : 'button',
																	itemId : 'add',
																	enableToggle : true,
																	toggleGroup : 'btnGroup',
																	text : '添加',
																	icon : '../resource/img/ui/icons/add.png',
																	// hidden:true,
																	handler : function() {

																		addWin = me
																				.createWin();

																		addWin
																				.show();
																	}
																},
																{// 
																	xtype : 'button',
																	itemId : 'del',
																	text : '删除',
																	enableToggle : true,
																	toggleGroup : 'btnGroup',
																	icon : '../resource/img/ui/icons/delete.png',
																	// hidden:true,
																	handler : function() {
																		if (me.searchGrid == null) {
																			Ext.Msg
																					.alert(
																							'提示',
																							'没有数据要删除！');
																			return false;
																		}

																		var recs = searchGrid
																				.getSelectionModel()
																				.getSelection();
																		if (recs.length > 0) {
																			Ext.Msg
																					.confirm(
																							'提示',
																							'确定删除选中的记录吗？',
																							function(
																									btn,
																									text) {
																								if (btn == 'no') {
																									return false;
																								} else {
																									Ext
																											.each(
																													recs,
																													function(
																															rec) {
																														Ext.Ajax
																																.request({

																																	url : me.delUrl
																																			+ "&id="
																																			+ rec
																																					.get('id'),

																																	success : function(
																																			response,
																																			opts) {

																																		var obj = Ext
																																				.decode(response.responseText);
																																		Ext.Msg
																																				.alert(
																																						"提示",
																																						obj.message);
																																		me.gridStore
																																				.load();

																																	},
																																	failure : function(
																																			responseObject) {
																																		Ext.Msg
																																				.alert(
																																						"提示",
																																						"删除失败");
																																		return false;
																																	}
																																});
																													});
																								}
																							});
																		} else {
																			Ext.Msg
																					.alert(
																							'提示',
																							'请选择需要删除的数据');
																			return false;
																		}

																	}
																},
																{

																	xtype : 'button',
																	itemId : 'edit',
																	enableToggle : true,
																	toggleGroup : 'btnGroup',
																	text : '修改',
																	icon : '../resource/img/ui/icons/page_edit.png',
																	// hidden:true,
																	handler : function() {

																		if (me.searchGrid == null) {
																			Ext.Msg
																					.alert(
																							'提示',
																							'没有数据要修改！');
																			return false;
																		}

																		var records = searchGrid
																				.getSelectionModel()
																				.getSelection();
																		if (records.length > 1) {
																			Ext.Msg
																					.alert(
																							'提示',
																							'只能修改一条数据');
																			return false;
																		} else if (records.length <= 0) {
																			Ext.Msg
																					.alert(
																							'提示',
																							'请选择要修改的数据');
																			return false;
																		} else {

																			// editWin=me.createWin();
																			editWin = me
																					.createWin(records[0]
																							.get('id'));

																			editWin
																					.show();
																		}
																	}// modify
																// end
																},

																{
																	xtype : 'button',
																	itemId : 'search',
																	text : '查询',
																	enableToggle : true,
																	toggleGroup : 'btnGroup',
																	icon : '../resource/img/ui/icons/zoom.png',
																	handler : function() {

																		me.searchWin = Ext
																				.create(
																						'Ext.Window',
																						{
																							title : '查询',
																							layout : 'fit',
																							itemId : 'baseSearchWindow',
																							height : 220,
																							width : 480,
																							items : {
																								xtype : 'form',
																								itemId : 'searchForm',
																								border : false,
																								bodyPadding : 5,
																								layout : 'anchor',
																								align : 'center',
																								defaultType : 'textfield',

																								dockedItems : [ {
																									xtype : 'toolbar',
																									dock : 'bottom',
																									layout : {
																										pack : 'end',
																										type : 'hbox'
																									},
																									items : [ 
																											{
																												xtype : 'button',
																												text : '查询',
																												align : 'center',
																												handler : function() {

																													me
																															.search();

																												}
																											},
																											{
																												xtype : 'button',
																												text : '重置',
																												align : 'center',
																												handler : function() {
																													this
																															.up(
																																	'form')
																															.getForm()
																															.reset();

																												}
																											},
																											{
																												xtype : 'button',
																												text : '关闭',
																												align : 'center',
																												handler : function() {
																													me.searchWin
																															.close();
																												}
																											} ]
																								} ]
																							}
																						});
																		me.searchWin.show();
																		// getSearchForm();

																	}
																},
																{
																	xtype : 'button',
																	itemId : 'cls',
																	text : '清空屏幕',
																	enableToggle : true,
																	toggleGroup : 'btnGroup',
																	handler : function() {

																		me
																				.getComponent(
																						'dataPanel')
																				.removeAll();

																	}
																} ]
													},
													{
														xtype : 'panel',
														width : 150,
														itemId : 'treePanel',
														collapsible : false,
														collapsed:false,
														hidden:true,
														layout : {
															type : 'fit'
														},
														title : '',
														region : 'west',
													},
													{
														xtype : 'panel',
														itemId : 'dataPanel',
														region : 'center',
														layout : {
															type : 'vbox',
															pack : 'start', // 纵向对齐方式
															// start：从顶部；center：从中部；end：从底部
															align : 'stretch' // 对齐方式
														// center、left、right：居中、左对齐、右对齐；stretch：延伸；stretchmax：以最大的元素为标准延伸
														},
														items : [
																{
																	xtype : 'panel',
																	itemId : 'searchPanel',
																	height : 60,
																	border : false,
																},
																{
																	xtype : 'panel',
																	itemId : 'gridPanel',
																	layout:'fit',
																	flex : 1,
																	border : false,
																}

														]
													},
													{
														xtype : 'panel',
														height : 150,
														itemId : 'operatePanel',
														collapsible : true,
														collapsed:true,
														layout : {
															type : 'fit'
														},
														title : '操作日志',
														region : 'south',
														items : [ {
															xtype : 'textareafield',
															margin: '0 0 0 0',
															itemId : 'operateNote',
															fieldLabel : '',
														} ]
													} ]
										});

						me.callParent(arguments);
					}
				});