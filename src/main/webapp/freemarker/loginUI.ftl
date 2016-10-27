<!DOCTYPE html>
<html>
    <head>
        <meta charset="UTF-8">
        <title>登陆</title>
        <style>
            body {
                padding: 0px;
                margin: 0px auto;
                font-size: 12px;
                width: 800px;
                height: 500px;
            }
            #formDiv {
                text-align: center;
                width: 100%;
                height: 100%;
                background: lightgray;

            }
            #formDiv div {
                margin: 0px auto;
                padding-top: 10px;
                width: 80%;
            }
            #formDiv div > span:first-child {
                display: inline-block;
                width: 30%;
                text-align: right;
                margin-right: 10px;
                height: 30px;
            }
            #formDiv div > span:last-child {
                display: inline-block;
                width: 65%;
                text-align: left;
                margin-left: 10px;
                height: 50px;
            }
            #userPassword, #userName {
                width: 200px;
            }
        </style>
    </head>
    <body>
        <div id="formDiv">
            <form action="${base.contextPath}/user/userLogin" method="post">
                <div>
                    <span>
                        <label for="userName">用户名</label>
                    </span>
                    <span>
                        <input type="text" name="userName" id="userName"/><br />
                    </span>
                </div>
                <div>
                    <span>
                        <label for="userPassword">密码</label>
                    </span>
                    <span>
                        <input type="password" name="userPassword" id="userPassword"/><br />
                    </span>
                </div>
                <div>
                    <input type="submit" value="登陆" />
                    <input type="reset" value="重置信息" />
                </div>
                <div>
                    <span>
                        <#--users是否存在-->
                        <#if errMsg??>
                            <span style="color: red">${errMsg }</span>
                        </#if>
                    </span>
                </div>
            </form>
        </div>
    </body>
</html>