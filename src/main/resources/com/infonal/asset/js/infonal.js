/**
 * Created by hikuley on 22.08.2015.
 */

var app = angular.module('app', []);
app.controller('UserController', ['$scope', '$http', UserController]);

function UserController($scope, $http) {

    loadUserList();

    $scope.saveUpdateBtn = "Save";

    $scope.users = [];

    $scope.updateStatus = false;

    $scope.createAndUpdate = function () {
        if ($scope.updateStatus) {
            showLoadGif();
            var request = {
                user: $scope.user
            };
            $http.put("/userRest", request).then(function (response) {
                $scope.user = {};
                $('#myModal').foundation('reveal', 'close');
                loadUserList();
                hideLoadGif();
            }, function (response) {
                hideLoadGif();
            });
        }
        else {
            showLoadGif();
            var request = {
                user: $scope.user
            };
            $http.post("/userRest", request).then(function (response) {
                $scope.user = {};
                $('#myModal').foundation('reveal', 'close');
                loadUserList();
                hideLoadGif();
            }, function (response) {
                hideLoadGif();
            });
        }
    }

    $scope.delete = function (user) {
        showLoadGif();
        $http.delete("/userRest/" + user.id).then(function (response) {
            hideLoadGif();
            loadUserList();
        }, function (response) {

        });
    }

    $scope.openUpdateForm = function (user) {
        $scope.user = user;
        $scope.saveUpdateBtn = "Update";
        openForm();
        $scope.updateStatus = true;
    }

    $scope.openCreateForm = function () {
        $scope.user = {};
        $scope.saveUpdateBtn = "Save";
        openForm();
        $scope.updateStatus = false;
    }

    function loadUserList() {
        showLoadGif();
        $http.get("/userRest/all").then(function (response) {
            if (response.data.status == "SUCCESS") {
                $scope.users = response.data.userList;
                hideLoadGif();
            }
        }, function (response) {
            hideLoadGif();
        });
    }
}

function showLoadGif() {
    $("#load_gif").show();
}

function hideLoadGif() {
    $("#load_gif").hide();
}

function openForm() {
    $('#myModal').foundation('reveal', 'open');
}

function closeForm() {
    $('#myModal').foundation('reveal', 'close');
}

