<!DOCTYPE html>

<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
    
<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%@ taglib prefix="spring" uri="http://www.springframework.org/tags"%>

<c:url value="/images/favicon.ico" var="iconImage" />
<c:url value="/style/app.css" var="stsm_css" />

<html>
	<head>
		<meta charset="utf-8">
		<style type="text/css" href="${stsm_css}"></style>
		<title>Index</title>
		<link rel="shortcut icon" href="${iconImage}" type="image/x-icon" />
	</head>
	<body>
		<jsp:include page="WEB-INF/view/jsp/menu.jspx"/>
	</body>
</html>