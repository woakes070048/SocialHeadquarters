<!DOCTYPE html>
<!--[if lt IE 7]>      <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8 lt-ie7"> <![endif]-->
<!--[if IE 7]>         <html lang="en" ng-app="app" class="no-js lt-ie9 lt-ie8"> <![endif]-->
<!--[if IE 8]>         <html lang="en" ng-app="app" class="no-js lt-ie9"> <![endif]-->
<!--[if gt IE 8]><!--> <html lang="en" ng-app="app" class="no-js"> <!--<![endif]-->
<head>
    <meta charset="utf-8">
    <meta http-equiv="X-UA-Compatible" content="IE=edge">
    <title>Social Headquarters</title>
    <meta name="description" content="">
    <meta name="viewport" content="width=device-width, initial-scale=1">
</head>
<body>
    <nav class="navbar navbar-default navbar-fixed-top">
    <div class="container">
        <div class="navbar-header">
          <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#navbar" aria-expanded="false" aria-controls="navbar">
            <span class="sr-only">Toggle navigation</span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
            <span class="icon-bar"></span>
          </button>
          <a class="navbar-brand" href="#/">Social Headquarters</a>
        </div>
        <div id="navbar" class="navbar-collapse collapse">
        <ul class="nav navbar-nav">
        <li><a href="#/users">Users Administration</a></li>
        <li><a href="#/brands">Brands</a></li>
        <li><a href="#/contactus">Contact</a></li>
    </ul>
    </div>
    </div>
        </nav>

<div class="container" ng-view></div>
<script src="./webjars/angularjs/1.5.0/angular.js"></script>
<script src="./webjars/angularjs/1.5.0/angular-resource.js"></script>
<script src="./webjars/angularjs/1.5.0/angular-route.js"></script>
<script src="../resources/static/js/app.js"></script>
<script src="../resources/static/js/controller.js"></script>
<script src="../resources/static/js/user_service.js"></script>
<script src="../resources/static/js/user_controller.js"></script>
<script src="../resources/static/js/brand_service.js"></script>
<script src="../resources/static/js/brand_controller.js"></script>
<script src="../resources/static/js/manageBrand_service.js"></script>
<script src="../resources/static/js/manageBrand_controller.js"></script>
<script src="../resources/static/js/ngDialog.js"></script>
<script src="../resources/static/js/directives.js"></script>
<script src="http://pc035860.github.io/angular-easyfb/angular-easyfb.min.js"></script>
<script src="./webjars/angular-ui-bootstrap/1.1.1-1/ui-bootstrap.js"></script>
<link rel="stylesheet" href="./webjars/bootstrap/3.3.6/css/bootstrap.css">
<link rel="stylesheet" href="../resources/static/css/custom.css">
<link rel="stylesheet" href="../resources/static/css/ngDialog.css">

</body>
</html>