rapp.service('regService',['$http','$q','$location', function($http, $q, $location) {
    var credDetails = {};
    var userDetails = {};
    var cardDetails= {};
    
    var registerResponse = {};
    
    
    this.getCredDetails = function getCredDetails() {
        return credDetails;
    };
    this.getUserDetails = function getUserDetails() {
        return userDetails;
    };
    this.getCardDetails = function getCardDetails() {
        return cardDetails;
    };   
    this.registerResponse = function getRegisterResponse() {
        return registerResponse;
    };
    
    this.register = function register(userDetails, cardDetails) {
       // if(userDetails.userType.toLowerCase()=="vendor") {
            var vendorDetails = {
                'vendor_id' : userDetails.vendorId,
                'vendor_name' : userDetails.vendorName,
                'owner_name' : userDetails.ownerName,
               'address': {
                    'street':userDetails.street,
                    'city':userDetails.city,
                    'state':userDetails.state,
                    'zipcode':userDetails.zipcode
                },
                'requestedCard':{
                    'cardType': cardDetails.cardType,
                    'cardHolder': cardDetails.cardHolder,
                    'cardNum': cardDetails.cardNum,
                    'securityCode': cardDetails.securityCode,
                    'purchaseAmount': 12000.00
                }
            };
            return registerVendor(vendorDetails);
            
        //} else if(userDetails.userTYpe.toLowerCase()=="customer") {
            
        //}
    }
    
    function registerVendor(vendorDetails) {
        var linkUrl = $location.host()+";"+$location.port+"/estore/vendor/add";
        var deferred = $q.defer();
        var req = $http({
            method : 'POST',
            url : linkUrl,
            data : vendorDetails,
            headers : {'Content-Type' : 'application/json'}
        }).then(function(data) {
            deferred.resolve(data);
        }, function(error) {
            deferred.reject(error);
        });
        return deferred.promise;
    }
    
    function registerCustomer(customerDetails) {
        
    }
}]);