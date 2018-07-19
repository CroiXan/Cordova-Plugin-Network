#import <Cordova/CDVPlugin.h>
#import <Cordova/CDV.h>

@interface NetworkOperator : CDVPlugin 

- (void)getNetworkOperator:(CDVInvokedUrlCommand *)command;

@end
