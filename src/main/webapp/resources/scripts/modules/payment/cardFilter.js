rapp.filter('visaFilter', [function () {  
    return function (cardnumber) {
      if (!cardnumber) { return ''; }
       var lastFourDigit=   cardnumber.substr(10,cardnumber.length);
       var returnValue="***"+lastFourDigit;
       return returnValue;
    }
}]);