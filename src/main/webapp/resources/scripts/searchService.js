rapp.service('searchService',['$http','$q', function($http, $q) {
    
    /*this.searchData ={
        'data':[
            {
                'id':'1',
                'name': 'Samsung phone',
                'image': 'image_link',
                'description': 'This is a samsung phone'
            },
             {
                'id':'1',
                'name': 'Apple phone',
                'image': 'image_link',
                'description': 'This is a apple phone'
            }
    ]};*/
    this.searchData = {'data':[
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
    ]};
    
    this.searchOneRes;
    this.similarProds;
    
    this.search = function(query) {
        
       /* search(query).then(function(data) {
            console.log(data);
            searchData = data;
        }, function(error) {
            console.log(error);
        });*/
        return this.searchData.data;
    }
    
    this.searchOne = function(productId) {
        for(var i=0;i<this.searchData.data.length;i++) {
            var item = this.searchData.data[i];
            if(item.productId == productId) {
                this.searchOneRes = item;
                break;
            }
        }
        return this.searchOneRes;
    }
    
    this.searchSimilarProds = function(productId) {
        
        //get similar products from server
        
        this.similarProds = this.searchData;
        return this.similarProds.data;
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