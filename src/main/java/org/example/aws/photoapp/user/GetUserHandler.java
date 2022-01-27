package org.example.aws.photoapp.user;

import com.amazonaws.services.lambda.runtime.Context;
import com.amazonaws.services.lambda.runtime.RequestHandler;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyRequestEvent;
import com.amazonaws.services.lambda.runtime.events.APIGatewayProxyResponseEvent;
import com.google.gson.JsonObject;

import java.util.Map;

public class GetUserHandler implements RequestHandler<APIGatewayProxyRequestEvent, APIGatewayProxyResponseEvent> {


    /** API Gateway proxies request object to our lambda function. */
    @Override
    public APIGatewayProxyResponseEvent handleRequest(APIGatewayProxyRequestEvent input, Context context) {

        Map<String, String> pathParameters = input.getPathParameters();

        var userId = pathParameters.get("userId");


        var returnValue = new JsonObject();
        returnValue.addProperty("firstName", "Mustafa");
        returnValue.addProperty("lastName", "Kurt");
        returnValue.addProperty("id", userId);

        var response = new APIGatewayProxyResponseEvent();
        response.withStatusCode(200).withBody(returnValue.toString());

        return response;
    }
}
