/*!
* view层,负责显示的grid,没有逻辑代码
*/
Ext.define('vms.view.dispatch.DispatchReportView' ,{
    extend: 'Ext.panel.Panel',
    alias : 'widget.dispatchreportview',
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
        layout:"column",
        baseCls:"x-plain",
        items:[{
            xtype: "panel",
            columnWidth: .5,
            baseCls:"x-plain",
            items: [{
                xtype:"panel",
                title:"",
                layout:"hbox",
                width: 400,
                height:35,
                baseCls:"x-plain",
                items:[{
                    xtype:"textfield",
                    itemId:"assignedCarID",
                    name:"assignedCarID",
                    labelWidth:55,
                    width:165,
                    fieldLabel:"车牌",
                    value:""
                }]
            },{
                xtype:"panel",
                title:"",
                layout:"hbox",
                height:35,
                width:400,
                baseCls:"x-plain",
                items:[{
                    xtype:"datefield",
                    name:"startTime1",
                    labelWidth:55,
                    fieldLabel:"用车时间"
                },{
                    xtype:"label",
                    html:"&nbsp;~&nbsp;"
                },{
                    xtype:"datefield",
                    itemId:"startTime2",
                    fieldLabel:""
                }]
            }]
        },{
            xtype: "panel",
            columnWidth: .5,
            baseCls:"x-plain",
            items: [{
                xtype:"panel",
                title:"",
                layout:"hbox",
                height:35,
                width:400,
                baseCls:"x-plain",
                items:[{
                    xtype:"combo",
                    itemId:"departmentId_apply_1",
                    labelWidth:55,
                    fieldLabel:"用车单位"
                },{
                    xtype:"combo",
                    itemId:"departmentId_apply_2",
                    fieldLabel:""
                }]
            },{
                xtype:"panel",
                frame:false,
                title:"",
                layout:"hbox",
                width: 400,
                height:35,
                baseCls:"x-plain",
                items:[{
                    xtype:"combo",
                    itemId:"departmentId_dispatch_1",
                    labelWidth:55,
                    fieldLabel:"分车单位"
                },{
                    xtype:"combo",
                    itemId:"departmentId_dispatch_2",
                    fieldLabel:""
                }]
            }]
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
            columnWidth:.95,
            items:[{
                text:"查询",
                itemId:"btnSearch",
                scale:"medium",
                icon : '../resource/img/ui/icons/zoom.png'
            },{
                text:"导出",
                itemId:"btnExport",
                scale:"medium",
                icon : '../resource/img/icons/icon_excel.gif'
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