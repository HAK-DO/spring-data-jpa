<jsp:root
        xmlns:jsp="http://java.sun.com/JSP/Page"
    xmlns:spring="http://www.springframework.org/tags"
    xmlns:c="http://java.sun.com/jsp/jstl/core"
    xmlns:form="http://www.springframework.org/tags/form" version="2.0">
    <jsp:directive.page language="java" contentType="text/html" />
    
    <jsp:directive.page contentType="text/html" pageEncoding="UTF-8" />
        <jsp:output omit-xml-declaration="true" />
        <jsp:output doctype-root-element="html" doctype-system="about:legacy-compat" />
        
<html>
        <head>
                <title>Success</title>
        </head>
        <body>
                <form name="logout" action="/logout" method="post">
                        <button type="submit">Logout</button>
                </form>
        </body>
</html>
</jsp:root>