<%@ page contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<!DOCTYPE html>
<html>
<head>
    <title>JSP - Hello World</title>
    <style type="text/css">
        body, div, p, button {
            margin: 0;
            padding: 0;
            user-select: none;
            -webkit-user-select: none;
            -moz-user-select: none;
            -ms-user-select: none;
        }

        #app {
            display: flex;
            justify-content: center;
            align-items: center;
            width: 100vw;
            height: 100vh;
            overflow: hidden;
            background-color: #F2F3F5;
        }

        #app > p#oContent{
            font-size: 12vmin;
        }

        #app > button#oBtn {
            position: fixed;
            bottom: 50px;
            right: 150px;
        }

        .btn-brand{
            min-width: 72px;
            height: 32px;
            color: hsl(0deg, 100%, 100%);
            background-color: #409EFF;
            border: 1px solid #409EFF;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-brand:hover{
            border-color: #a0cfff;
            background-color: #a0cfff;
        }

        .btn-success{
            min-width: 72px;
            height: 32px;
            color: hsl(0deg, 100%, 100%);
            background-color: #67C23A;
            border: 1px solid #67C23A;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-success:hover{
            border-color: #b3e19d;
            background-color: #b3e19d;
        }

        .btn-warning {
            min-width: 72px;
            height: 32px;
            color: hsl(0deg, 100%, 100%);
            background-color: #E6A23C;
            border: 1px solid #E6A23C;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-warning:hover{
            border-color: #f3d19e;
            background-color: #f3d19e;
        }

        .btn-danger{
            min-width: 72px;
            height: 32px;
            color: hsl(0deg, 100%, 100%);
            background-color: #F56C6C;
            border: 1px solid #F56C6C;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-danger:hover{
            border-color: #fab6b6;
            background-color: #fab6b6;
        }

        .btn-info {
            min-width: 72px;
            height: 32px;
            color: hsl(0deg, 100%, 100%);
            background-color: #909399;
            border: 1px solid #909090;
            border-radius: 4px;
            cursor: pointer;
        }

        .btn-info:hover{
            border-color: #c8c9cc;
            background-color: #c8c9cc;
        }
    </style>
</head>
<body>
    <div id="app">
        <p id="oContent">***** ******</p>
        <button class="btn-brand" id="oBtn">显示</button>
    </div>
    <script type="text/javascript">
        var oBtn = document.querySelector('#oBtn');
        var oContent = document.querySelector('#oContent');
        var IsAppear = true;
        var oCon = ['', ''];
        oBtn.onclick = () => {
            if(IsAppear){
                oCon[0] = oContent.innerText;
                oCon[1] = oBtn.innerText;
                oContent.innerHTML = "Hello World!";
                oBtn.innerText = "隐藏";
            }
            else{
                oContent.innerHTML = oCon[0];
                oBtn.innerText = oCon[1];
            }
            IsAppear = !IsAppear;
        }
    </script>
</body>
</html>