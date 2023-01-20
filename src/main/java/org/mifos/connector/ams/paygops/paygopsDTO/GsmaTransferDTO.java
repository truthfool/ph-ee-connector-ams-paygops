package org.mifos.connector.ams.paygops.paygopsDTO;

import com.fasterxml.jackson.annotation.JsonProperty;
import lombok.*;

import java.util.List;
@NoArgsConstructor
@AllArgsConstructor
@Getter
@Setter
@ToString
public class GsmaTransferDTO {
    @JsonProperty("requestingOrganisationTransactionReference")
    private String requestingOrganisationTransactionReference;
    @JsonProperty("subType")
    private String subType;
    @JsonProperty("type")
    private String type;
    @JsonProperty("amount")
    private String amount;
    @JsonProperty("currency")
    private String currency;
    @JsonProperty("descriptionText")
    private String descriptionText;
    @JsonProperty("requestDate")
    private String requestDate;
    @JsonProperty("customData")
    private List<CustomData> customData;
    @JsonProperty("payer")
    private List<PayerPayee> payer;
    @JsonProperty("payee")
    private List<PayerPayee> payee;
}
