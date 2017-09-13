var action = angular.module("Action", ["ngRoute", "ui.bootstrap"]);
action.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when("/login", {
        templateUrl: "/view/login.jsp",
        controller: "LoginCTRL"
    });

    $locationProvider.html5Mode(true);

});
action.controller("LoginCTRL", function ($scope, $http, $location) {


});

action.controller("UrlCtrl", function ($scope, $http, $route, $routeParams, $location) {

    $scope.controllerValue = {};
    var status = function () {
        var promise = $http.get("/api/auth/loginstatus");
        promise.then(fulfilled, rejected)
    };

    function fulfilled(respons) {
        $scope.value = {status: true}
    }

    function rejected(respons) {
        $scope.value = {status: false};
        $location.path("login");

    }

    status();


});



