<!DOCTYPE html>
<html>
<head>
    <meta charset="UTF-8">
    <title>爱调查问卷网系统</title>
    <link rel="stylesheet" href="webjars/bootstrap/css/bootstrap.css" rel="external nofollow">
    <script src="webjars/jquery/jquery.js"></script>
    <script src="webjars/bootstrap/js/bootstrap.js"></script>
    <script type="text/javascript">
       $(document).ready(function() {
            //页面初始加载时焦点将会聚焦于用户名框
            $("#txtName").focus();//输入焦点

            $("#txtName").keydown(function (event) {
                if (event.which == "13") {//回车键，用.ajax提交表单
                     $("#txtName").blur();
                }
            });

            //用户名框失去焦点触发ajax事件
            $("#txtName").blur(function () {
                var strTxtName = encodeURI($("#txtName").val());
                $.ajax({
                    type: "POST",
                    url: "ajaxCheckUserName",
                    data: {txtName: strTxtName},
                    dataType : "json",
                    success: function(msg){
                        if(!msg){
                            alert( "用户名不存在,请重新输入" + msg );
                            $("#txtPass").focus();//输入焦点
                        }
                    }
                });
            });

            //当在密码框中按下回车键后触发ajax提交表单事件
            $("#txtPass").keydown(function (event) {
                if (event.which == "13") {//回车键，用.ajax提交表单
                    $("#btnLogin").trigger("click");
                }
            });

            //点击登录按钮触发事件
            $("#btnLogin").click(function () { //“登录”按钮单击事件
                //获取用户名称
                var strTxtName = encodeURI($("#txtName").val());
                //获取输入密码
                var strTxtPass = encodeURI($("#txtPass").val());
                //开始发送数据
                $.ajax
                ({ //请求登录处理页
                    url: "checkUserInfo", //登录处理页
                    type:"POST",
                    //传送请求数据
                    data: {txtName: strTxtName, txtPass: strTxtPass},
                    success: function (msg) { //登录成功后返回的数据
                        //根据返回值进行状态显示
                        if (msg) {//注意是True,不是true
                            $(".clsShow").html("操作提示，登录成功！" + msg);
                        } else {
                            $("#divError").show().html("用户名或密码错误！" + msg);
                        }
                    }
                })
            })
        })
    </script>
</head>
<body>
<form id="frmUserLogin" style="margin-right: 500px;margin-left: 500px;margin-top: 200px">
    <fieldset input-group input-group-lg>
        <legend>用户登录</legend>

        <div class="clsShow">
            <div style="color:#FF0000" id="divError" class="clsError">
        </div>
        <div class="form-group has-success has-feedback">
            <label>登录账户</label>
            <input type="text" class="form-control" id="txtName" placeholder="请输入你的用户名或Email">
            <span class="help-block" style="display:none" id="success">你输入的信息是正确的</span>
            <span class="glyphicon glyphicon-ok form-control-feedback" style="display:none" id="success1"></span>
        </div>
        <div class="form-group has-success has-feedback">
            <label>密码</label>
            <input type="password" class="form-control" id="txtPass" placeholder="请输入你的密码">
        </div>
        <div class="checkbox">
            <label><input type="checkbox">记住密码</label>
        </div>
        <input id="btnLogin" type="button" value="登录" class="btn btn-primary">&nbsp;&nbsp
        <input id="btnReset" type="reset" value="取消" class="btn btn-primary">
        <a href="success.ftl">去注册</a>
        </div>
    </fieldset>
</form>
</body>
</html>
