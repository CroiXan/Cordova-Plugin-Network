var networkOperator = {
  getNetworkOperator: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'NetworkOperator', 'getNetworkOperator', []);
  }
}

cordova.addConstructor(function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.networkOperator = networkOperator;
  return window.plugins.networkOperator;
});