rapp.controller('productsCtrl', [
		'$scope',
		'$location',
		'searchService',
		'memService',
		function($scope, $location, searchService, memService) {
			$scope.productList = memService.getsdata();

			$scope.mo = function() {
				console.log(window.encodeURIComponent($location.path().split(
						"/")[2]));
			}
		} ]);

rapp.controller('productDetailCtrl', [
		'$scope',
		'$location',
		'searchService',
		'memService',
		'cartService',
		function($scope, $location, searchService, memService, cartService) {
			// $scope.productDetail =
			// searchService.searchOne($location.path().split("/")[2]);

			$scope.productDetails = searchService.searchOne(window
					.encodeURIComponent($location.path().split("/")[2]));

			if (!$scope.productDetails) {
				searchService.searchById($location.path().split("/")[2]).then(
						function(data) {
							$scope.productDetails = data;
							console.log($scope.productDetails);
						});

			}

			getSimilarProdsData();

			this.reload = function() {
				$scope.productDetails = searchService.searchOne(window
						.encodeURIComponent($location.path().split("/")[2]));

				getSimilarProdsData();
			}

			function getSimilarProdsData() {
				searchService
						.searchSimilarProds($location.path().split("/")[2])
						.then(
								function() {
									$scope.similarProducts = memService
											.getSimilarProdsData();
									// console.log($scope.similarProducts);
								}, function(error) {

								});
			}

			$scope.addCart = function(prodId) {
				cartService.setProdId(prodId);
				$location.path("/mycart");
			}

		} ]);