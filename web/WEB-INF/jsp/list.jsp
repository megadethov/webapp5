<%@ page import="ua.javawebinar.webapp.web.HtmlUtil" %>
<%@ page import="ua.javawebinar.webapp.storage.XmlFileStorage" %>
<%@ page import="ua.javawebinar.webapp.model.ContactType" %>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="fmt" uri="http://java.sun.com/jsp/jstl/fmt" %>
<html>
<head>
    <meta http-equiv="content-type" content="text/html; charset=UTF-8">
    <link rel="stylesheet" href="css/style.css">
    <title>Список всех резюме</title>
</head>
<body>
<section>
    <table>
        <tr>
            <td colspan="5" style="text-align: right"><a href="resume?action=create"><img src="img/add.png">Добавить
                Резюме</a></td>
        </tr>
        <tr>
            <td>
                <table border="1" cellpadding="8" cellspacing="0">
                    <tr>
                        <th>Имя</th>
                        <th>Проживание</th>
                        <th>Email</th>
                        <th>&nbsp;</th>
                        <th>&nbsp;</th>
                    </tr>
                    <%request.setAttribute("resumeList", new XmlFileStorage("./file_storage"));%>
                    <c:forEach items="${resumeList}" var="resume">
                        <jsp:useBean id="resume" type="ua.javawebinar.webapp.model.Resume"/>
                        <tr>
                            <td><a href="resume?uuid=${resume.uuid}&action=view">${resume.fullName}</a></td>
                            <%--<td><%=HtmlUtil.mask(resume.getLocation())%></td>--%>
                            <td>${resume.location}</td>
                            <td><%=HtmlUtil.getContact(resume, ContactType.MAIL)%></td>
                            <td><a href="resume?uuid=${resume.uuid}&action=delete"><img src="img/delete.png"></a></td>
                            <td><a href="resume?uuid=${resume.uuid}&action=edit"><img src="img/pencil.png"></a></td>
                        </tr>
                    </c:forEach>
                </table>
            </td>
        </tr>
    </table>
</section>

</body>
</html>
