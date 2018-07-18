var networkOperator = {
  getNetworkOperator: function (successCallback, errorCallback) {
    cordova.exec(successCallback, errorCallback, 'networkOperator', 'getNetworkOperator', []);
  }
}

cordova.addConstructor(function () {
  if (!window.plugins) {
    window.plugins = {};
  }

  window.plugins.networkOperator = networkOperator;
  return window.plugins.networkOperator;
});