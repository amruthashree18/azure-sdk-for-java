// Copyright (c) Microsoft Corporation. All rights reserved.
// Licensed under the MIT License.
package com.azure.spring.cloud.autoconfigure.implementation.kafka;

import org.springframework.boot.autoconfigure.kafka.KafkaProperties;

class KafkaPropertiesBeanPostProcessorTest
    extends AbstractKafkaPropertiesBeanPostProcessorTest<KafkaPropertiesBeanPostProcessor, KafkaProperties> {

    KafkaPropertiesBeanPostProcessorTest() {
        super(new KafkaPropertiesBeanPostProcessor());
    }
}
