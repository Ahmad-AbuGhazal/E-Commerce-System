rapp
		.service(
				'regService',
				[
						'$http',
						'$q',
						'$location',
						function($http, $q, $location) {
							var credDetails = {};
							var userDetails = {};
							var cardDetails = {};

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

							this.registerUser = function register(userType,
									credDetails, userDetails, cardDetails) {
								if (userType == "Vendor") {
									var vendorDetails = {
										'vendor_id' : userDetails.vendorId,
										'vendor_name' : userDetails.vendorName,
										'owner_name' : userDetails.ownerName,
										'address' : {
											'street' : userDetails.street,
											'city' : userDetails.city,
											'state' : userDetails.state,
											'zipcode' : userDetails.zipcode
										},
										'requestedCard' : {
											'cardType' : (cardDetails.cardType == "MasterCard") ? 'master'
													: 'visa',
											'cardHolder' : cardDetails.cardHolder,
											'cardNum' : cardDetails.cardNum,
											'securityCode' : cardDetails.securityCode,
											'purchaseAmount' : 12000.00
										},
										'userCredentials' : {
											'username' : credDetails.email,
											'password' : credDetails.password1,
											'verifyPassword' : credDetails.password2
										}
									};
									return registerx(1, vendorDetails);

								} else if (userDetails.userType == "Customer") {
									var customerDetails = {
										'firstName' : userDetails.customer.firstName,
										'lastName' : userDetails.customer.lastName,
										'email' : credDetails.email,
										'address' : {
											'street' : userDetails.street,
											'city' : userDetails.city,
											'state' : userDetails.state,
											'zipcode' : userDetails.zipcode
										},
										'requestedCard' : {
											'cardType' : (cardDetails.cardType == "MasterCard") ? 'master'
													: 'visa',
											'cardHolder' : cardDetails.cardHolder,
											'cardNum' : cardDetails.cardNum,
											'securityCode' : cardDetails.securityCode
										},
										'userCredentials' : {
											'username' : credDetails.email,
											'password' : credDetails.password1,
											'verifyPassword' : credDetails.password2
										}

									};
									return registerx(2, customerDetails);
								}
							}

							function registerx(userType, details) {
								var linkUrl = '';
								if (userType == 1)
									linkUrl = "vendor/add/";
								else
									linkUrl = "customer/add/";

								var deferred = $q.defer();
								var req = $http({
									method : 'POST',
									url : linkUrl,
									data : details,
									headers : {
										'Content-Type' : 'application/json'
									}
								}).then(function(data) {
									console.log(data.data);
									deferred.resolve(data.data);
								}, function(error) {
									deferred.reject(error);
								});
								return deferred.promise;
							}
						} ]);