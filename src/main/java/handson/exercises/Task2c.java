package handson.exercises;

import com.commercetools.api.client.ProjectApiRoot;
import handson.solutions.impl.ApiPrefixHelper;
import handson.solutions.impl.CustomObjectService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import javax.json.Json;
import javax.json.JsonObject;
import java.io.IOException;
import java.util.concurrent.ExecutionException;

import static handson.solutions.impl.ClientService.createApiClient;


public class Task2c {

    public static void main(String[] args) throws IOException, ExecutionException, InterruptedException {

        // Learning Goals
        // Custom Objects

        Logger logger = LoggerFactory.getLogger(Task2c.class.getName());

        final ProjectApiRoot apiRoot_poc =
                createApiClient(
                        ApiPrefixHelper.API_POC_CLIENT_PREFIX.getPrefix()
                );
        CustomObjectService customObjectService = new CustomObjectService(apiRoot_poc);

        // TODO Step 1: Design a structure for storing the following information
        //  Cart value  - Bonus Points earned
        //  0.01 - 10.00 USD - 1 point
        //  10.01 - 100.00 USD - 1 point for each USD
        //  above 100.00 USD - 2 points for each USD

        // Possible solution (Discuss, all in one custom object, you can have it in 3, what about higher cart values)
        //  MinCartValue / MaxCartValue / Factor / Addon
        //  0.01 / 10 / 0 / 1
        //  10.01 / 100 / 1 / 0
        //  100.01 / 100000 / 2 / 0

        JsonObject allBonuspointCalculationSchemata = null;

        // TODO Step 2: Create the custom object(s)

        logger.info("Custom Object stored: " +
                ""
        );

        apiRoot_poc.close();
    }
}
