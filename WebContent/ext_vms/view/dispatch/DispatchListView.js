/*!
* view层,负责显示的grid,没有逻辑代码
*/
Ext.define('vms.view.dispatch.DispatchListView' ,{
	extend: 'Ext.panel.Panel',
    alias : 'widget.dispatchlistview',
    title : '',
    layout:"vbox",
    autoScroll:true,
    height: "100%",
    width: "100%",
    bodyPadding: 0,
//    baseCls:"x-plain",
	items:[{
		xtype:"form",
		itemId:"searchForm",
		style: "padding:8px",
		layout:"hbox",
		baseCls:"x-plain",
		width:"100%",
		items:[{
            xtype:"combo",
            itemId:"departmentId_apply_1",
            labelWidth:60,
            fieldLabel:"用车单位"
        },{
            xtype:"combo",
            itemId:"departmentId_apply_2",
            fieldLabel:""
        }]
	},{
		xtype:"toolbar",
		itemId:"toolbar",
		height:38,
		width:"100%",
		layout:"column",
		frame:false,
		plain:true,
		items:[{
			xtype:"buttongroup",
			title:"",
			layout:"table",
			frame:false,
			columnWidth:.72,
			items:[{
				text:"查询",
				itemId:"btnSearch",
				scale:"medium",
				icon : '../resource/img/ui/icons/zoom.png'
			},{
				text:"调度",
				itemId:"btnDispatch",
				scale:"medium",
				icon : '../resource/img/icons/dispatch.png'
			}]
		},{
			xtype:"buttongroup",
			itemId:"countGroup",
			title:"",
			layout:"hbox",
			//style:"background:#f0f0f0",
			frame:false,
			columnWidth:.28,
			items:[{
				text:"全部",
				itemId:"count_all",
				scale:"medium"
			},{
				text:"当天",
				itemId:"count_today",
				scale:"medium"
			},{
				text:"明天",
				itemId:"count_tomorrow",
				scale:"medium"
			},{
				text:"后天",
				itemId:"count_tomorrow_after",
				scale:"medium"
			},{
				text:"以后",
				itemId:"count_later",
				scale:"medium"
			},{
				text:"出省",
				itemId:"count_outprovince",
				scale:"medium"
			}]			
		}]
	},{
		xtype:"panel",
		baseCls:"x-plain",
		layout:'fit',
		flex : 1,
		border: false,
		itemId:"schRstPanel",
		width:"100%"
	},{
		xtype : 'panel',
		itemId : 'operatePanel',
		collapsible : true,
		collapsed:true,
		width:"100%",
		layout : {type : 'fit'},
		title : '操作日志',
		items : [{
			xtype : 'textareafield',
			margin: '0 0 0 0',
			itemId : 'operateNote',
			fieldLabel : ''
		}]
	}]
});