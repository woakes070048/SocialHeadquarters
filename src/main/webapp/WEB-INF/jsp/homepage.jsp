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
<script data-main="../resources/static/app/main.js" src="../resources/static/app/node_modules/requirejs/require.js"></script>
<link rel="stylesheet" href="../resources/static/app/node_modules/bootstrap/dist/css/bootstrap.css">
<link rel="stylesheet" href="../resources/static/assets/css/custom.css">
<link rel="stylesheet" href="../resources/static/assets/css/ngDialog.css">

</body>
</html>