package com.catnest.common.secure.entity;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class KeyPairEntity {

    private String privateKey;

    private String publicKey;

}
