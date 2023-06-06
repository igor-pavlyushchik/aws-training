package com.epam.aws.training.controller;

import com.amazonaws.services.lambda.AWSLambda;
import com.amazonaws.services.lambda.model.InvokeRequest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Lambda Controller.
 */
@RestController
@RequestMapping("/lambda")
public class LambdaController {

    private final AWSLambda awsLambda;
    @Value("${amazon.lambda.function.arn}")
    private String functionARN;

    @Autowired
    public LambdaController(AWSLambda awsLambda) {
        this.awsLambda = awsLambda;
    }

    @PutMapping("/action")
    public ResponseEntity<Object> lambdaAction() {
        try {
            InvokeRequest invokeRequest = new InvokeRequest()
                    .withFunctionName(functionARN)
                    .withPayload("{\"detail-type\": \"AWP application\"}");
            awsLambda.invoke(invokeRequest);
        } catch (Exception e) {
            System.err.println(e.getMessage());
            return ResponseEntity.status(HttpStatus.INTERNAL_SERVER_ERROR).build();
        }
        return ResponseEntity.status(HttpStatus.NO_CONTENT).build();
    }
}
