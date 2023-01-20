package org.mifos.connector.ams.paygops.paygopsDTO;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@NoArgsConstructor
@AllArgsConstructor
@Setter
@Getter
public class PayerPayee {
    public String partyIdType;
    public String partyIdIdentifier;
}
