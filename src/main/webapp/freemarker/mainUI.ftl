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
            #div1 {
                text-align: center;
                width: 100%;
                height: 100%;
                background: lightgray;

            }
            #div1 div {
                margin: 0px auto;
                padding-top: 10px;
                width: 80%;
            }
        </style>
    </head>
    <body>
        <div id="div1">
            <div>
                <h2>
                    <span>
                        <#--users是否存在-->
                        <#if user??>
                            ${user.userName}
                        </#if>
                    </span>
                    <span>，欢迎您登陆！！！</span>
                </h2>
            </div>
        </div>
    </body>
</html>