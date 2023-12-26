
<%@page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8" %>
<%@taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/static/css/base.css"/>" type="text/css">
    <style>
        #notify-modal{
            display: flex;
        }

        /*          modal            */
        .confirm-container{
            background-color: var(--color0);
            height: 200px;
            min-width: 300px;
            border-radius: 30px;

        }

        .form-header{
            background-color: var(--color1);
            height: 40px;
            border-radius: 30px 30px 0 0;
            display: flex;
            flex-direction: row;
            justify-content: space-between;
            align-items: center;
            padding: 0 5%;
        }
        .form-header i,.form-header span{
            color: var(--color0);
            font-weight: 600;
            cursor: pointer;
        }

        .form-header .title{
            display: flex;
            gap: 10px;
            justify-content: center;
            align-items: center;
        }

        .form-content{
            background-color: var(--color0);
            height: 100%;
            display: flex;
            flex-direction: column;
            align-items: center;
            justify-content: space-around;
            border-radius:  0 0 30px 30px;
        }
        .confirm-btn{
            width: 30%;
            height: 40px;
            background-color: var(--color0);
            border-radius: 30px;
            border: none;
            cursor: pointer;
            color: var(--color0);
            font-weight: 600;
        }

        .confirm-btn:hover{
            transform: scale(1.1);
        }

        .form-selection{
            display: flex;
            width: 100%;
            justify-content: center;
            align-items: center;
            gap: 30px;
        }

        .confirm-mess{
            height: 50%;
            width: 90%;
            text-align: center;
            display: grid;
            place-items: center;
        }

    </style>
</head>
<body>
<c:if test="${isSuccessful !=null}">
    <div id="notify-modal" class="modal">
        <div class="modal__overlay" style="margin-top: var(--nav-height); position:fixed;" onclick="closeModalNotify()">
        </div>
        <div class="modal__body">
            <div class="modal__inner">
                <div class="confirm-container">
                    <div class="form-header">
                        <div class="title">
                            <span onclick="closeModalNotify()">Confirmation Message ! </span>
                            <i class="fa-light fa-message-smile" onclick="closeModalNotify()"></i>
                        </div>
                        <i class="fa-solid fa-chevron-down" onclick="closeModalNotify()"></i>
                    </div>
                    <form action="delete-prod" method="post" class="form-content">
                        <c:if test="${isSuccessful == true}">
                            <span class="confirm-mess" style="color: green;">Successful!</span>
                        </c:if>
                        <c:if test="${isSuccessful == false}">
                            <span class="confirm-mess" style="color: red;">Failed!</span>
                        </c:if>
                        <div class="form-selection">
                            <input class="confirm-btn" style="background-color: var(--color3);" type="button" value="Yes" onclick="closeModalNotify()">
                        </div>
                    </form>
                </div>
            </div>
        </div>
    </div>
</c:if>
<script>
    notifyModal = document.getElementById("notify-modal")
    function closeModalNotify(){
        notifyModal.style.display = "none";
    }
</script>
<script src="<c:url value="/static/js/base.js"/>" async defer ></script>
</body>
</html>
