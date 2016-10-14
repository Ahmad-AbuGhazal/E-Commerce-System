rapp.service('memService',[function() {
	this.sdata = {'data':[]};
	
	this.similarProdsData = {'data':[]};
	
	this.getsdata = function() {
		return this.sdata;
	}
	
	this.setsdata = function(data) {
		this.sdata = data;
	}
	
	this.getSimilarProdsData = function() {
		return this.similarProdsData;
	}
	
	this.setSimilarProdsData = function(data) {
		this.similarProdsData = data;
	}
}]);