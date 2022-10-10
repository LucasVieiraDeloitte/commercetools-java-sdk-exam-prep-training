package handson.exercises;

import com.commercetools.api.client.ProjectApiRoot;
import com.commercetools.api.models.common.LocalizedString;
import com.commercetools.api.models.common.LocalizedStringBuilder;
import handson.exercises.impl.ApiPrefixHelper;
import handson.exercises.impl.ConfigurationService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.IOException;
import java.util.HashMap;
import java.util.concurrent.ExecutionException;

import static handson.exercises.impl.ClientService.createApiClient;


public class Task2ab {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        // Learning Goals
        // Get Query
        // Custom Types

        Logger logger = LoggerFactory.getLogger(Task2ab.class.getName());

        final ProjectApiRoot apiRoot_poc =
                createApiClient(
                        ApiPrefixHelper.API_POC_CLIENT_PREFIX.getPrefix()
                );
        ConfigurationService configurationService = new ConfigurationService(apiRoot_poc);

        // TODO Step 1: Check in ConfigurationService.java that customers have not already a type attached
        logger.info("Customers have currently types attached: " +
                configurationService.getAssignedTypes()
                    .toCompletableFuture().get()
                    .getBody().getResults()
                    .size()
        );



        final LocalizedString localizedNameForBonuspoints = LocalizedStringBuilder.of()
                .values(new HashMap<String, String>() {
                    {
                        put("DE", "Bonuspunkte für Kunden");
                        put("EN", "Bonuspoints on customers");
                    }
                })
                .build();

        // TODO Step 2: Assign ConfigurationService.java a custom type for bonus points to customers
        // You can use above localizedString for all name fields
        logger.info("Customers have now the following types attached: " +
                ""
        );

        // TODO Step 3: Provide a random number 1..100 in MC for your customer

        apiRoot_poc.close();
    }
}
