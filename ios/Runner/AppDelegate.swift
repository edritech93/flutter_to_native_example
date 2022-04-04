import UIKit
import Flutter

@UIApplicationMain
@objc class AppDelegate: FlutterAppDelegate {
    override func application(
        _ application: UIApplication,
        didFinishLaunchingWithOptions launchOptions: [UIApplication.LaunchOptionsKey: Any]?) -> Bool {
            
            let controller : FlutterViewController = window?.rootViewController as! FlutterViewController
            let batteryChannel = FlutterMethodChannel(name: "flutter.native/helper",
                                                      binaryMessenger: controller.binaryMessenger)
            weak var weakSelf = self
            batteryChannel.setMethodCallHandler({
                (call: FlutterMethodCall, result: @escaping FlutterResult) -> Void in
                if "helloFromNativeCode" == call.method {
                    let strNative = weakSelf?.helloFromNativeCode()
                    result(strNative)
                } else {
                    result(FlutterMethodNotImplemented)
                }
            })
            
            GeneratedPluginRegistrant.register(with: self)
            return super.application(application, didFinishLaunchingWithOptions: launchOptions)
        }
    
    func helloFromNativeCode() -> String? {
        return "Hello From Native IOS Code"
    }
}

