/*
控制层,
所有逻辑代码都在这里写
*/
Ext.define('vms.controller.DispatchCtrl', {
    extend: 'Ext.app.Controller',
    views: ['dispatch.DispatchListView', 'dispatch.DispatchAddWinView', 'dispatch.DispatchSearchView', 'dispatch.DispatchReportView'],
    refs: [{ref: 'dispatchlistview', selector: 'dispatchlistview'},
           {ref: 'dispatchaddwinview', selector: 'dispatchaddwinview'},
           {ref: 'dispatchsearchview', selector: 'dispatchsearchview'},
           {ref: 'dispatchreportview', selector: 'dispatchreportview'}],
   
    selectedApplyID : null,
    selectedCarID : null,
    selectedDriverID : null,
    me : null,
    	
    init: function() {
    	me = this;
        this.control({
            'viewport > dispatchlistview': {
				beforerender: function(gp){
					me.searchApplyList(gp, me);
				},
                afterrender: function(gp){
                	gp.down('button[itemId=btnSearch]').on('click',function(){
                		me.searchApplyList(gp, me);
                	},this);                   	
                	gp.down('button[itemId=btnDispatch]').on('click',function(){
                		if(me.selectedApplyID == null) {
                			alert("请选择一条申请数据！");
                			return ;
                		}
                		Ext.create('vms.view.dispatch.DispatchAddWinView').showWin('1');
                	},this);
                }
            },
            'dispatchaddwinview': {
            	afterrender: function(win){
            		//取数据
            		me.searchApplyInfoWithID(win, me); //申请单信息
            		me.searchDispatchPlace(win, me); //派车点
                	me.searchCarsByGroupID(win, me); //Car List
                	me.searchDriver(win, me); // Driver List
                	
                	//返回按钮事件
	            	win.down('button[itemId=btnBack]').on('click',function(){
	            		win.close();
	            	},this);
	            	
	            	//派车按钮
                    win.down('button[itemId=btnSent]').on('click',function(){
                        me.saveSent(win, me);
                    },this);
                    
                }
            },
            'viewport > dispatchsearchview': {
            	beforerender: function(gp) {
                    me.searchApplyList(gp, me);
                },
                afterrender : function(gp) {
                	me.addDepartment(gp.down('panel[itemId=departmentPanel]'), me);
                }
            },
            'viewport > dispatchreportview': {
            	beforerender: function(gp){
                    me.searchDispatchReport(gp, me);
                },
                afterrender: function(gp){
                    gp.down('button[itemId=btnExport]').on('click',function(){
                        window.location = "dispatchReport.xls" ;
                    },this);                    
                }                
            }
        });
    },
    
    addDepartment : function(container_, me_) {
    	var cb = ExtjsCmp.createCombo('../services/org/getComboOrg?parent=1');
    	container_.add(cb);
    },
    
    saveSent : function(win, me_) {
   	
    	var params = 
    	       '{' +
    	           '"applyID":"' + me_.selectedApplyID + '",' +
    	           '"starttime":"' + win.down('textfield[itemId=txtStarttime]').getValue() + '",' +
    	           '"endtime":"' + win.down('textfield[itemId=txtEndtime]').getValue() + '",' +
    	           '"carID":"' + me_.selectedCarID + '",' +
    	           '"driverID":"' + me_.selectedDriverID + '",' +
    	           '"status":"0"' +
    			'}';

        alert(params);
    	
        Ext.Ajax.request({
            url : '../services/dispatch/addAssign',
            params : params,
            method : 'POST',
            headers : {"Content-Type" : "application/json; charset=utf-8"},
            success : function(response,opts) {
                var obj = Ext.decode(response.responseText);
                Ext.Msg.alert('提示',obj.message);
            },
            failure : function(form,action) {
                Ext.Msg.alert('提示','保存失败');
                return false;
            }
        });
        
    },
    
    //取得派车点
    searchDispatchPlace　: function(win, me_) {

        var searchUrl= '../services/simplecommon/load?model=Organization';
        var conStr = '{"type":"2"}';
        searchUrl += "&conStr=" + conStr;
        
        
//        var obj = VMSComm.search(searchUrl, conStr);
//        alert(obj);
//        var radioGroup = win.down('radiogroup[itemId=radioGroup]');
//        Ext.each(obj.root, function(record){
//          var inputValue = 1;
//          var boxLabel = "";
//          var radio = new Ext.form.Radio({
//                name : "dispatchPlace",
//                inputValue : "1",
//                boxLabel : "驾驶班1"
//            });
//            radioGroup.add(radio);
//        });        
        
        Ext.Ajax.request({
            url : encodeURI(searchUrl),
            timeout : 600000,
            method : 'GET',
            headers : {"Content-Type" : "application/json; charset=utf-8"},
            scope : this,
            success : function(response, opts) {
                var obj = Ext.decode(response.responseText);
                var data = obj.root;
                
                var radioGroup = win.down('radiogroup[itemId=radioGroup]');
                Ext.each(data, function(record){
                	var inputValue = 1;
                	var boxLabel = "";
                	if(record.parentOrganizationId != null) {
                	    var radio = new Ext.form.Radio({
                            name : "dispatchPlace",
                            inputValue : record.id,
                            boxLabel : record.name
                        });
                        radioGroup.add(radio);
                	}
                });
            },
                
            failure : function(responseObject) {
                Ext.Msg.alert("", "取数据库失败");
                return false;
            }
        });
        
    },
    
    //取得申请单信息
    searchApplyInfoWithID : function(win, me_) {

    	var searchUrl= '../services/simplecommon/load?model=Apply';
    	var conStr = '{"id":"' +  me_.selectedApplyID + '"}';
    	searchUrl += "&conStr=" + conStr;
    	
    	Ext.Ajax.request({
            url : encodeURI(searchUrl),
            timeout : 600000,
            method : 'GET',
            headers : {"Content-Type" : "application/json; charset=utf-8"},
            scope : this,
            success : function(response, opts) {
            	var obj = Ext.decode(response.responseText);
            	var data = obj.root;
            	Ext.each(data, function(record){
            		win.down('textfield[itemId=txtApplyID]').setValue(record.serialID);
            		win.down('textfield[itemId=txtDepartName]').setValue(record.departmentName);
            		win.down('textfield[itemId=txtCarTypeName]').setValue(record.carTypeName);
            		win.down('textfield[itemId=txtStartAddress]').setValue(record.startAddr);
            		win.down('textfield[itemId=txtStarttime]').setValue(record.starttime);
            		win.down('textfield[itemId=txtIsReturn]').setValue(record.isReturn==0?'否':'是');
            		
            		win.down('textfield[itemId=txtApplyUser]').setValue(record.applyUserId);
            		win.down('textfield[itemId=txtContactPerson]').setValue(record.contactPerson);
            		win.down('textfield[itemId=txtAssignedCarID]').setValue(record.assignedCarID);
            		win.down('textfield[itemId=txtDestination]').setValue(record.destination);
            		win.down('textfield[itemId=txtEndtime]').setValue(record.endtime);
            		win.down('textfield[itemId=txtIsOutProvince]').setValue(record.isOutProvince==0?'否':'是');
            		
                    win.down('textfield[itemId=txtCreatetime]').setValue(record.createTime);
                    win.down('textfield[itemId=txtTaskType]').setValue(record.taskID);
                    win.down('textfield[itemId=txtAssignedDriverID]').setValue(record.assignedDriverID);
                    win.down('textfield[itemId=txtPassAddr]').setValue(record.passAddr);
                    win.down('textfield[itemId=txtReason]').setValue(record.reason);
            	});
            },
                
            failure : function(responseObject) {
                Ext.Msg.alert("", "取数据库失败");
                return false;
            }
    	});
    },

    searchApplyList : function(gp, me_) {
    	
        var selectedIndex= [];
        var selectedGridId=[];
        var gridStore= null;
        var searchUrl= '../services/simplecommon/load?model=Apply';
        var resultTitle= '';
        var infoWin =null;
        
        var conStr1 = '{}';
        searchUrl = searchUrl + "&conStr=" + conStr1;
		
		Ext.Ajax.request({
			url : encodeURI(searchUrl),
			timeout : 600000,
			method : 'GET',
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			},

			scope : this,
			success : function(response, opts) {
				var obj = Ext.decode(response.responseText);
				
				var columns = obj.columns;
				var fields = [];

				//状态数据变换
				var data = obj.root;
				var count_all=0, count_today=0, count_tomorrow=0, count_tomorrow_after=0, count_later=0, count_outprovince=0;
                var today = Ext.util.Format.date(new Date(), 'Y-m-d');
                var tomorrow = Ext.util.Format.date(Ext.Date.add(new Date(), Ext.Date.DAY, 1), 'Y-m-d');
                var tomorrow_after = Ext.util.Format.date(Ext.Date.add(new Date(), Ext.Date.DAY, 2), 'Y-m-d');
                
				Ext.each(data, function(record){
					count_all += 1;
					var starttime = record.starttime.substr(0,10);
					if (starttime == today) {
						count_today += 1;
					} else if (starttime == tomorrow) {
						count_tomorrow += 1;
					} else if (starttime == tomorrow_after) {
						count_tomorrow_after += 1;
					} else if (starttime > tomorrow_after) {
						count_later += 1;
					}
					
					var isOutProvince = record.isOutProvince;
					if (isOutProvince == 1) {
						count_outprovince += 1;
					}
				});
				
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_all').setText("全部("+count_all+")");
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_today').setText("当天("+count_today+")");
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_tomorrow').setText("明天("+count_tomorrow+")");
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_tomorrow_after').setText("后天("+count_tomorrow_after+")");
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_later').setText("以后("+count_later+")");
				gp.getComponent('toolbar').getComponent('countGroup').getComponent('count_outprovince').setText("出省("+count_outprovince+")");
				
				Ext.each(columns, function(column) {
					fields.push(column.dataIndex);
				});
				
				//添加操作日志
				var operate = gp.getComponent('operatePanel').getComponent('operateNote');
				operate.setValue(operate.getValue() + obj.message);
				
				deSelect = function(model, record, index) {
					id = record.get('id');
					if (Ext.Array.contains(selectedGridId, id)) {
						Ext.Array.remove(selectedGridId, id);
						Ext.Array.remove(selectedIndex, record);
					}
				};
					
				gridStore = Ext.create('Ext.data.Store',	{
					fields : fields,
					pageSize : 10,
					autoLoad : true,
					listeners : {
						beforeload : function(store, e,	eOpts) {
							searchGrid.getSelectionModel().removeListener('deselect', deSelect);
							for ( var i = 0; i < selectedIndex.length; i++) {
								searchGrid.getSelectionModel().select(selectedIndex[i], true);
							}
						},
						load : function(store, records,	succ, eOpts) {
							searchGrid.getSelectionModel().removeListener('deselect', deSelect);
							for ( var i = 0; i < selectedIndex.length; i++) {
								searchGrid.getSelectionModel().select(selectedIndex[i], true);
							}
							searchGrid.getSelectionModel().addListener('deselect', deSelect);
						}
					},
					proxy : {
						type : 'ajax',
						url : encodeURI(searchUrl),
						reader : {
							type : 'json',
							root : 'root'
						}
					}
				});

				searchGrid = Ext.create('Ext.grid.Panel', {
					title : resultTitle,
					itemId : 'dataGrid',
					store : gridStore,
					columns : columns,
					autoScroll : true,
					forceFit : true,
					selModel : Ext.create(
				        'Ext.selection.CheckboxModel', {
						    checkOnly : true,
							listeners : {
								select : function(model, record, index) {
									id = record.get('id');
									if (!Ext.Array.contains(selectedGridId, id)) {
										selectedGridId.push(id);
										selectedIndex.push(record);
										me_.selectedApplyID = id;
									}
								},
								deselect : deSelect
							}
						}),
					dockedItems : [ {
						xtype : 'pagingtoolbar',
						store : gridStore,
						dock : 'bottom',
						emptyMsg : '没有数据',
						displayInfo : true,
						displayMsg : '当前显示{0}-{1}条记录 / 共{2}条记录 ',
						beforePageText : '第',
						afterPageText : '页/共{0}页'
					} ]
				});

				searchGrid.addListener('itemdblclick', recordFn, this);
				function recordFn(searchGrid, record, e) {
					infoWin = Ext.create('Ext.Window', {
										title : '详细信息',
										layout : 'fit',
										itemId : 'baseInfoWindow',
										height : 320,
										width : 480
									});
				}

            	if(searchGrid != null) {
					gp.getComponent('schRstPanel').add(searchGrid);
				} else {
            		alert('searchResult is null');
            	}
			},
				
			failure : function(responseObject) {
				Ext.Msg.alert("", "\u64cd\u4f5c\u5931\u8d25");
				return false;
			}

		});
	
    },

    /**
     * 根据班组搜索车辆信息
     */
    searchCarsByGroupID : function(win, me_) {
    	
    	var groupID = '1';
        var selectedIndex= [];
        var selectedGridId=[];
        var gridStore= null;
        var searchGrid= null;
        var searchUrl= '../services/simplecommon/load?model=CarInfo';
        var resultTitle= '';
        var infoWin =null;
        
		Ext.Ajax.request({
			url : searchUrl,
			timeout : 600000,
			method : 'GET',
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			},
			params : {
				//conStr : '{GroupID:' + groupID + '}'
				conStr : '{}'
			},
			scope : this,
			success : function(response, opts) {
				var obj = Ext.decode(response.responseText);
				var columns = obj.columns;
				var fields = [];

				Ext.each(columns, function(column) {
					fields.push(column.dataIndex);

				});
				
				deSelect = function(model, record, index) {
					id = record.get('id');
					if (Ext.Array.contains(selectedGridId, id)) {
						Ext.Array.remove(selectedGridId, id);
						Ext.Array.remove(selectedIndex, record);
					}
				};
					
				gridStore = Ext.create('Ext.data.Store',	{
					fields : fields,
					pageSize : 10,
					autoLoad : true,
					proxy : {
						type : 'ajax',
						extraParams : {
							//conStr : Ext.JSON.encode(fv)
							conStr : '{}'
						},
						url : searchUrl,
						reader : {
							type : 'json',
							root : 'root'
						}
					}
				});
				
				searchGrid = Ext.create('Ext.grid.Panel', {
					title : resultTitle,
					itemId : 'dataGrid',
					store : gridStore,
					columns : columns,
					region:'center',
					autoScroll:true,
					listeners:{
						'itemclick':function(me,record){
							win.down('textfield[itemId=selectedCar]').setValue(record.get('carNum'));
							me_.selectedCarID = record.get('id');
						}
					}
				});

            	if(searchGrid != null) {
            		win.getComponent('dispatchPanel').getComponent('dispatchPanelSelect').getComponent('carList').add(searchGrid);
				} else {
            		alert('searchResult is null');
            	}
			},
				
			failure : function(responseObject) {
				Ext.Msg.alert("", "\u64cd\u4f5c\u5931\u8d25");
				return false;
			}

		});
	
    
    },

    /**
     * 派车报表查询
     * @param {} gp
     */
    searchDispatchReport : function(gp, me_) {
        
        var selectedIndex= [];
        var selectedGridId=[];
        var gridStore= null;
        //var searchGrid= null;
        var searchUrl= '../services/simplecommon/load?model=Apply';
        var resultTitle= '';
        var infoWin =null;
        
        var conStr1 = '{}';
        searchUrl = searchUrl + "&conStr=" + conStr1;
        
        Ext.Ajax.request({
            url : encodeURI(searchUrl),
            timeout : 600000,
            method : 'GET',
            headers : {
                "Content-Type" : "application/json; charset=utf-8"
            },

            scope : this,
            success : function(response, opts) {
                var obj = Ext.decode(response.responseText);
                var columns = obj.columns;
                var fields = [];

                Ext.each(columns, function(column) {
                    fields.push(column.dataIndex);
                });
                
                //添加操作日志
                var operate = gp.getComponent('operatePanel').getComponent('operateNote');
                operate.setValue(operate.getValue() + obj.message);
                
                deSelect = function(model, record, index) {
                    id = record.get('id');
                    if (Ext.Array.contains(selectedGridId, id)) {
                        Ext.Array.remove(selectedGridId, id);
                        Ext.Array.remove(selectedIndex, record);
                    }
                };
                    
                gridStore = Ext.create('Ext.data.Store',    {
                    fields : fields,
                    pageSize : 10,
                    autoLoad : true,
                    listeners : {
                        beforeload : function(store, e, eOpts) {
                            searchGrid.getSelectionModel().removeListener('deselect', deSelect);
                            for ( var i = 0; i < selectedIndex.length; i++) {
                                searchGrid.getSelectionModel().select(selectedIndex[i], true);
                            }
                        },
                        load : function(store, records, succ, eOpts) {
                            searchGrid.getSelectionModel().removeListener('deselect', deSelect);
                            for ( var i = 0; i < selectedIndex.length; i++) {
                                searchGrid.getSelectionModel().select(selectedIndex[i], true);
                            }
                            searchGrid.getSelectionModel().addListener('deselect', deSelect);
                        }
                    },
                    proxy : {
                        type : 'ajax',
                        url : encodeURI(searchUrl),
                        reader : {
                            type : 'json',
                            root : 'root'
                        }
                    }
                });

                searchGrid = Ext.create('Ext.grid.Panel', {
                    title : resultTitle,
                    itemId : 'dataGrid',
                    store : gridStore,
                    columns : columns,
                    autoScroll : true,
                    forceFit : true,
                    selModel : Ext.create(
                        'Ext.selection.CheckboxModel', {
                            checkOnly : true,
                            listeners : {
                                select : function(model, record, index) {
                                    id = record.get('id');
                                    if (!Ext.Array.contains(selectedGridId, id)) {
                                        selectedGridId.push(id);
                                        selectedIndex.push(record);
                                        me_.selectedApplyID = id;
                                    }
                                },
                                deselect : deSelect
                            }
                        }),
                    dockedItems : [ {
                        xtype : 'pagingtoolbar',
                        store : gridStore,
                        dock : 'bottom',
                        emptyMsg : '没有数据',
                        displayInfo : true,
                        displayMsg : '当前显示{0}-{1}条记录 / 共{2}条记录 ',
                        beforePageText : '第',
                        afterPageText : '页/共{0}页'
                    } ]
                });

                searchGrid.addListener('itemdblclick', recordFn, this);
                function recordFn(searchGrid, record, e) {
                    infoWin = Ext.create('Ext.Window', {
                                        title : '详细信息',
                                        layout : 'fit',
                                        itemId : 'baseInfoWindow',
                                        height : 320,
                                        width : 480
                                    });
                }

                if(searchGrid != null) {
                    gp.getComponent('schRstPanel').add(searchGrid);
                } else {
                    alert('searchResult is null');
                }
            },
                
            failure : function(responseObject) {
                Ext.Msg.alert("", "\u64cd\u4f5c\u5931\u8d25");
                return false;
            }

        });
    
    },
    
    /**
     * 检索驾驶员信息
     */
    searchDriver :　function(win, me_) {
    	var groupID = '1';
        var selectedIndex= [];
        var selectedGridId=[];
        var gridStore= null;
        var searchGrid= null;
        var searchUrl= '../services/simplecommon/load?model=DriverInfo';
        var resultTitle= '';
        var infoWin =null;
        
		Ext.Ajax.request({
			url : searchUrl,
			timeout : 600000,
			method : 'GET',
			headers : {
				"Content-Type" : "application/json; charset=utf-8"
			},
			params : {
				conStr : '{}'
			},
			scope : this,
			success : function(response, opts) {
				var obj = Ext.decode(response.responseText);
				var columns = obj.columns;
				var fields = [];

				Ext.each(columns, function(column) {
					fields.push(column.dataIndex);

				});
				
				deSelect = function(model, record, index) {
					id = record.get('id');
					if (Ext.Array.contains(selectedGridId, id)) {
						Ext.Array.remove(selectedGridId, id);
						Ext.Array.remove(selectedIndex, record);
					}
				};
					
				gridStore = Ext.create('Ext.data.Store',	{
					fields : fields,
					pageSize : 10,
					autoLoad : true,
					proxy : {
						type : 'ajax',
						extraParams : {
							conStr : '{}'
						},
						url : searchUrl,
						reader : {
							type : 'json',
							root : 'root'
						}
					}
				});
				
				searchGrid = Ext.create('Ext.grid.Panel', {
					title : resultTitle,
					itemId : 'dataGrid',
					store : gridStore,
					columns : columns,
					region:'center',
					autoScroll:true,
					frame:false,
					listeners:{
						'itemclick':function(me,record){
							win.down('textfield[itemId=selectedDriver]').setValue(record.get('name'));
							me_.selectedDriverID = record.get('id');
						}
					}
				});

            	if(searchGrid != null) {
            		win.down('panel[itemId=driverList]').add(searchGrid);
				} else {
            		alert('searchResult is null');
            	}
			},
				
			failure : function(responseObject) {
				Ext.Msg.alert("", "\u64cd\u4f5c\u5931\u8d25");
				return false;
			}

		});    	
    }
});

