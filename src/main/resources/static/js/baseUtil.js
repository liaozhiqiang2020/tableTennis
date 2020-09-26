function openWin(title,url){

    layer.open({
        type: 2,
        skin: 'layui-layer-demo', //样式类名
        title: title,
        closeBtn: 1, //不显示关闭按钮
        anim: 2,
        area: ['893px', '600px'],
        shadeClose: true, //开启遮罩关闭
        content: url
    });
}