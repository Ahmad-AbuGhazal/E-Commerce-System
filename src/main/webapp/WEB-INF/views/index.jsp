<!DOCTYPE HTML>
<html >

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
                        <button type="button" class="btn btn-default" dropdown-toggle data-toggle="dropdown" aria-haspopup="true" aria-expanded="true">{{categoryName}} <span class="caret"></span></button>
                        <ul class="dropdown-menu" aria-labelledby="dropdownMenuCategories">
                            <li ng-repeat="cat in catList"><a ng-click="catClick(cat.categoryName)">{{cat.categoryName}}</a></li>
                        </ul>
                    </div>
                    <script type="text/ng-template" id="searchTemplate1.html">
                        <a href="#/products/{{match.model.productName}}">
                            <div>
                                <span ng-bind-html="match.model.productName | uibTypeaheadHighlight:query"></span>
                            </div>

                        </a>
                    </script>
                    <input type="text" class="form-control" placeholder="Search..." ng-model="searchQuery" ng-change="search()"
                            id='searchBox' uib-typeahead="product as product.productName for product in searchData | filter:{productName:$viewValue} | limitTo:10" typeahead-show-hint="true" typeahead-on-select="mo($item, $model, $label, $event)"
                           typeahead-template-url="searchTemplate1.html" ng-keypress="searchEnter($event)">
        
                    
                    <span class="input-group-btn">
                            <button type="button" class="btn btn-default"><span class="glyphicon glyphicon-search"
                                      ng-click="searchClick()"></span> Search</button>
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
                                                <button type="button" class="btn btn-default" ng-click="login()">Sign In</button>
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

    </nav>

    <div ng-view></div>



    <script src="http://code.jquery.com/jquery-3.1.1.min.js" integrity="sha256-hVVnYaiADRTO2PzUGmuLJr8BLUSjGIZsDYGmIJLv2b8=" crossorigin="anonymous"></script>
    <script>
        jquery = $.noConflict();
    </script>
    
    <script type="text/javascript" src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular.min.js"></script>
    <script src="https://code.angularjs.org/1.5.8/angular-route.min.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-animate.js"></script>
    <script src="https://ajax.googleapis.com/ajax/libs/angularjs/1.5.8/angular-sanitize.js"></script>
    <script src="https://angular-ui.github.io/bootstrap/ui-bootstrap-tpls-2.2.0.js"></script>
    <script src="resources/scripts/routehandler.js"></script>
    <script src="resources/scripts/indexController.js"></script>
     <script src="resources/scripts/regService.js"></script>
    <script src="resources/scripts/regCtrl.js"></script>
    <script src="resources/scripts/searchService.js"></script>
    <script src="resources/scripts/productsCtrl.js"></script>
    <script src="resources/scripts/memService.js"></script>
    <!-- login module -->
    <script src="resources/scripts/modules/login/logCtrl.js"></script>
    <!-- Payment module -->

    <script src="resources/scripts/modules/payment/cardFilter.js"></script>
    <script src="resources/scripts/modules/payment/paymentService.js"></script>
    <script src="resources/scripts/modules/payment/paymentcontroller.js"></script>
    
    
    <!-- Order module -->
 <script src="resources/scripts/modules/order/orderService.js"></script>
    <script src="resources/scripts/modules/order/orderController.js"></script>
   

    <script src="resources/styles/bootstrap-3.3.7/js/bootstrap.min.js"></script>
    <script src="resources/scripts/slick/slick.min.js"></script>
   
</body>

</html>