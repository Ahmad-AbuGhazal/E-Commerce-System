<!DOCTYPE HTML>
<html>

<head>
    <meta charset="UTF-8">
    <meta name="viewport" content="width=device-width, initial-scale=1">
    <title>EStore</title>
    <link rel="stylesheet" href="resources/styles/bootstrap-3.3.7/css/bootstrap.min.css" />
    <link rel="stylesheet" href="resources/styles/main.css" />
    <link rel="stylesheet" type="text/css" href="resources/scripts/slick/slick.css" />
    <link rel="stylesheet" type="text/css" href="resources/scripts/slick/slick-theme.css" />
</head>

<body data-ng-app="estore" ng-controller="indexCtrl">
    <nav class="navbar navbar-default">
        <div class="container-fluid">
            <div class="navbar-header">
                <div style="height: 0.1em;"></div>
                <button type="button" class="navbar-toggle collapsed" data-toggle="collapse" data-target="#estore-navbar-collapse-1" aria-expanded="false">
                    <span class="sr-only">Toggle navigation</span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                    <span class="icon-bar"></span>
                </button>
                <a class="navbar-brand" href="#">
                    EStore Logo
                </a>
            </div>
            <div style="height: 0.5em;"></div>
            <div class="col-lg-1"></div>

            <div class="col-lg-7">
                <div class="input-group">
                    <div class="input-group-btn">
                        <button type="button" class="btn btn-default" dropdown-toggle data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">Categories <span class="caret"></span></button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuCategories">
                            <li><a href="#">Electronics</a></li>
                            <li><a href="#">Flowers</a></li>
                            <li><a href="#">Computers</a></li>
                            <li><a href="#">Mobile phones</a></li>
                        </ul>
                    </div>
                    <input type="text" class="form-control" placeholder="Search...">
                    <span class="input-group-btn">
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"></span> Search</button>
                    </span>
                </div>
            </div>

            <div class="collapse navbar-collapse" id="estore-navbar-collapse-1">
                <ul class="nav navbar-nav">
                    <li>
                        <div class="col-lg-1">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">Your Account <span class="caret"></span></button>

                                <ul class="dropdown-menu">
                                    <li>
                                        <div class="row">
                                            <div class="col-lg-8 col-lg-offset-3">
                                                <button type="button" class="btn btn-default">Sign In</button>
                                            </div>
                                            <div class="col-lg-11 col-lg-offset-1">
                                                <a href="#/vendor/register">Register New Account</a>
                                            </div>
                                        </div>
                                    </li>
                                    <li role="separator" class="divider"></li>
                                    <li><a href="#">Hottest Deals</a></li>
                                    <li><a href="#">View Orders</a></li>
                                    <li><a href="#">Offers and Discounts</a></li>
                                </ul>
                            </div>
                        </div>

                    </li>
                    <li>
                        <div class="col-lg-2">
                            <div class="btn-group">
                                <button type="button" class="btn btn-default dropdown-toggle" data-toggle="dropdown" aria-haspopup="true" aria-expanded="false">
                                    <span class="glyphicon glyphicon-shopping-cart" aria-hidden="true"> Cart</span>
                                </button>
                            </div>
                        </div>
                    </li>
                </ul>
            </div>

        </div>

    <div ng-view></div>


    <script src="http://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
     <script>
        jquery = $.noConflict();
    </script>
    <script type="text/javascript" src="resources/styles/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script type="text/javascript" src="resources/scripts/slick/slick.min.js"></script>
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.5.8/angular-route.min.js"></script>
    <script src="https://code.angularjs.org/1.5.8/angular-resource.min.js"></script>
    <script src="resources/scripts/routehandler.js"></script>
    
    <script src="resources/scripts/indexController.js"></script>
     <script src="resources/scripts/regService.js"></script>
    <script src="resources/scripts/regCtrl.js"></script>
</body>

</html>