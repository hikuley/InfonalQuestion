<%@ taglib prefix="c" uri="http://java.sun.com/jsp/jstl/core" %>
<%--
  Created by IntelliJ IDEA.
  User: hikuley
  Date: 21.08.2015
  Time: 12:23
  To change this template use File | Settings | File Templates.
--%>
<%@ page contentType="text/html;charset=UTF-8" language="java" %>
<html>
<head>
    <link rel="stylesheet" href="<c:url value="/css/normalize.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/foundation.css"/>"/>
    <link rel="stylesheet" href="<c:url value="/css/infonalStyle.css"/>"/>
    <script type="text/javascript" src="<c:url value="/js/jquery.2.1.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/foundation.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/foundation.reveal.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/angular.min.js"/>"></script>
    <script type="text/javascript" src="<c:url value="/js/infonal.js"/>"></script>
    <title>Infonal</title>
</head>
<body ng-app="app">

<div class="wrap" ng-controller="UserController">


    <div class="row header-userlist">
        <h5>User List
        </h5>
        <a href="#" class="button radius new_user_button" ng-click="openCreateForm()">Create User</a>
    </div>

    <div class="row user-data-table">

        <table>
            <thead>
            <tr>
                <th class="user-table-th">Citizen Number</th>
                <th class="user-table-th">Name</th>
                <th class="user-table-th">Surname</th>
                <th class="user-table-th">Cell Phone</th>
                <th class="user-table-th">Work Phone</th>
                <th class="user-table-th">E-Mail</th>
                <%--<th class="user-table-th">Address</th>--%>
                <th class="user-table-th"></th>

            </tr>
            </thead>
            <tbody>
            <tr ng-repeat="user in users">
                <td>{{user.citizenNumber}}</td>
                <td>{{user.name}}</td>
                <td>{{user.surname}}</td>
                <td>{{user.cellPhone}}</td>
                <td>{{user.workPhone}}</td>
                <td>{{user.email}}</td>
                <%--<td>{{user.address}}</td>--%>
                <td>
                    <button ng-click="openDeleteModal(user)" class="table_btn button tiny alert">Delete</button>
                    <button ng-click="openUpdateForm(user)" class="table_btn button tiny success">Update</button>
                </td>
            </tr>
            </tbody>
        </table>

        <%--create modal--%>
        <div id="myModal" class="reveal-modal" data-reveal aria-labelledby="modalTitle" aria-hidden="true"
             role="dialog">

            <p class="lead">User Create</p>

            <a class="close-reveal-modal" aria-label="Close">&#215;</a>

            <form ng-model="user" name="userForm" novalidate>
                <div class="row">
                    <div class="small-12 columns">

                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline">Citizen Number</label>
                            </div>
                            <div class="small-9 columns">
                                <input name="citizenNumber" ng-minlength="10" ng-maxlength="12"
                                       ng-model="user.citizenNumber" type="text"
                                       placeholder="Citizen Number">
                                <span class="error" ng-show="!userForm.citizenNumber.$valid">Characters length minumum 10 and maximum 12</span>
                            </div>
                        </div>

                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline">Name</label>
                            </div>
                            <div class="small-9 columns">
                                <input name="name" ng-model="user.name" type="text" placeholder="Name" required>
                                <span class="error" ng-show="!userForm.name.$valid">Required!</span>
                            </div>
                        </div>
                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline">Surname</label>
                            </div>
                            <div class="small-9 columns">
                                <input ng-model="user.surname" type="text" placeholder="Surname">
                            </div>
                        </div>
                        <div class="row">
                            <div class="small-3 columns">

                                <label for="right-label" class="right inline">Cell Phone</label>
                            </div>
                            <div class="small-9 columns">
                                <input ng-model="user.cellPhone" type="text" placeholder="Work Phone">
                            </div>
                        </div>
                        <div class="row">
                            <div class="small-3 columns">

                                <label for="right-label" class="right inline">Work Phone</label>
                            </div>
                            <div class="small-9 columns">
                                <input ng-model="user.workPhone" type="text" placeholder="Work Phone">
                            </div>
                        </div>

                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline">E-Mail</label>
                            </div>
                            <div class="small-9 columns">
                                <input ng-model="user.email" name="email" type="email" placeholder="E-Mail">
                                <span class="error" ng-show="userForm.email.$error.email">Not valid email!</span>
                            </div>
                        </div>

                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline">Address</label>
                            </div>
                            <div class="small-9 columns">
                                <input ng-model="user.address" type="text" placeholder="Address">
                            </div>
                        </div>

                        <div class="row">
                            <div class="small-3 columns">
                                <label for="right-label" class="right inline"></label>
                            </div>

                            <div class="small-9 columns">
                                <button class="button tiny user_save_button" ng-click="createAndUpdate()">
                                    {{saveUpdateBtn}}
                                </button>
                            </div>

                        </div>

                    </div>
                </div>
            </form>


        </div>
        <%--create modal--%>


    </div>

    <div id="deleteModal" class="reveal-modal" data-reveal aria-labelledby="modalTitle" aria-hidden="true"
         role="dialog">
        <p>Are you sure you want to delete user?</p><br/>
        <a href="#" class="button tiny" ng-click="closeDeleteModal()">No</a>
        <a href="#" class="button tiny" ng-click="delete()">Yes</a>
    </div>

</div>

<div id="load_gif">
    <img src="<c:url value="/images/support-loading.gif"/>" alt=""/>
</div>


</body>
</html>
