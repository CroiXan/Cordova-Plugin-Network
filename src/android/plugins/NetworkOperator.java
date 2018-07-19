/**
 */
package plugins;

import android.app.Activity;
import org.apache.cordova.CallbackContext;
import org.apache.cordova.CordovaPlugin;
import org.json.JSONObject;
import org.json.JSONArray;
import org.json.JSONException;
import android.content.Context;
import android.telephony.TelephonyManager;


public class NetworkOperator extends CordovaPlugin {

  @Override
  public boolean execute(String action, JSONArray args, CallbackContext callbackContext) throws JSONException {
	  
	if(action.equals("getNetworkOperator")) {
		
		Context context = this.cordova.getActivity().getApplicationContext();
		TelephonyManager manager = (TelephonyManager) context.getSystemService(Context.TELEPHONY_SERVICE);
		
		String carrier = "NA";
		String networkCode = "NA";
		String countryCode = "NA";
		
		if (manager.getSimState() != 1) {
			carrier = manager.getSimOperatorName();
			networkCode = manager.getNetworkOperator().substring(3,5);
			countryCode = manager.getNetworkOperator().substring(0,3);
		}
		
		JSONObject result = new JSONObject();
		
		result.put("carrier", carrier);
		result.put("networkCode", networkCode);
		result.put("countryCode", countryCode);
		
		callbackContext.success(result);
	  
		return true;
    } else {
		return false;
	}
    
  }
}
