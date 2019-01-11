function remaintime(){
    var starttime = $("#starttime").html();
    var s1 = new Date(starttime.replace("/-/g","/"));
    var s2 = new Date();
    var date3 = s1.getTime() - s2.getTime();//这是一个相差时间戳
    if(date3 > 2){
        $("#sellbnt").attr({"disabled":"disabled"});
        //天
        var days = Math.floor(date3/(24*3600*1000));
        //小时
        var leave = date3%(24*3600*1000)
        var hours = Math.floor(leave/(3600*1000));
        //分钟
        var leave1 = leave%(3600*1000)
        var minutes = Math.floor(leave1/(60*1000));
        //秒
        var leave2 = leave1%(60*1000)
        var seconds = Math.floor(leave2/1000)
        $("#remainnoties").html("相差 "+days+" 天 "+ hours + " 小时" + minutes + " 分钟"+seconds+"秒");
    }else{
        $("#remainnoties").html("");
        $("#sellbnt").removeAttr("disabled");

        $.ajax({
            type: "get",
            url: "producejs",
            success: function(msg){

            }
        });

    }

    //alert("相差 "+days+" 天 "+ hours + " 小时" + minutes + " 分钟"+seconds+"秒");
}
setInterval('remaintime()',500);