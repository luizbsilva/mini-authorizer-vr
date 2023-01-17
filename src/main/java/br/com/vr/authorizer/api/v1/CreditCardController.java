package br.com.vr.authorizer.api.v1;

import br.com.vr.authorizer.domain.dto.CreditCartDTO;
import br.com.vr.authorizer.domain.dto.CreditCartRequest;
import br.com.vr.authorizer.domain.port.adapter.CreditCardServicePort;
import br.com.vr.authorizer.infra.util.ConstantsUrl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.math.BigDecimal;

@RestController
@RequestMapping(ConstantsUrl.CREDITCARD_URL)
public class CreditCardController {

    private CreditCardServicePort servicePort;

    public CreditCardController(CreditCardServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @ApiOperation(value = "Create a new Credit Card", notes = "Used to Create a new credit card")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Card created successfully"),
            @ApiResponse(code = 422, message = "Existing card, please provide another card number"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @PostMapping("cartoes")
    ResponseEntity<CreditCartDTO> createdCreditCard(@RequestBody CreditCartRequest request) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.createdCreditCard(request));
    }

    @ApiOperation(value = "Change Credit Card password", notes = "Used to change Credit Card password")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Successfully cleared password"),
            @ApiResponse(code = 422, message = "Existing card, please provide another card number"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @PutMapping("cartoes/{password}")
    ResponseEntity<CreditCartDTO> changePassword(@RequestBody CreditCartRequest request, @PathVariable String password) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.CREATED).body(servicePort.changePassword(request, password));
    }

    @ApiOperation(value = "Check credit Card Balance", notes = "Used to check credit card balance")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Card Available successfully"),
            @ApiResponse(code = 404, message = "Nor Existing card, please provide another card number"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @GetMapping("cartoes/{cardNumber}/{password}")
    ResponseEntity<BigDecimal> getAvailableCreditCard(@PathVariable String cardNumber, @PathVariable String password) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getAvailableCreditCard(cardNumber, password));
    }
}
