/**
 * 
 * Base64 encode / decode http://www.webtoolkit.info/
 * 
 */

var VMSComm = {

	/**
	 * 业务2位字母 + 4位年份 + 2位月份 + 2位日期 + 4位流水号（流水号每天以0001开始）；
     * 举例：派车单号：PC201211020001—>2012年11月2日0001编号的派车单
	 */
    createSerialID_PC : function() {
    	var today = Ext.util.Format.date(new Date(), 'Ymd');
    	
    	//this.searchDispatchPlace("../services/simplecommon/load?model=Organization", "{}");
    	
    	
    	var params = '{"status":"1"}';
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
    
    searchSuccessCallback : function(obj) {
    	alert("js");
    	return obj;
    },
    
    search : function(searchUrl_, conStr_) {

    	var me = this;
        var searchUrl= searchUrl_ + "&conStr=" + conStr_;
        Ext.Ajax.request({
            url : encodeURI(searchUrl),
            timeout : 600000,
            method : 'GET',
            headers : {"Content-Type" : "application/json; charset=utf-8"},
            scope : this,
            success : function(response, opts) {
                var obj = Ext.decode(response.responseText);
                if (me.searchSuccessCallback != null) {
                    me.searchSuccessCallback.call(new Object(), obj);
                }
            },
                
            failure : function(responseObject) {
                Ext.Msg.alert("", "取数据库失败");
                return false;
            }
        });     
    }
    
    
}