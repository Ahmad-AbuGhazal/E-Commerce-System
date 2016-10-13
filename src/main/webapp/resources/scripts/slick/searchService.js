rapp.service('searchService',['$http','$q', function($http, $q) {
    
    this.searchData ={
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
    ]};
    
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