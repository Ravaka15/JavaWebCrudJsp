<%-- 
    Document   : list_Client
    Created on : 19 janv. 2023, 18:25:13
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

            <div class="row">
                <!-- <div class="alert alert-success" *ngIf='message'>{{message}}</div> -->

                <div class="container">
                    <h3 class="text-center">List Client</h3>
                    <hr>
                    <div class="container text-left">

                        <a href="<%=request.getContextPath()%>/new" class="btn btn-success">Ajout client</a>
                    </div>
                    <br>
                    <table class="table table-bordered">
                        <thead>
                            <tr>
                                <th>Id</th>
                                <th>Nom</th>
                                <th>Prenom</th>
                                <th>Sexe</th>  
                                <th>Adresse</th>
                                <th>Situation Matrimonial</th>
                                <th>E-mail </th>
                                <th>Option</th>
                            </tr>
                        </thead>
                        <tbody>
                            <!--   for (Todo todo: todos) {  -->
                            <c:forEach var="client" items="${listClient}">

                                <tr>
                                    <td>
                                        <c:out value="${client.idClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.nomClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.prenomClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.sexeClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.adresseClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.situationMatClient}" />
                                    </td>
                                    <td>
                                        <c:out value="${client.emailClient}" />
                                    </td>
                                    <td><a href="edit?id=<c:out value='${client.idClient}' />">Edit</a> &nbsp;&nbsp;&nbsp;&nbsp; <a href="delete?id=<c:out value='${client.idClient}' />">Delete</a></td>
                                </tr>
                            </c:forEach>
                            <!-- } -->
                        </tbody>

                    </table>
                </div>
            </div>
        </body>

        </html>