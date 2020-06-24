package com.wfs.client.service;

import com.apollographql.apollo.ApolloCall;
import com.apollographql.apollo.api.Response;
import com.apollographql.apollo.exception.ApolloException;
import com.wfs.client.config.ApolloClientConfig;
import com.wfs.client.config.MasterDataServiceProperties;
import com.wfs.client.generated.FindUserQuery;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;


import javax.annotation.Nonnull;
import java.util.concurrent.CompletableFuture;

@Service
public class ClientService {

    @Autowired
    MasterDataServiceProperties masterDataServiceProperties;

    @Autowired
    ApolloClientConfig apolloClientConfig;


    public FindUserQuery.FindUser findUser(Integer id) {

        com.wfs.client.generated.FindUserQuery findUserQuery = com.wfs.client.generated.FindUserQuery.builder().id(id).build();

        ApolloCall<com.wfs.client.generated.FindUserQuery.Data> findUserQueryData = apolloClientConfig.getApolloClient(masterDataServiceProperties.getUrl())
                .query(findUserQuery);

        CompletableFuture<com.wfs.client.generated.FindUserQuery.FindUser> future = new CompletableFuture<>();

        findUserQueryData.enqueue(new ApolloCall.Callback<com.wfs.client.generated.FindUserQuery.Data>() {
            @Override
            public void onResponse(@Nonnull Response<com.wfs.client.generated.FindUserQuery.Data> response) {
                future.complete(response.data().findUser());
            }

            @Override
            public void onFailure(@Nonnull ApolloException e) {

            }
        });

        return Mono.fromFuture(future).block();
    }
}
