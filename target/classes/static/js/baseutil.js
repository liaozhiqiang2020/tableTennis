//弹出窗口通用方法，参数1：窗口名称；参数2：窗口url
function openWin(title,url){
	layui.use(['layer'], function(){
		layer.open({
	         type: 2,
	         maxmin: true,
	         title: title,
	         cellMinWidth: 80,
	         shadeClose: false,
	         shade: 0.4,
	         area: ['50%', '70%'],
	         content: url,
	         end:function(){
	         	
	         }
	     });
	 })
}



