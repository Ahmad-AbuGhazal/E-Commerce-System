rapp.controller('cartCtrl', [ '$rootScope',
		'$scope',
		'$location',
		'cartService',
		'memService',
		'searchService',
		function($rootScope,$scope, $location, cartService, memService, searchService) {
			// $scope.productList = memService.getsdata();
			$scope.prodId;
			$scope.qty = 1;
			$scope.cart;

			$scope.hideFirst = false;
			$scope.selVals = [];

			$scope.productDetails = searchService.searchOne(cartService
					.getProdId());
			/*if($scope.productDetails==null) {
				searchService.searchById(cartService.getProdId()).then(function(data) {
					$scope.productDetails = data;
					$scope.prodId=$scope.productDetails.productId;
				});			
			}*/
			for (var i = 1; i <= 100; i++)
				$scope.selVals.push(i);
			if ($scope.productDetails) {
				/*for (var i = 1; i <= 100; i++)
					$scope.selVals.push(i);*/
				$scope.prodId = $scope.productDetails.productId;
			} else {
				searchService.searchById(cartService.getProdId()).then(function(data) {
					$scope.productDetails = data;
				});
			}

			$scope.checkout = function() {
				console.log($scope.cart);
				cartService.checkout();
			};

			function getCartx() {
				$scope.cart = memService.getCart();
			}
			
			$scope.removeCart = function(prodId, qtyx) {
				cartService.removeCart(prodId, qtyx).then(function() {
					getCartx();
				});
			};

			$scope.getCart = function() {
				$scope.cart = cartService.getCart();
			};

			$scope.addCart = function() {
				console.log($scope.prodId, $scope.qty);
				cartService.addCart($scope.prodId, $scope.qty).then(
						function(response) {
							console.log(response);
							$scope.hideFirst = true;
							console.log($scope.hideFirst);
							$scope.productDetails = null;
							getCartx();
						});
			};
			
			getCartx();
		} ]);

rapp.service('cartService', [ '$http', '$q', 'memService','searchService',
		function($http, $q, memService, searchService) {

			this.prodId;
			this.prodQuantity;

			this.getProdId = function() {
				return this.prodId;
			};
			this.setProdId = function(id) {
				this.prodId = id;
			};
			this.getProdQuantity = function() {
				return this.prodQuantity;
			};
			this.setProdQuantity = function(qty) {
				this.prodQuantity = qty;
			};

			/** add items to the shopping cart * */
			this.addCart = function(prodId, qty) {
				var deferred = $q.defer();
				addCart(prodId, qty).then(function(response) {
					memService.addCartItem(response);
					deferred.resolve(response);
				}, function(error) {
					console.log(this.error);
					deferred.reject(error);
				});
				return deferred.promise;
			};

			function addCart(prodId, qty) {
				var prod;
				var deferred = $q.defer();
				searchService.searchById(prodId).then(function(data) {
					prod = angular.copy(data.data);
					prod[0].purchaseQty = qty;
					deferred.resolve(prod);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
				/*var linkUrl = "shopping/" + prodId + "/" + qty;
				var deferred = $q.defer();
				$http({
					method : 'GET',
					url : linkUrl
				}).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;*/
			}

			/** remove items in cart * */
			this.removeCart = function(prodId, qty) {
				var deferred = $q.defer();
				removeCart(prodId, qty).then(function() {
					deferred.resolve();
				}, function() {
					console.log();
					deferred.reject();
				});
				return deferred.promise;
			};

			function removeCart(prodId, qty) {
				var deferred = $q.defer();
				memService.removeCartItem(prodId, qty).then(function() {
					deferred.resolve();
				});
				
				return deferred.promise;
				/*var linkUrl = "shopping/remove/" + prodId + "/" + qty;
				var deferred = $q.defer();
				$http({
					method : 'GET',
					url : linkUrl
				}).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;*/
			}

			/** get items in the shopping cart * */
			this.getCart = function() {
				return memService.getCart();
				/*var deferred = $q.defer();
				getCart().then(function(data) {
					deferred.resolve(data);
				});
				return deferred.promise;*/
			};

			function getCart() {
				var deferred = $q.defer();
				var data = memService.getCart();
				deferred.resolve(data);
				return deferred.promise;
				/*var linkUrl = "shopping/products";
				var deferred = $q.defer();
				$http({
					method : 'GET',
					url : linkUrl
				}).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;*/
			}

			/** checkout * */
			this.checkout = function() {
				var deferred = $q.defer();
				checkout().then(function(response) {
					deferred.resolve();
				}, function(error) {
					console.log(this.error);
					deferred.reject(error);
				});
				return deferred.promise;
			};

			function checkout() {
				var linkUrl = "shopping/processtoCheckout";
				var deferred = $q.defer();
				var cartDetails = {
					'data' : memService.getCart()
				};
				$http({
					method : 'POST',
					url : linkUrl,
					data : cartDetails
				}).then(function(response) {
					deferred.resolve(response.data);
				}, function(error) {
					deferred.reject(error);
				});
				return deferred.promise;
			}
		} ]);
