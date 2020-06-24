# apollo_client

Client code for consuming graphql api with apollo android graphql package

The schema for the graph ql endpoint can be fetched with the below command -

http://localhost:8080/graphql is the graphql endpoint

gradlew downloadApolloSchema -Pcom.apollographql.apollo.endpoint=http://localhost:8080/graphql -Pcom.apollographql.apollo.schema=src/main/graphql/com/wfs/client/generated/schema.json

The below command will generate stub classes for the client with apollo android gradle plugin.

gradlew generateApolloSources
