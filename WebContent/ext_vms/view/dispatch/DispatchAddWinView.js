Ext.define('vms.view.dispatch.DispatchAddWinView', {
    extend: 'Ext.window.Window',
    alias : 'widget.dispatchaddwinview',
    title : '车辆调度',
    autoScroll:false,
    modal:true,
    height: "580",
    width: "880",
    bodyPadding: 2,
    items:[{
        title:"预约单信息",
        layout: 'column',
        style: "padding:5 5 5 5",
        frame:true,
        items: [{
            columnWidth: .3,
            layout:"auto",
            defaultType:"textfield",
            baseCls:"x-plain",
            items:[
                {fieldLabel: '申请单号',labelWidth:60,disabled:true,style:"color:red",itemId:"txtApplyID"},
                {fieldLabel: '用车单位',labelWidth:60,disabled:true,style:"color:red",itemId:"txtDepartName"},
                {fieldLabel: '所需车型',labelWidth:60,disabled:true,style:"color:red",itemId:"txtCarTypeName"},
                {fieldLabel: '上车地点',labelWidth:60,disabled:true,style:"color:red",itemId:"txtStartAddress"},
                {fieldLabel: '上车时间',labelWidth:60,disabled:true,style:"color:red",itemId:"txtStarttime"},
                {fieldLabel: '往返否',labelWidth:60,disabled:true,style:"color:red",itemId:"txtIsReturn"}
            ]   
        },{
            columnWidth: .33,
            layout:"auto",
            defaultType:"textfield",
            baseCls:"x-plain",
            items:[
                {fieldLabel: '申请人',labelWidth:90,disabled:true,style:"color:red",itemId:"txtApplyUser"},
                {fieldLabel: '用车人',labelWidth:90,disabled:true,style:"color:red",itemId:"txtContactPerson"},
                {fieldLabel: '指定车辆',labelWidth:90,disabled:true,style:"color:red",itemId:"txtAssignedCarID"},
                {fieldLabel: '目的地',labelWidth:90,disabled:true,style:"color:red",itemId:"txtDestination"},
                {fieldLabel: '预计结束时间',labelWidth:90,disabled:true,style:"color:red",itemId:"txtEndtime"},
                {fieldLabel: '出省否',labelWidth:90,disabled:true,style:"color:red",itemId:"txtIsOutProvince"}
            ]
        },{
            columnWidth: .3,
            layout:"auto",
            defaultType:"textfield",
            baseCls:"x-plain",
            items:[
                {fieldLabel: '申请时间',labelWidth:80,disabled:true,style:"color:red",itemId:"txtCreatetime"},
                {fieldLabel: '用车事由',labelWidth:80,disabled:true,style:"color:red",itemId:"txtTaskType"},
                {fieldLabel: '指定驾驶员',labelWidth:80,disabled:true,style:"color:red",itemId:"txtAssignedDriverID"},
                {fieldLabel: '途径地',labelWidth:80,disabled:true,style:"color:red",itemId:"txtPassAddr"},
                {
                    xtyp:'textarea',
                    itemId:"txtReason",
                    fieldLabel: '备注',
                    labelWidth:80,
                    grow:true,
                    disabled:true,style:"color:red"
                }
            ]
        }]
    },{
        xtype:"panel",
        title:"",
        height:5,
        baseCls:"x-plain"
    },{
        xtype:"panel",
        itemId:"dispatchPanel",
        title:"派车选择",
        frame:true,
        items:[{
            xtype:'fieldset',   
            title:'派车点',
            collapsible: true,
            width:"100%",
            items:[{
                xtype:'radiogroup',
                itemId:'radioGroup',
                columns : 10
//                items:[
//                    new Ext.form.Radio({   
//                    name : "inBillType",     
//                    inputValue : "2",      
//                    boxLabel : "驾驶班1"      
//                }), new Ext.form.Radio({      
//                    name : "inBillType",   
//                    inputValue : "3",      
//                    boxLabel : "驾驶班2"                           
//                }),  new Ext.form.Radio({      
//                    name : "inBillType",    
//                    inputValue : "4",      
//                    boxLabel : "驾驶班3"      
//                }),  new Ext.form.Radio({
//                    name : "inBillType",      
//                    inputValue : "4",   
//                    boxLabel : "驾驶班4"     
//                })]
            }]
        },{
            xtype:"panel",
            itemId:"dispatchPanelSelect",
            layout:"hbox",
            baseCls:"x-plain",
            items:[{
                xtype:"panel",
                title:"请选择车辆",
                layout:"fit",
                flex:1,
                itemId:"carList",
                autoScroll:true,
                width:"50%",
                height:165,
                style:"padding:2px"
            },{
                xtype:"panel",
                title:"请选择驾驶员",
                layout:"fit",
                flex:1,
                itemId:"driverList",
                autoScroll:true,
                width:"45%",
                height:165,
                style:"padding:2px"
            }]
        },{
            xtype: "form",
            itemId:"resultForm",
            baseCls:"x-plain",
            style:"padding:3px,align:center",
            items:[{
                xtype:'fieldset',
                itemId:"tttt",
                layout: 'column',   
                style:"padding:5px",
                baseCls:"x-plain",
                items:[{
                    columnWidth: 0.15,
                    baseCls:"x-plain",
                    html: '&nbsp;'
                },{
                    columnWidth: 0.25,
                    layout:"auto",
                    xtype:"textfield",
                    itemId:"selectedCar",
                    labelWidth:45,
                    fieldLabel:"车 辆"
                },{
                    columnWidth: 0.05,
                    baseCls:"x-plain",
                    html: '&nbsp;'
                },{
                    columnWidth: 0.25,
                    layout:"auto",
                    xtype:"textfield",
                    itemId:"selectedDriver",
                    labelWidth:55,
                    fieldLabel:"驾驶员"
                },{
                    columnWidth: 0.05,
                    baseCls:"x-plain",
                    html: '&nbsp;'
                },{
                    columnWidth: 0.25,
                    layout:"auto",
                    xtype:"checkboxfield",
                    itemId:"isSingle",
                    boxLabel:"是否单程"
                }]
            }]
        }]
    },{
        xtype:"panel",
        title:"",
        height:5,
        baseCls:"x-plain"
    },{
        xtype:"panel",
        itemId:"actionPanel",
        baseCls:"x-plain",
        layout:"column",
        items:[{
            columnWidth: 0.3,
            baseCls:"x-plain",
            html: '&nbsp;'
        },{
            columnWidth: 0.13,
            xtype:"button",
            itemId:"btnSent",
            scale:"medium",
            baseCls:"x-plain",
            html:'<img src="../resource/img/btn_sent.gif"/>'
        },{
            columnWidth: 0.13,
            xtype:"button",
            itemId:"btnUnable",
            scale:"medium",
            baseCls:"x-plain",
            html:'<img src="../resource/img/btn_unable.gif"/>'
        },{
            columnWidth: 0.12,
            xtype:"button",
            itemId:"btnBack",
            scale:"medium",
            baseCls:"x-plain",
            html:'<img src="../resource/img/btn_back.gif"/>'
        }]
    }],
    
    initComponent: function() {
        this.callParent(arguments);
    },
    
    showWin: function(dispatchID) {
        this.show();
    }

});