rapp.service('searchService',['$http','$q','memService', function($http, $q, memService) {
    
    this.searchData = {
    		'data':[]
    };/*= {'data':[
            {
                'productId':'1',
                'productName': 'Samsung phone',
                'productPrice':'56.40',
                'productQuantity': '20',
                'image_link': 'http://www.technobuffalo.com/wp-content/uploads/2016/04/HTC-10-product-200x200.jpg',
                'description': 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
                'vendor': {
                	'vendor_id': 'COMP1003',
                	'vendor_name' : 'Weiwuu Wei',
                	'owner_name': 'ss',
                	'address': {
                		'street': '100N 34',
                		'city' : 'New York',
                		'state': 'NJ',
                		'zipcode': '51426'
                	}
                }
            },
            {
                'productId':'2',
                'productName': 'Apple phone',
                'productPrice':'56.40',
                'productQuantity': '20',
                'image_link': 'http://www.technobuffalo.com/wp-content/uploads/2016/10/Google-Pixel-product-image-200x200.jpg',
                'description': 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
                'vendor': {
                	'vendor_id': 'COMP1003',
                	'vendor_name' : 'Weiwuu Wei',
                	'owner_name': 'ss',
                	'address': {
                		'street': '100N 34',
                		'city' : 'New York',
                		'state': 'NJ',
                		'zipcode': '51426'
                	}
                }
            },
            {
                'productId':'3',
                'productName': 'Amazon Fire',
                'productPrice':'256.40',
                'productQuantity': '20',
                'image_link': 'http://www.technobuffalo.com/wp-content/uploads/2016/09/fire-hd-8-4-200x200.jpg',
                'description': 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
                'vendor': {
                	'vendor_id': 'COMP1003',
                	'vendor_name' : 'Weiwuu Wei',
                	'owner_name': 'ss',
                	'address': {
                		'street': '100N 34',
                		'city' : 'New York',
                		'state': 'NJ',
                		'zipcode': '51426'
                	}
                }
            },
            {
                'productId':'4',
                'productName': 'Nokia Lumia',
                'productPrice':'75.40',
                'productQuantity': '20',
                'image_link': 'http://ixchange.com.au/public/image/cache/data/Uploads_NoBackground/NOKIA/PHONES/nokia-lumia-1320-200x200.jpg',
                'description': 'Lorem Ipsum is simply dummy text of the printing and typesetting industry. Lorem Ipsum has been the industry\'s standard dummy text ever since the 1500s, when an unknown printer took a galley of type and scrambled it to make a type specimen book. It has survived not only five centuries, but also the leap into electronic typesetting, remaining essentially unchanged. It was popularised in the 1960s with the release of Letraset sheets containing Lorem Ipsum passages, and more recently with desktop publishing software like Aldus PageMaker including versions of Lorem Ipsum.',
                'vendor': {
                	'vendor_id': 'COMP1003',
                	'vendor_name' : 'Weiwuu Wei',
                	'owner_name': 'ss',
                	'address': {
                		'street': '100N 34',
                		'city' : 'New York',
                		'state': 'NJ',
                		'zipcode': '51426'
                	}
                }
            }
    ]};*/
    
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