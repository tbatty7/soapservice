package mypackage.endpoints;

import mypackage.model.request.GetUserRequest;
import mypackage.model.request.GetUserResponse;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ws.server.endpoint.annotation.Endpoint;
import org.springframework.ws.server.endpoint.annotation.PayloadRoot;
import org.springframework.ws.server.endpoint.annotation.RequestPayload;
import org.springframework.ws.server.endpoint.annotation.ResponsePayload;
import mypackage.services.UserService;

@Endpoint
public class UserEndpoint {

    @Autowired
    private UserService userService;

    @PayloadRoot(namespace = "http://techprimers.com/spring-boot-soap-example",
    localPart = "getUserRequest")
    @ResponsePayload //Automatically turns it into a SOAP response
    public GetUserResponse getUserRequest(@RequestPayload GetUserRequest request){
        GetUserResponse response = new GetUserResponse();
        response.setName(userService.getUser(request.getName()));
        return response;
    }
}
