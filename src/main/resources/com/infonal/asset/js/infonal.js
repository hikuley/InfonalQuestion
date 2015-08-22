/**
 * Created by hikuley on 22.08.2015.
 */

var app = angular.module('app', []);
app.controller('UserController', ['$scope', '$http', UserController]);

function UserController($scope, $http) {

    loadUserList();

    $scope.saveUpdateBtn = "Save";

    $scope.deleteUser = {};

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

    $scope.delete = function () {
        showLoadGif();
        $http.delete("/userRest/" + $scope.deleteUser.id).then(function (response) {
            hideLoadGif();
            loadUserList();
            $("#deleteModal").foundation('reveal', 'close');
        }, function (response) {
            hideLoadGif();
        });
    }

    $scope.closeDeleteModal = function () {
        $("#deleteModal").foundation('reveal', 'close');
        $scope.deleteUser = {};
    }

    $scope.openCreateForm = function () {
        $scope.user = {};
        $scope.saveUpdateBtn = "Save";
        openForm();
        $scope.updateStatus = false;
    }


    $scope.openUpdateForm = function (user) {
        $scope.user = user;
        $scope.saveUpdateBtn = "Update";
        openForm();
        $scope.updateStatus = true;
    }

    $scope.openDeleteModal = function (user) {
        $("#deleteModal").foundation('reveal', 'open');
        $scope.deleteUser = user;
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

