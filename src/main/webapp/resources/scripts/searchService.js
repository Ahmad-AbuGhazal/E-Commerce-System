rapp.service('searchService',['$http','$q','memService', function($http, $q, memService) {
    
    this.searchData = {
    		'data':[]
    };
    
    this.searchOneRes;
    this.similarProds;
    
    this.getSearchData = function() {
    	return this.searchData.data;
    };
    
    var callbacks = [];
    
    this.registerCallback = function(callbackFunc) {
    	callbacks.push(callbackFunc);
    };
    
    function notify(data) {
    	angular.forEach(callbacks, function(callback) {
    		callback(data);
    	})
    };
    
    this.response = function(response) {
    	notify(response.data.data);
    	memService.setsdata(response.data.data);
    };
    
    this.search = function(query, category) {
    	
       search(query, category).then(this.response, function(error) {
        	console.log(this.error);
        });
    }
    
    this.searchOne = function(productId) {
    	var data = memService.getsdata();
        for(var i=0;i<data.length;i++) {
            var item = data[i];
            if(item.productId == productId) {
                this.searchOneRes = item;
                break;
            }
        }
        return this.searchOneRes;
    }
    
    this.searchById = function(productId) {
    	var deferred = $q.defer();
    	searchById(productId).then(function(response) {
    		memService.getsdata().push(response);
        	deferred.resolve(response);
        }, function(error) {
        	console.log(this.error);
        	deferred.reject(error);
        });
    	return deferred.promise;
    }
    
    this.searchSimilarProds = function(productId) {        
        //get similar products from server
    	var deferred = $q.defer();
    	searchSimilarProds(productId).then(function(response) {
        	memService.setSimilarProdsData(response.data.data);
        	deferred.resolve();
        }, function(error) {
        	console.log(this.error);
        	deferred.reject(error);
        });
    	return deferred.promise;
    }
    
    this.getCategories = function() {
    	var deferred = $q.defer();
    	getCategories().then(function(response) {
        	memService.setCatList(response.data);
        	deferred.resolve();
        }, function(error) {
        	console.log(this.error);
        	deferred.reject(error);
        });
    	return deferred.promise;
    }
    
    function search(productName, categoryName) {
        var linkUrl ="products";
        var deferred = $q.defer();
        $http({
            method : 'GET',
            url : linkUrl,
            params: {'productName':productName, 'productCategory' : categoryName}
        }).then(function(data) {
            deferred.resolve(data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function searchById(productId) {
        var linkUrl ="products/"+productId;
        var deferred = $q.defer();
        $http({
            method : 'GET',
            url : linkUrl
        }).then(function(data) {
            deferred.resolve(data.data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function searchSimilarProds(productId) {
        var linkUrl ="products/"+productId+"/names";
        var deferred = $q.defer();
        $http({
            method : 'GET',
            url : linkUrl
        }).then(function(data) {
            deferred.resolve(data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function getCategories() {
    	var linkUrl ="categories";
        var deferred = $q.defer();
        $http({
            method : 'GET',
            url : linkUrl
        }).then(function(response) {
            deferred.resolve(response.data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
}]);