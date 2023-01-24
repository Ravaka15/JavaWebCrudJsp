<%-- 
    Document   : client_form
    Created on : 19 janv. 2023, 18:36:04
    Author     : 26134
--%>

<%@ page language="java" contentType="text/html; charset=UTF-8"
 pageEncoding="UTF-8"%>
    <%@ taglib uri="http://java.sun.com/jsp/jstl/core" prefix="c"%>
        <html>

        <head>
            <title>User Management Application</title>
            <link rel="stylesheet" href="https://stackpath.bootstrapcdn.com/bootstrap/4.3.1/css/bootstrap.min.css" integrity="sha384-ggOyR0iXCbMQv3Xipma34MD+dH/1fQ784/j6cY/iJTQUOhcWr7x9JvoRxT2MZw1T" crossorigin="anonymous">
            <style>
                .nav__logo {
                    position: absolute ;
                    left: 0;
                    right: 95%;
                    top: 0.5rem;
                    width: 40px;
                    height: 40px;
                    border-radius: 50%;
                    background-color: violet;
                    text-align: center;
                    margin: auto;
                }

                .nav__logo-text {
                    font-size: 1.125rem;
                    color: white;
                    line-height: 40px;
                    text-decoration: none;
                }
            </style> 
        </head>

        <body>

            <header>
                <nav class="navbar navbar-expand-md navbar-dark" style="background-color: purple">
                    <div class="nav__logo">
                        <a href="<%=request.getContextPath()%>" class="nav__logo-text">R</a>
                    </div>

                    <ul class="navbar-nav">
                        <li><a href="<%=request.getContextPath()%>/list" class="nav-link">C</a></li>
                    </ul>
                   
                </nav>
            </header>
            <br>
            <div class="container col-md-5">
                <div class="card">
                    <div class="card-body">
                        <c:if test="${client != null}">
                            <form action="update" method="post">
                        </c:if>
                        <c:if test="${client == null}">
                            <form action="insert" method="post">
                        </c:if>

                        <caption>
                            <h2>
                                <c:if test="${client != null}">
                                    Edit Client
                                </c:if>
                                <c:if test="${client == null}">
                                    Add New Client
                                </c:if>
                            </h2>
                        </caption>

                        <c:if test="${client != null}">
                            <input type="hidden" name="idClient" value="<c:out value='${client.idClient}' />" />
                        </c:if>

                        <fieldset class="form-group">
                            <label>Nom</label> <input type="text" value="<c:out value='${client.nomClient}' />" class="form-control" name="nomClient" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Prenom</label> <input type="text" value="<c:out value='${client.prenomClient}' />" class="form-control" name="prenomClient" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Sexe</label> 
                                <div class="form-check">
                                    <input type="radio" name="sexeClient" value="<c:out value='masculin' />" />Masculin  
                                    <input type="radio" name="sexeClient" value="<c:out value='feminin' />"/>Feminin 
                                </div>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Situation matrimonial</label>
                            <select name="situationMatClient" class="form-control" aria-label="Default select example" value="<c:out value='${client.situationMatClient}'/>" /> 
                                <option selected>Marie</option>  
                                <option>Celibataire</option>  
                                <option>Veuve</option>  
                                <option>Divorce</option>  
                            </select>
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Adresse</label> <input type="text" value="<c:out value='${client.adresseClient}' />" class="form-control" name="adresseClient" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Telephone</label> <input type="text" value="<c:out value='${client.telephoneClient}' />" class="form-control" name="telephoneClient" required="required">
                        </fieldset>
                        <fieldset class="form-group">
                            <label>Email</label> <input type="text" value="<c:out value='${client.emailClient}' />" class="form-control" name="emailClient">
                        </fieldset>
                        <button type="submit" class="btn btn-success">Save</button>
                        </form>
                    </div>
                </div>
            </div>
        </body>

        </html>
