<!DOCTYPE html>
<html ng-app="Action">
<head>
    <base href="/">
    <meta name="viewport" content="width=device-width, initial-scale=1.0, maximum-scale=1.0, user-scalable=no">
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <script src="js/jquery-3.1.0.min.js"></script>
    <link href="/css/mdb.css" rel="stylesheet">
    <link href="/css/bootstrap.css" rel="stylesheet">
    <script src="/js/bootstrap.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.6.1/angular.min.js"></script>
    <script src="/js/angular-route.js"></script>
    <script src="http://ajax.googleapis.com/ajax/libs/angularjs/1.4.8/angular-animate.js"></script>
    <script src="/js/angular-route.js"></script>
    <script data-require="angular-ui-bootstrap@0.11.0" data-semver="0.11.0"
            src="http://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-0.11.0.js"></script>
    <link rel="icon" href="/images/favicon.ico" type="image/x-icon">
    <link href="/css/css.css" rel="stylesheet">
    <link rel="stylesheet" href="/css/style.css">
    <script src="/js/app.js"></script>
    <script src="/js/spin.js"></script>


    <!-- <base href="http://109.167.132.145/">-->
</head>
<body ng-cloak ng-controller="UrlCtrl">

Hello
<div>{{1+2}}</div>

<ng-include ng-cloak src="url.header"></ng-include>
<div ng-cloak ng-view></div>
<ng-include ng-cloak src="url.footer"></ng-include>

</body>

</html>