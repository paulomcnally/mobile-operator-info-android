package nd.mobileoperatorinfo;

import android.content.Context;
import android.telephony.TelephonyManager;

public class Operator {

    public static OperatorObject info(Context context) {
        TelephonyManager telephonyManager = (TelephonyManager) context
                .getSystemService(Context.TELEPHONY_SERVICE);
        String networkOperator = telephonyManager.getNetworkOperator();
        int mcc = 0, mnc = 0;
        if (networkOperator != null) {
            mcc = Integer.parseInt(networkOperator.substring(0, 3));
            mnc = Integer.parseInt(networkOperator.substring(3));
        }

        String SimNumber = telephonyManager.getLine1Number();

        String SimSerialNumber = telephonyManager.getSimSerialNumber();
        String countryISO = telephonyManager.getSimCountryIso();
        String operatorName = telephonyManager.getSimOperatorName();
        String mccmnc = telephonyManager.getSimOperator();


        OperatorObject operatorObject = new OperatorObject();
        operatorObject.setCountryISO(countryISO);
        operatorObject.setMccmnc(mccmnc);
        operatorObject.setMcc(String.format("%d", mcc));
        operatorObject.setMnc(String.format("%d", mnc));
        operatorObject.setName(operatorName);

        return operatorObject;

    }
}