package com.wfs.client.config;

import com.apollographql.apollo.ApolloClient;
import org.springframework.stereotype.Component;


@Component
public class ApolloClientConfig {

    public ApolloClient getApolloClient(String url)
    {
        return ApolloClient.builder().serverUrl(url).build();
    }
}
