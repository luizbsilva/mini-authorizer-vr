package br.com.vr.authorizer.api.v1;

import br.com.vr.authorizer.domain.dto.TransactionDTO;
import br.com.vr.authorizer.domain.dto.TransactionRequest;
import br.com.vr.authorizer.domain.port.adapter.TransactionServicePort;
import br.com.vr.authorizer.infra.util.ConstantsUrl;
import io.swagger.annotations.ApiOperation;
import io.swagger.annotations.ApiResponse;
import io.swagger.annotations.ApiResponses;
import javassist.NotFoundException;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(ConstantsUrl.TRANSACTION_URL)
public class TransactionController {

    private TransactionServicePort servicePort;

    public TransactionController(TransactionServicePort servicePort) {
        this.servicePort = servicePort;
    }

    @ApiOperation(value = "Create Credit Card transaction", notes = "Used to create credit card transaction")
    @ApiResponses(value = {
            @ApiResponse(code = 201, message = "Transaction performed successfully"),
            @ApiResponse(code = 422, message = "Error executing transaction"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @PostMapping("transacoes")
    ResponseEntity<String> startTransaction(@RequestBody TransactionRequest request) throws NotFoundException {
        servicePort.startTransaction(request);
        return ResponseEntity.ok("OK");
    }

    @ApiOperation(value = "Search Transaction Data", notes = "Used to Fetch credit card transaction data")
    @ApiResponses(value = {
            @ApiResponse(code = 202, message = "Search Transaction successfully"),
            @ApiResponse(code = 404, message = "Nor Existing card, please provide another card number"),
            @ApiResponse(code = 500, message = "The requested operation could not be performed. Contact support and report the error")})
    @GetMapping("transacoes/{cardNumber}/{password}")
    ResponseEntity<TransactionDTO> getListTransaction(@PathVariable String cardNumber, @PathVariable String password) throws NotFoundException {
        return ResponseEntity.status(HttpStatus.OK).body(servicePort.getListTransaction(cardNumber, password));
    }
}
