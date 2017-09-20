var action = angular.module("Action", ["ngRoute", "ui.bootstrap"]);
action.config(function ($routeProvider, $locationProvider) {
    $routeProvider.when("/login", {
        templateUrl: "/view/login.jsp",
        controller: "LoginCTRL"
    });
    $routeProvider.when("/artist", {
        templateUrl: "/view/artist.jsp",
        controller: "ArtistCTRL"
    });

    $locationProvider.html5Mode(true);

});
action.controller("LoginCTRL", function ($scope, $http, $route, $routeParams, $location) {
    $scope.login = function (user) {

        var dataLogin = btoa(user.login + ":" + user.password);
        var req = {
            method: 'GET',
            url: '/',
            headers: {
                'Authorization': "Basic " + dataLogin
            }
        };
        $http(req)
            .then(function () {
                status($scope, $http, $route, $routeParams, $location);

            }, function () {
                status($scope, $http, $route, $routeParams, $location);
            });
    };

});

action.controller("UrlCtrl", function ($scope, $http, $route, $routeParams, $location) {
    status($scope, $http, $route, $routeParams, $location);


});
action.controller("ArtistCtrl", function ($scope, $http, $route, $routeParams, $location) {

});

function status($scope, $http, $route, $routeParams, $location) {
    var promise = $http.get("/api/auth/loginstatus");
    promise.then(fulfilled, rejected);

    function fulfilled(respons) {
        $scope.value = {status: true};
        var role = respons.data;
        if (role == "ARTIST") {
            $location.path("artist");
        }
    }

    function rejected(respons) {
        $scope.value = {status: false};
        $location.path("login");
    }
}


