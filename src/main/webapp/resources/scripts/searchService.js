rapp.service('searchService',['$http','$q', function($http, $q) {
    
    this.searchData =[
            {
                'productId':'1',
                'productName': 'Samsung phone',
                'productPrice':'56.40',
                'productQuantity': '20',
                'image_link': 'image_link',
                'description': 'This is a samsung phone',
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
                'productId':'1',
                'productName': 'Apple phone',
                'productPrice':'56.40',
                'productQuantity': '20',
                'image_link': 'image_link',
                'description': 'This is a apple phone',
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
    ];
    
    this.search = function(query) {
        
       /* search(query).then(function(data) {
            console.log(data);
            searchData = data;
        }, function(error) {
            console.log(error);
        });*/
        return this.searchData.data;
    }
    
    function search(query) {
        var linkUrl = 'products/';
        var deferred = $q.defer();
        $http({
            method : 'GET',
            url : linkUrl,
            data : query
        }).then(function(data) {
            deferred.resolve(data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
}]);