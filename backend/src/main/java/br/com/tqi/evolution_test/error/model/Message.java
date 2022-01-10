package br.com.tqi.evolution_test.error.model;

import lombok.Builder;
import lombok.Data;

import java.util.Collections;
import java.util.Map;

@Data
@Builder
public class Message {
    private String value;

    @Builder.Default
    private Map<String, String> variables = Collections.emptyMap();
}
