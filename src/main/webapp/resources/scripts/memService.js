rapp.service('memService',['$q',function($q) {
	this.sdata = {'data':[]};
	
	this.similarProdsData = {'data':[]};
	
	this.catList = [];
	
	this.cart = {};
	this.cart.data=[];
	
	console.log('memService');
	
	this.getCart = function() {
		this.cart = JSON.parse(localStorage.getItem("cart"));
		if(!this.cart) {
			this.cart = {};
			this.cart.data = [];
		} else if(!this.cart.data) {
			this.cart.data = [];
		}
		return this.cart.data;
	}
	
	this.setCart = function(cartx) {
		localStorage.setItem("cart", JSON.stringify(cartx));
		this.cart = cartx;
	}
	
	this.addCartItem = function(item) {
		this.cart = JSON.parse(localStorage.getItem("cart"));
		if(!this.cart) {
			this.cart = {};
			this.cart.data = [];
		} else if(!this.cart.data) {
			this.cart.data = [];
		}
		this.cart.data = this.cart.data.concat(item);
		localStorage.setItem("cart", JSON.stringify(this.cart));
	}
	
	this.removeCartItem = function(prodId, qty) {
		var deferred = $q.defer();
		var index = -1;
		for(var i=0;i<this.cart.data.length;i++) {
			var item = this.cart.data[i];
			if(item.productId == prodId && item.purchaseQty == qty) {
				index = i;
				break;
			}
		}
		if(index!=-1) {
			this.cart.data.splice(index, 1);
			this.setCart(this.cart);
		}
		deferred.resolve();
		return deferred.promise;
	}
	
	this.getsdata = function() {
		this.sdata = JSON.parse(localStorage.getItem("sdata"));
		return this.sdata;
	}
	
	this.setsdata = function(data) {
		localStorage.setItem("sdata", JSON.stringify(data));
		this.sdata = data;
	}
	
	this.getSimilarProdsData = function() {
		this.similarProdsData = JSON.parse(localStorage.getItem("sprod"));
		return this.similarProdsData;
	}
	
	this.setSimilarProdsData = function(data) {
		localStorage.setItem("sprod", JSON.stringify(data));
		this.similarProdsData = data;
	}
	
	this.getCatList = function() {
		this.catList = JSON.parse(localStorage.getItem('catList'));
		return this.catList;
	}
	
	this.setCatList = function(data) {
		localStorage.setItem('catList', JSON.stringify(data));
		this.catList = data;
	}
}]);