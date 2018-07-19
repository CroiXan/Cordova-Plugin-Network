#import "NetworkOperator.h"

#import <Cordova/CDVAvailability.h>
#import <CoreTelephony/CTCarrier.h>
#import <CoreTelephony/CTTelephonyNetworkInfo.h>

@implementation NetworkOperator

- (void)getNetworkOperator:(CDVInvokedUrlCommand *)command {

    CTTelephonyNetworkInfo *phoneInfo = [[CTTelephonyNetworkInfo alloc] init];
	CTCarrier *phoneCarrier = [phoneInfo subscriberCellularProvider];

	NSString * carrierName = [phoneCarrier carrierName];
    NSString * mobileNetworkCode = [phoneCarrier mobileNetworkCode];
    NSString * mobileCountryCode = [phoneCarrier mobileCountryCode];

	NSDictionary *operatorInfo = [NSDictionary dictionaryWithObjectsAndKeys:
		carrierName,@"carrier",
		mobileNetworkCode,@"networkCode",
		mobileNetworkCode,@"countryCode",
	nil];
	
    CDVPluginResult *result = [CDVPluginResult resultWithStatus:CDVCommandStatus_OK messageAsDictionary:operatorInfo];
    [self.commandDelegate sendPluginResult:result callbackId:command.callbackId];
}

@end
