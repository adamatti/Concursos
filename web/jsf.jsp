<?xml version="1.0" encoding="UTF-8" ?>  
<%@ page language="java" contentType="text/html; charset=UTF-8"  pageEncoding="UTF-8"%>  
<%@ taglib uri="http://java.sun.com/jsf/core" prefix="f" %>  
<%@ taglib uri="http://java.sun.com/jsf/html" prefix="h" %>  
<f:view>
<h:form>
	<h:outputLabel value="Message:"/>
	<h:inputText value="#{messageview.message.message}"/>
	<h:commandButton action="#{messageview.save}" value="Save"/>
</h:form>
</f:view>