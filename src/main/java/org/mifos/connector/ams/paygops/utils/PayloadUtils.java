package org.mifos.connector.ams.paygops.utils;

import org.json.JSONObject;
import org.mifos.connector.ams.paygops.paygopsDTO.CustomData;
import org.mifos.connector.ams.paygops.paygopsDTO.GsmaTransferDTO;
import org.mifos.connector.ams.paygops.paygopsDTO.PayerPayee;

import java.util.List;

public class PayloadUtils {
    public static String convertCustomData(List<CustomData> customData, String key)
    {
        for(CustomData obj: customData)
        {
            try {
                String filter = obj.getKey();
                if (filter != null && filter.equalsIgnoreCase(key)) {
                    return obj.getValue();
                }
            } catch (Exception e){
            }
        }
        return null;
    }
    public static String getPayerPayeeInfo(List<PayerPayee> jsonArray, String key){
        System.out.println("Json Array: "+jsonArray);
        for(PayerPayee obj:jsonArray){
            System.out.println(obj);
            String keyVal= obj.getPartyIdType();
            if(keyVal!=null && keyVal.equalsIgnoreCase(key)){
                return obj.getPartyIdIdentifier();
            }
        }
        return null;
    }
    public static JSONObject convertChannelToPaygopsPayload(GsmaTransferDTO gsmaTransferDTO) {
        System.out.println("Json Custom Data"+gsmaTransferDTO);
        String amount=gsmaTransferDTO.getAmount();
        String currency=convertCustomData(gsmaTransferDTO.getCustomData(),"currency");
        String msisdn=getPayerPayeeInfo(gsmaTransferDTO.getPayer(),"MSISDN");
        String foundationalId=getPayerPayeeInfo(gsmaTransferDTO.getPayee(),"foundationalId");

        JSONObject channelRequest=new JSONObject();

        JSONObject payerObj=new JSONObject();
        payerObj.put("partyIdType","MSISDN");
        payerObj.put("partyIdentifier",msisdn);

        JSONObject partyIdInfo=new JSONObject();
        partyIdInfo.put("partyIdInfo",payerObj);

        channelRequest.put("payer",partyIdInfo);
        channelRequest.put("payee",partyIdInfo);

        JSONObject amountObj=new JSONObject();
        amountObj.put("amount",amount);
        amountObj.put("currency",currency);
        channelRequest.put("amount",amountObj);

        return channelRequest;
    }
}
